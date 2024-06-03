package graphtheory;

public class RedundantConnection_684 {

  public int[] father;

  public int[] findRedundantConnection(int[][] edges) {
    father = new int[edges.length + 1];
    init();
    for (int i = 0; i < father.length; i++)  {
      int node1 = edges[i][0];
      int node2 = edges[i][1];
      if (isSame(node1, node2)) {
        return edges[i];
      }

      union(node1, node2);
    }
    return null;
  }

  // 并查集
  public void init(){
    for (int i = 0; i < father.length; i++) {
      father[i] = i;
    }
  }

  public int find(int x){
    if (father[x] == x) {
      return x;
    }

    father[x] = find(father[x]);
    return father[x];
  }

  public void union(int v, int u){
    int vFather = find(v);
    int uFather = find(u);
    if (vFather == uFather ){
      return;
    }

    father[uFather] = vFather;

  }

  public boolean isSame(int v, int u){
    int vFather = find(v);
    int uFather = find(u);
    return vFather == uFather;
  }


}
