class Solution {
    public int maxProfit(int[] arr) {
      int n = arr.length;
      int[] l=new int[n];
      int[] r=new int[n];
      l[0]= arr[0];
      for(int i=1;i<n;i++){
        l[i]= Math.min(arr[i],l[i-1]);
      }
      r[n-1]=arr[n-1];
      for(int i=n-2;i>=0;i--){
        r[i]=Math.max(arr[i],r[i+1]);
      }
      int profit =0;
      for(int i=0;i<n;i++){
        profit = Math.max(profit, r[i]-l[i]);
      }
      return profit;
    }
}
