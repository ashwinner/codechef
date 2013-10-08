import java.io.*;

public class HelpLira {

    public static void main(String[] args) throws Exception {

        BufferedReader in = new BufferedReader( new InputStreamReader( System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        
        int nTriangles = Integer.parseInt(in.readLine());
        
        int minIndex, maxIndex;
        float minArea, maxArea;
        minIndex=maxIndex=0;
        minArea=Float.MAX_VALUE;
        maxArea=0.0f;

        for(int index=1;index<=nTriangles;++index) {

            Triangle t = new Triangle(in.readLine().split(" "));

            float area = t.area();

            if(area<=minArea) {
                minArea=area;
                minIndex=index;
            }

            if(area>=maxArea) {
                maxArea=area;
                maxIndex=index;
            }

        }

        out.println(minIndex + " " + maxIndex);
        out.flush();
    }
}

class Triangle {

    int x1, y1, x2, y2, x3, y3;

    public Triangle(String[] coordinates) {
        x1 = Integer.parseInt(coordinates[0]);
        y1 = Integer.parseInt(coordinates[1]);
        x2 = Integer.parseInt(coordinates[2]);
        y2 = Integer.parseInt(coordinates[3]);
        x3 = Integer.parseInt(coordinates[4]);
        y3 = Integer.parseInt(coordinates[5]);
    }

    float area() {
        return Math.abs((float)(x1*(y2-y3)+x2*(y3-y1)+x3*(y1-y2))/2.0f);
    }

}

