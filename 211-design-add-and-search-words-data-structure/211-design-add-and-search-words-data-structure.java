class WordDictionary {
    
    class TrieNode{
        TrieNode children[];
        boolean isEnd;
        
        public TrieNode(){
            children = new TrieNode[26];
            isEnd=false;
        }
    }
    TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
       
    }
    
    public void addWord(String word) {
        TrieNode curr = root;
        for(char c:word.toCharArray()){
            int index = (int) c - 'a';
            if(curr.children[index]==null){
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.isEnd=true;
    }
    
    public boolean search(String word) {
        return find(word,root,0);
    }
    
    boolean find(String word,TrieNode curr,int index){
        if(index==word.length()){
            return curr.isEnd;
        }
        char c = word.charAt(index);
        if(c=='.'){
            for(int i=0;i<26;i++){
                if(curr.children[i]!=null)
                {
                    if(find(word,curr.children[i],index+1))
                        return true;
                }
            }
            return false;
        }
        else{
            int position = (int) c - 'a';
            if(curr.children[position] !=null && find(word,curr.children[position],index+1)){
                return true;
            }
            return false;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */