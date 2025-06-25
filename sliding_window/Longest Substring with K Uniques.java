// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        int begin=0,end=0,counter=0;
        int len = 0;
        HashMap<Character,Integer> map= new HashMap<>();
        while(end<s.length()){
            char c= s.charAt(end);
            map.put(c,map.getOrDefault(c,0)+1);
            if(map.get(c) == 1) counter++;//new char
            end++;
            
            while(counter>k){
                char tempc = s.charAt(begin);
                if(map.containsKey(tempc)){
                    map.put(tempc,map.get(tempc)-1);
                }
                if(map.get(tempc)==0){
                    counter--;
                }
                begin++;
            }
            
            if (counter == k) {
                    len = Math.max(len, end - begin);
            }
            
        }
        return len;
    }
}