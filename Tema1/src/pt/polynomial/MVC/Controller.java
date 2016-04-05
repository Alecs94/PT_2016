package pt.polynomial.MVC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

import pt.polynomial.model.Polynomial;
import pt.polynomial.logic.*;

public class Controller {

	private MainView view;
	private Polynomial result = new Polynomial();
	private Polynomial result2 = new Polynomial();

	public Controller(MainView view) {
		super();
		this.view = view;
		setupControl();
	}

	public void setupControl() {
		ActionListener actL = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Polynomial p1 = PolynomialParser.parse(view.polynomial1.getText());
				Polynomial p2 = PolynomialParser.parse(view.polynomial2.getText());

				if (e.getSource() == view.addButton) {
					result = Operation.addOperation(p1, p2);
					Collections.sort(result.terms);
				}
				if (e.getSource() == view.subButton) {
					result = Operation.subtractOperation(p1, p2);
					Collections.sort(result.terms);
				}
				if (e.getSource() == view.clearButton) {
					view.result.setText(null);
				}
				if (e.getSource() == view.mulButton) {
					result = Operation.multiplicationOperation(p1, p2);
					Collections.sort(result.terms);
				}
				if (e.getSource() == view.divButton) {
					result = Operation.divisionOperation(p1, p2).get(0);
					result2 = Operation.divisionOperation(p1, p2).get(1);
					Collections.sort(result.terms);
					Collections.sort(result2.terms);
					view.result.setText(result.toString() + " rest " + result2.toString());
				}
				if (e.getSource() == view.integrateButton) {
					result = Operation.integrationOperation(p1);
					Collections.sort(result.terms);
				}
				if (e.getSource() == view.derivateButton) {
					result = Operation.differentiationOperation(p1);
					Collections.sort(result.terms);
				}
				updateResult();
			}
		};

		view.addButton.addActionListener(actL);
		view.subButton.addActionListener(actL);
		view.clearButton.addActionListener(actL);
		view.divButton.addActionListener(actL);
		view.mulButton.addActionListener(actL);
		view.integrateButton.addActionListener(actL);
		view.derivateButton.addActionListener(actL);
	}

	

	private void updateResult() {
		view.result.setText(result.toString());
	}
}
