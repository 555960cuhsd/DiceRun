import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class U72 {
    public static void main(String[] args) {
        int[] dice = new int[20];
        int[] numLengths = new int[6];
        int[] lengthsIndex = new int[6];
        int pastNum = 0;
        int currentLength = 0;

        Random rand = new Random();
        for (int i = 0; i < 20; i++) {
            dice[i] = rand.nextInt(5) + 1;
        }

        for (int j = 0; j < dice.length; j++) {
            while (dice[j] == pastNum) {
                currentLength += 1;
                j++;
            }
            if (pastNum > 0 && currentLength > numLengths[pastNum-1]) {
                numLengths[pastNum-1] = currentLength;
                currentLength = 0;
                lengthsIndex[pastNum-1] = j;
            }
            pastNum = dice[j];
        }

        System.out.println(Arrays.toString(dice));
        System.out.println(Arrays.toString(numLengths));
        System.out.println(Arrays.toString(lengthsIndex));
        System.out.println(addParenthesis(dice, numLengths, lengthsIndex));
    }

    public static String addParenthesis(int[] dice, int[] numLengths, int[] lengthsIndex) {
        String list = "";
        int highestNum = highestRunNum(numLengths);
        for (int i = 0; i < dice.length; i++) {
            if (i == lengthsIndex[highestNum-1]) {
                list += "(";
            }
            if (i == lengthsIndex[highestNum-1] + numLengths[highestNum-1]) {
                list += ")";
            }
            list += dice[i] + " ";
        }
        return list;
    }

    public static int highestRunNum(int[] array) {
        int largest = 0;
        int i;
        for (i = 0; i < array.length; i++) {
            if (array[i] > largest) {
                largest = array[i];
            }
        }
        return i+1;
    }

}
