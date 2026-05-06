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
        int l = 1;
        int r = n;
        while(guess(l + (r-l)/2) != 0) {
            int mid = l + (r-l)/2;
            int key = guess(mid);
            System.out.println(mid + " " + key);
            if (key == 1) {
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        return l + (r-l)/2;
    }
}