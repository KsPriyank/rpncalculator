package rpncalc;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestRPNCalcPercentage {
	String expression;
	RPNCalculator calculator = new RPNCalculator();
	double result;
	
	@Test
	public void testValidCalcPercentage () throws Exception
	{
		expression = "4 %";
		result = calculator.calculate(expression);
		assertTrue(result == 0.04);	
		
		expression = "40000	 % %  %";
		result = calculator.calculate(expression);
		assertTrue(result == 0.04);
	}
	
	@Test
	public void testValidCalcDoublePercentage() throws Exception
	{
		expression = "4 % %";
		result = calculator.calculate(expression);
		assertTrue(result == 0.0004);	
	}
	
	@Test(expected = InvalidExpressionException.class) 
	public void testEmptyExpression() throws Exception{
		expression = "";
		calculator.calculate(expression);
	}
	
	@Test(expected = InvalidExpressionException.class) 
	public void testNullExpression() throws Exception{
		
		expression = null;
		calculator.calculate(expression);
	}
	
	@Test(expected = InvalidExpressionException.class) 
	public void testOperandOnlyExpression() throws Exception{
		
		expression = "2";
		calculator.calculate(expression);
	}
	
	@Test(expected = InvalidExpressionException.class) 
	public void testOperatorOnlyExpression() throws Exception{
		
		expression = "%";
		calculator.calculate(expression);
	}
	
	@Test(expected = InvalidExpressionException.class) 
	public void testInvalidExpression() throws Exception{
		
		expression = "% 4";
		calculator.calculate(expression);
	}
	
	@Test(expected = InvalidExpressionException.class) 
	public void testCharacterOperandExpression() throws Exception{
		
		expression = "r %";
		calculator.calculate(expression);
	}
	


}
