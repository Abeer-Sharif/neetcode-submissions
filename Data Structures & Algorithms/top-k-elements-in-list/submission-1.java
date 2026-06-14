class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap <Integer,Integer> map = new HashMap<>();
        //count the number of times each num occured
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        List<Integer>[] buckets = new ArrayList[nums.length+1];
        map.forEach((num,freq)->{
            if(buckets[freq]==null) buckets[freq]=new ArrayList<>();
            buckets[freq].add(num);
        });
        List<Integer> result = new ArrayList<>();
        for(int i=buckets.length-1;i>=0 && result.size()<k ;i--){
            if(buckets[i]!=null){
                result.addAll(buckets[i]);
            }
        }
        return result.stream().mapToInt(val->val).toArray();
    }
}
