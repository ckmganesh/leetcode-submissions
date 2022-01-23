class Solution {
//     public int numberOfArrays(int[] diff, int lower, int upper) {
//         List<Integer> result = new ArrayList();
//         result.add(lower);
//         int min=lower,max=lower;
//         for(int i=0;i<diff.length;i++){
//             result.add(result.get(result.size()-1)+diff[i]);
//             min=Math.min(min,result.get(result.size()-1));
//             max=Math.max(max,result.get(result.size()-1));
//         }
//         int liftValue = lower-min;
//         for(int i=0;i<result.size();i++){
//             result.set(i,result.get(i)+liftValue);
//         }
//         for(int a:result){
//             if(a>upper||a<lower) return 0;
//         }
//         int liftValueUp =  (upper-max);
//         return liftValueUp-liftValue+1;
        
//     }
    public int numberOfArrays(int[] diff, int lower, int upper) {
        long a = 0, ma = 0, mi = 0;
        for (int d: diff) {
            a += d;
            ma = Math.max(ma, a);
            mi = Math.min(mi, a);
        }
        return (int)Math.max(0, (upper - lower) - (ma - mi) + 1);
    }
}