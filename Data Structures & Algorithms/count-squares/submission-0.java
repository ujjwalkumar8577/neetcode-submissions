class CountSquares {
    HashMap<String, Integer> map;

    public CountSquares() {
        map = new HashMap<>();
    }

    public String getKey(int[] point) {
        return point[0] + "_" + point[1];
    }

    public String getKey(int x, int y) {
        return x + "_" + y;
    }
    
    public void add(int[] point) {
        String key = getKey(point);
        map.put(key, map.getOrDefault(key, 0) + 1);
    }
    
    public int count(int[] point) {
        int count = 0;
        for (String diagonalPoint: map.keySet()) {
            String[] tmp = diagonalPoint.split("_");
            int x = Integer.parseInt(tmp[0]);
            int y = Integer.parseInt(tmp[1]);
            int xDiff = Math.abs(x - point[0]);
            int yDiff = Math.abs(y - point[1]);
            if (xDiff == 0 || yDiff == 0 || xDiff != yDiff) {
                continue;
            }
            String point1 = getKey(point[0], y);
            String point2 = getKey(x, point[1]);
            if (map.containsKey(point1) && map.containsKey(point2)) {
                count += (map.get(diagonalPoint) * map.get(point1) * map.get(point2));
            }
        }
        return count;
    }
}
