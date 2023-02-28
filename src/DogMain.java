/**
 * Created by dev on 17/01/2016.
 */
public class DogMain {
    public static void main(String[] args) {
        Labrador rover = new Labrador("Rover");
        Dog rover2 = new Dog("Rover");

        System.out.println(rover2.equals(rover)); // this will field true and
        System.out.println(rover.equals(rover2)); //this will field false IF the equals method is also overridden in
        // the Labrador class with the casting of the object to subclass type Labrador. Why this happens is that
        // Labrador is a subclass of Dog, so rover = rover2. But the reverse is not true where Dog is not a type of
        // Labrador. Violates the symmetric rules that an equals method must obey. Must be equal both ways.
        // to reesolve this, only override the equals method in Dog and make it final
    }
}
