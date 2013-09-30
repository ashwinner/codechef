import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Factorial {
	public static void main(String[] args) throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
		int t =  Integer.parseInt(reader.readLine());
	
		while(t-->0) {
	
			int n = Integer.parseInt(reader.readLine());
			out.println(factorial(n));
		}

		out.flush();
	}

	public static BigInteger factorial(Integer n) {
	
		BigInteger product = BigInteger.ONE;
		
		while(n > 0) {
			product = product.multiply(new BigInteger(n.toString()));
			--n;
		}

		return product;
	}
}
