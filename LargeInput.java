import java.io.*;
import java.util.*;

public class LargeInput {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputLine;
		inputLine = br.readLine().split(" ");
		int n = Integer.parseInt(inputLine[0]);
		int k = Integer.parseInt(inputLine[1]);
		int temp=0, count=0;
		while(n-->0) {
			temp = Integer.parseInt(br.readLine());
			if(temp%k==0)
				count++;
		}

		System.out.println(count);
	}
}
