class Solution {
    public int characterReplacement(String s, int k) {
       int begin=0,end=0,len=0;
       int counter=0;
       Map<Character,Integer> map=new HashMap<Character,Integer>();
       while(end<s.length()){
        char c= s.charAt(end);
        map.put(c,map.getOrDefault(c,0)+1);
        counter = Math.max(counter,map.get(c)); //counter is max chars of same letter so that replace by this char 
        end++;

        while(!(end - begin - counter <= k)){ //if exceeds k constraint (subtracting counter coz we are replacing chars with highest count)
            char temp = s.charAt(begin);
            map.put(temp,map.get(temp)-1);
            counter = getmax(map);
            begin++;
        }
        len=Math.max(len,end-begin);
       }
       return len;
    }
    public int getmax(Map<Character,Integer> map){
        int c=0;
        for(int v : map.values()){
            c=Math.max(c,v);
        }
        return c;
    }
}
