class ParkingSystem {
    int[] cap = new int[4];
    int[] parkedCar = new int[4];
    public ParkingSystem(int big, int medium, int small) {
        cap[1] = big;
        cap[2] = medium;
        cap[3] = small;
    }
    
    public boolean addCar(int carType) {
        if(parkedCar[carType]==cap[carType]) return false;
        parkedCar[carType]++;
        return true;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */