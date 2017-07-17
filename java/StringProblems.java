import java.util.HashMap;
import java.util.HashSet;
public class StringProblems {
    public static void removeSpecifiedCharacters2(StringBuffer strbuf, StringBuffer remove) {
        HashSet<Character> removeHash = new HashSet<Character>();
        Character c;
        int slotCursor = 0;
        int scanCursor = 0;

        //scan remove, build hashset
        for(int i = 0; i < remove.length(); i++) {
            removeHash.add(new Character(remove.charAt(i)));
        }

        //scan strbuf, remove characters
        for(int i = 0; scanCursor < strbuf.length(); i++) {
            if(!removeHash.contains(strbuf.charAt(scanCursor))) {
                strbuf.setCharAt(slotCursor, strbuf.charAt(scanCursor));
                slotCursor++;
            }
            scanCursor++;
        }

        //delete 'extra' characters
        for(int i = strbuf.length()-1; i >= slotCursor; i--) {
            strbuf.deleteCharAt(i);
        }

    }

    public static void reverseWords(StringBuffer strbuf) {
        int headRef = 0;
        int tailRef = strbuf.length() - 1;
        char tempCopiedChar;
        for(int i = 0; i < strbuf.length()/2; i++) {
            tempCopiedChar = strbuf.charAt(headRef);
            strbuf.setCharAt(headRef, strbuf.charAt(tailRef));
            strbuf.setCharAt(tailRef, tempCopiedChar);
            headRef++;
            tailRef--;
        }
    }

    public static void main(String[] args) {
        StringBuffer strbuf = new StringBuffer("shivanshu");
        StringBuffer remove = new StringBuffer("shia");
        removeSpecifiedCharacters2(strbuf, remove);
        System.out.println(strbuf);
        StringBuffer reverseWord = new StringBuffer("shivanshu");
        reverseWords(reverseWord);
        System.out.println(reverseWord);
    }

}