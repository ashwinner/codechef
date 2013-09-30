import java.io.*;
import java.util.*;

public class Caos {
    public static void main(String[] args) throws Exception{
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
       
        Primes primes = new Primes(500);
       
        int cases = Integer.parseInt(in.readLine());

        while(cases-->0) {
            
            String[] input = in.readLine().split(" ");
            int nrow = Integer.parseInt(input[0]);
            int ncolumn = Integer.parseInt(input[1]);

            char[][] cells = new char[nrow][ncolumn];
            for(int i=0;i<nrow;++i)
                cells[i] = in.readLine().toCharArray();

            CaosMap map = new CaosMap(cells);
            int monsterCount=0;

            for (int i=0;i<nrow;++i) 
                for(int j=0;j<ncolumn;++j) 
                     monsterCount+=primes.getNoOfPrimes(map.getMin(i,j));
            
            out.println(monsterCount);
        }
        out.flush();
    }
}


class Primes {
	List<Integer> primesList;
	
	public Primes(int n) {
		this.primesList = buildPrimesList(n);
        }
        
        private List<Integer> buildPrimesList(int n) {
        
		List<Integer> primes = new ArrayList<Integer>();
	       
	        for(int i=2;i<n;++i)
		   if(isPrime(i))
		       primes.add(i);

		return primes; 
	}
        
        public static boolean isPrime(int num) {
            int i;
            for(i=2;i*i<=num;++i)
                if(num%i==0)
                    return false;

                return true;
        }
    
    	public int getNoOfPrimes(int n) {
    		int count=0;
    		while(n>=primesList.get(count))
    			count++;
    		return count;
    	}
    
}

class CaosMap {
    
    char[][] cell;
    int[][] left, right, top, bottom;
    int nrow;
    int ncolumn;

    public CaosMap(char[][] cell) {
        this.cell=cell;
        this.nrow = cell.length;
        this.ncolumn = cell[0].length;
        this.left = leftCal();
        this.right = rightCal();
        this.top = topCal();
        this.bottom = bottomCal();
        }

        public int[][] leftCal() {
            int[][] l = new int[nrow][ncolumn];
            for(int i=0;i<nrow;++i)
                l[i][0]=0;

            for(int i=0;i<nrow;++i)
                for(int j=1;j<ncolumn;++j) {
                    if(cell[i][j-1]=='^')
                        l[i][j]=l[i][j-1]+1;
                    else
                        l[i][j]=0;
                }
            return l;
        }
        
        public int[][] rightCal() {
            int[][] r = new int[nrow][ncolumn];
            for(int i=0;i<nrow;++i)
                r[i][ncolumn-1]=0;

            for(int i=0;i<nrow;++i)
                for(int j=ncolumn-2;j>=0;--j) {
                    if(cell[i][j+1]=='^')
                        r[i][j]=r[i][j+1]+1;
                    else
                        r[i][j]=0;
                }
            return r;
        }


        public int[][] topCal() {
            int[][] t = new int[nrow][ncolumn];
            for(int i=0;i<ncolumn;++i)
                t[0][i]=0;

            for(int i=1;i<nrow;++i)
                for(int j=0;j<ncolumn;++j) {
                    if(cell[i-1][j]=='^')
                        t[i][j]=t[i-1][j]+1;
                    else
                        t[i][j]=0;
                }
            return t;
        }

         public int[][] bottomCal() {
            int[][] b = new int[nrow][ncolumn];
            for(int i=0;i<ncolumn;++i)
                b[nrow-1][i]=0;

            for(int i=nrow-2;i>=0;--i)
                for(int j=0;j<ncolumn;++j) {
                    if(cell[i+1][j]=='^')
                        b[i][j]=b[i+1][j]+1;
                    else
                        b[i][j]=0;
                }
            return b;
        }


    public int getMin(int row, int column) {

        if(cell[row][column]=='#')
            return 0;
        
        int min = left[row][column];

        if(right[row][column]<min)
            min=right[row][column];

        if(top[row][column]<min)
            min=top[row][column];

        if(bottom[row][column]<min)
            min=bottom[row][column];


        return min;
    }
}
