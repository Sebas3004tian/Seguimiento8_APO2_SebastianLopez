package model;

public class Femenino extends Pais implements Comparable<Femenino>{
	

	public Femenino(String pais, int oro, int plata, int bronce) {
		super(pais, oro, plata, bronce);
	}

	@Override
	public int compareTo(Femenino o) {
		Femenino B = this;
		Femenino A = o;
		
		int comOro=B.getOro()-A.getOro();
		if(comOro==0) {
			int comPlata=B.getPlata()-A.getPlata();
			if(comPlata==0) {
				int comBronce=B.getBronce()-A.getBronce();
				if(comBronce==0) {
					int comPais=A.getPais().compareTo(B.getPais());
					return comPais;
				}else {
					return comBronce;
				}
			}else {
				return comPlata;
			}
		}else {
			return comOro;
		}
	}
}
