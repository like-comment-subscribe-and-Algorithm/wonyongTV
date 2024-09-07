package string;

import java.util.Arrays;


public class PG_LEVEL2_파일명정렬 {

    class Solution {
        public String[] solution(String[] files) {
            File[] newFiles = new File[files.length];
            System.out.println((int) ' ');
            for (int i = 0; i < files.length; i++) {
                newFiles[i] = new File(i, files[i]);
            }

            Arrays.sort(newFiles);
            String[] answer = new String[files.length];
            for (int i = 0; i < files.length; i++) {
                answer[i] = newFiles[i].title;
            }
            return answer;
        }

    }

    class File implements Comparable<File> {
        int idx;
        String title;
        String head;
        int number;

        File(int idx, String t) {
            this.idx = idx;
            this.title = t;
            this.head = getHeader(t);
            this.number = getNumber(t);
        }

        private String getHeader(String t) {
            for (int i = 1; i < t.length(); i++) {
                char c = t.charAt(i);
                if (c - '0' >= 0 && c - '0' <= 10) {
                    return t.substring(0, i).toLowerCase();
                }
            }
            return "";
        }

        private int getNumber(String t) {
            int startIdx = 0;
            for (int i = 1; i < t.length(); i++) {
                char c = t.charAt(i);
                if (c - '0' >= 0 && c - '0' <= 10) {
                    startIdx = i;
                    break;
                }
            }

            for (int i = startIdx; i < t.length(); i++) {
                char c = t.charAt(i);
                if (c - '0' < 0 || c - '0' > 10) {
                    return Integer.valueOf(t.substring(startIdx, i));
                }
            }
            return Integer.valueOf(t.substring(startIdx, t.length()));
        }

        @Override
        public int compareTo(File other) {
            if (!this.head.equals(other.head)) {
                return this.head.compareTo(other.head);
            }
            if (this.number != other.number) {
                return this.number - other.number;
            }
            return this.idx - other.idx;
        }
    }

}
