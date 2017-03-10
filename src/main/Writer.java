package main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class Writer {
	public static void write(HashMap<Integer, CacheServer> CS, String nomFichier) {
		try {
			// Les operations sur les fichiers peuvent lever des exceptions
			// On ouvre le fichier en écriture
			PrintWriter aEcrire = new PrintWriter(new BufferedWriter(new FileWriter(nomFichier)));
			// On écrit dans le fichier
			// int N = CS.size();
			// for (int i = 0; i < N; i++){
			ArrayList<CacheServer> listeCS = new ArrayList<CacheServer>();
			int count = 0;

			for (CacheServer c : CS.values()) {
				if (!c.getVideos().isEmpty()) {
					listeCS.add(c);
					count++;
				}
			}

			aEcrire.println(count);
			for (CacheServer c : listeCS) {
				String s = "" + c.getIdc();
				for (Video v : c.getVideos()) {
					s += " " + v.getIdvid();
				}
				aEcrire.println(s);
			}
			aEcrire.close();
		} catch (IOException e) {
			System.out.println("Une operation sur les fichiers a leve l’exception " + e);
		}
	}
}