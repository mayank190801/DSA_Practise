import java.io.*;
import java.util.*;

public class second {

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String word = "ioiaaiauaaeeuiaauiaoeiieeuuoaauauoiuuooaoeiuieaiuoaoueuaeeueaaaiiioueaoeuuuaooeeeoeiauoiuiioiooaeaiaieooaieaoiiiiaiiuiooaeeeiuoaiuuuueoeeaaeuiioaauoaueiauueoiiueaauaaaeiaaiouauieuaaoooaueiaaaiuuaoaieoiiiouuaaouoiaeoouieeuiiooaiiaoiueauaioiiueuieeeuooiuaoueooeaoouuaiaouiuaueauaoaoaeouuuoaeuioeiouooaeuioeauuuooeaueooiaiuaieaooaeueaoiooiaauioeaoiauieaaeiiiieueouauaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiioooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooouuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuueiooaaoiiauaeeaaaioieoaiaeioiueuoaeauaiueeuoeaaoueoaouaueuaaiuaueuuuueiueeiioueaaueoaueeiuiuouiiioaaeoeoouauoaueiaaueoueuiaiiaaiuooiiiaiueiaiaauoaoouuooaeoeuoaeiuuoauuioueueueuiiiiiieeueoauaaeuaaaeeeoaiuuaieiiuaaiieaiaeiioeiuaioaiaaieuaeauiuoiauoaueieeiuuuaaueoaeiiaioaiueieuoueeueauuaooeiauaoaaiaiioooeuuauiaeiaoaoieoeeuieuuiaieieueeaouueiuoioieaiueuuaiaiiuaaaoeiiiouiouiieeiuoeeooieoaiiaoiuuiauioioeuooieuiuiuiuoueaoooeieieiieeaaeooueiaooiauoiaoueaeuiaauueuuaoiiiiuieuiuiuioooaeaoiuiueoeuiiaeaaouauaiuuueeiuooaieooeuuiaeiueiiuoeauuoaaiieooaauaouooieaioooeeuaiaaoeuuiaueaaiaieiaeaouoaouiiuaieeueiiuuooeiieuieoeoaouiiaaieiieiaiiuiaaoiiuoeaoiieaooiiiieeeoiiauieioooouieoieeaaiueaoiaoeauiuieiiieiiaiueuuauieaauoeeiauoieooaiaeiueoeoeeuaaoeeeuaeueoiuioooeoeaouieeueoaaieoioieoueuiooiuiouaueauoiaouaaiiuaouuaeeaaiaooaoeeoiiuueeeiieaieiuaieouoeaiaiiuoaoieoeoeiuoaieoaeuuaoaeuooaeauooooiauuaoeaoiuuuouaeuuioiuoouuieaoeoeiuaeouuiaueaiiauiauoiauooiouaaiaoooaooooueuiuaouuaoauueeuoaeuoioaiuaeoaoiuieouiaaaioeieooaaauiaiuoueuuiaaaoieoeueuuaiieeooauaiioaeaaoooaoaueieuuiuaioeuuoieoooeuaeiooeaoueuuoauoiuoiueoiuioeaauueaiaoioouaouoaoauuaieiiaeoauaeaaiuaueoaeaaeoioouoaieoeoieaiuaoueuiiaaieeiuuouuoaauoiaiuaaiuaaaeuieieoouoeoieoeeaioeiaeooaaeiaiuouiueoiouaaaeeeeoioeoioaooeueaieeaaoiieiauoeaauueoooaiieeeeaaiaueiaaueeaouioiiauaaaoueeuieeaaooeooeeuoauoouaaouiiueoooaoeoaoauieeouoaueaeuoioieuiaoooeeoeouiaaiiiieiaaaiuiuoaiiuuioeoououuiieieiaeiooouoaiuu";
        // String word = "aaaaeiiiiouuuooaauu";

        Set<Character> currentAlpha = new HashSet<>();
        Map<Character, Integer> aphaValue = new HashMap<>();

        aphaValue.put('a', 1);
        aphaValue.put('e', 2);
        aphaValue.put('i', 3);
        aphaValue.put('o', 4);
        aphaValue.put('u', 5);

        int max = 0;
        int lastVal = 0;
        int count = 0;

        Long.bitCount(i)
        char[] c = word.toCharArray();

        for (int i = 0; i < word.length(); i++) {
            int currentVal = aphaValue.get(c[i]);
            if (currentVal >= lastVal) {
                count++;
                currentAlpha.add(c[i]);
                if (currentAlpha.size() >= 5) {
                    if (max < count) {
                        max = count;
                    }
                }
                lastVal = currentVal;
            } else {
                count = 0;
                lastVal = 0;
                i--;
                currentAlpha.clear();
            }

            // System.out.println(currentAlpha);
        }

        // for (char c : word.toCharArray()) {

        // int currentVal = aphaValue.get(c);
        // if (currentVal >= lastVal) {
        // count++;
        // currentAlpha.add(c);
        // if (currentAlpha.size() == 5) {
        // max = count;
        // }
        // lastVal = currentVal;
        // } else {
        // currentAlpha.clear();
        // count = 1;
        // lastVal = currentVal;
        // currentAlpha.add(c);

        // }
        // System.out.println(currentAlpha);

        // }

        System.out.println(max);

        output.flush();
        output.close();
    }

}