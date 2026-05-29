import java.io.*;
import java.util.*;

public class Main {

    public static int answer;
    public static int[][] arr;
    public static int[] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        arr = new int[10][10];
        paper = new int[6];
        answer = -1;

        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 10; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0);

        pw.println(answer);
        // 정답 출력 pw.println();

        // 풀이 작성 끝 =======================
        br.close();
        pw.flush();
        pw.close();
    }

    public static void dfs(int r, int c, int cnt) {
        if (r == 10 && c == 10) {
            answer = answer == -1 ? cnt : Math.min(answer, cnt);
            return;
        }

        for (int i = r; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (arr[i][j] == 1) {
                    for (int k = 1; k <= 5; k++) {
                        if (paper[k] < 5) {
                            boolean can = true;
                            for (int l = 0; l < k; l++) {
                                for (int m = 0; m < k; m++) {
                                    int checkR = i + l;
                                    int checkC = j + m;
                                    if (checkR >= 10 || checkC >= 10 || arr[checkR][checkC] == 0) {
                                        return;
                                    }
                                }
                            }

                            // 색종이를 붙일 수 있다!
                            paper[k]++;
                            for (int l = i; l < i + k; l++) {
                                for (int m = j; m < j + k; m++) {
                                    arr[l][m] = 0;
                                }
                            }
                            dfs(i, j, cnt + 1);
                            paper[k]--;
                            for (int l = i; l < i + k; l++) {
                                for (int m = j; m < j + k; m++) {
                                    arr[l][m] = 1;
                                }
                            }
                        }
                    }
                }
                else if (i == 9 && j == 9) dfs(10, 10, cnt);
            }
        }
    }
}

