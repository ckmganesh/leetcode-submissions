class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        boolean visited[] = new boolean[friends.length];
        visited[id]=true;
        List<Integer> queue = new ArrayList();
        queue.add(id);
        for(int i=0;i<level;i++){
            List<Integer> nextLevel = new ArrayList();
            for(int a:queue){
                for(int f:friends[a]){
                    if(!visited[f]){
                    visited[f]=true;
                    nextLevel.add(f);
                    }
                }
            }
            queue = nextLevel;
        }
        HashMap<String,Integer> map = new HashMap();
        for(int a:queue){
            for(String s:watchedVideos.get(a)){
                map.put(s,map.getOrDefault(s,0)+1);
            }
        }
        List<String> result = new ArrayList();
        for(String str:map.keySet()){
            result.add(str);
        }
        result.sort((a,b)->{
            int freqA = map.get(a);
            int freqB = map.get(b);
            if(freqA!=freqB) return freqA-freqB;
            else return a.compareTo(b);
        });
        return result;
    }
}