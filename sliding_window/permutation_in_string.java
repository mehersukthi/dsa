class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()){
            return false;
        }
        int begin=0,end=0,counter=0;
        Map<Character,Integer> map=new HashMap<>();
        for(char c: s1.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        counter = map.size();
        while(end<s2.length()){
            char c= s2.charAt(end);
            if(map.containsKey(c)){
                map.put(c,map.get(c)-1); //matching cut 
                if(map.get(c) == 0) counter--;
            }
            end++;
            while(counter==0){
                char temp = s2.charAt(begin);
                if(map.containsKey(temp)){
                    map.put(temp,map.get(temp)+1);
                    if(map.get(temp)>0){
                        counter++;
                    }
                }
                if(end-begin==s1.length()){
                    return true;
                }
                begin++;
            }
        }
        return false;

    }
}
