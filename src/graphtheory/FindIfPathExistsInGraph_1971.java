package graphtheory;

public class FindIfPathExistsInGraph_1971 {

  public int[] father;
  public boolean validPath(int n, int[][] edges, int source, int destination) {
    father = new int[n];
    init();
    for (int i = 0; i < edges.length; i++) {
      join(edges[i][0], edges[i][1]); // join 方法是在根据提供的 edge 数组构建题目所给的图。
    }
    return isSame(source, destination);
  }

  // 并查集初始化
  public void init() {
    for (int i = 0; i < father.length; i++) {
      father[i] = i;
    }
  }

  // 并查集里寻根的过程
  public int find(int u) {
    if (u == father[u]) {
      return u;
    } else {
      father[u] = find(father[u]);
      return father[u];
    }
  }

  // 判断 u 和 v是否找到同一个根
  public boolean isSame(int u, int v) {
    u = find(u);
    v = find(v);
    return u == v;
  }

  // 将v->u 这条边加入并查集
  public void join(int u, int v) {
    u = find(u); // 寻找u的根
    v = find(v); // 寻找v的根
    if (u == v) return; // 如果发现根相同，则说明在一个集合，不用两个节点相连直接返回

    father[v] = u;
  }


  public static void main(String[] args) {

    FindIfPathExistsInGraph_1971 test = new FindIfPathExistsInGraph_1971();
    int[][] edges = {{0,1},{0,2},{2,1},{3,0}};
    int n = 4;
    int source = 1;
    int destination = 3;
    System.out.println(test.validPath(n, edges, source, destination));

  }


}
