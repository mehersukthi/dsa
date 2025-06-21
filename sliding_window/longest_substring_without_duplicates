class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map=new HashMap<>();
        int begin=0,end=0;
        int counter=0;
        int len=0;

        while(end<s.length()){
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if(map.get(c)>1){ //check if its duplicate
                counter++; //duplicate in the current window im considering
            }
            end++;
            while(counter>0){ //while counter greater than 0 i dont want it thats why move begin forward therefore exclude the values which i considered previosuly
                char tempc= s.charAt(begin);
                if(map.get(tempc) > 1){
                    counter--;
                }
                map.put(tempc, map.get(tempc)-1);
                begin++;
            }
            len=Math.max(len,end-begin);
        }
        return len;
    }
}
