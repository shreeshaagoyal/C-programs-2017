import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegexExample {

	public static void main(String[] args) {
		String text = "This is the text to be searched for occurrences of the http:// pattern.";

		String stringPattern = ".*http://.*";

		Pattern pattern = new Pattern(stringPattern);

		Matcher matcher = pattern.matcher(text);
		boolena matches = matcher.matches();
		
		System.out.println("text contains http? " + matches);
	}
}