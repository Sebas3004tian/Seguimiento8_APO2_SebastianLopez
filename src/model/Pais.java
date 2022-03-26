package model;

public class Pais {
	private String pais;
	private int oro;
	private int plata;
	private int bronce;
	
	public Pais(String pais, int oro, int plata, int bronce) {
		this.pais = pais;
		this.oro = oro;
		this.plata = plata;
		this.bronce = bronce;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public int getOro() {
		return oro;
	}

	public void setOro(int oro) {
		this.oro = oro;
	}

	public int getPlata() {
		return plata;
	}

	public void setPlata(int plata) {
		this.plata = plata;
	}

	public int getBronce() {
		return bronce;
	}

	public void setBronce(int bronce) {
		this.bronce = bronce;
	}
	
	public String toString() {
		return getPais()+" "+getOro()+" "+getPlata()+" "+getBronce();
	}
}
