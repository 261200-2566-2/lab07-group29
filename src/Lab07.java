import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
public class Lab07 {
    public static void main(String[] args){
        testSetByHashMap();
    }
    private static void testSetByHashMap(){

        Set<String> mySet = new SetByHashMap<>();

       // add element
        mySet.add("ace");
        mySet.add("luffy");
        mySet.add("sabo");

        System.out.println("Size of the set: "+mySet.size());
        System.out.println("Element in the set: "+mySet);

        //Test contains
        System.out.println("Contains 'ace': "+mySet.contains("ace"));
        System.out.println("Contains 'sanji': "+mySet.contains("sanji"));


        //Test addAll  // asList ->https://chat.openai.com//
        Set<String> otherSet = new HashSet<>(Arrays.asList("akainu","kuzan","kizaru"));
        mySet.addAll(otherSet);
        System.out.println("After adding element from another set: "+mySet);


        //Test remove
        mySet.remove("ace");
        System.out.println("After removing 'ace': "+mySet);

        //Test removeAll
        mySet.removeAll(Arrays.asList("luffy","sabo"));
        System.out.println("After removing 'luffy' and 'sabo': "+mySet);

        //Test retainAll
        Set<String> retainSet = new HashSet<>(Arrays.asList("akainu","luffy"));
        mySet.retainAll(retainSet);
        System.out.println("After retaining 'akainu' and 'luffy': "+mySet);


        //Test clear
        mySet.clear();
        System.out.println("After clearing the set: "+mySet);



    }
}
