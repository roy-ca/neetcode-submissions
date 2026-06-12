class Solution {

    public String encode(List<String> strs) {
        String encodedString = "";
        for(String s: strs) {
            int stringLen = s.length();
            String encodedVal = stringLen + "#" + s;
            encodedString = encodedString + encodedVal;
        }
        return encodedString;
    }

    public List<String> decode(String str) {
        List<String> decodedList = new ArrayList<>();

        int i = 0;
        while(i < str.length()) {
            int j = i;

            while(str.charAt(j) != '#') {
                j++;
            }
            int len = Integer.parseInt(str.substring(i, j));
            String subStr = str.substring(j+1, j+1+len);

            i = j+len+1;

            decodedList.add(subStr);
        }
        return decodedList;
    }
}
