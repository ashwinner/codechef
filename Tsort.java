import java.io.*;
import java.util.*;

public class Tsort {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
int n = Integer.parseInt(reader.readLine());
		int[] numbers = new int[n];
		while(n>0)
			numbers[--n] = Integer.parseInt(reader.readLine());
		Arrays.sort(numbers);
		for (int num : numbers)
			out.println(num);
		out.flush();
	}
}
