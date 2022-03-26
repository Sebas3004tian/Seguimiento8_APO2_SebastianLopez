package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OlimpicoData {
	private List<Femenino> resultadosF;
	private ArrayList<Masculino> resultadosM;
	private ArrayList<Combinado> resultadosComb;
	
	public OlimpicoData() {
		resultadosF=new ArrayList<>();
		resultadosM=new ArrayList<>();
		resultadosComb=new ArrayList<>();
	}
	public void add(String namePais, int oroM, int plataM, int bronceM,int oroF,int plataF,int bronceF) {
       resultadosM.add(new Masculino(namePais, oroM, plataM, bronceM));
       resultadosF.add(new Femenino(namePais, oroF, plataF, bronceF));
       int oro=oroM+oroF;
       int plata=plataM+plataF;
       int bronce=bronceM+bronceF;
       resultadosComb.add(new Combinado(namePais,oro,plata,bronce));
	}
	public String listMas() {
		ordenarMas();
		String list="----------"+"\n"+"Masculino"+"\n";
		for(int i=0;i<resultadosM.size();i++) {
			list+=resultadosM.get(i).toString()+"\n";
		}
		return list;
	}
	public String listFem() {
		ordenarFem();
		String list="----------"+"\n"+"Femenino"+"\n";
		for(int i=0;i<resultadosF.size();i++) {
			list+=resultadosF.get(i).toString()+"\n";
		}
		return list;
	}
	public String listComb() {
		ordenarComb();
		String list="----------"+"\n"+"Combinado"+"\n";
		for(int i=0;i<resultadosComb.size();i++) {
			list+=resultadosComb.get(i).toString()+"\n";
		}
		return list;
	}
	public void ordenarMas() {
		Collections.sort(resultadosM,new Comparator<Masculino>(){
			@Override
			public int compare(Masculino A, Masculino B) {
				if( B.getOro() != A.getOro()) {
					return B.getOro() - A.getOro();
				}else if( B.getPlata() != A.getPlata()){
					return B.getPlata() - A.getPlata();
				}else if( B.getBronce() != A.getBronce()) {
					return B.getBronce() - A.getBronce();
				}else {
					return A.getPais().compareTo(B.getPais());
				}
			}
		});
	}
	public void ordenarFem() {
		Collections.sort(resultadosF);
	}
	public void ordenarComb() {
		int a, b;
		String namePais="";
		int oro=0;
		int plata=0;
		int bronce=0;
        boolean changed=false;
        for(int i=0; i<resultadosComb.size()-1; i++) {
            a = resultadosComb.get(i).getOro();
            for(int j=(i+1); j<resultadosComb.size() && !changed; j++) {
                b = resultadosComb.get(j).getOro();

                if(a<b) {
                   
                    namePais=resultadosComb.get(j).getPais();
                    plata=resultadosComb.get(j).getPlata();
                    bronce=resultadosComb.get(j).getBronce();
                    resultadosComb.remove(j);
                    
                    resultadosComb.add(i,new Combinado(namePais,b,plata,bronce));
                    changed = true;
                    i--;
                }else if(a==b) {
                	a = resultadosComb.get(i).getPlata();
                	b = resultadosComb.get(j).getPlata();
                	if(a<b) {
                        
                        namePais=resultadosComb.get(j).getPais();
                        oro=resultadosComb.get(j).getOro();
                        bronce=resultadosComb.get(j).getBronce();
                        resultadosComb.remove(j);
                        
                        resultadosComb.add(i,new Combinado(namePais,oro,b,bronce));
                        changed = true;
                        i--;
                	}else if(a==b) {
                    	a = resultadosComb.get(i).getBronce();
                    	b = resultadosComb.get(j).getBronce();
                    	if(a<b) {
                            
                            namePais=resultadosComb.get(j).getPais();
                            plata=resultadosComb.get(j).getOro();
                            plata=resultadosComb.get(j).getPlata();
                            resultadosComb.remove(j);
                            
                            resultadosComb.add(i,new Combinado(namePais,oro,plata,b));
                            changed = true;
                            i--;
                    	}else if(a==b) {
                    		String nameA = resultadosComb.get(i).getPais();
                        	String nameB = resultadosComb.get(j).getPais();
                    		int valor=nameA.compareTo(nameB);
                    		if(valor>0) {
                    			
                                oro=resultadosComb.get(j).getOro();
                                plata=resultadosComb.get(j).getPlata();
                                bronce=resultadosComb.get(j).getBronce();
                                resultadosComb.remove(j);
                                
                                resultadosComb.add(i,new Combinado(nameB,oro,plata,bronce));
                                changed = true;
                                i--;
            				}
                    	}
                    }
                }

            }
            changed = false;
        }
	}
}
