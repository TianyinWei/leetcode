'''
This is a follow up of Shortest Word Distance. The only difference is now word1 could be the same as word2.

Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

word1 and word2 may be the same and they represent two individual words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = “makes”, word2 = “coding”, return 1.
Given word1 = "makes", word2 = "makes", return 3.

Note:
You may assume word1 and word2 are both in the list.
'''

class Solution(object):
    def shortestWordDistance(self, words, word1, word2):
        """
        :type words: List[str]
        :type word1: str
        :type word2: str
        :rtype: int
        """
        index = -1
        minDistance = len(words)
        for i in range(len(words)):
            if word1 != word2:
                if (words[i] == word1 or words[i] == word2):
                    if (index > -1 and (words[i] != words[index])):
                        minDistance = min(minDistance, i - index)
                    index = i
            else:
                if (words[i] == word1):
                    if (index > -1):
                        minDistance = min(minDistance, i - index)
                    index = i
        return minDistance
                    
                
