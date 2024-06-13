package two_pointer;

public class LT5_MIDIUMN_LONG_PALIDROME {
    class Solution {
        public String longestPalindrome(String s) {
            String answer = "";
            for (int i = 0; i < s.length(); i++) {
                String odd = search(i, i, s);
                String even = search(i, i + 1, s);
                if (odd.length() >= even.length() && answer.length() < odd.length()) {
                    answer = odd;
                } else if (odd.length() < even.length() && answer.length() < even.length()) {
                    answer = even;
                }
            }
            return answer;
        }

        public String search(int left, int right, String s) {
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }

            return s.substring(left + 1, right);
        }
    }
}
