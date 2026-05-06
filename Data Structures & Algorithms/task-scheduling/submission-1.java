class Solution {
    public int leastInterval(char[] tasks, int n) {
        int freq[] = new int[26];
        for (char task: tasks) {
            freq[task - 'A']++;
        }
        Arrays.sort(freq);
        int max = freq[25];
        int count = 0;
        for (int i=25; i>=0; i--) {
            if (freq[i] == max) {
                count++;
            } else {
                break;
            }
        }
        return Math.max((n+1)*(max-1) + count, tasks.length);
    }
}

// 10 - X 1 2 X 1 2 X 1 2 X
// 07 - X 1 2 X 1 2 X
// 04 - X 1 2 X
// 01 - X

// (n+1) * (f-1) + 1
// 3 * (f - 1) + 1


