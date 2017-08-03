import java.util.HashSet;

public class LeetCode {
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> resultSet = new HashSet<Character>();
        HashSet<Character> tempSet = new HashSet<Character>();
        int i;
        for(i = 0; i < s.length(); i++) {
            if(!resultSet.contains(s.charAt(i))) {
                resultSet.add(s.charAt(i));
            } else {
                break;
            }
        }
        for(int j = i; j < s.length(); j++) {
            if(!tempSet.contains(s.charAt(j))) {
                tempSet.add(s.charAt(j));
            } else {
                if(tempSet.size() >= resultSet.size()) {
                    resultSet = tempSet;
                    tempSet = new HashSet<Character>();
                    tempSet.add(s.charAt(j));
                }
            }
        }
        if(tempSet.size() > resultSet.size()) {
            return tempSet.size();
        } else {
            return resultSet.size();
        }
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("aab"));
    }
}