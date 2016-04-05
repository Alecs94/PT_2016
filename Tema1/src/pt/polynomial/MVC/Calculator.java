package pt.polynomial.MVC;

public class Calculator {

	public Calculator() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String []args){
		MainView window = new MainView();
		Controller control = new Controller(window);	
	}
}
