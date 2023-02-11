import javafx.util.Pair;
 
import java.util.ArrayList;
import java.util.List;
 
class Main
{
    // Demonstrate `javafx.util.Pair` class introduced in Java 8 and above
    public static void main(String[] args)
    {
        List<Pair<String, Integer>> entries = new ArrayList<>();
 
        entries.add(new Pair<>("C", 20));
        entries.add(new Pair<>("C++", 30));
 
        // print first pair using `getKey()` and `getValue()` method
 
        System.out.println("{" + entries.get(0).getKey() + ", " +
                            entries.get(0).getValue() + "}");
 
        // print second pair using `getKey()` and `getValue()` method
 
        System.out.println("{" + entries.get(1).getKey() + ", " +
                            entries.get(1).getValue() + "}");
    }
}