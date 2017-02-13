/**
 * Created by prestonbattin on 2/12/17.
 */
public class Main {

    public static void main(String[] args) {

        RefactoredDuplicateFinder rf = new RefactoredDuplicateFinder();
        String findDuplicates = "";
        String[] findDuplicatesArray = rf.splitTextToArray(findDuplicates);


        while ((rf.getCount() + 1) < findDuplicatesArray.length) {


            if (findDuplicatesArray[rf.getCount()].charAt(0) == findDuplicatesArray[rf.getCount() + 1].charAt(0)) {

                if (findDuplicatesArray[rf.getCount()].length() == findDuplicatesArray[rf.getCount() + 1].length()) {

                    rf.ifStringsLengthIsSame(findDuplicatesArray);
                    rf.compareSecondChar(findDuplicatesArray);
                    rf.compareSecondToLastChar(findDuplicatesArray);
                    rf.compareSecondToLastChar(findDuplicatesArray);

                    if (findDuplicatesArray[rf.getCount()].length() > 6) {

                        rf.lengthsEvenAndMoreThanSixChar();
                    }

                    if (findDuplicatesArray[rf.getCount()].length() < 6) {

                        rf.lengthsEvenAndLessThanSixChar();
                    }
                }else rf.upCount();
            }


                else if (findDuplicatesArray[rf.getCount()].length() > findDuplicatesArray[rf.getCount() + 1].length() || findDuplicatesArray[rf.getCount() + 1].length() > findDuplicatesArray[rf.getCount()].length()) {

                    rf.ifStringLengthsAreDifferent(findDuplicatesArray);

                    if (findDuplicatesArray[rf.getCount()].length() > findDuplicatesArray[rf.getCount() + 1].length() && findDuplicatesArray[rf.getCount()].length() > 6) {

                        rf.lengthNotEvenAndMoreThanSixChar();

                    } else
                        rf.lengthNotEvenAndLessThanSixChar();


                } else rf.upCount();

            }
        System.out.println("Rough estimate of the total number of duplicates found are " + rf.getDuplicates() + "!");

    }


}