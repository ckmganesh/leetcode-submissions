class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<asteroids.length;i++)
        {
            if(asteroids[i]>0)
            {
                stack.push(asteroids[i]);
                
            }
            else 
            {
                while(!stack.isEmpty()&&stack.peek()>0&&stack.peek()<Math.abs(asteroids[i]))
                {
                    stack.pop();
                }
                if(stack.isEmpty()||stack.peek()<0)
                {
                    stack.push(asteroids[i]);
                }
                else if(stack.peek()==Math.abs(asteroids[i]))
                {
                    stack.pop();
                }
            }
        }
        int[] result =new int[stack.size()];
        for(int i= stack.size()-1;i>=0;i--)
        {
            result[i]=stack.pop();
        }
        System.out.println("Length"+asteroids.length);
        for(int i=0;i<result.length;i++)
            System.out.println(result[i]);
        return result;
        
    }
}