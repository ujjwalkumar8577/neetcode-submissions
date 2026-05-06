class Solution {
    HashMap<Character, ArrayList<Character>> map;
    public List<String> letterCombinations(String digits) {
        if (digits.equals("")) {
            return new ArrayList<>();
        }
        map = new HashMap<>();
        map.put('2', new ArrayList<>(Arrays.asList('a', 'b', 'c')));
        map.put('3', new ArrayList<>(Arrays.asList('d', 'e', 'f')));
        map.put('4', new ArrayList<>(Arrays.asList('g', 'h', 'i')));
        map.put('5', new ArrayList<>(Arrays.asList('j', 'k', 'l')));
        map.put('6', new ArrayList<>(Arrays.asList('m', 'n', 'o')));
        map.put('7', new ArrayList<>(Arrays.asList('p', 'q', 'r', 's')));
        map.put('8', new ArrayList<>(Arrays.asList('t', 'u', 'v')));
        map.put('9', new ArrayList<>(Arrays.asList('w', 'x', 'y', 'z')));
        List<String> res = new ArrayList<>();
        combinationHelper(digits, "", 0, res);
        return res;
    }

    public void combinationHelper(String digits, String tmp, int i, List<String> res) {
        if (i >= digits.length()) {
            res.add(tmp);
            return;
        }
        for (char c: map.get(digits.charAt(i))) {
            combinationHelper(digits, tmp + c, i+1, res);
        }
    }
}
