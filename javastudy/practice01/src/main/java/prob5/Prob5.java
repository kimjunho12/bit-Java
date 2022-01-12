package prob5;

public class Prob5 {

	public static void main(String[] args) {
		int i = 1;
		while(i<100) {
			String result = "";
			char[] charNum = String.valueOf(i).toCharArray();
			for(char c : charNum) {
				if (c == '3' || c == '6' || c == '9') {
					if(!result.contains("짝"))
						result += i + " ";
					result += "짝";
				}
			}
			if(result.contains("짝"))
				System.out.println(result);
			++i;
		}		
	}
}
