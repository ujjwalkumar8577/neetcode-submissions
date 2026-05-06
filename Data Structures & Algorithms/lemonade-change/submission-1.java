class Solution {
    public boolean lemonadeChange(int[] bills) {
        int count5 = 0;
        int count10 = 0;
        int count20 = 0;
        for (int e: bills) {
            if (e == 5) {
                count5++;
            } else if (e == 10) {
                if (count5 <= 0) {
                    return false;
                }
                count5--;
                count10++;
            } else {
                if (count10 > 0 && count5 > 0) {
                    count5--;
                    count10--;
                    count20++;
                } else if ((count5 / 3) > 0) {
                    count5 -= 3;
                    count20++;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    // public boolean lemonadeChange(int[] bills) {
    //     int count5 = 0;
    //     int count10 = 0;
    //     int count20 = 0;
    //     for (int e: bills) {
    //         if (e == 5) {
    //             count5++;
    //         } else if (e == 10) {
    //             count10++;
    //         } else {
    //             count20++;
    //         }
    //     }
    //     if (count10 > count5) {
    //         return false;
    //     }
    //     count5 -= count10;
    //     int tmp = count10 + (count5 / 2);
    //     System.out.println(count20);
    //     System.out.println(count10 + (count5 / 2));
    //     return tmp >= count20; 
    // }
}