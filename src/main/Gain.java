package main;

public class Gain implements Comparable<Gain> {
	
	private Request request;
	private CacheServer cache;
	private double gain;

	public Gain(Request r,CacheServer c){
		this.request = r;
		this.cache = c;
    
    //LALIGNEDELAMORT ON GALERE !!! 
		this.gain = (((double)(this.request.getRn()))*(((double)this.request.getEndPoint().getLd())-((double)this.request.getEndPoint().getLatence(c.getIdc()))))/((double)this.request.getVideo().getSize());
    //LE CANCER DE CETTE LIGNE A LE SIDA
	}

	public Request getRequest(){
		return this.request;
	}

	public CacheServer getCache(){
		return this.cache;
	}

	public double getGain(){
		return this.gain;
	}

	public int compareTo(Gain g){
		return (this.getGain()>g.getGain() ? 1 : (this.getGain()==g.getGain() ? 0 : -1));
	}

}
