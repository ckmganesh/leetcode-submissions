class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int visited[]=new int[numCourses];
        int result[] =new int[numCourses];
        int k=0;
        for(int i=0;i<prerequisites.length;i++)
        { 
            visited[prerequisites[i][0]]++;
        }
       LinkedList<Integer> st=new LinkedList<>();
        for(int i=0;i<visited.length;i++)
        {
            if(visited[i]==0)
                st.push(i);
        }
        int count=0;
        while(!st.isEmpty())
        {
            System.out.print(st);
            int s=st.pop();
            result[k++]=s;
            count++;
            for(int i=0;i<prerequisites.length;i++){
                if(prerequisites[i][1] == s){
                    visited[prerequisites[i][0]]--;
            if(visited[prerequisites[i][0]]==0)
            {
                st.push(prerequisites[i][0]);
            }
                    
                
            
        }
            }
                
        
    }
          if(count==numCourses)
         return result;
            
            else return new int[0];
    

}
}