package rpncalc;

import java.util.Stack;

public class RPNCalculator {

	Stack<Double> rpnStack = new Stack<>();
	
	public double calculate(String expression) throws Exception{
		
		boolean valid = isValid(expression);
		if ( !valid){
			throw new InvalidExpressionException();
		}
		
		String[] expressionArray = expression.split("\\s+");
		
		
		for (String element : expressionArray){
			element = element.trim();
			if ( "%".equals(element)){
				if ( rpnStack.isEmpty()){
					throw new InvalidExpressionException();
				}
				
				Double operand = rpnStack.pop();
				rpnStack.push(operand / 100);
			}
			else
			{
				try{
					rpnStack.push(Double.parseDouble(element));
				}catch(NumberFormatException ex){
					throw new InvalidExpressionException();
				}
				
			}
		}
		return rpnStack.pop();
	}

	private boolean isValid(String expression) {
		return (expression != null && expression.length() > 1) ;
	}
	
}
