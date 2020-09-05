import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int cantLines = Integer.parseInt(br.readLine());  
		
		for(int i=1; i<=cantLines; i++) { 
			String line = "";
			line = br.readLine();
			String[] change = line.split(" ");
			double[] preOrganized = new double[change.length];	
			for (int j = 0; j < preOrganized.length; j++) {
				preOrganized[j] = Double.parseDouble(change[j]);
			}
			
			int moves = 0;
			int[] preAverage = new int[preOrganized.length-1];
			for (int k = preOrganized.length-1; k > 0; k--) {
				for (int j = 0; j < k; j++) {
					if(preOrganized[j] > preOrganized[j+1]) {
						double temp = preOrganized[j];
						preOrganized[j] = preOrganized[j+1];
						preOrganized[j+1] = temp;
						moves++;
					}
				}
				preAverage[k-1] = moves;
				moves = 0;
			}
			
			double sum = 0;
			for (int j = 0; j < preAverage.length; j++) {	
				sum += preAverage[j];	
			}
			
			double average = 0;
			average = sum / (double)preAverage.length;

//			
//			
			BigDecimal bd = new BigDecimal(average);
			bd = bd.setScale(2, RoundingMode.DOWN);
			String formatNumberS = bd.toString(); 
			String s = formatNumberS.indexOf(".") < 0 ? formatNumberS : formatNumberS.replaceAll("0*$", "").replaceAll("\\.$", ".0");
//			
//			The idea of the line 56 was obtained of this links
//			https://es.stackoverflow.com/questions/29408/como-limitar-la-cantidad-de-decimales-de-un-double
//			https://stackoverflow.com/questions/14984664/remove-trailing-zero-in-java
			
			String organized = "";
			organized += s + "-";
			for (int j = 0; j < preOrganized.length-1; j++) {
				organized += preOrganized[j] + " "; 
			}
			organized += preOrganized[preOrganized.length-1];
			bw.write(organized+"\n");
		}
		bw.close();
		br.close();
	}
}
