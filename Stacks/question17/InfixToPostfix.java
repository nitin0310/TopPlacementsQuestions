package question17;
import java.io.*;
import java.util.*;

public class InfixToPostfix {

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String expr="";
		System.out.println("Enter expression : ");
		expr=br.readLine();
		convertInfixToPostfix(expr);
	}
	
	static void convertInfixToPostfix(String expr) {
		//done in question2
	}
	
	
}
