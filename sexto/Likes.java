package sexto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Likes {

	public static void main(String[] args) {
		
		String file = "C:\\Users\\admin\\Desktop\\Apoyo Desafío - Likes\\likes";
		ArrayList<String> likes = new ArrayList<String>();
		String lectura = "";
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			lectura = br.readLine();
			while(lectura!=null) {
				ArrayList<String> temp = new ArrayList<String>(Arrays.asList(lectura.split(" ")));
				for(String el: temp) {
					likes.add(el);
				}
				lectura = br.readLine();
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
				
		TreeSet<String> unicos = new TreeSet<String>(likes);
		
		Counter<String> freq = new Counter<>();
		for(String el: likes) {
			freq.add(el);
		}
		
		for(String unico: unicos) {
			System.out.printf("%s: %d\n", unico, freq.count(unico));
		}
		
		Set<String> masLikes = freq.getKeysByValue(freq.max());
		Set<String> menosLikes = freq.getKeysByValue(freq.min());

		
		if (menosLikes.size() == 1) {
			menosLikes.iterator().next();
			System.out.println("La foto con menos likes es: " + menosLikes.iterator().next() + " con "+ freq.min() + " likes");
		} else if (menosLikes.size() > 1) {
			Iterator<String> it = menosLikes.iterator();
			System.out.printf("Las fotos con menos likes son: ");
			while(it.hasNext()) {
				System.out.printf(it.next() + " ");
			}
			System.out.printf("con " + freq.min() + " likes");
		}
		
		if(masLikes.size() == 1) {
			System.out.println("La foto con más likes es: " + masLikes.iterator().next() + " con "+ freq.max() + " likes");
		} else if (masLikes.size() > 1) {
			Iterator<String> it = masLikes.iterator();
			System.out.printf("Las fotos con más likes son: ");
			while(it.hasNext()) {
				System.out.printf(it.next() + " ");
			}
			System.out.printf("con " + freq.max() + " likes");
		}
		
		System.out.println(freq.promedio());

	}


}
