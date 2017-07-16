import java.util.HashMap;
public class FirstNonRepeated {
    public static char findFirstNonRepeated(String userInput) {
        HashMap str = new HashMap(userInput.length());
        char[] charArr = userInput.toCharArray();
        int value = 0;
        for(int i = 0; i < charArr.length; i++) {
            str.put(charArr[i], value+1);
        }
        for(int i = 0; i < charArr.length; i++) {
            if(str.get(charArr[i]) == 1) {
                return charArr[i];
            }
        }
    }
}