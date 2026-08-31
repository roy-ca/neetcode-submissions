class Pair {
    String word;
    int step;

    Pair(String word, int step) {
        this.word = word;
        this.step = step;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();

        queue.add(new Pair(beginWord, 1));

        for(String s: wordList) {
            set.add(s);
        }
        set.remove(beginWord);

        while(!queue.isEmpty()) {
            String word = queue.peek().word;
            int step = queue.peek().step;

            queue.poll();

            if(word.equals(endWord)) {
                return step;
            }
            for(int i = 0; i < word.length(); i++) {
                for(char ch = 'a'; ch <= 'z'; ch++) {
                    char[] chArr = word.toCharArray();
                    chArr[i] = ch;
                    String replString = new String(chArr);
                    if(set.contains(replString)) {
                        set.remove(replString);
                        queue.add(new Pair(replString, step + 1));
                    }
                }
            }
        }
        return 0;
    }
}
