import java.util.HashMap;

public class LeetCode {
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> stringMap = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++) {
            stringMap.put(s.charAt(i), 0);
        }
        for(int i = 0; i < s.length(); i++) {
            int value = stringMap.get(s.charAt(i));
            if(value == 0) {
                stringMap.put(s.charAt(i), 1);
            } else {
                
            }
        }
    }
}