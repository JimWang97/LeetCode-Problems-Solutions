package solutions;

/**
 * 685. Redundant Connection II
难度
困难

200





In this problem, a rooted tree is a directed graph such that, there is exactly one node (the root) for which all other nodes are descendants of this node, plus every node has exactly one parent, except for the root node which has no parents.

The given input is a directed graph that started as a rooted tree with N nodes (with distinct values 1, 2, ..., N), with one additional directed edge added. The added edge has two different vertices chosen from 1 to N, and was not an edge that already existed.

The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] that represents a directed edge connecting nodes u and v, where u is a parent of child v.

Return an edge that can be removed so that the resulting graph is a rooted tree of N nodes. If there are multiple answers, return the answer that occurs last in the given 2D-array.

Example 1:

Input: [[1,2], [1,3], [2,3]]
Output: [2,3]
Explanation: The given directed graph will be like this:
  1
 / \
v   v
2-->3
分析
当向一棵有向树插入一条额外的边 u \rightarrow vu→v 时：

一定会产生一个无向环
另外，如果 vv 并非树的根节点，则 vv 会有两个不同的父节点。此时，我们称在节点 vv 上产生了「冲突」，相关的两条边被称为「冲突边」。
由于我们仅插入了一条边，因此环与「冲突」的个数最多都只有一个。如果仅出现了环，我们需要将这个环「拆掉」；如果两者都出现，我们必须找到一条特殊的边，使得在「拆掉」环的同时，还能够将「冲突」解决。

如果出现了「冲突」，根据两条「冲突边」出现的位置，可以分成以下几种情况：

两条边都在环外：不可能出现，否则不可能通过去掉一条边的方式，同时解决「环」和「冲突」。
一条边在环外，一条边在环内：需要去掉在环内的那条边。
两条边都在环内：去除其中一条即可。根据题意，我们要去除后出现的那条。
否则，如果只有「环」而没有「冲突」，则去除环中任意一条边即可。

判断一条特定的边是否在环内，是相对比较困难的事情。因此，我们采取一种比较巧的策略：如果发现了「冲突」边，就仅仅将后出现的那条记录下来，而不加到图中。通过这种方式，我们能够得到一张新图。如果原图中存在「冲突边」：

对于一条边在环内，一条边在环外的情形：如果环内「冲突边」先出现，则新图中依然有环；否则，如果环外「冲突边」先出现，则由于随后不会将第二条在环内的「冲突边」加入到图中，因此新图中没有环。
对于两条边都在环内：新图中一定没有环。
这样，不难发现：如果新图中有环，则要去除的是先出现的那条；否则，新图中如果没有环，则要去出的是后出现的那条。

算法
通过上面的分析，其实本题要解决的只有两个关键点：

判断是否存在环：根据并查集，能够找到环中最后出现的那条边。
判断是否存在「冲突」：判断是否有某个顶点 vv 有两条不同的入边。

作者：Arsenal-591
链接：https://leetcode-cn.com/problems/redundant-connection-ii/solution/xi-zhi-jie-du-yi-wen-rang-ni-zhen-zheng-du-dong-be/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class S0685 {
  int[] result = new int[2];
  int doubleRoot = 0;
  int[] hadRoot;
  int[][] rootResult = new int[2][2];

  public int[] findRedundantDirectedConnection(int[][] edges) {
      hadRoot = new int[edges.length+1];  // 并查集
      int[] father = new int[edges.length+1]; // father[i]表示i节点的父节点是谁
      //每个人都是独立的掌门，即自己就是掌门人
      for(int i=0;i<father.length;i++){
          father[i] = i;
      }

      for(int[] edge : edges){
          //计算某个结点的入度
          hadRoot[edge[1]]++;
          //如果某个结点入度是2，说明不满足条件：其他节点都是根结点的后继
          //记录下来,此时记录的是第二次出现这个值的数组了
          if(hadRoot[edge[1]] == 2){ // 出现冲突边时，并没有把他加入到图里。
              doubleRoot = edge[1];
              rootResult[1] = edge; // 这里是出现冲突时，也就是说是第二条冲突边
          }else{
              //进行帮派联合
              union(father,edge[1],edge[0]); //找最上面的父节点，如果相同，说明此时会出现环
          }
      }

      //说明存在入度为2的情况
      if(doubleRoot != 0){
          //找到入度为2的点
          for(int[] edge:edges){
              //找到第一次出现这个入度的值
              if(edge[1] == doubleRoot){
                  rootResult[0] = edge; // 第一条冲突边
                  break;
              }
          }
          int root = 0;
          for(int i=1;i<father.length;i++){
              if(root == 0){
                  //找到i的掌门
                  root = findXFather(father,i);
              }
              if(root != findXFather(father,i))
                  return rootResult[0];
          }
          return rootResult[1];
      }
      return result;
  }

  //找到它的掌门人
  public int findXFather(int[] father,int x){
      while(father[x] != x){
          //路径压缩
          father[x] = father[father[x]];
          x = father[x];
      }
      return x;
  }

  //帮派联合
  public void union(int[] father,int x,int y){
      int xFather = findXFather(father,x);
      int yFather = findXFather(father,y);
      //如果两者的掌门人都不同，说明可以合并
      //否则说明它们两者是连通的
      if(xFather != yFather){
          father[xFather] = yFather;
      }else{
          //说明两者有连通性 如果有环，删除最后一条边就行了
          result[0] = y;
          result[1] = x;
      }
  }
}