package solutions;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 973. 最接近原点的 K 个点
我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。

（这里，平面上两点之间的距离是欧几里德距离。）

你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
 */
public class S0973 {
    class Solution {
        public int[][] kClosest(int[][] points, int K) {
            if(K==points.length) return points;
            if(K==0) return new int[0][0];
            double[] dis = new double[points.length];
            int[] ind = new int[points.length];
            for(int i = 0; i < dis.length; i++){
                dis[i] = calculateDis(points[i]);
                ind[i] = i;
            }
    
            return quickSort(dis, points, ind, 0, dis.length -1, K);
        }
    
        public int[][] quickSort(double[] dis, int[][] points, int[] ind, int left, int right, int K) {
            int i,j;
            double tmp = dis[left];
            i = left;
            j = right;
            while(i!=j) {
                while(i<j && dis[j]>=tmp) {
                    j--;
                }
                while(i<j && dis[i]<=tmp) {
                    i++;
                }
                System.out.println(i);
                if(i<j){
                    double t = dis[i];
                    dis[i] = dis[j];
                    dis[j] = t;
                    int y = ind[i];
                    ind[i] = ind[j];
                    ind[j] = y;
                }
            }
            dis[left] = dis[i];
            dis[i] = tmp;
            int tmp_ind = ind[left];
            ind[left] = ind[i];
            ind[i] = tmp_ind;
            if(K==i) {
                int[][] ans = new int[K][2];
                for(int k = 0; k < K; k++){
                    ans[k] = points[ind[k]];
                }
                return ans;
            } else if(K<i) {
                return quickSort(dis, points, ind, left, i-1, K);
            } else {
                return quickSort(dis, points, ind, i+1, right, K);
            }
        }
    
        public static double calculateDis(int[] point){
            return Math.sqrt(Math.pow(point[0]-0,2) + Math.pow(point[1]-0,2));
        }

        // 大顶堆的实现
        public int[][] kClosest(int[][] points, int K) {
            // 默认是小根堆，实现大根堆需要重写一下比较器。
            PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);      
            for (int[] point: points) {
                if (pq.size() < K) { // 如果堆中不足 K 个，直接将当前 point 加入即可
                    pq.offer(point);
                } else if (pq.comparator().compare(point, pq.peek()) > 0) { // 否则，判断当前点的距离是否小于堆中的最大距离，若是，则将堆中最大距离poll出，将当前点加入堆中。
                    pq.poll();
                    pq.offer(point);
                }
            }
    
            // 返回堆中的元素
            int[][] res = new int[pq.size()][2];
            int idx = 0;
            for (int[] point: pq) {
                res[idx++] = point;
            }
            return res;
        }
    }
}