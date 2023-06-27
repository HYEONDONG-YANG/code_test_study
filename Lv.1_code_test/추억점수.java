/*
추억 점수
문제 설명
사진들을 보며 추억에 젖어 있던 루는 사진별로 추억 점수를 매길려고 합니다. 사진 속에 나오는 인물의 그리움 점수를 모두 합산한 값이 해당 사진의 추억 점수가 됩니다. 예를 들어 사진 속 인물의 이름이 ["may", "kein", "kain"]이고 각 인물의 그리움 점수가 [5점, 10점, 1점]일 때 해당 사진의 추억 점수는 16(5 + 10 + 1)점이 됩니다. 다른 사진 속 인물의 이름이 ["kali", "mari", "don", "tony"]이고 ["kali", "mari", "don"]의 그리움 점수가 각각 [11점, 1점, 55점]]이고, "tony"는 그리움 점수가 없을 때, 이 사진의 추억 점수는 3명의 그리움 점수를 합한 67(11 + 1 + 55)점입니다.

그리워하는 사람의 이름을 담은 문자열 배열 name, 각 사람별 그리움 점수를 담은 정수 배열 yearning, 각 사진에 찍힌 인물의 이름을 담은 이차원 문자열 배열 photo가 매개변수로 주어질 때, 사진들의 추억 점수를 photo에 주어진 순서대로 배열에 담아 return하는 solution 함수를 완성해주세요.

제한사항
3 ≤ name의 길이 = yearning의 길이≤ 100
3 ≤ name의 원소의 길이 ≤ 7
name의 원소들은 알파벳 소문자로만 이루어져 있습니다.
name에는 중복된 값이 들어가지 않습니다.
1 ≤ yearning[i] ≤ 100
yearning[i]는 i번째 사람의 그리움 점수입니다.
3 ≤ photo의 길이 ≤ 100
1 ≤ photo[i]의 길이 ≤ 100
3 ≤ photo[i]의 원소(문자열)의 길이 ≤ 7
photo[i]의 원소들은 알파벳 소문자로만 이루어져 있습니다.
photo[i]의 원소들은 중복된 값이 들어가지 않습니다.
입출력 예
name	yearning	photo	result
["may", "kein", "kain", "radi"]	[5, 10, 1, 3]	[["may", "kein", "kain", "radi"],["may", "kein", "brin", "deny"], ["kon", "kain", "may", "coni"]]	[19, 15, 6]
["kali", "mari", "don"]	[11, 1, 55]	[["kali", "mari", "don"], ["pony", "tom", "teddy"], ["con", "mona", "don"]]	[67, 0, 55]
["may", "kein", "kain", "radi"]	[5, 10, 1, 3]	[["may"],["kein", "deny", "may"], ["kon", "coni"]]	[5, 15, 0]
입출력 예 설명
입출력 예 #1

첫 번째 사진 속 "may", "kein", "kain", "radi"의 그리움 점수를 합치면 19(5 + 10 + 1 + 3)점 입니다. 두 번째 사진 속 그리워하는 사람들인 "may"와 "kein"의 그리움 점수를 합치면 15(5 + 10)점입니다. 세 번째 사진의 경우 "kain"과 "may"만 그리워하므로 둘의 그리움 점수를 합한 6(1 + 5)점이 사진의 추억 점수입니다. 따라서 [19, 15, 6]을 반환합니다.

입출력 예 #2

첫 번째 사진 속 그리워하는 사람들인 "kali", "mari", "don"의 그리움 점수를 합치면 67(11 + 1 + 55)점입니다. 두 번째 사진 속엔 그리워하는 인물이 없으므로 0점입니다. 세 번째 사진 속 그리워하는 사람은 "don"만 있으므로 55점입니다. 따라서 [67, 0, 55]를 반환합니다.

입출력 예 #3

설명 생략
*/

import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] result = new int[photo.length];
        Map<String,Integer> map = new HashMap<>();//name 배열에서 이름을 찾기위한 map
        
        for(int i=0;i<name.length;i++){
            map.put(name[i],yearning[i]);//key값을 이름으로, value를 점수로 지정
        }
        
        int j=0; //result배열의 index
        for(String[]photoArray:photo){
            int point=0;
            for(String photoOne:photoArray){
                if(map.get(photoOne)!=null)point+=(int)map.get(photoOne);   //찾는값이 null이 아닌경우 점수추가
            }
            result[j]=point;
            j++;
        }
        
        return result;
    }
}

/*
실행 결과
채점을 시작합니다.
정확성  테스트
테스트 1 〉	통과 (0.03ms, 73.6MB)
테스트 2 〉	통과 (0.03ms, 66.1MB)
테스트 3 〉	통과 (0.19ms, 73.4MB)
테스트 4 〉	통과 (0.14ms, 80.1MB)
테스트 5 〉	통과 (0.40ms, 79.8MB)
테스트 6 〉	통과 (1.11ms, 81.6MB)
테스트 7 〉	통과 (0.55ms, 81.3MB)
테스트 8 〉	통과 (0.65ms, 75.7MB)
테스트 9 〉	통과 (1.23ms, 89.2MB)
테스트 10 〉	통과 (1.93ms, 98.6MB)
테스트 11 〉	통과 (1.29ms, 103MB)
테스트 12 〉	통과 (0.93ms, 95.4MB)
테스트 13 〉	통과 (0.15ms, 83MB)
테스트 14 〉	통과 (0.03ms, 74.7MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
*/