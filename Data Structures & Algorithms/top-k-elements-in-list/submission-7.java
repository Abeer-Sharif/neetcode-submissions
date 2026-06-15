class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       HashMap<Integer, Integer> map = new HashMap<>();
        //calculate the frequency
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //create a list with the keys
        List<Integer> list = new ArrayList<>(map.keySet());
        //sort [a=2,b=3: map.get(2)-map.get(3)=2-3=-1=>3 should come before 2]
        list.sort((a, b) -> map.get(b) - map.get(a));
        //create an int array for storing the result woth size=k
        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = list.get(i);
        }

        return result;
    
    }
}
