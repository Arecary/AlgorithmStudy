package graphtheory;

public class UnionFind {


  int n = 1005; // n根据题目中节点数量而定，一般比节点数量大一点就好
  int[] father = new int[n]; // Java里的数组

  // 并查集初始化
  public void init() {
    for (int i = 0; i < n; ++i) {
      father[i] = i;
    }
  }

  // 并查集里寻根的过程
  public int find(int u) {
    if (u == father[u]) {
      return u;
    } else {
      father[u] = find(father[u]); // 路径压缩
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
    UnionFind uf = new UnionFind();
    uf.init();

    // 测试用例
    uf.join(1, 2);
    uf.join(3, 4);
    System.out.println(uf.isSame(1, 2)); // true
    System.out.println(uf.isSame(1, 3)); // false
    uf.join(2, 3);
    System.out.println(uf.isSame(1, 4)); // true
  }
}
