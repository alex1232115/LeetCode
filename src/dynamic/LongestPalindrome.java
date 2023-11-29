package dynamic;

public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindromeDynamic("abdedbaac"));
    }

    public static String longestPalindromeDynamic(String s) {
        int n = s.length();
        if (n <= 1 ) {
            return s;
        }

        int maxLength = 1;
        int start = 0, end = 0;
        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    if (i - j + 1 > maxLength) {
                        maxLength = i - j + 1;
                        start = j;
                        end = i;
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }

    public static String longestPalindromeExpandAroundCenter(String s) {
        int n = s.length();
        if (n <= 1 ) {
            return s;
        }

        String result = s.substring(0, 1);
        for (int i = 0; i < n - 1; i++) {
            String odd = expandFromCenter(s, i, i);
            String even = expandFromCenter(s, i, i + 1);

            if (odd.length() > result.length()) {
                result = odd;
            }
            if (even.length() > result.length()) {
                result = even;
            }
        }

        return result;
    }

    private static String expandFromCenter(String str, int left, int right) {
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        return str.substring(left + 1, right);
    }

    public static String longestPalindromeBruteForce(String s) {
        int n = s.length();

        if (n <= 1) {
            return s;
        }

        int maxLength = 1;
        String result = s.substring(0, 1);

        for (int i = 0; i < n; i++) {
            for (int j = i + maxLength; j <= n; j++) {
                if (j - i > maxLength) {
                    String cur = s.substring(i, j);
                    if (cur.equals(reverse(cur))) {
                        maxLength = j - i;
                        result = cur;
                    }
                }
            }
        }
        return result;
    }

    private static String reverse(String cur) {
        StringBuilder stringBuilder = new StringBuilder(cur);
        return String.valueOf(stringBuilder.reverse());
    }
}
