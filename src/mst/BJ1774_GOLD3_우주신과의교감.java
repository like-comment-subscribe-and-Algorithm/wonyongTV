package mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ1774_GOLD3_우주신과의교감 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] sites = new int[n][];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int[] temp = new int[2];
            temp[0] = Integer.parseInt(st.nextToken());
            temp[1] = Integer.parseInt(st.nextToken());
            sites[i] = temp;
        }

        List<Path1> paths = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] a = sites[i];
            for (int j = i + 1; j < n; j++) {
                int[] b = sites[j];
                double d1 = Math.pow(b[0] - a[0], 2);
                double d2 = Math.pow(b[1] - a[1], 2);
                double div = Math.sqrt(d2 + d1);
                paths.add(new Path1(i, j, div));
            }
        }

        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            union(a, b, parent);
        }

        Collections.sort(paths);
        double answer = 0d;
        for (Path1 path : paths) {
            if (find(path.start, parent) == find(path.end, parent)) continue;

            union(path.start, path.end, parent);
            answer += path.value;

        }
        System.out.println(String.format("%.2f", answer));
    }


    private static void change(int a, int b, int[] parent) {
        if (a > b) parent[a] = b;
        else parent[b] = a;
    }


    private static void union(int a, int b, int[] parent) {
        int a1 = find(a, parent);
        int b1 = find(b, parent);
        if (a1 != b1) change(a1, b1, parent);
    }

    private static int find(int a, int[] parent) {
        if (a == parent[a]) return a;
        return parent[a] = find(parent[a], parent);
    }
}

class Path1 implements Comparable<Path1> {
    int start;
    int end;
    double value;

    public Path1(int start, int end, double value) {
        this.start = start;
        this.end = end;
        this.value = value;
    }

    @Override
    public int compareTo(Path1 o) {
        if (this.value > o.value) return 1;
        return -1;
    }
}