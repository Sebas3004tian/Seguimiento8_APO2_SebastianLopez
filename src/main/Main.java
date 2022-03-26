package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.OlimpicoData;

public class Main {
	private Scanner sc;
	private OlimpicoData data;
	
	public Main() {
		sc= new Scanner(System.in);
		data=new OlimpicoData();
	}
	
	public static void main(String[] args) {
		Main inicio = new Main();
		inicio.inicio();
	} 
	public void inicio() {
		boolean salir = true;
		do{
			System.out.println("Seleccione:");
			System.out.println("(1).Si desea ingresar los paises.");
			System.out.println("(2).Si desea que se lea el archivo txt de paises.");
			System.out.println("(0).Salir.");
			
			int respuesta=sc.nextInt();
			
			if(respuesta==1) {
				data=new OlimpicoData();
				int numPaises=sc.nextInt();
				String pais="";
				for(int i=0;i<numPaises;i++) {
					sc.nextLine();
					pais=sc.next();
					separarDatos(pais);
				}
				System.out.println(data.listMas()+"\n"+data.listFem()+"\n"+data.listComb());
			}else if(respuesta==2) {
				
				data=new OlimpicoData();
				try {
					leerTXT();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(data.listMas()+"\n"+data.listFem()+"\n"+data.listComb());
			}else if(respuesta==0) {
				System.out.println("Saliendo de la aplicacion...");
				salir=false;
			}else {
				System.out.println("Ingresa un numero valido...");
			}
		} while(salir);
		
	}
	public void leerTXT() throws IOException {
		String path="Pruebas.txt";
		FileReader fr = new FileReader(path);
		BufferedReader br = new BufferedReader(fr);
		String line;
		while((line = br.readLine()) != null) {
			separarDatos(line);
		}
		if (br != null)br.close();
        if (fr != null)fr.close();
		
	}
	public void separarDatos(String pais) {
		String[] datoResultado = pais.split(";");
		
        String nPais = datoResultado[0];
        int oroM = Integer.parseInt(datoResultado[1]);
        int plataM = Integer.parseInt(datoResultado[2]);
        int bronceM =Integer.parseInt(datoResultado[3]);
        int oroF = Integer.parseInt(datoResultado[4]);
        int plataF = Integer.parseInt(datoResultado[5]);
        int bronceF = Integer.parseInt(datoResultado[6]);
        
        data.add(nPais, oroM, plataM, bronceM, oroF, plataF, bronceF);
	}
	

}
