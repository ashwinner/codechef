import java.io.*;

public class Maandi {

    public static void main(String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int testCases = Integer.parseInt(in.readLine());
        
        int overLuckyDivisors;

        while(testCases-->0) {

            int n = Integer.parseInt(in.readLine());
            overLuckyDivisors = 0;

            for ( int i=2;i*i<=n;++i) {

                if(n%i==0) {
                    if(isOverLucky(i))
                        overLuckyDivisors++;

                    if(isOverLucky(n/i))
                        overLuckyDivisors++;
                }
            }

            if(isOverLucky(n))
                overLuckyDivisors++;

            out.println(overLuckyDivisors);
        }
        out.flush();
    }

    static boolean isOverLucky(int num) {

        do {
            int digit=num%10;
            
            if(digit==7||digit==4)
                return true;

            num=num/10;
        } while (num>0);
    
        return false;
    }
}


            
