class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Stack<Double> fleet = new Stack<>();
        ArrayList<Car> cars = new ArrayList<>();
        for (int i=0; i<n; i++) {
            cars.add(new Car(position[i], speed[i]));
        }
        Collections.sort(cars);
        for (int i=n-1; i>=0; i--) {
            Car car = cars.get(i);
            double time = 1.0 * (target - car.position) / car.speed;
            if (fleet.isEmpty() || time > fleet.peek()) {
                fleet.add(time);
            }
        }
        return fleet.size();
    }
}

class Car implements Comparable<Car> {
    int position;
    int speed;

    public Car(int p, int s) {
        position = p;
        speed = s;
    }

    @Override
    public int compareTo(Car c) {
        return this.position - c.position;
    }

    @Override
    public String toString() {
        return "p: " + position + " s: " + speed;
    }
}
