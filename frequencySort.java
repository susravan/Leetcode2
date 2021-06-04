import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public String frequencySort(String s) {
        int[] occurances = new int[256];
        for(char ch: s.toCharArray()) {
            occurances[ch]++;
        }
        Queue<Character> pq = new PriorityQueue<>(
                new Comparator<Character>() {
                    @Override
                    public int compare(Character ch1, Character ch2) {
                        return occurances[ch2]-occurances[ch1];
                    }
                }
        );

        for(int i=0; i < occurances.length; i++) {
            int occur = occurances[i];
            if(occur != 0) {
                pq.offer((char)i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            char ch = pq.poll();
            while(occurances[ch] != 0) {
                sb.append(ch);
                occurances[ch]--;
            }
        }
        return sb.toString();
    }
}
