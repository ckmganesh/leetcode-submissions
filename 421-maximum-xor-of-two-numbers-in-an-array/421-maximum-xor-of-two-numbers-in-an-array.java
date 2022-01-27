class Solution {
    class TrieNode{
        TrieNode children[];
        TrieNode(){
            children = new TrieNode[2];
        }
    }
    
    public int findMaximumXOR(int[] nums) {
     int max=0; TrieNode root = new TrieNode();
        for(int i=0;i<nums.length;i++){
            TrieNode current = root;
            for(int j=31;j>=0;j--){
                int bit = (nums[i]&(1<<j))>0?1:0;
                if(current.children[bit]==null){
                    current.children[bit] = new TrieNode();
                }
                current = current.children[bit];
            }
        }
        
        for(int i=0;i<nums.length;i++){
            TrieNode current = root;
            int val=0;
            for(int j=31;j>=0;j--){
                int bit = (nums[i]&(1<<j))>0?1:0;
                if(bit==0){
                    if(current.children[1]!=null){
                        val=val*2+1;
                        current = current.children[1];
                    }
                    else{
                        val = val*2;
                        current = current.children[0];
                    }
                }
                else{
                    if(current.children[0]!=null){
                        val = val*2+1;
                        current=current.children[0];
                    }
                    else{
                        val = val*2;
                        current = current.children[1];
                    }
                }
            }
            max=Math.max(max,val);
        }
        
        return max;
    }
}