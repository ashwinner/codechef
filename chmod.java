import java.io.*;

public class chmod {
    public static void main(String[] args) throws Exception {
       
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int n = Integer.parseInt(in.readLine());
        int[] array = new int[n+1];
        String[] input = in.readLine().split(" ");
        for(int i=1;i<=n;++i)
            array[i]=Integer.parseInt(input[i-1]);

        //array of primes under 100
        int[] prime = {0,2,3,5,7,11,13,17,19,23,29,31,37,41,43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
        int[][] cf = new int[n+1][26];
        
        //calculating cumulative frequencies of prime factors of input.
        for(int i=1;i<=n;++i) {
            for(int j=1;j<26;++j) 
                cf[i][j]=cf[i-1][j];
            addCumulativeFreq(cf[i], prime, array[i]); 
        }

        int testCases = Integer.parseInt(in.readLine());
        int low,high;
        long modulus;
        while(testCases-->0) {
            input = in.readLine().split(" ");
            low = Integer.parseInt(input[0]);
            high = Integer.parseInt(input[1]);
            modulus = Long.parseLong(input[2]);
            
            long res=1;
            for(int i=1;i<26;++i) {
                int temp = cf[high][i]-cf[low-1][i];
                 
                if(temp>0) 
                    res=res*modPow(prime[i], temp, modulus)%modulus;
                    
            }
            res=res%modulus;
            out.println(res);
        }
        out.flush();
    }
    
    private static long modPow(long num, long pow, long modulus) {
        long res = 1;
        while(pow>0) {
            if(pow%2==1)
                res=(res*num)%modulus;
            pow=pow>>1;
            num = (num*num)%modulus;
        }
        return res;
    }
    
    private static void addCumulativeFreq(int cf[],int prime[],int num) {
        for(int i=1;i<26;++i) {
            while(num%prime[i]==0) {
                cf[i]++;
                num/=prime[i]; 
            }
        }
    }

}


