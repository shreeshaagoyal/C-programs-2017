import java.util.HashMap;

import javax.management.RuntimeErrorException;
public class FirstNonRepeated {
    public static Character findFirstNonRepeated(String str) {
        HashMap carHash = new HashMap();
        Character c; // using Character class to pass to hashmap
        Integer intgr;
        int value = 0;

        // Scan str, build hashmap
        for(int i = 0; i < str.length(); i++) {
            c = new Character(str.charAt(i));
            intgr = (Integer) carHash.get(c);
            if(intgr == null) {
                carHash.put(c, new Integer(1));
            } else {
                carHash.put(c, new Integer(intgr.intValue() + 1));
            }
        }

        // Search hashmap in order of str
        for(int i = 0; i < str.length(); i++) {
            c = new Character(str.charAt(i));
            // *** HAVE TO CAST BECAUSE THE GET() METHOD RETURNS AN OBJECT
            if(((Integer) carHash.get(c)).intValue() == 1) {
                return c;
            }
        }
        return null;
    }
}