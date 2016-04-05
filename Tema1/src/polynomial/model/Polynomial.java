package polynomial.model;

import java.util.ArrayList;
import java.util.List;
import java.text.*;
public class Polynomial {
	private List<Term> terms;

	public Polynomial(Polynomial p) {
		this.terms = new ArrayList<Term>();
		for (Term t : p.getTerms()) {
			terms.add(new Term(t.getDegree(), t.getCoefficient()));
		}
	}

	public Polynomial() {
		super();
		this.terms = new ArrayList<Term>();
	}

	public List<Term> getTerms() {
		return terms;
	}

	public void setTerms(List<Term> terms) {
		this.terms = terms;
	}

	public void addTerm(Term t) {

		boolean exists = false;

		for (Term t1 : terms) {
			if (t1.getDegree() == t.getDegree()) {
				float coeff = t1.getCoefficient();
				coeff += t.getCoefficient();
				t1.setCoefficient(coeff);
				exists = true;
			}
		}

		if (exists == false) {
			terms.add(new Term(t.getDegree(), t.getCoefficient()));
		}

	}

	public void polyFromString(String poly) {
		int i = 0, coeff = 0, pow = 0, sign = 1;

		if (i < poly.length() && poly.charAt(i) == '-') {
			sign = -1;
		} else {
			sign = 1;
		}

		while (i < poly.length()) {
			if (i < poly.length() && '0' <= poly.charAt(i) && poly.charAt(i) <= '9') {
				coeff = 0;
				coeff = poly.charAt(i) - '0';
				i++;
			
				while (i < poly.length() && '0' <= poly.charAt(i) && poly.charAt(i) <= '9') {
					coeff = coeff * 10 + (poly.charAt(i) - '0');
					i++;
				}

				if (coeff == 0) {
					coeff = 1;
				}
				if (i < poly.length() && poly.charAt(i) == 'x') {
					i++;
				}
				if (i < poly.length() && poly.charAt(i) == '^') {
					i++;
				}
				pow = 0;
				pow = poly.charAt(i) - '0';
				i++;
				while (i < poly.length() && '0' <= poly.charAt(i) && poly.charAt(i) <= '9') {
					pow = pow * 10 + (poly.charAt(i) - '0');
					i++;
				}
				if (i < poly.length() && poly.charAt(i) == '-')
					sign = -1;
				else
					sign = 1;
				terms.add(new Term(pow, sign * coeff));
			}
			i++;
		}
	}

	public String toString() {
		String s = new String();
		NumberFormat numberFormat = new DecimalFormat("+##.#;-#");

		for (Term currentTerm : terms) {
			String currentCoefficient;
			if (currentTerm.getCoefficient() != 1) {
				currentCoefficient = numberFormat.format(currentTerm.getCoefficient());
			} else {
				currentCoefficient = "+";
			}

			if (currentTerm.getCoefficient() != 0) {
				if (currentTerm.getDegree() > 1) {
					s = s + currentCoefficient + "x^" + currentTerm.getDegree() + " ";
				} else if (currentTerm.getDegree() == 1) {
					s = s + currentCoefficient + "x^1";
				} else {
					s = s + currentCoefficient+ "x^0";
				}
			}
		}
		if (s.startsWith("+")) {
			s = s.substring(1);
		}
		if(s.length()==0)
		{
			s=s+"0";
		}
		return s;
	}
	
	public void clear()
	{
		this.terms.clear();
	}
}