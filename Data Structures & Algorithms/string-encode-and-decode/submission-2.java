class Solution {

    public String encode(List<String> strs) {
        String encodedStr = "";
        for(String str: strs) {
            int strLen = str.length();
            encodedStr = encodedStr + strLen + "#" + str;
        }
        return encodedStr;
    }

    public List<String> decode(String str) {
        List<String> decodedStrs = new ArrayList<>();
        int i = 0;
        while(i < str.length()) {
            int j = str.indexOf('#', i);
            int strLen = Integer.parseInt(str.substring(i, j));
            String word = str.substring(j + 1, j + 1 + strLen);

            decodedStrs.add(word);

            i = j + 1 + strLen;
        }
        return decodedStrs;
    }
}
