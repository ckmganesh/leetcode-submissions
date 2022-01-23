class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        Queue<Integer> queue = new LinkedList();
        for(int i=1;i<=9;i++){
            queue.add(i);
        }
        List<Integer> result = new ArrayList();
        while(!queue.isEmpty()){
            int current = queue.poll();
            if(current>=low&& current<=high){
                result.add(current);
            }
            int unit = current%10;
            if(unit<9){
                queue.add(current*10+unit+1);
            }
        }
        return result;
    }
}