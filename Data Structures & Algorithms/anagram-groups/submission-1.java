class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {

            int[] freq = new int[26];

            // Count characters
            for (char c : word.toCharArray()) {
                freq[c - 'a']++;
            }

            // Convert frequency to string key
            String key = Arrays.toString(freq);

            // Add to map
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(word);
        }

        return new ArrayList<>(map.values());
    }
}
