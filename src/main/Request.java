package main;

public class Request {
	
	private Video v;
	private EndPoint ep;
	private int nbRequest;

	public Request(Video v, EndPoint ep, int nbRequest) {
		this.v=v;
		this.ep=ep;
		this.nbRequest=nbRequest;
	}
	
//	public String toString() {
//		return ""+this.idv+" "+this.ide+" ";
//	}
	
	public int getRn(){
		return this.nbRequest;
	}
	
	public EndPoint getEndPoint(){
		return this.ep;
	}
	
	public Video getVideo(){
		return this.v;
	}

}
