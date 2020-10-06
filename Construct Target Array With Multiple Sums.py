class Solution(object):
    def isPossible(self, target):
        if(len(target)<2):
            return target[0]==1
        sume=sum(target)
        maxe=max(target)
        maxindex=target.index(maxe)
        while(maxe>1):
            remain=sume-maxe
            if(remain==1):
                return True;
            x=maxe%remain
            if(x==0 or maxe<remain):
                return False;
            target[maxindex]=x
            sume=remain+x
            maxe=max(target)
            maxindex=target.index(maxe)
        return True;
    
       