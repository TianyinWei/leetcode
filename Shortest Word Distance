public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int minDistance = Integer.MAX_VALUE;
        int index = -1;
        
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1) || words[i].equals(word2)) {
                if (index > -1 && (!words[index].equals(words[i]))) {
                    minDistance = Math.min(minDistance, i - index);
                }
                index = i;
            }
        }
        
        return minDistance;
    }
}
