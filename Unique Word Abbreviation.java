/*
An abbreviation of a word follows the form <first letter><number><last letter>. Below are some examples of word abbreviations:

1) [“dog”]; isUnique(“dig”);   
//False, because “dig” has the same abbreviation with “dog" and “dog” is already in the dictionary. It’s not unique.

2) [“dog”, “dog"]; isUnique(“dog”);  
//True, because “dog” is the only word that has “d1g” abbreviation.

3) [“dog”, “dig”]; isUnique(“dog”);   
//False, because if we have more than one word match to the same abbreviation, this abbreviation will never be unique.
*/

public class ValidWordAbbr {
    HashMap<String, String> map = new HashMap<String, String>();

    public ValidWordAbbr(String[] dictionary) {
        for (int i = 0; i < dictionary.length; i++) {
            String str = dictionary[i];
            String abbr = generateAbbr(str);
            if (map.containsKey(abbr)) {
                if (map.get(abbr).equals(str))  continue;
                else map.put(abbr, ""); //invalidate this entry
            } else {
                map.put(abbr, str);
            }
        }
    }

    public boolean isUnique(String word) {
        String abbr = generateAbbr(word);
        if (!map.containsKey(abbr)) return true;
        if (map.get(abbr) == "")    return false;
        if (map.get(abbr).equals(word)) return true;
        return false;
    }
    
    private String generateAbbr(String str) {
        if (str.length() == 0 || str.length() == 1 || str.length() == 2) return str;
        return (str.charAt(0) + String.valueOf(str.substring(1, str.length()).length()) + str.charAt(str.length()-1));
    }
}




// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");
