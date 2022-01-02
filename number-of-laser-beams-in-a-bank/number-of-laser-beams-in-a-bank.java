class Solution {
    public int numberOfBeams(String[] bank) {
        int count[] = new int[bank.length];
        for(int i=0;i<bank.length;i++){
            for(int j=0;j<bank[i].length();j++){
                if(bank[i].charAt(j)=='1') count[i]++;
            }
        }
        int result=0;
        int prev=count[0],index=-1;
        for(int i=0;i<count.length;i++){
            if(count[i]>0){
                prev=count[i];
                index=i;
                break;
            }
        }
        if(index==-1) return 0;
        for(int j=index+1;j<count.length;j++){
            if(count[j]>0){
                result+=prev*count[j];
                prev=count[j];
            }
        }
        return result;
    }
}