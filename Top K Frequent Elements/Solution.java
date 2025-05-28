import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 1. Contar frequências
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        // 2. Criar buckets por frequência
        @SuppressWarnings("unchecked")
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(key);
        }
        
        // 3. Percorrer buckets de trás para frente para pegar os mais frequentes
        List<Integer> result = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && result.size() < k; i--) {
            if (buckets[i] != null) {
                result.addAll(buckets[i]);
            }
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
}




