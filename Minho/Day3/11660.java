import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int A[][]  = new int[N+1][N+1];

        for(int i = 1; i<=N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j<=N; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int D[][] = new int[N+1][N+1];
        for(int i = 1; i<=N; i++){
            for(int j = 1; j<=N; j++ ){
                D[i][j] = D[i][j-1] + D[i-1][j] - D[i-1][j-1] + A[i][j];
            }
        }

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int result = D[x2][y2] - D[x1 - 1][y2] - D[x2][y1-1] + D[x1 - 1][y1 - 1];
            System.out.println(result);

        }
    }
}


// 보통 초보는 이차원 배열 돌면서 다 더할 생각함.
// 근데 질문이 너무 많아서 터짐.
// 그래서 미리 합을 저장해야겠다는 생각이 나와야됌.
// 이게 누적합의 시작
// 사각형에서 사각형만 빼서 원하는 사각형 구하기
// 합 배열 만들고 그 합 배열에서 안들어가는 빼고 겹쳐서 빠지는 부분 다시 추가
