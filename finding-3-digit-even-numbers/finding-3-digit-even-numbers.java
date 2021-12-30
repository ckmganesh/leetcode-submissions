class Solution {
    public int[] findEvenNumbers(int[] digits) {
      List<Integer> list = new ArrayList();
        int count[] = new int[10];
        for(int a:digits) count[a]++;
        for(int i=100;i<999;i+=2){
            int current[] = new int[10];
            int temp=i;
            while(temp!=0){
                current[temp%10]++;
                temp/=10;
            }
            boolean flag=true;
            for(int j=0;j<current.length;j++){
                if(current[j]>count[j]){
                    flag=false;
                    break;
                }
            }
            if(flag) list.add(i);
        }
        int result[] = new int[list.size()];
        for(int i=0;i<list.size();i++)
            result[i]=list.get(i);
        return result;
    }
}