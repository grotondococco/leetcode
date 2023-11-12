import java.util.Map;

public class Solution13 {
    public final static Map<Character, Integer> conversionMap = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
            );

    public int romanToInt(String s) {
        int res = 0;
        char[] charArray = s.toCharArray();
        for (int i = charArray.length -1  ; i>=0; i--) {
            if (i == 0){
                res += conversionMap.get(charArray[i]);
                break;
            }
            switch (charArray[i]) {
                case 'I' -> {
                    res += conversionMap.get(charArray[i]);
                }
                case 'V', 'X' -> {
                    if (charArray[i - 1] == 'I') {
                        res += conversionMap.get(charArray[i]) - 1;
                        i--;
                    }
                    else{
                        res += conversionMap.get(charArray[i]);
                    }
                }
                case 'L', 'C' -> {
                    if (charArray[i - 1] == 'X') {
                        res += conversionMap.get(charArray[i]) - 10;
                        i--;
                    }
                    else{
                        res += conversionMap.get(charArray[i]);
                    }
                }
                case 'D', 'M' -> {
                    if (charArray[i - 1] == 'C') {
                        res += conversionMap.get(charArray[i]) - 100;
                        i--;
                    }else{
                        res += conversionMap.get(charArray[i]);
                    }
                }
                default -> {
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(new Solution13().romanToInt(s));
    }
}