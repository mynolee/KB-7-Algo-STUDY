import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        // 이름 별 인덱스 저장
        Map<String, Integer> indexMap = new HashMap<>();
        // 중복 신고 제거를 위한 신고 목록 저장
        Set<String> reportSet = new HashSet<>();
        // 각 사람별로 신고 당한 횟수 저장
        Map<String, Integer> reportCountMap = new HashMap<>();

        for (int i = 0; i < id_list.length; i++) {
            String name = id_list[i];
            indexMap.put(name, i);
            reportCountMap.put(name, 0);
        }
        
        for (String singleReport : report) {
            reportSet.add(singleReport);
        }

        for (String singleReport : reportSet) {
            String[] reportArr = singleReport.split(" ");
            String reported = reportArr[1];    
            
            reportCountMap.put(reported, reportCountMap.get(reported) + 1);
        }

        // 각 사람이 신고한 사람 중 정지당한 사람 세기
        for (String singleReport : reportSet) {
            String[] reportArr = singleReport.split(" ");
            String reporter = reportArr[0];
            String reported = reportArr[1];
            if (reportCountMap.get(reported) >= k) {
                int index = indexMap.get(reporter);
                answer[index]++;
            }
        }
        return answer;
    }
}
