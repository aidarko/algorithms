package leetcode;

public class IsPalindrome {

    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        isPalindrome.isPalindrome("0P");
    }

    public boolean isPalindrome(String s) {
        int leftPointer = 0;
        int rightPointer = s.length() - 1;

        while (leftPointer < rightPointer) {
            char charAtLeft = s.charAt(leftPointer);
            while (!Character.isLetterOrDigit(charAtLeft) && leftPointer < rightPointer) {
                leftPointer++;
                charAtLeft = s.charAt(leftPointer);
            }
            char charAtRight = s.charAt(rightPointer);
            while (!Character.isLetterOrDigit(charAtRight) && leftPointer < rightPointer) {
                rightPointer--;
                charAtRight = s.charAt(rightPointer);
            }

            if (Character.isLetterOrDigit(charAtLeft) && Character.isLetterOrDigit(charAtRight)) {
                if (Character.toLowerCase(charAtLeft) != Character.toLowerCase(charAtRight)) {
                    return false;
                }
                leftPointer++;
                rightPointer--;
            }
        }

        return true;
    }
}
