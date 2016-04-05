package pt.polynomial.MVC;
import java.util.regex.*;
import pt.polynomial.model.*;

import java.util.*;
import java.util.regex.Pattern;

public class PolynomialParser {

	public PolynomialParser() {
		
	}
	
	public static Polynomial parse(String polynomialString) {
		Polynomial result = new Polynomial();
		
		Pattern p = Pattern.compile("(-?\\b\\d+)[xX]\\^(-?\\d+\\b)");		
		Matcher m = p.matcher(polynomialString);
		
		while (m.find()){
			Monom monomTemp = new Monom(0, 0);
			monomTemp.coefficient = Double.parseDouble(m.group(1));
			monomTemp.power = Integer.parseInt(m.group(2));
			result.addTerm(monomTemp);
		}
		
		return result;
	}

}
