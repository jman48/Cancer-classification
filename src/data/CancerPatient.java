package data;

import java.util.ArrayList;
import java.util.List;

public class CancerPatient {

	private int id;
	private int ct; // Clump thickness
	private int usz; // Uniformity of Cell Size
	private int ushp;	//Uniformity of Cell Shape
	private int ma;	//Marginal Adhesion
	private int bn;	//Bare Nuclei
	private int bc;	//Bland Chromatin
	private int nn;	//Normal Nucleoli
	private int m;	//Mitoses
	
	/**
	 * Construct a new cancer patient
	 * 
	 * @param id The id of the cancer patient
	 * @param ct Clump thickness
	 * @param usz Uniformity of Cell Size
	 * @param ushp Uniformity of Cell Shape
	 * @param ma Marginal Adhesion
	 * @param bn Bare Nuclei
	 * @param bc Bland Chromatin
	 * @param nn Normal Nucleoli
	 * @param m Mitoses
	 */
	public CancerPatient(int id, int ct, int usz, int ushp, int ma, int bn,
			int bc, int nn, int m) {
		this.id = id;
		this.ct = ct;
		this.usz = usz;
		this.ushp = ushp;
		this.ma = ma;
		this.bn = bn;
		this.bc = bc;
		this.nn = nn;
		this.m = m;
	}

	public int getId() {
		return id;
	}

	/**
	 * Get Clump thickness
	 * @return
	 */
	public int getCt() {
		return ct;
	}

	/**
	 * Get Uniformity of Cell Size
	 * @return
	 */
	public int getUsz() {
		return usz;
	}

	/**
	 * Get Uniformity of Cell Shape
	 * @return
	 */
	public int getUshp() {
		return ushp;
	}

	/**
	 * Get Marginal Adhesion
	 * @return
	 */
	public int getMa() {
		return ma;
	}

	/**
	 * Get Bare Nuclei
	 * @return
	 */
	public int getBn() {
		return bn;
	}

	/**
	 * Get Bland Chromatin
	 * @return
	 */
	public int getBc() {
		return bc;
	}

	/**
	 * Get Normal Nucleoli
	 * @return
	 */
	public int getNn() {
		return nn;
	}

	/**
	 * Get Mitoses
	 * @return
	 */
	public int getM() {
		return m;
	}

	
}
