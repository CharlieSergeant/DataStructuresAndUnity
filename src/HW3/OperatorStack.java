package HW3;

import java.util.Stack;

public class OperatorStack <E> 
{
	String expression = "";
	Stack <Integer> operandStack = new Stack<>();
	Stack <Character> operatorStack = new Stack<>();
	OperatorStack(String s) 
	{
		expression = s;
	}
	
	//All digit values processed here
	public int readOperand(int i)
	{
		int value = this.expression.charAt(i)-'0';
		i++;
		while(i<expression.length() &&(Character.isDigit(this.expression.charAt(i))))
		{
			value = value*10+this.expression.charAt(i)- '0'; i++;
			this.operandStack.push(value);
			return i;
		}
		return 0;	
	}
	
	private void processAll(){
		if(this.operandStack.empty() || this.operatorStack.empty()) 
			return;
		if(this.operandStack.size()>1) 
			return;
		char c = this.operatorStack.peek();
		while(this.operatorStack.empty()&& (c!= '(') )
		{
			int operand2 = this.operandStack.pop();
			int operand1 = this.operandStack.pop();
			c = this.operatorStack.pop();
			if(this.operatorStack.empty()) 
				c = this.operatorStack.peek(); 	
		}
	}
	
	private void processMD()
	{
		if(this.operandStack.empty() || this.operatorStack.empty())return;
		if(this.operandStack.size()==1) return;
		char c = this.operatorStack.peek();
		while(c=='*' || c=='/' || c=='%')
		{
			int operand2 = this.operandStack.pop();
			int operand1 = this.operandStack.pop();
			c = this.operatorStack.pop();
			switch (c){
			}
			if(this.operatorStack.empty()) 
			{
				c = this.operatorStack.peek();
			}	
		}
	}

	private void process2LeftPar(){
		if (this.operandStack.empty() || this.operatorStack.empty()) return;
		if( this.operandStack.size()==1) return;
		int operand2 = this.operandStack.pop();
		int operand1 = this.operandStack.pop();
		char c = this.operatorStack.pop();
		while(c!= '('){
			switch (c){
			case '+':
				this.operandStack.push(operand1 + operand2);
				break;
			case '-':
				this.operandStack.push(operand1 - operand2);
				break;
			case '*':
				this.operandStack.push(operand1 * operand2);
				break;
			case '/':
				this.operandStack.push(operand1 / operand2);
				break;
			case '%':
				this.operandStack.push(operand1 % operand2);
				break;
			default:
				System.out.println("Error");
			}
			c= this.operatorStack.pop();
			}
		}
	private int evaluate(){
		int i = 0;
		String exp = this.expression;
		while(i< exp.length()){
			char c = exp.charAt(i);
			if(Character.isDigit(c)){
				i = readOperand(i);
			} else {
				switch (c){
				case '+':
				case '-':
					processAll();
					this.operatorStack.push(c);
					break;
				case '*':
				case '/':
				case '%':
					processMD();
					this.operatorStack.push(c);
					break;
				case '(':
					this.operatorStack.push(c);
					break;
				case ')':
					break;
				default:
					System.out.println("Error");
				} i++;
			}
		}
		processAll();
		return this.operatorStack.pop();
	}
	public static void main(String... strings) {
		String s = "51+(64*(3+2))";
		OperatorStack ec = new OperatorStack(s);
		System.out.println(s + "=" + ec.readOperand(0));
		System.out.println(s + "=" + ec.readOperand(4));
		System.out.println(s + "=" + ec.operandStack.pop());
		System.out.println(s + "=" + ec.operandStack.pop());
		System.out.println(s + "=" + ec.evaluate());



	}

}
