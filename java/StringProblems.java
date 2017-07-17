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
        for(int i = 0; i < strbuf.length(); i++) {
            c = new Character(strbuf.charAt(scanCursor));
            if(removeHash.contains(c)) {
                while(removeHash.contains(strbuf.charAt(scanCursor))) {
                    scanCursor++;
                }
                strbuf.setCharAt(slotCursor, strbuf.charAt(scanCursor));
            }
            scanCursor++;
            slotCursor++;
        }
        for(int i = slotCursor; i < strbuf.length(); i++) {
            strbuf.deleteCharAt(i);
        }
    }

    public static void main(String[] args) {
        StringBuffer strbuf = new StringBuffer("Shivanshu");
        StringBuffer remove = new StringBuffer("shia");
        removeSpecifiedCharacters2(strbuf, remove);
        System.out.println(strbuf);
    }

}