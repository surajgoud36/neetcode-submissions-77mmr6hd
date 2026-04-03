/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int l=1,high=n;
        while(l<=high){
            int mid=l + (high - l) / 2;
            System.out.println("mid= "+mid);
            int status=guess(mid);
            System.out.println(status);
            if(status==0)
                return mid;
            else if(status>0)
                l=mid+1;
            else
                high=mid-1;
        }
        return 0;
    }
}