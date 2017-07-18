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

    public static void reverseWord(StringBuffer strbuf) {
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

    public static StringBuffer reverseWords (StringBuffer strbuf) {
        strbuf.insert(0, ' ');
        strbuf.append(' ');
        int spaceRef = strbuf.length() - 2;
        int i = spaceRef;
        int index = 0;
        StringBuffer reversedStr = new StringBuffer(strbuf.length()-1);
        for (int x = 0; x < strbuf.length()-1; x++) {
            reversedStr.append('-');
        }
        while(strbuf.charAt(i) != ' ') {
            i--;
            if(strbuf.charAt(i) == ' ') {
                spaceRef = i;
                int j = spaceRef + 1;
                while(strbuf.charAt(j) != ' ') {
                    reversedStr.setCharAt(index, strbuf.charAt(j));
                    j++; index++;
                }
                reversedStr.setCharAt(index, ' ');
                index++;
                if(i == 0) {
                    break;
                }
                i--;
            }
        }
        reversedStr.deleteCharAt(reversedStr.length()-1);
        return reversedStr;
    }

    public static int stringToInt(String str) {
        int length = str.length();
        int result = 0;
        char[] charArr = new char[length];
        charArr = str.toCharArray();
        int j = 0;
        for(int i = length-1; i >= 0; i--) {
            result = result + ((charArr[i] - 48)* (int) Math.pow(10, j));
            j++;
        }
        return result;
    }

    public static String intToString(int num) {
        int numLength = findNumberOfDigits(num);
        char[] charArr = new char[numLength];
        charArr[numLength-1] = (char) 48 + (num % 10);;
        int temp = 0, temp2 = 0;
        for(int i = numLength-2; i >= 0; i--) {
            temp = num - (num % 10);
            temp2 = temp / 10;
            charArr[i] = (char) 48 + (temp2 % 10);
            num = temp2;
        }
        String str = new String(charArr);
    }

    private static int findNumberOfDigits(int num) {
        int i = 1;
        while(num > 0) {
            num = num - (num % (int) Math.pow(10, i));
            i++;
        }
        return i-1;
    }

    public static void main(String[] args) {
        System.out.println(stringToInt("786"));
    }
}
