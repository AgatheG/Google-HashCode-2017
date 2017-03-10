package main;

import java.util.ArrayList;

public class EndPoint {

	private int id;
	private int ld;
	private ArrayList<Integer> C;
	private ArrayList<Integer> latenceC;

	public EndPoint(int id,int ld, ArrayList<Integer> C, ArrayList<Integer> latenceC) {
		this.id=id;
		this.ld=ld;
		this.C=C;
		this.latenceC = latenceC;
	}

	public String toString() {
		return ""+this.id+" "+this.ld+" "+this.C.toString();
	}

	public int getLd(){
		return this.ld;
	}

	public int getLatence(int idc){
		return this.latenceC.get(C.indexOf(idc));
	}

	public int getC(int i) {
		return this.C.get(i);
	}
	
	public ArrayList<Integer> getC() {
		return this.C;
	}
}
