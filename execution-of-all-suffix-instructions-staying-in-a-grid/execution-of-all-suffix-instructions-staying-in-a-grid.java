class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int result[] = new int[s.length()];
        for(int i=0;i<s.length();i++){
            result[i] = helper(n,i,s,0,startPos[0],startPos[1]);
        }
        return result;   
    }
    int helper(int n,int index,String s,int count,int x,int y){
        if(index==s.length()) return count;
        if(s.charAt(index)=='R'){
            if(y+1<n) return helper(n,index+1,s,count+1,x,y+1);
            else return count;
        }
        else if(s.charAt(index)=='L'){
            if(y-1>=0) return helper(n,index+1,s,count+1,x,y-1);
            else return count;
        }
        else if(s.charAt(index)=='U'){
            if(x-1>=0) return helper(n,index+1,s,count+1,x-1,y);
            else return count;
        }
        else{
            if(x+1<n) return helper(n,index+1,s,count+1,x+1,y);
            else return count;
        } 
    }
}