package pt.polynomial.logic;
import pt.polynomial.model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import pt.polynomial.model.*;

public class Operation {

	public Operation() {

	}

	public static Polynomial addOperation(Polynomial poly1, Polynomial poly2) {
		Polynomial poly1Copy = poly1.copy();
		for (Monom m : poly2.terms) {
			poly1Copy.addTerm(m);
		}

		return poly1Copy;
	}

	public static Polynomial subtractOperation(Polynomial poly1, Polynomial poly2) {
		Polynomial poly1Copy = new Polynomial();
		poly1Copy = poly1.copy();
		for (Monom m : poly2.terms) {
			Monom mCopy = new Monom(m.coefficient, m.power);
			mCopy.coefficient = (-1) * mCopy.coefficient;
			poly1Copy.addTerm(mCopy);
		}

		return poly1Copy;
	}

	public static Polynomial differentiationOperation(Polynomial poly) {
		Polynomial polyNew = new Polynomial();

		for (Monom m : poly.terms) {
			Monom mCopy = new Monom(m.coefficient, m.power);
			mCopy.coefficient *= mCopy.power;
			mCopy.power--;
			polyNew.addTerm(mCopy);
		}

		return polyNew;
	}

	public static Polynomial integrationOperation(Polynomial poly) {
		Polynomial polyNew = new Polynomial();

		for (Monom m : poly.terms) {
			Monom mCopy = new Monom(m.coefficient, m.power);
			mCopy.coefficient /= mCopy.power + 1;
			mCopy.coefficient = (double) Math.round(mCopy.coefficient * 100.0) / 100;
			mCopy.power++;
			polyNew.addTerm(mCopy);
		}

		return polyNew;
	}

	public static Polynomial multiplicationOperation(Polynomial poly1, Polynomial poly2) {
		Polynomial polyNew = new Polynomial();

		for (Monom m1 : poly1.terms) {
			for (Monom m2 : poly2.terms) {
				Monom newMonom = new Monom(m1.coefficient, m1.power);
				newMonom.coefficient = m1.coefficient * m2.coefficient;
				newMonom.power = m1.power + m2.power;
				polyNew.addTerm(newMonom);
			}
		}

		return polyNew;
	}

	public static Polynomial monomMultiplicationOperation(Polynomial poly1, Monom monom) {
		Polynomial polyNew = new Polynomial();

		for (Monom m1 : poly1.terms) {
			Monom newMonom = new Monom(m1.coefficient, m1.power);
			newMonom.coefficient = m1.coefficient * monom.coefficient;
			newMonom.power = m1.power + monom.power;
			polyNew.addTerm(newMonom);
		}

		return polyNew;
	}

	public static ArrayList<Polynomial> divisionOperation(Polynomial deimp, Polynomial imp) {

		ArrayList<Polynomial> result = new ArrayList<Polynomial>();
		Polynomial quotient = new Polynomial();
		Polynomial remainder = new Polynomial();
		Polynomial partRemainder = deimp.copy();
		Polynomial partQuotient = new Polynomial();
		Polynomial auxPoly = new Polynomial();

		while (!partRemainder.terms.isEmpty() && !imp.terms.isEmpty()
				&& partRemainder.terms.get(0).power >= imp.terms.get(0).power) {
			partQuotient.addTerm(new Monom(partRemainder.terms.get(0).coefficient / imp.terms.get(0).coefficient,
					partRemainder.terms.get(0).power - imp.terms.get(0).power));
			auxPoly = Operation.multiplicationOperation(imp, partQuotient);
			partRemainder = Operation.subtractOperation(partRemainder, auxPoly);
			partRemainder.clearIfZero();
			Collections.sort(partRemainder.terms);
			quotient.addTerm(partQuotient.terms.get(0));
		}
		if(!partRemainder.terms.isEmpty())
		for (Monom m : partRemainder.terms) {
			remainder.addTerm(m);
		}	

		result.add(quotient);
		result.add(remainder);

		return result;
	}

	/*
	 * Monom firstOfRemainder = new Monom(remainder.terms.get(0).coefficient,
	 * remainder.terms.get(0).power); Monom qTerm = new
	 * Monom(firstOfRemainder.coefficient / imp.terms.get(0).coefficient,
	 * firstOfRemainder.power - imp.terms.get(0).power);
	 * quotient.addTerm(qTerm); System.out.println("Quotient:" +
	 * quotient.toString()); remainder = Operation.subtractOperation(remainder,
	 * monomMultiplicationOperation(imp, qTerm)); do { if
	 * (remainder.terms.get(0).coefficient == 0) { remainder.terms.remove(0); }
	 * 
	 * if (qTerm.power > 0) { System.out.println("qR coeff and power before:" +
	 * qTerm.coefficient + " " + qTerm.power); qTerm.coefficient =
	 * remainder.terms.get(0).coefficient / imp.terms.get(0).coefficient;
	 * qTerm.power = remainder.terms.get(0).power - imp.terms.get(0).power;
	 * System.out.println("qR coeff and power after:" + qTerm.coefficient + " "
	 * + qTerm.power); System.out.println("Quotient:" + quotient); } remainder =
	 * Operation.subtractOperation(remainder, monomMultiplicationOperation(imp,
	 * qTerm)); // System.out.println("Remainder: " + remainder);
	 * System.out.println("Quotient:" + quotient.toString());
	 * quotient.addTerm(qTerm); System.out.println("Quotient:" +
	 * quotient.toString()); } while (remainder.terms.get(0).power >=
	 * quotient.terms.get(0).power && qTerm.power > 0); result.add(quotient);
	 * result.add(remainder); return result;
	 */
}
