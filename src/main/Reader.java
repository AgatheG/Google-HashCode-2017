package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Reader {
  private ArrayList<Video> videos;
	private HashMap<Integer, EndPoint> endpoints;
	//private ArrayList<CacheServer> cacheservers;
	private HashMap<Integer,CacheServer> cacheservers;
	private ArrayList<Request> requests;



	public ArrayList<Video> getVideos() {
		return videos;
	}


	public HashMap<Integer,EndPoint> getEndPoints() {
		return endpoints;
	}

	public HashMap<Integer,CacheServer> getCacheServers() {
		return cacheservers;
	}


	public ArrayList<Request> getRequests() {
		return requests;
	}


	public Reader(){
		this.videos = new ArrayList<Video>();
		this.endpoints = new HashMap<Integer, EndPoint>();
		this.cacheservers = new HashMap<Integer,CacheServer>();
		this.requests = new ArrayList<Request>();
	}


	public void read(String filename) {
		try {
			int V, E, R, C, X;
			BufferedReader lecteur = new BufferedReader(new FileReader(filename));

			String line=lecteur.readLine();
			V=Integer.parseInt(line.split(" ")[0]);
			E=Integer.parseInt(line.split(" ")[1]);
			R=Integer.parseInt(line.split(" ")[2]);
			C=Integer.parseInt(line.split(" ")[3]);
			X=Integer.parseInt(line.split(" ")[4]);

			line=lecteur.readLine();
			for (int i = 0; i < V; i++){
				this.videos.add(new Video(i, Integer.parseInt(line.split(" ")[i])));
			}

			for (int i = 0; i < E; i++){
				line = lecteur.readLine();
				int ld = Integer.parseInt(line.split(" ")[0]);
				int Nc = Integer.parseInt(line.split(" ")[1]);
				ArrayList<Integer> llatence = new ArrayList<Integer>();
				ArrayList<Integer> lcache = new ArrayList<Integer>();
				for (int j = 0; j < Nc; j++){
					line = lecteur.readLine();
					CacheServer Ctemp = new CacheServer(Integer.parseInt(line.split(" ")[0]),X);
					if (!this.getCacheServers().containsKey(Ctemp.getIdc())){
						this.cacheservers.put(Ctemp.getIdc(), Ctemp);
					}
					lcache.add(Ctemp.getIdc());
					llatence.add(Integer.parseInt(line.split(" ")[1]));
				}
				this.endpoints.put(i,new EndPoint(i,ld,lcache,llatence));
			}

			for (int i = 0; i < R; i++){
				line = lecteur.readLine();
				this.requests.add(new Request(this.videos.get(Integer.parseInt(line.split(" ")[0])),this.endpoints.get(Integer.parseInt(line.split(" ")[1])),Integer.parseInt(line.split(" ")[2])));
			}


		}
		catch (IOException e){
			System.out.println("Le reader marche pas biatch");
		}
	}


}
