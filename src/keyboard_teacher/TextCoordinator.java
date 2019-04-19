package keyboard_teacher;

import java.io.File;
import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

public class TextCoordinator {
    public static boolean ifFirstLine = true;
    public static Instant start;
    public static Instant stop;
    public static Duration sessionTime;
    public static File selectedFile;
    public static Scanner mainScanner;
    public static int totalSumOfCharacters = 0;
    public static int totalSumOfMistakes = 0;
    public static boolean lastGoodAnswer;

    public static int howManyCharacters(String text){
        int counter = 0;
        for (char currentChar :
                text.toCharArray()) {
            counter++;
        }
        return counter;
    }
    public static int indexOfMistake(String originalText, String rewrittenText) {
        if (rewrittenText.length() == 0)
            return 0;
        else if (originalText.length() == rewrittenText.length()) {
            for (int i = 0; i <= originalText.length() - 1; i++) {
                if (originalText.toCharArray()[i] != rewrittenText.toCharArray()[i]) {
                    return i;
                }
            }
        }else if (originalText.length() < rewrittenText.length()) {
            for (int i = 0; i <= originalText.length() - 1; i++) {
                if (originalText.toCharArray()[i] != rewrittenText.toCharArray()[i]) {
                    return i;
                }
            }
            return originalText.length();
        }else if(originalText.length() > rewrittenText.length()){
            for (int i = 0; i <= rewrittenText.length() - 1; i++) {
                if (originalText.toCharArray()[i] != rewrittenText.toCharArray()[i]) {
                    return i;
                }
            }
            return rewrittenText.length();
        }
        return -1;
    }
    public static double setSessionTime(Instant start, Instant stop){//only seconds
        Duration sessionTime =  Duration.between(start, stop);
        double seconds = sessionTime.getSeconds();
        double nano = sessionTime.getNano();
        nano/=1000000000;//?
        seconds+=nano;


        return seconds;
    }
    public static String charPerSeconds(double seconds, int characters){
        return String.format("%.2f", (double)characters/seconds);
    }
}
