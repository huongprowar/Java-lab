
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TrashTest {

    public static void quiz(int x) {
        if (x > 1) {
            quiz(x / 2);
            quiz(x / 2);
        }
        System.out.print("* ");
    }
    

    public static void main(String[] args) throws Exception {
        quiz(5);

    }
}
