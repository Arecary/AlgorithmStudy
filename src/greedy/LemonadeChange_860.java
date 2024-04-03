package greedy;

public class LemonadeChange_860 {


  public boolean lemonadeChange(int[] bills) {
  int five, ten;
  five = ten = 0;
    for (int bill : bills) {
      if (bill == 5) {
        five+=1;
      }else if (bill == 10){
        if (five == 0) {
          return false;
        }else {
          ten+=1;
          five-=1;
        }
      }else if (bill == 20) {
        if (ten!=0 && five!=0) {
          ten-=1;
          five-=1;
        }else if (ten ==0 &&five >= 3){
          five-=3;
        }else {
          return false;
        }
      }
    }
    return true;
  }


}
