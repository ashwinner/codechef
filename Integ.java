import java.io.*;

public class Integ {
    public static void main (String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());

        long[] array = new long[n];
        String[] numbers = in.readLine().split(" ");
        for(int i=0;i<n;++i)
            array[i]=Long.parseLong(numbers[i]);
        
        long x = Long.parseLong(in.readLine());
        long cost=0;
        int nneg;
        while(true) {
            nneg=0;
            for(int i=0;i<n;++i)
                if(array[i]<0)
                    nneg++;
            if(nneg>x) {
                for(int i=0;i<n;++i)
                    array[i]++;
                cost+=x;
            }

            else
                break;
        }

        for(int i=0;i<n;++i)
            if(array[i]<0)
                cost+=Math.abs(array[i]);

        System.out.println(cost);
    }
}


