package polynomial.model;


public class Operation {
	
	public static Polynomial add(Polynomial a, Polynomial b)
	{
		Polynomial result= new Polynomial(a);
		//System.out.println(a.toString());
		//System.out.println(b.toString());
		for(Term t: b.getTerms())
		{
			result.addTerm(t);
		}
		System.out.println(result.toString());
		
		return result;
	}
	
	public static Polynomial sub(Polynomial a, Polynomial b)
	{
		Polynomial result= new Polynomial(a);
		for(Term t: b.getTerms())
		{
			float coeff=t.getCoefficient();
			coeff=coeff*(-1);
			t.setCoefficient(coeff);
			result.addTerm(t);
		}
		return result;
	}
	
	public static Polynomial mul(Polynomial a, Polynomial b)
	{
		Polynomial result= new Polynomial();
		
		for(Term t1: a.getTerms())
		{
			for(Term t2: b.getTerms())
			{
				float coeff=t1.getCoefficient()*t2.getCoefficient();
				int deg=t1.getDegree()+t2.getDegree();
				Term t3= new Term(deg, coeff);
				result.addTerm(t3);
			}
		}
		return result;
	}
	
	public static Polynomial differentiate(Polynomial a)
	{
		Polynomial result= new Polynomial();
		
		for(Term t: a.getTerms())
		{
			float coeff=t.getCoefficient();
			int deg=t.getDegree();
			
			coeff=coeff*deg;
			deg=deg-1;
			Term tResult=new Term(deg, coeff);
			
			result.addTerm(tResult);
		}
		return result;
	}
	
	public static Polynomial integrate(Polynomial a)
	{
		Polynomial result= new Polynomial();
		
		for(Term t: a.getTerms())
		{
			int deg=t.getDegree()+1;
			float coeff=t.getCoefficient()/deg;
			
			Term tResult= new Term(deg, coeff);
			result.addTerm(tResult);
		}
		return result;
	}

}
