package data;

import java.util.ArrayList;
import java.util.List;

public class CancerPatient {

	private int id;
	private int ct; // Clump thickness
	private int usz; // Uniformity of Cell Size
	private int ushp; // Uniformity of Cell Shape
	private int ma; // Marginal Adhesion
	private int bn; // Bare Nuclei
	private int bc; // Bland Chromatin
	private int nn; // Normal Nucleoli
	private int m; // Mitoses

	/**
	 * Construct a new cancer patient
	 * 
	 * @param id
	 *            The id of the cancer patient
	 * @param ct
	 *            Clump thickness
	 * @param usz
	 *            Uniformity of Cell Size
	 * @param ushp
	 *            Uniformity of Cell Shape
	 * @param ma
	 *            Marginal Adhesion
	 * @param bn
	 *            Bare Nuclei
	 * @param bc
	 *            Bland Chromatin
	 * @param nn
	 *            Normal Nucleoli
	 * @param m
	 *            Mitoses
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
	
	private CancerPatient(PatientBuilder builder) {
		this.id = builder.id;
		this.ct = builder.ct;
		this.usz = builder.usz;
		this.ushp = builder.ushp;
		this.ma = builder.ma;
		this.bn = builder.bn;
		this.bc = builder.bc;
		this.nn = builder.nn;
		this.m = builder.m;
	}

	public int getId() {
		return id;
	}

	/**
	 * Get Clump thickness
	 * 
	 * @return
	 */
	public int getCt() {
		return ct;
	}

	/**
	 * Get Uniformity of Cell Size
	 * 
	 * @return
	 */
	public int getUsz() {
		return usz;
	}

	/**
	 * Get Uniformity of Cell Shape
	 * 
	 * @return
	 */
	public int getUshp() {
		return ushp;
	}

	/**
	 * Get Marginal Adhesion
	 * 
	 * @return
	 */
	public int getMa() {
		return ma;
	}

	/**
	 * Get Bare Nuclei
	 * 
	 * @return
	 */
	public int getBn() {
		return bn;
	}

	/**
	 * Get Bland Chromatin
	 * 
	 * @return
	 */
	public int getBc() {
		return bc;
	}

	/**
	 * Get Normal Nucleoli
	 * 
	 * @return
	 */
	public int getNn() {
		return nn;
	}

	/**
	 * Get Mitoses
	 * 
	 * @return
	 */
	public int getM() {
		return m;
	}
	
	@Override
	public String toString() {
		return "Patient - id: " + id + " ct: " + ct + " usz: " + usz + " ushp: " + ushp + " ma: " + ma + " bn: " + bn + " bc: " + bc + " nn: " + nn + " m: " + m; 		
	}

	public static class PatientBuilder {
		private int id;
		private int ct; // Clump thickness
		private int usz; // Uniformity of Cell Size
		private int ushp; // Uniformity of Cell Shape
		private int ma; // Marginal Adhesion
		private int bn; // Bare Nuclei
		private int bc; // Bland Chromatin
		private int nn; // Normal Nucleoli
		private int m; // Mitoses

		public PatientBuilder(int id) {
			this.id = id;
		}

		public PatientBuilder ct(int ct) {
			this.ct = ct;
			return this;
		}

		public PatientBuilder usz(int usz) {
			this.usz = usz;
			return this;
		}

		public PatientBuilder ushp(int ushp) {
			this.ushp = ushp;
			return this;
		}

		public PatientBuilder ma(int ma) {
			this.ma = ma;
			return this;
		}

		public PatientBuilder bn(int bn) {
			this.bn = bn;
			return this;
		}

		public PatientBuilder bc(int bc) {
			this.bc = bc;
			return this;
		}

		public PatientBuilder nn(int nn) {
			this.nn = nn;
			return this;
		}

		public PatientBuilder m(int m) {
			this.m = m;
			return this;
		}
		
		public CancerPatient build() {
			return new CancerPatient(this);
		}
	}

}
