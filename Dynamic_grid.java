//author Laxmikant Patil

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Dynamic_grid {

	
	public static int blank(char[][] a,int x, int y,int X, int Y) {
        if ((x < 0) || (x >= X) || (y < 0) || (y >= Y) || (a[x][y] == '0'))
                return 0;

        a[x][y] = '0';

        return 1 + blank(a,x - 1, y,X,Y) + blank(a,x + 1, y,X,Y) + blank(a,x, y - 1,X,Y) + blank(a,x, y + 1,X,Y);
}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in);
		 FileWriter fw = new FileWriter( "C:\\Users\\Laxmikant\\Desktop\\Gooogle\\out1.txt" );
		 BufferedWriter bw = new BufferedWriter( fw );

		 
		 int T = Integer.parseInt(sc.nextLine());
	
		 for(int i=0;i<T;i++)
		 {
			 String[] rc=sc.nextLine().split(" ");
			 int R = Integer.parseInt(rc[0]);
			 int C = Integer.parseInt(rc[1]);
			 
			 char m[][]=new char[R][C];
			 String line="";
			 for(int j=0;j<R;j++){
				 line =sc.nextLine();
				 //System.out.println("line  " + line);
				 for(int k=0;k<C;k++)
				 {
					// System.out.println("ind " + k);
					 m[j][k]=line.charAt(k);
				 }
			 }
			 int N = Integer.parseInt(sc.nextLine());
			 System.out.println("Case #"+(i+1));
			 String temp="";
			 temp="Case #"+(i+1)+"\n";;
					 
			 bw.write( temp );
			 for(int j=0;j<N;j++)
			 {
				 String op=sc.nextLine();
				 if (op.charAt(0)=='M')
				 {
					 int  x=Integer.parseInt(op.split(" ")[1]);
					 int y=Integer.parseInt(op.split(" ")[2]);
					 char z=op.split(" ")[3].charAt(0);
					 m[x][y]=z;
					 
				 }
				 if (op.charAt(0)=='Q')
				 {
                       int areas=0;
                       
                       char [][] myInt = new char[R][C];
                       for(int d=0;d<R;d++){
          				
          				 for(int f=0;f<C;f++)
          				 {
          					myInt[d][f]=m[d][f];
          					//System.out.println("mat"+myInt[d][f]);
          				 }
                       }
                       
				        for(int p = 0; p < R; p++)
				                for (int q = 0; q < C; q++)
				                        if (myInt[p][q] == '1')
				                        {
				                        	 //System.out.println("---1---");
				                                if (blank(myInt,p,q,R,C)  >=1)
				                                        areas++;
				                        }
				        System.out.println(areas);
				        temp=""+areas+"\n";
				        bw.write( temp );
				 }
			 }
			 
		 }
	}

}
