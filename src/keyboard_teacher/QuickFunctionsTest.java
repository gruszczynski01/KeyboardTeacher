package keyboard_teacher;

import java.time.Instant;
import java.util.Scanner;

public class QuickFunctionsTest {
    public static void main(String[] args) {
        Instant start = Instant.now();
        System.out.println("poczekaj chwile i kliknij");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        Instant stop = Instant.now();
        TextCoordinator.setSessionTime(start, stop);
    }
}
