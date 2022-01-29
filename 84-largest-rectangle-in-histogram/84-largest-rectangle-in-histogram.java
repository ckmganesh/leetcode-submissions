class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights==null||heights.length==0) return 0;
        if(heights.length==1) return heights[0];
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        Stack<Integer> st = new Stack();
        for(int i=0;i<heights.length;i++){
            if(st.isEmpty()){
                left[i]=0;
                st.push(i);
            }
            else{
            while(!st.isEmpty()&&heights[st.peek()]>=heights[i]){
                st.pop();
            }
                
            if(st.isEmpty()) left[i] = 0;
            else left[i] = st.peek()+1;
                st.push(i);
        }
                
    }
        while(!st.isEmpty()) st.pop();

        for(int i=heights.length-1;i>=0;i--){
            if(st.isEmpty()){
                right[i]=heights.length-1;
                st.push(i);
            }
            else{
            while(!st.isEmpty()&&heights[st.peek()]>=heights[i]){
                st.pop();
            }    
            if(st.isEmpty()) right[i] = heights.length-1;
            else right[i] = st.peek()-1;
                st.push(i);
        }
    }
        
        int max = Integer.MIN_VALUE;
        for(int i=0;i<heights.length;i++){
            max=Math.max(max,((right[i]-left[i]+1)*heights[i]));
        }

        return max;
    }
}