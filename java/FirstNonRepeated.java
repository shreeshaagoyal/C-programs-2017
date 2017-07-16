import java.util.HashMap;
public class FirstNonRepeated {
    public static char findFirstNonRepeated(String userInput) {
        HashMap str = new HashMap(userInput.length());
        char[] charArr = new char[userInput.length()];
        charArr = userInput.toCharArray();
        Integer value = new Integer(0);
        Integer seenOnce = new Integer(1);
        for(int i = 0; i < charArr.length; i++) {
            str.put(charArr[i], value+1);
        }
        for(int i = 0; i < charArr.length; i++) {
            if(str.get(charArr[i]) == seenOnce) {
                return charArr[i];
            }
            else {
                throw new RuntimeException("All characters repeat");
            }
        }
    }
}