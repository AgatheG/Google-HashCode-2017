package main;

import java.util.ArrayList;
import java.util.Collections;

public class Test {

	public static void main(String[] args) {
		Reader r = new Reader();
		r.read("ressources/me_at_the_zoo.in");
		//r.read("ressources/trending_today.in");
		System.out.println("End of the reader");

		ArrayList<Gain> gains = new ArrayList<Gain>();
		for (Request rq : r.getRequests()) {
			for (Integer idc : rq.getEndPoint().getC()) {
				CacheServer c = r.getCacheServers().get(idc);
				gains.add(new Gain(rq,c));
			}
		} 
		System.out.println("Gains added");

		Test t = new Test();
		t.algoRemplissage(gains);
		System.out.println("Filling algorithm ended");

		for (int i = 0; i < r.getCacheServers().size(); i++){
			System.out.println(r.getCacheServers().get(i).toString());
		}
		System.out.println("Writing the output file");
		Writer.write(r.getCacheServers(),"ressources/test2.out");
		System.out.println("Output file available");

	}

	public Test() {

	}

	public void algoRemplissage(ArrayList<Gain> liste) {
		double sizeL=liste.size();
		liste.sort(Collections.reverseOrder());
		while (!liste.isEmpty()) {
			Gain g = liste.get(0);
			liste.remove(0);
			System.out.println(100.00000*(sizeL-liste.size())/sizeL+""+"%"); //avancement en % de l'algo
			if ((g.getCache().getCapaRestante() >= g.getRequest().getVideo().getSize()) && (!g.getCache().getVideos().contains(g.getRequest().getVideo()))) {
				g.getCache().setCapaRestante(g.getRequest().getVideo());
				g.getCache().ajouterVideo(g.getRequest().getVideo());
			}
		}
	}
	
}
