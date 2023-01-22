package leetcode;

public class LongestPalindrome {
    private String expand(int l, int r,  String s, String tmp){
        String ans = tmp; // d
        for (int j=1; l-j>=0 && r+j < s.length(); j++) {
            char lChar = s.charAt(l-j);
            char rChar = s.charAt(r+j);
            if (lChar == rChar) {
                tmp = lChar + tmp + rChar;
                ans = ans.length() < tmp.length() ? tmp : ans;
            } else {
                break;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        LongestPalindrome lp = new LongestPalindrome();
        lp.longestPalindrome("aacabdkacaa");
    }
    // "aacabdkacaa"
    //       ^
    public String longestPalindrome(String s) {
        String ans = "";

        int n = s.length();
        for (int i=0; i< n; i++) {
            char c = s.charAt(i);
            String tmp2 = expand(i, i, s, String.valueOf(c));
            ans = ans.length() < tmp2.length() ? tmp2 : ans;

            // expand 2 char center
            if (i+1 < n && c == s.charAt(i+1)) {
                String tmp = String.valueOf(c) + s.charAt(i+1);
                tmp2 = expand(i, i+1, s, tmp);
                ans = ans.length() < tmp2.length() ? tmp2 : ans;
            }

        }

        return ans;
    }
}
