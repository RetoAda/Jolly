package es.unex.cum.retoada;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) {
		Main m = new Main();
		int n = 2^31;

		//Lo primero es leer lo introducido por teclado
		Scanner s = new Scanner (System.in);
		String entrada = s.nextLine();
		ArrayList <String>lista = new ArrayList <String>();
		lista.add(entrada); //voy guardando en la lista lo que me va metiendo por teclado
		entrada = s.nextLine();	
		lista.add(entrada);
		//Ya tengo las lineas cogidas.
		m.jolly(lista);
		s.close();
	}
	
	public void jolly (ArrayList <String>lista) {
		ArrayList <Integer> restas = new ArrayList <Integer> ();
		Iterator it = lista.iterator();
		while (it.hasNext()) {
			String fila = (String) it.next();
			StringTokenizer tokens = new StringTokenizer(fila);
			int n1 = Integer.parseInt(tokens.nextToken());
			int n2 = 0;
			int cont = 0; //Para saber cuantos numeros tengo
			while (tokens.hasMoreTokens()) {
				cont ++;
				n2 = Integer.parseInt(tokens.nextToken());
				if (n1 > n2) restas.add(n1 - n2);
				else restas.add(n2 - n1);
				n1 = n2;
			}
			int cont2 = 0; //para comprobar que todos las restas hechas son menores al numero de numeros
			Iterator it2 = restas.iterator();
			while (it2.hasNext()) {
				int n = (int) it2.next();
				if (n>0 && n<=cont) cont2++;
			}
			if (cont2 == cont) System.out.println("Jolly");
			else System.out.println("No Jolly");
		}
	}

}
