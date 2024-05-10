package graphtheory;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget_797 {


  /*
  Input: graph = [[1,2],[3],[3],[]]
  Output: [[0,1,3],[0,2,3]]
  Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
   */
  public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    if (graph == null || graph.length == 0 || graph[0].length == 0) {
      return new ArrayList<>();
    }

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    path.add(0);
    dfs(graph, 0, result, path);
    return result;
  }

  private void dfs(int[][] graph, int start, List<List<Integer>> result, List<Integer> path) {
    if (start == graph.length - 1) {
      result.add(new ArrayList<>(path));
    }

    for (int i = 0; i < graph[start].length; i++) {

      path.add(graph[start][i]);
      dfs(graph, graph[start][i], result, path);
      path.remove(path.size() - 1);
    }

  }

}
