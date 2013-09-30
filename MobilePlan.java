import java.io.*;

public class MobilePlan  {

	public static void main(String[] args) throws Exception{
	
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(reader.readLine());
		String inputLine[];
		while(testCases-->0) {
			inputLine = reader.readLine().split(" ");
			float baseTariff = Float.parseFloat(inputLine[0]);
			int minutes = Integer.parseInt(inputLine[1]);
			int bestPlan = 0;
			float minCost = baseTariff*minutes;
			
			int plans = Integer.parseInt(inputLine[2]);
			for(int i=1;i<=plans;++i) {
				inputLine=reader.readLine().split(" ");
				int validity = Integer.parseInt(inputLine[0]);
				float tariff = Float.parseFloat(inputLine[1]);
				int planCost = Integer.parseInt(inputLine[2]);
				
				float totalCost = ((float)planCost/validity)+(tariff*minutes);
				
				if(totalCost<minCost) {
					minCost = totalCost;
					bestPlan = i;
				}
			}
			System.out.println(bestPlan);
		}
	}
}
			
