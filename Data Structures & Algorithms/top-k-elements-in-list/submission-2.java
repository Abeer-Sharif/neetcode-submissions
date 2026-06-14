class Solution {
    public int[] topKFrequent(int[] nums, int k) {


        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> buckets = new ArrayList<>(map.keySet());
        buckets.sort((a, b) -> map.get(b) - map.get(a));
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(buckets.get(i));
        }
        System.out.println(result);
    }
}
