
import java.math.*;
class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
           
               return (z == 0 || x + y >= z && z%gcd(x,y) == 0);

}
 public int gcd(int a,int b)
 {
      if (a == 0) 
          return b; 
        if (b == 0) 
          return a; 
       
        if (a == b) 
            return a; 
        
        if (a > b) 
            return gcd(a-b, b); 
        return gcd(a, b-a); 
 }
}