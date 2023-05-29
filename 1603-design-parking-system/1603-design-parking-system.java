class ParkingSystem {
    int[] space = new int[3];
    public ParkingSystem(int big, int medium, int small) {
        this.space = new int[] {big,medium,small};
    }
    
    public boolean addCar(int car) {
        if(space[car-1]>0){
            space[car-1]--;
            return true;
        }
        return false;
    }
}
/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */