import java.util.Arrays;

/**
 * Created by prestonbattin on 2/12/17.
 */

@SuppressWarnings("Duplicates")
public class RefactoredDuplicateFinder {

    private static int duplicates =0;
    private static int count = 0;
    private static int charCount = 0;
    private static int stringPatternCountOne = 0;
    private static int stringPatternCountTwo = 0;


    public int getDuplicates() {
        return duplicates;
    }

    public int getCharCount() {
        return charCount;
    }

    public int getStringPatternCountOne() {
        return stringPatternCountOne;
    }

    public int getStringPatternCountTwo() {
        return stringPatternCountTwo;
    }




    public String[] splitTextToArray(String input){

        String[] splitText = input.split("\\s*,\\s*");
        Arrays.sort(splitText);
        return splitText;
    }

    public void ifStringsLengthIsSame(String[] input){

        stringPatternCountOne = 0;
        stringPatternCountTwo = 0;

        for (int i = 0; i < input[count].length() - 1; i++) { //counting the patterns in each word

            if (input[count].charAt(i) != input[count].charAt(i + 1))
                stringPatternCountOne++;


            if (input[count + 1].charAt(i) != input[count + 1].charAt(i + 1))
                stringPatternCountTwo++;
        }
    }

    public void compareSecondChar(String[] input){

        if (input[count].charAt(1) == input[count + 1].charAt(1)) {

            charCount++;
        }
    }

    public void compareLastChar(String[] input){

        if (input[count].charAt(input[count].length()-1) == input[count + 1].charAt(input[count + 1].length()-1)) {

            charCount++;
        }
    }

    public void compareSecondToLastChar(String[] input){

        if (input[count].charAt(input[count].length() - 2) == input[count + 1].charAt(input[count + 1].length()-2)) {

            charCount++;
        }
    }

    public void lengthsEvenAndLessThanSixChar(){

        if (stringPatternCountOne == stringPatternCountTwo && charCount >= 2)
            duplicates++;
    }

    public void lengthsEvenAndMoreThanSixChar(){

        if (stringPatternCountOne - stringPatternCountTwo <= Math.abs(1)) {

            duplicates++;
        }
    }

    public void ifStringLengthsAreDifferent(String[] input){

        int difference;

        if (input[count].length() > input[count + 1].length()) {

             difference = Math.abs(input[count].length() - input[count + 1].length());

            for (int i = 0, j = (input[count].length() - difference -1); i < input[count].length() - 1; i++, j--) {

                if (input[count].charAt(i) != input[count].charAt(i + 1))
                    stringPatternCountOne++;

                if (j > 0) {
                    if (input[count + 1].charAt(j) != input[count + 1].charAt(j - 1))
                        stringPatternCountTwo++;
                }
            }
        }

        if(input[count].length() < input[count + 1].length()){

            difference = Math.abs(input[count + 1].length() - input[count].length());

            for (int i = 0, j = (input[count+1].length() - difference - 1); i < input[count + 1].length() - 1; i++, j--) {

                if (input[count + 1].charAt(i) != input[count + 1].charAt(i + 1))
                    stringPatternCountTwo++;

                if (j > 0) {

                    if (input[count].charAt(j) != input[count].charAt(j - 1))
                        stringPatternCountOne++;
                }
            }
        }
    }

    public void lengthNotEvenAndLessThanSixChar(){

        if (stringPatternCountOne == stringPatternCountTwo && charCount >= 2){

            duplicates++;

        }
    }

    public void lengthNotEvenAndMoreThanSixChar(){

                if (stringPatternCountOne == stringPatternCountTwo && charCount >= 2){
                    duplicates++;
            }

        }

}
