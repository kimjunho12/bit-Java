package prob04;

public class StringUtil {
	public static String concatenate(String[] str) {
		String result = "";
		for (String s : str) {
			result += s;
		}
		return result;
	}
}
