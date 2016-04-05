package pt.polynomial.model;
import java.util.*;

public class Polynomial{

	public List<Monom> terms;
	
	public Polynomial(){
		terms = new ArrayList<Monom>();
	}
	
	public void addTerm(Monom term) {
		boolean ok = false;
		for(Monom t : terms){
			if(t.power == term.power) {
				t.coefficient += term.coefficient;
				ok = true;
				break;
			}
		}
		
		if(ok == false){
			terms.add(term);
		}
	}
	
	public String toString(){
		String polyS = "";
		for(Monom t : terms){
			String monomS = t.toString();
			polyS += monomS;
		}
		
		return polyS;
	}
	
	public Polynomial copy(){
		Polynomial p = new Polynomial();
		for(Monom m : terms) {
			if(m.coefficient != 0){
				p.addTerm(new Monom(m.coefficient, m.power));
			}
			
		}
		
		return p;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Polynomial other = (Polynomial) obj;
		if (terms == null) {
			if (other.terms != null)
				return false;
		} else if (!terms.equals(other.terms))
			return false;
		return true;
	}
	
	public void clearIfZero() {
		
		int index = 0;
		if(terms.isEmpty()) {
			return;
		}
		for(Monom m: terms){
			index ++;
			if(m.coefficient == 0){
				break;
			}
		}
		System.out.println(this);
		System.out.println(index);
		index--;
		terms.remove(index);
		
		
	}
	
}
