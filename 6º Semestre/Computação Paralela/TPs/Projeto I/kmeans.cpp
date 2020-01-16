// Implementation of the KMeans Algorithm
// reference: http://mnemstudio.org/clustering-k-means-example-1.htm

#include <iostream>
#include <vector>
#include <math.h>
#include <omp.h>
#include <stdlib.h>
#include <time.h>
#include <algorithm>
using namespace std;
/**
 * Aluno Ian Rodrigues dos Reis Paix�os, Rithie Natan Carvalhaes Prado
 * TEMPO SEQUENCIAL M�QUINA PESSOAL: 23,618s
 * TEMPO PARALELO M�QUINA PESSOAL 2 THREADS: 13,581s ---- SpeedUp: 1,73
 * TEMPO PARALELO M�QUINA PESSOAL 4 THREADS: 11,258s ---- SpeedUp: 2,09
 * TEMPO PARALELO M�QUINA PESSOAL 8 THREADS: 11,388s ---- SpeedUp: 2,07
 * 
 * TEMPO SEQUENCIAL M�QUINA PARCODE: 23,049s
 * TEMPO PARALELO M�QUINA PARCODE 2 THREADS: 17,468s -------- SpeedUp: 1,31
 * TEMPO PARALELO M�QUINA PARCODE 4 THREADS: 14,297s -------- SpeedUp: 1,61
 * TEMPO PARALELO M�QUINA PARCODE 8 THREADS: 23,936s (?) ---- SpeedUp: 0,96 (n�o h� SpeedUp)
 */

class Point
{
private:
	int id_point, id_cluster;
	vector<double> values;
	int total_values;
	string name;

public:
	Point(int id_point, vector<double>& values, string name = "")
	{
		this->id_point = id_point;
		total_values = values.size();

		for(int i = 0; i < total_values; i++)
			this->values.push_back(values[i]);

		this->name = name;
		id_cluster = -1;
	}

	int getID()
	{
		return id_point;
	}

	void setCluster(int id_cluster)
	{
		this->id_cluster = id_cluster;
	}

	int getCluster()
	{
		return id_cluster;
	}

	double getValue(int index)
	{
		return values[index];
	}

	int getTotalValues()
	{
		return total_values;
	}

	void addValue(double value)
	{
		values.push_back(value);
	}

	string getName()
	{
		return name;
	}
};

class Cluster
{
private:
	int id_cluster;
	vector<double> central_values;
	vector<Point> points;

public:
	Cluster(int id_cluster, Point point)
	{
		this->id_cluster = id_cluster;

		int total_values = point.getTotalValues();

		for(int i = 0; i < total_values; i++)
			central_values.push_back(point.getValue(i));

		points.push_back(point);
	}

	void addPoint(Point point)
	{
		points.push_back(point);
	}

	bool removePoint(int id_point)
	{
		int total_points = points.size();

		for(int i = 0; i < total_points; i++)
		{
			if(points[i].getID() == id_point)
			{
				points.erase(points.begin() + i);
				return true;
			}
		}
		return false;
	}

	double getCentralValue(int index)
	{
		return central_values[index];
	}

	void setCentralValue(int index, double value)
	{
		central_values[index] = value;
	}

	Point getPoint(int index)
	{
		return points[index];
	}

	int getTotalPoints()
	{
		return points.size();
	}

	int getID()
	{
		return id_cluster;
	}
};

class KMeans
{
private:
	int K; // number of clusters
	int total_values, total_points, max_iterations;
	vector<Cluster> clusters;

	// return ID of nearest center (uses euclidean distance)
	int getIDNearestCenter(Point point)
	{
		double sum = 0.0, min_dist;
		int id_cluster_center = 0;
        
        //#pragma omp parallel for reduction(+:sum)
		for(int i = 0; i < total_values; i++)
		{
			sum += pow(clusters[0].getCentralValue(i) -
					   point.getValue(i), 2.0);
		}

		min_dist = sqrt(sum);

		
		for(int i = 1; i < K; i++)
		{
			double dist;
			sum = 0.0;
			for(int j = 0; j < total_values; j++)
			{
				sum += pow(clusters[i].getCentralValue(j) -
						   point.getValue(j), 2.0);
			}

			dist = sqrt(sum);

			if(dist < min_dist)
			{
				min_dist = dist;
				id_cluster_center = i;
			}
		}

		return id_cluster_center;
	}

public:
	KMeans(int K, int total_points, int total_values, int max_iterations)
	{
		this->K = K;
		this->total_points = total_points;
		this->total_values = total_values;
		this->max_iterations = max_iterations;
	}

	void run(vector<Point> & points)
	{
		if(K > total_points)
			return;

		vector<int> prohibited_indexes;

		// choose K distinct values for the centers of the clusters
		for(int i = 0; i < K; i++)
		{
			while(true)
			{
				int index_point = rand() % total_points;

				if(find(prohibited_indexes.begin(), prohibited_indexes.end(),
						index_point) == prohibited_indexes.end())
				{
					prohibited_indexes.push_back(index_point);
					points[index_point].setCluster(i);
					Cluster cluster(i, points[index_point]);
					clusters.push_back(cluster);
					break;
				}
			}
		}

		int iter = 1;

		while(true)
		{
			bool done = true;

			// associates each point to the nearest center
			// Regi�o paralelizada por demandar maior tempo de execu��o, onde identifica o cluster mais pr�ximo do ponto em quest�o.
			#pragma omp parallel for schedule(guided, 1500) num_threads(8)
			for(int i = 0; i < total_points; i++)
			{
				int id_old_cluster = points[i].getCluster();
				int id_nearest_center = getIDNearestCenter(points[i]);

				if(id_old_cluster != id_nearest_center)
				{

					// Regi�o cr�tica pois h� modifica��o de variaveis
					#pragma omp critical
					{
						if(id_old_cluster != -1)
							clusters[id_old_cluster].removePoint(points[i].getID());
					
						points[i].setCluster(id_nearest_center);
						clusters[id_nearest_center].addPoint(points[i]);
						done = false;
					}					
				}
			}

			// recalculating the center of each cluster.
			// Regi�o paralelizada para auxiliar no c�lculo dos centroides dos clusters.
            #pragma omp parallel for num_threads(8)
			for(int i = 0; i < K; i++) {	
				for(int j = 0; j < total_values; j++) {
					int total_points_cluster = clusters[i].getTotalPoints();
					double sum = 0.0;

					if(total_points_cluster > 0)
					{
						// Regi�o paralela onde acrescente um ponto ao cluster em quest�o.
                        #pragma omp parallel for reduction(+:sum) num_threads(8)
						for(int p = 0; p < total_points_cluster; p++)
							sum += clusters[i].getPoint(p).getValue(j);
						clusters[i].setCentralValue(j, sum / total_points_cluster);
					}
				}
			}

			if(done == true || iter >= max_iterations)
			{
				cout << "Break in iteration " << iter << "\n\n";
				break;
			}

			iter++;
		}

		// // shows elements of clusters
		// for(int i = 0; i < K; i++)
		// {
		// 	int total_points_cluster =  clusters[i].getTotalPoints();

		// 	cout << "Cluster " << clusters[i].getID() + 1 << endl;
		// 	for(int j = 0; j < total_points_cluster; j++)
		// 	{
		// 		cout << "Point " << clusters[i].getPoint(j).getID() + 1 << ": ";
		// 		for(int p = 0; p < total_values; p++)
		// 			cout << clusters[i].getPoint(j).getValue(p) << " ";

		// 		string point_name = clusters[i].getPoint(j).getName();

		// 		if(point_name != "")
		// 			cout << "- " << point_name;

		// 		cout << endl;
		// 	}

		// 	cout << "Cluster values: ";

		// 	for(int j = 0; j < total_values; j++)
		// 		cout << clusters[i].getCentralValue(j) << " ";

		// 	cout << "\n\n";
		// }
	}
};

int main(int argc, char *argv[])
{
	srand (time(NULL));

	int total_points, total_values, K, max_iterations, has_name;

	cin >> total_points >> total_values >> K >> max_iterations >> has_name;

	vector<Point> points;
	string point_name;

	for(int i = 0; i < total_points; i++)
	{
		vector<double> values;

		for(int j = 0; j < total_values; j++)
		{
			double value;
			cin >> value;
			values.push_back(value);
		}

		if(has_name)
		{
			cin >> point_name;
			Point p(i, values, point_name);
			points.push_back(p);
		}
		else
		{
			Point p(i, values);
			points.push_back(p);
		}
	}
    
	KMeans kmeans(K, total_points, total_values, max_iterations);
	kmeans.run(points);

	return 0;
}