package exam;

import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int N = report.length;
        int M = id_list.length;
        int[] answer = new int[M];

        // id에 따른 신고목록을 저장할 자료구조 선택
        Map<String, HashSet<String>> map = new HashMap<>();
        // index 저장을 위한 맵
        Map<String, Integer> idxMap = new HashMap<>();

        // 이름에 따른 해쉬셋 초기화
        for(int i = 0; i < M; i++) {
            String s = id_list[i];
            map.put(s, new HashSet<>());
            idxMap.put(id_list[i], i);
        }
        // " "으로 구분하여 신고자, 신고당한사람 기록
        for(int i = 0; i < N; i++) {
            String[] r = report[i].split(" "); // 0은 신고자, 1은 신고당한사람
            // 신고당한 사람 리스트에 신고한 사람을 추가
            map.get(r[1]).add(r[0]);
            // 자료구조를 조회하여 이미 신고한 사람일 경우 추가 x => 해쉬 셋 이용.
        }

        // 신고당한 사람 리스트를 조회하여 신고횟수가 k를 넘을 경우 report에 추가
        for(int i = 0; i < M; i++) {
            HashSet<String> reporter = map.get(id_list[i]);
            if(reporter.size() >= k) {
                // 신고자들에게 메일 수 증가시키기
                for(String name : reporter) {
                    answer[idxMap.get(name)]++;
                }
            }
        }
        return answer;
    }
}
