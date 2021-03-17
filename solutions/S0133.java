package solutions;

import java.util.*;

/**
 * 133. 克隆图
 * 给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
 *
 * 图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
 *
 * class Node {
 *     public int val;
 *     public List<Node> neighbors;
 * }
 *
 *
 * 测试用例格式：
 *
 * 简单起见，每个节点的值都和它的索引相同。例如，第一个节点值为 1（val = 1），第二个节点值为 2（val = 2），以此类推。该图在测试用例中使用邻接列表表示。
 *
 * 邻接列表 是用于表示有限图的无序列表的集合。每个列表都描述了图中节点的邻居集。
 *
 * 给定节点将始终是图中的第一个节点（值为 1）。你必须将 给定节点的拷贝 作为对克隆图的引用返回。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：adjList = [[2,4],[1,3],[2,4],[1,3]]
 * 输出：[[2,4],[1,3],[2,4],[1,3]]
 * 解释：
 * 图中有 4 个节点。
 * 节点 1 的值是 1，它有两个邻居：节点 2 和 4 。
 * 节点 2 的值是 2，它有两个邻居：节点 1 和 3 。
 * 节点 3 的值是 3，它有两个邻居：节点 2 和 4 。
 * 节点 4 的值是 4，它有两个邻居：节点 1 和 3 。
 */
public class S0133 {
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    class Solution {
        public Node cloneGraph(Node node) {
            if(node==null) {
                return null;
            }

            Node root = new Node(node.val);
            Map<Integer, Node> map = new HashMap<>();
            ArrayList<Node> visited = new ArrayList<>();
            map.put(root.val, root);

            Queue<Node> q1 = new LinkedList<>();
            q1.add(node);
            while(!q1.isEmpty()) {
                Node tmp = q1.poll();
                if(!visited.contains(tmp)) {
                    visited.add(tmp);
                    ArrayList<Node> new_neighbors = new ArrayList<>();
                    for(Node tn : tmp.neighbors) {
                        if(map.containsKey(tn.val)) {
                            new_neighbors.add(map.get(tn.val));
                        } else {
                            Node n = new Node(tn.val);
                            new_neighbors.add(n);
                            map.put(n.val, n);
                        }
                        q1.add(tn);
                    }
                    if(map.containsKey(tmp.val)) {
                        map.get(tmp.val).neighbors = new_neighbors;
                    } else {
                        Node ne = new Node(tmp.val, new_neighbors);
                        map.put(tmp.val, ne);
                    }
                }

            }
            return root;
        }
    }
}
