class Solution {
    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> merged = new LinkedList();
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        merged.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            int current[] = intervals[i];
            if(current[0]<=merged.get(merged.size()-1)[1]){
                merged.getLast()[1]=Math.max(merged.getLast()[1],current[1]);
            }
            else{
                merged.add(current);
            }
        }
        
        return merged.toArray(new int[merged.size()][]);
    }
}