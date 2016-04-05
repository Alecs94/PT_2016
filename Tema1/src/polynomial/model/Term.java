package polynomial.model;

public class Term {

	private int degree;
	private float coefficient;

	public Term(int degree, float coefficient) {
		super();
		this.degree = degree;
		this.coefficient = coefficient;
	}

	public int getDegree() {
		return degree;
	}

	public void setDegree(int degree) {
		this.degree = degree;
	}

	public float getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(float coefficient) {
		this.coefficient = coefficient;
	}

}
