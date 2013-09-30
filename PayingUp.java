import java.io.*;

public class PayingUp {

    public static void main (String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int testCases = Integer.parseInt(in.readLine());

        while(testCases-->0) {

            String[] input = in.readLine().split(" ");

            int nNotes = Integer.parseInt(input[0]);
            int amount = Integer.parseInt(input[1]);

            int[] notes = new int[nNotes];

            for(int i=0;i<nNotes;++i)
                notes[i]=Integer.parseInt(in.readLine());
    
            out.println(solve(notes, amount));
        }
        out.flush();
    }

    
    public static String solve(int[] notes, int amount) {

            int twoPowern = (int)Math.pow(2, notes.length);
            
            for(int i=0;i<twoPowern;++i) {
                int sum=0;
                
                for(int j=0;j<notes.length;++j)
                    if((1<<j & i)>0)
                       sum+=notes[j];
                
                if(sum==amount) 
                    return "Yes";

          }
            return "No";
    }

}
