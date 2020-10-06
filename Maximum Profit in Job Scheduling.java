class Solution {
    
      class Job
    {
          int Start;
          int End;
          int Profit;
        public Job(int start, int end, int profit)
        {
            Start = start;
            End = end;
            Profit = profit;
        }

       
    }
    
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
          
        Job[] job=new Job[profit.length];
         for(int i=0;i<profit.length;i++)
         {
            job[i]=new Job(startTime[i],endTime[i],profit[i]);
         }
        Arrays.sort(job,(x,y) -> x.End-y.End);
        int[] dp=new int[profit.length];
        dp[0]=job[0].Profit;
        for(int i=1;i<dp.length;i++)
        {
            dp[i]=Math.max(dp[i-1],job[i].Profit);
            for(int j=i-1;j>=0;j--)
            {
                if(job[i].Start>=job[j].End)
                {
                    dp[i]=Math.max(dp[i],job[i].Profit+dp[j]);
                    break;
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
        }
        
    }
