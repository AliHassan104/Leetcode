package _2125NumberofLaserBeamsInABank;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static int numberOfBeams(String[] bank) {

        int numberOfBeam = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < bank.length; i++) {
            int temp = 0;
            for (int j = 0; j < bank[i].length(); j++) {
                if (bank[i].charAt(j) == '1'){
                    temp ++;
                }
            }
            if (temp != 0){
                list.add(temp);
            }

        }
        System.out.println(list);

        for (int i = 0; i < list.size()-1; i++) {
            numberOfBeam += (list.get(i) * list.get(i+1) );
        }

        return numberOfBeam;
    }

    public static int numberOfBeamsChatGPT(String[] bank) {
        int prevDevices = 0; // number of devices in the previous row with devices
        int totalBeams = 0;

        for (String row : bank) {
            int currentDevices = countDevices(row);
            if (currentDevices > 0) {
                totalBeams += prevDevices * currentDevices;
                prevDevices = currentDevices;
            }
        }

        return totalBeams;
    }

    private static int countDevices(String row) {
        int count = 0;
        for (char c : row.toCharArray()) {
            if (c == '1') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numberOfBeams(new String[]{"011001", "000000", "010100", "001000"}));
    }
}
/*

2125. Number of Laser Beams in a Bank
        Medium
Topics
        Companies
Hint
Anti-theft security devices are activated inside a bank. You are given a 0-indexed binary string array bank representing the floor plan of the bank, which is an m x n 2D matrix. bank[i] represents the ith row, consisting of '0's and '1's. '0' means the cell is empty, while'1' means the cell has a security device.

There is one laser beam between any two security devices if both conditions are met:

The two devices are located on two different rows: r1 and r2, where r1 < r2.
For each row i where r1 < i < r2, there are no security devices in the ith row.
Laser beams are independent, i.e., one beam does not interfere nor join with another.

Return the total number of laser beams in the bank.



Example 1:


Input: bank = ["011001","000000","010100","001000"]
Output: 8
Explanation: Between each of the following device pairs, there is one beam. In total, there are 8 beams:
        * bank[0][1] -- bank[2][1]
        * bank[0][1] -- bank[2][3]
        * bank[0][2] -- bank[2][1]
        * bank[0][2] -- bank[2][3]
        * bank[0][5] -- bank[2][1]
        * bank[0][5] -- bank[2][3]
        * bank[2][1] -- bank[3][2]
        * bank[2][3] -- bank[3][2]
Note that there is no beam between any device on the 0th row with any on the 3rd row.
This is because the 2nd row contains security devices, which breaks the second condition.
        Example 2:


Input: bank = ["000","111","000"]
Output: 0
Explanation: There does not exist two devices located on two different rows.


        Constraints:

m == bank.length
n == bank[i].length
1 <= m, n <= 500
bank[i][j] is either '0' or '1'.*/
