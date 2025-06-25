//crazy you solved this on your own without any help:
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0 || k == 0) return result.stream().mapToInt(Integer::intValue).toArray();;
        HashMap<Integer,Integer> map=new HashMap<>();
        int begin = 0, end = 0;
        while(end< nums.length){
            int c = nums[end];
            map.put(c,map.getOrDefault(c,0)+1);
            end++;

            while(end-begin>k){
                int tempc = nums[begin];
                if(map.containsKey(tempc)){
                    map.put(tempc,map.get(tempc)-1);
                }
                if(map.get(tempc)==0){
                    map.remove(tempc);
                }
                begin++;
            }

            if(end-begin==k){
                int max_of_w = getmax(map);
                result.add(max_of_w);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    public int getmax(HashMap<Integer,Integer> map){
        int maxKey = Integer.MIN_VALUE;
        for (int key : map.keySet()) {
            maxKey = Math.max(maxKey, key);
        }
        return maxKey;
    }

}

//alternative solution using deque

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0 || k == 0) return result.stream().mapToInt(Integer::intValue).toArray();;
        Deque<Integer> deque = new ArrayDeque<>();
        int begin = 0, end = 0;
        while(end< nums.length){
            int current = nums[end];
            while(!deque.isEmpty() && deque.peekLast()<current){
                deque.pollLast();
            }
            deque.offerLast(current);
            if(end-begin+1==k){
                result.add(deque.peekFirst());
                if (nums[begin] == deque.peekFirst()) {
                    deque.pollFirst();
                }
                begin++;
            }
            end++;
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
