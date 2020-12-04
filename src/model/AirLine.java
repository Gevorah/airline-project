package model;

import java.io.*;
import java.util.*;
import datastructure.*;

public class AirLine {

	private ListGraph<String> distlg;
	private MatrixGraph distmg;
	private ListGraph<String> costlg;
	private MatrixGraph costmg;
	private List<String> destinations;

	public AirLine() {
		distlg = new ListGraph<>();
		distmg = new MatrixGraph(8);
		costlg = new ListGraph<>();
		costmg = new MatrixGraph(8);
		destinations = new ArrayList<String>();
	}

	public String calculateRoute(String departure, String arrival, String criteria, String typeGraph) {

		String result = "";

		if (typeGraph.equals("Grafo 1")) {

			if (criteria.equals("Speed")) {
				result = searchbySpeedMatrix(departure, arrival);

			}

			else if (criteria.equals("Cost")) {

				result = searchbyCostMatrix(departure, arrival);

			}

		}

		else if (typeGraph.equals("Grafo 2")) {

			if (criteria.equals("Speed")) {

				result = searchbySpeedList(departure, arrival);
			}

			else if (criteria.equals("Cost")) {

				result = searchbyCostList(departure, arrival);
			}
		}

		return result;
	}

	public String searchbySpeedMatrix(String departure, String arrival) {
		distmg.search(departure,arrival);
		distmg.DFS();
		return distmg.spath();

	}

	public String searchbyCostMatrix(String departure, String arrival) {
		distmg.search(departure,arrival);
		distmg.DFS();
		return distmg.spath() + "\n $" + distmg.spath().split(" ").length*25;
	}

	public String searchbySpeedList(String departure, String arrival) {
		distlg.bfs(distlg.search(departure));
		return distlg.print(distlg.search(departure),distlg.search(arrival));
	}

	public String searchbyCostList(String departure, String arrival) {
		costlg.bfs(costlg.search(departure));
		String str = costlg.print(costlg.search(departure),costlg.search(arrival));
		return str +"\n $" +str.split(" ").length*25;
	} 

	public void addDestinations(String d) {
		for (int i = 0; i < destinations.size(); i++) {
			if (destinations.get(i).equals(d)) {
				break;
			} else {
				destinations.add(d);
			}
		}

	}

	public ArrayList<String> getDestinations() {
		return (ArrayList<String>) destinations;
	}

	public double calculateCost(double speed) {
		return 5;
	}

	public final static String INFO = "data" + File.separator + "info.txt";

	public void init() throws IOException {
		distmg.initializeMatrix();
		costmg.initializeMatrix();
		destinations.add("Cali");
		destinations.add("Bogota");
		destinations.add("Medellin");
		destinations.add("España");
		destinations.add("Rusia");
		destinations.add("Suiza");
		
		BufferedReader br = new BufferedReader(new FileReader(INFO));
		String place = null;
		while ((place = br.readLine()) != null) {
			String[] tmp = place.split(",");
			distmg.addEdge(tmp[0], tmp[1], Double.parseDouble(tmp[2]));
			distlg.addEdge(tmp[0], tmp[1], Double.parseDouble(tmp[2]));
			double value = 20 + (int) Math.round(Math.random() * 10);
			costmg.addEdge(tmp[0], tmp[1], Double.parseDouble(tmp[2])*value);
			costlg.addEdge(tmp[0], tmp[1], Double.parseDouble(tmp[2])*value);
		}
		br.close();
	}
}