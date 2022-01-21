class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int g=0,c=0,tank=0,start=0;
        for(int i=0;i<gas.length;i++)
        {
            g+=gas[i];
            c+=cost[i];
            tank+=(gas[i]-cost[i]);
            if(tank<0)
            {
                tank=0;
                start=i+1;
            }
        }
        if(g<c)
            return -1;
        return start;
        
    }
}