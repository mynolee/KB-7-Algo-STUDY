import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 채점용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        /*
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        PrintWriter pw = new PrintWriter(new FileWriter("output.txt"));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        */

        // 풀이 작성 시작 =====================

        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        String dna = br.readLine();

        st = new StringTokenizer(br.readLine());
        int[] a = new int[4]; // acgt answer
        for (int i = 0; i < 4; i++) a[i] = Integer.parseInt(st.nextToken());

        // 처음 p개의 acgt를 기록. 확인. 다음칸으로 넘어갈때 앞에거 뺴고 뒤에거 추가.
        HashMap<Character, Integer> idx = new HashMap<>(); // index
        idx.put('A', 0);
        idx.put('C', 1);
        idx.put('G', 2);
        idx.put('T', 3);

        int[] c = new int[4]; // current count
        for (int i = 0; i < p; i++) {
            c[idx.get(dna.charAt(i))]++;
        }

        int count = 0;
        for (int i = 0; i + p - 1 < s; i++) {
            if (i != 0) {
                c[idx.get(dna.charAt(i - 1))]--;
                c[idx.get(dna.charAt(i + p - 1))]++;
            }
            if (c[0] >= a[0] && c[1] >= a[1] && c[2] >= a[2] && c[3] >= a[3]) count++;
        }

        // **** 정답 출력 pw.println(answer) ========
        pw.println(count);

        // 풀이 작성 끝 =======================
        br.close();
        pw.flush();
        pw.close();
    }
}
