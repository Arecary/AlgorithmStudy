package backtrack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class ReconstructItinerary_332 {

  // 回溯法超时
  private LinkedList<String> res;
  private LinkedList<String> path = new LinkedList<>();

  public List<String> findItinerary(List<List<String>> tickets) {
    Collections.sort(tickets, (a, b) -> a.get(1).compareTo(b.get(1)));
    path.add("JFK");
    boolean[] used = new boolean[tickets.size()];
    backTracking((ArrayList) tickets, used);
    return res;
  }

  public boolean backTracking(ArrayList<List<String>> tickets, boolean[] used) {
    if (path.size() == tickets.size() + 1) { // 考虑到行程是连续的，所以路径的长度比机票的数量多1, 就是顶点比边多1
      res = new LinkedList(path);
      return true;
    }

    for (int i = 0; i < tickets.size(); i++) {
      if (!used[i] && tickets.get(i).get(0).equals(path.getLast())) {
        path.add(tickets.get(i).get(1));
        used[i] = true;

        if (backTracking(tickets, used)) { // 目的是确保一旦找到一条满足条件的路径，就通过递归的方式返回，从而跳出循环和递归调用栈。
          return true;
        }

        used[i] = false;
        path.removeLast();
      }
    }
    return false;
  }
}


// 图论dfs，邻接列表
class Solution {
  public List<String> findItinerary(List<List<String>> tickets) {

    HashMap<String, PriorityQueue<String>> adjList = getList(tickets);

    List<String> path = new ArrayList<>();
    dfs("JFK",adjList,path);
    return path;
  }

  public void dfs(String curr, HashMap<String,PriorityQueue<String>> adjList, List<String> path) {

    PriorityQueue<String> neigh = adjList.get(curr);

    while(neigh!=null && !neigh.isEmpty()) {
      dfs(neigh.remove(),adjList,path);
    }

    path.add(0,curr);
  }

  public HashMap<String,PriorityQueue<String>> getList(List<List<String>> tickets) {
    HashMap<String,PriorityQueue<String>> hm = new HashMap<>();

    for(int i=0;i<tickets.size();i++) {
      String from = tickets.get(i).get(0);
      String to = tickets.get(i).get(1);

      hm.putIfAbsent(from, new PriorityQueue<>());
      hm.get(from).add(to);
    }

    return hm;
  }
}
