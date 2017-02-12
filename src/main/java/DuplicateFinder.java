import java.util.Arrays;

/**
 * Created by prestonbattin on 2/11/17.
 */
public class DuplicateFinder {

    public static int duplictes;
    static int count = 0;
    static int numberOfitems = 0;
    static int charCount = 0;


    static public void sameLength(String file) {


        boolean valid = true;

        String[] split = file.split("\\s*,\\s*");

        Arrays.sort(split);

        while ((count + 1) < split.length) {

            if (split[count].charAt(0) == split[count + 1].charAt(0)) {  //seeing if first letter is the same

                int localCountfirst = 0;
                int localCountSecond = 0;

                if (split[count].length() == split[count + 1].length()) { //checking lengths

                    for (int i = 0; i < split[count].length() - 1; i++) { //counting the patterns in each word

                        if (split[count].charAt(i) != split[count].charAt(i + 1))
                            localCountfirst++;


                        if (split[count + 1].charAt(i) != split[count + 1].charAt(i + 1))
                            localCountSecond++;
                    }

                    if (split[count].charAt(split[count].length()-1) == split[count + 1].charAt(split[count+1].length()-1)) { // compare last chars

                        charCount++;

                    }

                    if (split[count].charAt(split[count].length() - 2) == split[count + 1].charAt(split[count].length()-2)) { //compare second to last

                        charCount++;


                    }

                    if (split[count].charAt(1) == split[count + 1].charAt(1)) {

                        charCount++;
                    }
                }


                if (split[count].length() < 6 ) { //if less than 6 characters make dup matching more strict

                    if (localCountfirst == localCountSecond && charCount >= 2)
                        duplictes++;
                }

                if (split[count].length() > 6 ) { // if more than 6 make dup matching less strict

                    if (localCountfirst - localCountSecond <= Math.abs(1) )
                        duplictes++;
                }


                if (split[count].length() > split[count + 1].length() || split[count + 1].length() > split[count].length()) {

                    int difference = Math.abs(split[count].length() - split[count + 1].length());

                    for (int i = 0; i < split[count].length() - 1; i++) { //counting the patterns in each word

                        if (split[count].charAt(i) != split[count].charAt(i + 1))
                            localCountfirst++;

                        if (i + difference < split[count + 1].length()) {
                            if (split[count + 1].charAt(i) != split[count + 1].charAt(i + 1))
                                localCountSecond++;
                        }
                    }

                    if (split[count].length() < 6 && charCount >= 3) { //if less than 6 characters make dup matching more strict

                        if (localCountfirst == localCountSecond) {
                            duplictes++;
                            charCount = 0;
                        }
                    }

                    if (split[count].length() > 6 && charCount >= 3) { // if more than 6 make dup matching less strict

                        if (localCountfirst - localCountSecond <= Math.abs(1)) {
                            duplictes++;
                            charCount =0;
                        }
                    }

                }

            }
            count = count + 1;
            charCount =0;

        }


    }
}





