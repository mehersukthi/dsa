class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length()){ //edge case
            return "";
        }
        Map<Character,Integer> map=new HashMap<Character,Integer>(); // char count in target
        for(char c: t.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int counter = map.size(); //to check if all duplicates of one char matched 
        int begin=0,end=0;
        int head=0; //to track length we need minimum so when ever we found match update head with begin where the diff is minimum between begin and end 
        int len= Integer.MAX_VALUE;

        while(end<s.length()){
            char c = s.charAt(end);
            if(map.containsKey(c)){
                map.put(c,map.get(c)-1); //crossing out t's char and s's char
                if(map.get(c)==0){
                    counter--; //that means the whole char with its duplicate matched
                }
            }
           
            end++; //incrementing here because ?

            //to check if you got all matches , move begin forward and back to map uncut
            while(counter==0){
                char tempc = s.charAt(begin);
                if(map.containsKey(tempc)){
                    map.put(tempc,map.get(tempc)+1);
                    if(map.get(tempc)>0){
                        counter++;
                    }
                }

                //catch begin and end ;
                if(end-begin<len){
                    len= end-begin;
                    head=begin;
                }

                begin++;
            }

        }

        if(len == Integer.MAX_VALUE) return "";
        return s.substring(head, head+len);
    }
}