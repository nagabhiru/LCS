import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LCS_Vamsi_Krishna_Nagabhiru_vnagabhi {
	
	public static void main(String args[]) throws IOException {
		FileReader f = new FileReader("input.txt");
		BufferedReader br = new BufferedReader(f);
		String string1 = br.readLine();
		int n = string1.length();
		char[] A = string1.toCharArray();
		String string2 = br.readLine();
		int m = string2.length();
		char[] B = string2.toCharArray();
		br.close();
		f.close();
		
		int[][] optSol = new int[n+1][m+1];
		for (int i = 0; i <= n; i++) {
			optSol[i] = new int[m+1];
			}
		
		int[][] piSol = new int[n+1][m+1];
		for (int i = 0; i <= n; i++) {
			piSol[i] = new int[m+1];
			}
		
		for (int j=0;j<=m;j++) {
			optSol[0][j] = 0;
		}
		
		for (int i=1;i<=n;i++) {
			for (int j=1;j<=m;j++) {
				if (A[i-1]==B[j-1]) {
					optSol[i][j] = optSol[i-1][j-1]+1;
					piSol[i][j] = -1;
				} 
				else if (optSol[i][j-1] >= optSol[i-1][j]) {
					optSol[i][j] = optSol[i][j-1];
					piSol[i][j] = -2;
				}
				else {
					optSol[i][j] = optSol[i-1][j];
					piSol[i][j] = -3;
				}
			}
		}
		
		int i=n;
		int j=m;
		String sol = "";
		while(i>0&&j>0) {
			if (piSol[i][j]==-1) {
				sol = A[i-1]+sol;
				i-=1;
				j-=1;
			}
			else if (piSol[i][j]==-3) i-=1;
			else j-=1;
		}
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
		bw.write(optSol[n][m]+"\n");
		bw.write(sol);
		bw.close();
	}

}
