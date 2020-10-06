class Solution {
public:
    int maxEnvelopes(vector<vector<int>>& envelopes) {
        int n=envelopes.size();
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        vector<pair<int ,int> >enve(n);
        for(int i=0;i<n;i++)
        {
            enve[i].first=envelopes[i][0];
            enve[i].second=envelopes[i][1];
        }
        sort(enve.begin(),enve.end());
        vector<int>dp(n+1,1);
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(enve[i].first>enve[j].first&&enve[i].second>enve[j].second)
                {
                    dp[i]=max(dp[i],dp[j]+1);
                }
            }
        }
        int ans=INT_MIN;
        for(int i=0;i<n;i++)
            ans=max(ans,dp[i]);
        return ans;
    }
};