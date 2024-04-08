package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class BJ4358_SILVER2_생태학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Word2> map = new HashMap<>();

        int count = 0;
        String s = br.readLine();
        while (true) {
            if (!map.containsKey(s)) map.put(s, new Word2(s));
            map.get(s).count++;
            count++;
            s = br.readLine();
            if (s == null || s.isEmpty()) break;
        }

        List<Word2> words = map.values().stream().sorted().collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();

        for (Word2 word : words) {
            double temp = ((double) word.count / count) * 100;
            sb.append(word.w).append(" ").append(String.format("%.4f", temp)).append("\n");
        }

        System.out.println(sb);
    }
}

class Word2 implements Comparable<Word2> {
    String w;
    int count;

    public Word2(String w) {
        this.w = w;
        this.count = 0;
    }

    @Override
    public int compareTo(Word2 o) {
        return w.compareTo(o.w);
    }
}
