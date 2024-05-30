package graphtheory;

import java.util.ArrayList;
import java.util.List;

public class KeysAndRooms_841 {

  public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    List<Boolean> visited = new ArrayList<Boolean>(){{
      for(int i = 0 ; i < rooms.size(); i++){
        add(false);
      }
    }};
    dfs(0, rooms, visited);
    //检查是否都访问到了
    for (boolean flag : visited) {
      if (!flag) {
        return false;
      }
    }
    return true;
  }

  private void dfs(int key, List<List<Integer>>  rooms, List<Boolean> visited) {
    if (visited.get(key)) {
      return;
    }
    visited.set(key, true);
    for (int k : rooms.get(key)) {
      // 深度优先搜索遍历
      dfs(k, rooms, visited);
    }
  }



}
