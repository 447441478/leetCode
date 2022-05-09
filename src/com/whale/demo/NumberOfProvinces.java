package com.whale.demo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/number-of-provinces/
 */
public class NumberOfProvinces {
    /**
     * 1 0 1 0 1
     *   1 0 0 0
     *     1 1 0
     *       1 0
     *         1
     * ====================
     * 1 0 0 0 0
     *   1 0 1 0
     *     1 0 0
     *       1 0
     *         1
     */
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        Queue<Integer> queue = new LinkedList<>();
        int result = 0;
        for (int i = 0; i < n; i++) {
            if(isConnected[i][i] == 1){
                queue.add(i);
                isConnected[i][i] = 0;
            }else {
                continue;
            }
            searchAdjacent(isConnected, n, queue, i);
            while (!queue.isEmpty()){
                int k = queue.poll();
                searchAdjacent(isConnected, n, queue, k);
            }
            result++;
        }
        return result;
    }

    private void searchAdjacent(int[][] isConnected, int n, Queue<Integer> queue, Integer i) {
        for(int j = 0; j < i; j++){
            if(isConnected[i][j] == 1){
                if(isConnected[j][j] == 1){
                    queue.add(j);
                    isConnected[j][j] = 0;
                }
                isConnected[i][j] = 0;
            }
        }
        for(int j = i+1; j < n; j++){
            if(isConnected[j][i] == 1){
                if(isConnected[j][j] == 1){
                    queue.add(j);
                    isConnected[j][j] = 0;
                }
                isConnected[j][i] = 0;
            }
        }
    }

}
