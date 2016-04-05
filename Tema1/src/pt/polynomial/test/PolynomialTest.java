package pt.polynomial.test;
import pt.polynomial.logic.Operation;
import pt.polynomial.model.*;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.junit.Before;
import org.junit.Test;

public class PolynomialTest {


	private  Polynomial p1;
    private  Polynomial p2;
    @Before
    public void init(){
    	  // 2x^3 + 2x^2 + 1x^0

        Monom term1Poly1 = new Monom(2, 3);
        Monom term2Poly1 = new Monom(2, 2);
        Monom term3Poly1 = new Monom(1, 0);

        p1 = new Polynomial();
        p1.addTerm(term1Poly1);
        p1.addTerm(term2Poly1);
        p1.addTerm(term3Poly1);
        // 3x^3 -2x^2 + 5x^0

        Monom term1Poly2 = new Monom(3, 3);
        Monom term2Poly2 = new Monom(-2, 2);
        Monom term3Poly2 = new Monom(5, 0);

        p2 = new Polynomial();
        p2.addTerm(term1Poly2);
        p2.addTerm(term2Poly2);
        p2.addTerm(term3Poly2);
    	
    }

    @Test
    public void add() throws Exception {
      

        Polynomial actual = Operation.addOperation(p1, p2);
        System.out.println(actual);

  
        Monom expectedTerm1 = new Monom(5, 3);
        Monom expectedTerm2 = new Monom(0, 2);
        Monom expectedTerm3 = new Monom(6, 0);
       

        Polynomial expected = new Polynomial();
        expected.addTerm(expectedTerm1);
        expected.addTerm(expectedTerm2);
        expected.addTerm(expectedTerm3);
        
        System.out.println(expected);
        
        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void sub() throws Exception {

        Polynomial actual =Operation.subtractOperation(p1, p2);
        System.out.println(actual);

        
        Monom expectedTerm1 = new Monom(-1, 3);
        Monom expectedTerm2 = new Monom(4, 2);
        Monom expectedTerm3 = new Monom(-4, 0);

        Polynomial expected = new Polynomial();
        expected.addTerm(expectedTerm1);
        expected.addTerm(expectedTerm2);
        expected.addTerm(expectedTerm3);
           
        System.out.println(expected);
        
        Assert.assertEquals(expected, actual);
    }
    
    @Test
    public void multiply() throws Exception {
        Polynomial actual =Operation.multiplicationOperation(p1, p2);
        System.out.println(actual);

        //    +6.0x^6 +2.0x^5 -4.0x^4 +13.0x^3 +8.0x^2 +5.0
        Monom expectedTerm1 = new Monom(6, 6);
        Monom expectedTerm2 = new Monom(2, 5);
        Monom expectedTerm3 = new Monom(13, 3);
        Monom expectedTerm4 = new Monom(-4, 4);
        Monom expectedTerm5 = new Monom(8, 2);
        Monom expectedTerm6 = new Monom(5, 0);

        Polynomial expected = new Polynomial();
        expected.addTerm(expectedTerm1);
        expected.addTerm(expectedTerm2);
        expected.addTerm(expectedTerm3);
        expected.addTerm(expectedTerm4);
        expected.addTerm(expectedTerm5);
        expected.addTerm(expectedTerm6);
        
        System.out.println(expected);
        
        Assert.assertEquals(expected, actual);
    }
    //@Test
    /*public void divide() throws Exception {
    
        Polynomial cat=new Polynomial();
        Polynomial rest=new Polynomial();
        
        Operation.divisionOperation(p1,p2);
     

        // 
        Monom expectedTerm1cat = new Monom(1, 0);
      

        Polynomial expectedCat = new Polynomial();
        expectedCat.addTerm(expectedTerm1cat);
        
        Monom expectedTerm1rest = new Monom(-9, 0);
        Monom expectedTerm2rest= new Monom(7, 1);
        
        Polynomial expectedRest=new Polynomial();
        expectedRest.addTerm(expectedTerm2rest);
        expectedRest.addTerm(expectedTerm1rest);
        
        
       
        
        Assert.assertEquals(expectedCat, cat);
        Assert.assertEquals(expectedRest, rest);

    }*/
    @SuppressWarnings("deprecation")
	@Test
    public void deriv() throws Exception {
        
        Monom expectedTerm1 = new Monom(6, 2);
        Monom expectedTerm2 = new Monom(4, 1);
        Monom expectedTerm3 = new Monom(0, -1);
        
        Polynomial actual = Operation.differentiationOperation(p1);
        System.out.println(actual);
        Polynomial expected = new Polynomial();
        expected.addTerm(expectedTerm1);
        expected.addTerm(expectedTerm2);
        expected.addTerm(expectedTerm3);
        
        
        System.out.println(expected);
        
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void integr() throws Exception {
       
        Monom expectedTerm1 = new Monom(0.5,4);
        Monom expectedTerm2 = new Monom(0.67,3);
        Monom expectedTerm3 = new Monom(1, 1);
        Polynomial actual = Operation.integrationOperation(p1);
        System.out.println(actual);
        Polynomial expected = new Polynomial();
        expected.addTerm(expectedTerm1);
        expected.addTerm(expectedTerm2);
        expected.addTerm(expectedTerm3);
        
        System.out.println(expected);
        
        Assert.assertEquals(expected, actual);
    }

}


