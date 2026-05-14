import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        // 단어를 저장하지 않고 words 배열의 인덱스를 저장함
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[words.length];
        int[] dist = new int[words.length];

        // begin에서 한 글자만 바꿔서 변환할 수 있는 단어들을 처음 큐에 넣고 bfs 시작
        for (int i = 0; i < words.length; i++) {
            if (canConvert(begin, words[i])) {
                q.offer(i);
                visited[i] = true;
                dist[i] = 1;
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            // 문자열 내용 비교: equals() 사용
            if (words[cur].equals(target)) {
                return dist[cur];
            }
            for (int next = 0; next < words.length; next++) {
                if (!visited[next] && canConvert(words[cur], words[next])) {
                    q.offer(next);
                    visited[next] = true;
                    dist[next] = dist[cur] + 1;
                }
            }
        }
        return 0;
    }

    private boolean canConvert(String a, String b) {
        int diffCount = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diffCount++;
            }
            if (diffCount > 1) {
                return false;
            }
        }
        // 한 글자만 다른 경우 true 리턴
        return diffCount == 1;
    }
}
