package leetcode1094;

import java.util.TreeMap;

public class CheckIfAbleToCarPool {
	// Greedy solution, O(n) time and O(t) space where t is the max travel
    public boolean carPooling(int[][] trips, int capacity) {
    	// Won't work unless total trip is 1000
        int[] totalTrips = new int[1001];
        
        // update as needed
        for(int[] trip : trips){
            totalTrips[trip[1]] += trip[0];
            totalTrips[trip[2]] -= trip[0];
        }
        
        // if negative, not enough capacity so return false
        for(int i = 0; i < totalTrips.length && capacity >= 0; i++){
            capacity -= totalTrips[i];
        }
        
        return capacity >= 0;
    }
    
    // O(nlogn) solution since used treemap to sort values, O(m) space for how many trips given
    public boolean carPooling2(int[][] trips, int capacity) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for(int[] trip : trips){
            map.put(trip[1], map.getOrDefault(trip[1], 0) + trip[0]);
            map.put(trip[2], map.getOrDefault(trip[2], 0) - trip[0]);
        }
        
        // once capacity is negative, return false
        for(int value : map.values()){
            capacity -= value;
            
            if(capacity < 0){
                return false;
            }
        }
        
        
        return true;
    }
}
