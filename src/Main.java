import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
//		Reading input
		String line = br.readLine();
		String[] numsLine = line.split("\\+");
		int[] nums = new int [numsLine.length];
		
//		Cast values to int
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(numsLine[i]);
		}
		
//		Sorting
		for (int i = nums.length-1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (nums[j] > nums[j+1]) {
					int temp  = nums[j];
					nums[j]   = nums[j+1];
					nums[j+1] = temp;
				}
			}
		}
		
//		Output
		String output = "";
		for (int i = 0; i < nums.length-1; i++) {
			output += nums[i] + "+";
		}
		
		output += nums[nums.length-1];
		
		bw.write(output);
		
		br.close();
		bw.close();
	}

}
