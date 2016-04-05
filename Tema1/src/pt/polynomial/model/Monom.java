package pt.polynomial.model;

import java.util.*;

public class Monom implements Comparable<Monom>{

	public double coefficient;
	public int power;
	

	public Monom(double coefficient, int power) {
		super();
		this.coefficient = coefficient;
		this.power = power;
	}

	public String toString() {
		
		if (coefficient > 0 && power == 1){
			return " +" + coefficient + "x";
		}
		if (coefficient > 0 && (power > 1 || power < 0)) {
			return " +" + coefficient + "x^" + power;
		}
		if (coefficient > 0 && power == 0) {
			return " +" + coefficient;
		}
		if (coefficient == 0) {
			return "";
		}
		if (coefficient < 0 && power == 1) {
			return " " + coefficient + "x";
		}
		if (coefficient < 0 && (power > 1 || power < 0)) {
			return " " + coefficient + "x^" + power;
		}
		if (coefficient < 0 && power == 0) {
			return " " + coefficient;
		}

		return coefficient + "x";
	}

	@Override
	public int compareTo(Monom o) {
		
		return o.power - this.power;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Monom other = (Monom) obj;
		if (Double.doubleToLongBits(coefficient) != Double.doubleToLongBits(other.coefficient))
			return false;
		if (power != other.power)
			return false;
		return true;
	}

	
	
}
