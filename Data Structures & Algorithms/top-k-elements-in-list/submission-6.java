class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap <Integer,Integer> map = new HashMap<>();
        //count the number of times each num occured
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        //create a list to store the number of times each num occured
        List<Integer>[] buckets = new ArrayList[nums.length+1];
        map.forEach((num,freq)->{
            //for num=2: freq=2 ->if buckets[2]==null then create bucket[2]={}
            if(buckets[freq]==null) buckets[freq]=new ArrayList<>();
            //add that num to the list
            buckets[freq].add(num);
        });
        //create a list for result
        List<Integer> result = new ArrayList<>();
        // traverse backwards
        for(int i=buckets.length-1;i>=0 && result.size()<k ;i--){
            if(buckets[i]!=null){
                //If this frequency bucket has numbers, dump all of them into the result list.
                result.addAll(buckets[i]);
            }

        }
        //convert to int type 
        return result.stream().mapToInt(val->val).toArray();
    }
}
