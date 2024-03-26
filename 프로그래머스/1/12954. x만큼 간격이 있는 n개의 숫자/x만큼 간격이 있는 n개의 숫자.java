import java.util.*;

class Solution {
    public long[] solution(int x, int n) {
      
        List<Long> answer = new ArrayList<>();
        long num = 0;
        while (answer.size() < n) {
            num += (long)x;
            answer.add(num);
        }
     
        return answer.stream().mapToLong(i->i).toArray();
    }
}