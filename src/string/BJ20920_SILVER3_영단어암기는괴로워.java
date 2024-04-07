package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BJ20920_SILVER3_영단어암기는괴로워 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, Word> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            if (word.length() < m) continue;

            if (map.containsKey(word)) map.get(word).count();
            else map.put(word, new Word(word));
        }

        List<Word> words = map.values().stream().sorted().collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        for (Word w : words) {
            sb.append(w.content).append("\n");
        }
        System.out.println(sb);
    }
}

class Word implements Comparable<Word> {
    String content;
    int count;

    public Word(String content) {
        this.content = content;
        this.count = 1;
    }

    public void count() {
        this.count += 1;
    }

    @Override
    public int compareTo(Word o) {
        if (this.count != o.count) return o.count - this.count;
        if (this.content.length() != o.content.length()) return o.content.length() - this.content.length();
        return this.content.compareTo(o.content);
    }
}
