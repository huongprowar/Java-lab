package j1.s.h207;

public class main {

    public static int secondHalfLetters(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            //count if the character in the string come from the second half
            if (str.toLowerCase().charAt(i) >= 'n' && str.toLowerCase().charAt(i) <= 'z') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String str = Validation.getStringInput();
        System.out.println(secondHalfLetters(str));
    }
}
