import java.util.HashSet;

public class LeetCode {
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> resultSet = new HashSet<Character>();
        HashSet<Character> tempSet = new HashSet<Character>();
        for(int i = 0; i < s.length(); i++) {
            if(!tempSet.contains(s.charAt(i))) {
                tempSet.add(s.charAt(i));
            } else {
                if(tempSet.size() >= resultSet.size()) {
                    resultSet = tempSet;
                    tempSet = new HashSet<Character>();
                    tempSet.add(s.charAt(i));
                }
            }
        }
        return resultSet.size();
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("accompossssssssss"));
    }
}