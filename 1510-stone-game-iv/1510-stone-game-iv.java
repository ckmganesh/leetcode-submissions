class Solution {
    public boolean winnerSquareGame(int n) {
        return dfs(n, new HashMap<>());
    }

    private boolean dfs(int n, Map<Integer, Boolean> memo){
        if(n <= 0)
            return false;
        if(memo.containsKey(n)) return memo.get(n);
        boolean result = false;
        for(int i=1; i*i<=n; i++){
            if(!dfs(n-(i*i), memo)){
                result = true;
                break;
            }
        }
        memo.put(n, result);
        return result;
    }
}