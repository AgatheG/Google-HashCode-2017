package main;

import java.util.ArrayList;

public class CacheServer {

	private int idc;
	private ArrayList<Video> videos;
	private int capRestante;

	public CacheServer(int idc, ArrayList<Video> videos, int capRestante) {
		this.idc=idc;
		this.videos=videos;
		this.capRestante=capRestante;
	}
	public CacheServer(int idc, int Capa){
		this.idc= idc;
		this.capRestante = Capa;
		this.videos = new ArrayList<Video>();
	}
	
	public int getIdc(){
		return this.idc;
	}
	
	public int getCapaRestante(){
		return this.capRestante;
	}
	public void setCapaRestante(Video v){
		this.capRestante -= v.getSize();
	}
	
	public void ajouterVideo(Video v){
		this.videos.add(v);
		this.setCapaRestante(v);
	}
	
	public ArrayList<Video> getVideos(){
		return this.videos;
	}
	
	public String toString(){
		String s = this.idc + " : ";
		for (int i = 0; i < this.videos.size(); i++){
			s += this.videos.get(i).toString() + " ";
		}
		return s;
	}
}
