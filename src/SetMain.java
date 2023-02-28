import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by dev on 3/02/2016.
 */
public class SetMain {

    //will be looking at set intersection and seeing if one st is a subset of another
    public static void main(String[] args) {
        Set<Integer> squares = new HashSet<>();
        Set<Integer> cubes = new HashSet<>();

        for (int i = 1; i <= 100; i++) {
            squares.add(i * i);
            cubes.add(i * i * i);
        }

        System.out.println("There are " + squares.size() + " squares and " + cubes.size() + " cubes.");
        //demonstrates that 100 squares and 100 cubes are created
        Set<Integer> union = new HashSet<>(squares);
        union.addAll(cubes);
        //addAll is a type of bulk operation as defined by oracle documentation
        System.out.println("Union contains " + union.size() + "  elements.");
        //this shows that the union of the squares set and cubes set will result in 196 items, not 200. this is partially
        //because bulk operations are desctructive, which means they modify the content.

        Set<Integer> intersection = new HashSet<>(squares);
        intersection.retainAll(cubes);
        System.out.println(intersection + " look at this stuff"); //retainAll instance method modifies the 'intersection'
        // set to only contain items that are also contained in the specified collection (in this case, 'cubes')
        System.out.println("Intersection contains " + intersection.size() + " elements.");
        for (int i : intersection) {
            System.out.println(i + " is the square of " + Math.sqrt(i) + " and the cube of " + Math.cbrt(i)); //cbrt is cube root
            // the 4 numbers in the intersection exist, exemplified by supposing i = 4, where i^3 = 64, but an i of 8
            // then i^2 also = 64. so the number 64 is redundant despite different computational arrivals.
            //this concern symmetric differences and asymmetric difference. java can find thee asymmetric difference of two sets
            // using the remove all bulk operation.
        }

        Set<String> words = new HashSet<>();
        String sentence = "one day in the year of the fox";
        String[] arrayWords = sentence.split(" ");
        words.addAll(Arrays.asList(arrayWords));

//        for (String s : words) {
//            System.out.println(s);
//        }

        Set<String> nature = new HashSet<>();
        Set<String> divine = new HashSet<>();
        String[] natureWords = {"all", "nature", "is", "but", "art", "unknown", "to", "thee"};
        nature.addAll(Arrays.asList(natureWords));

        String[] divineWords = {"to", "err", "is", "human", "to", "forgive", "divine"};
        divine.addAll(Arrays.asList(divineWords));

        //doing is this one since no set or map literals in java...

        System.out.println("nature - divine:");
        Set<String> diff1 = new HashSet<>(nature);
        diff1.removeAll(divine);
        printSet(diff1);
        //removeAll is the asymmetric difference and shows that set one takes set two, is not the same as set two takes one
        //java has no method for calculating symmetric difference. these are the items in the separate sections of
        // a ven-diagram model where the asymmetric diffeerence is thee overlap

        System.out.println("divine - nature:");
        Set<String> diff2 = new HashSet<>(divine);
        diff2.removeAll(nature);
        printSet(diff2);

        Set<String> unionTest = new HashSet<>(nature);
        unionTest.addAll(divine); // collection of single occurnce of all words
        Set<String> intersectionTest = new HashSet<>(nature);
        intersectionTest.retainAll(divine); //single listing of all words that appear from both sets

        System.out.println("Symmetric difference");
        unionTest.removeAll(intersectionTest); // removed the "middle" of the ven-diagram to get symmetric difference
        printSet(unionTest);

        if(nature.containsAll(divine)) {
            System.out.println("divine is a subset of nature");
        }

        //containsAdd is non-desctructive (doesn't modify items) and tests to see if one is a super seet of another.
        // this is also a bulk operation

        if(nature.containsAll(intersectionTest)) {
            System.out.println("intersection is a subset of nature");
        }

        if(divine.containsAll(intersectionTest)) {
            System.out.println("intersection is a subset of divine");
        }












    }

    private static void printSet(Set<String> set) {
        System.out.print("\t");
        for(String s : set) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
