package main;

public class Video {
	
	private int s;
	private int idvid;

	public Video(int idvid, int s) {
		this.s=s;
		this.idvid=idvid;
	}
	
	public String toString() {
		return ""+this.idvid+" "+this.s;
	}
	
	public int getSize(){
		return this.s;
	}
  
  public int getIdvid(){
    return this.idvid;
  }

}