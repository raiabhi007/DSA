class UndergroundSystem {
    private class StationData {
        String station;
        int t;
        
        public StationData(String station, int t) {
            this.station = station;
            this.t = t;
        }
    }
    
    private class TripData {
        String trip;
        int tripCount;
        double totalTime;
        
        public TripData(String trip, double totalTime) {
            this.trip = trip;
            this.tripCount = 1;
            this.totalTime = totalTime;
        }
    }
    
    Map<Integer, StationData> checkIn;
    Map<String, TripData> trips;
    
    public UndergroundSystem() {
        checkIn = new HashMap<>();
        trips = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        if (checkIn.containsKey(id)) {
            return;
        }
        StationData checkInData = new StationData(stationName, t);
        checkIn.put(id, checkInData);
    }
    
    public void checkOut(int id, String stationName, int t) {
        if (!checkIn.containsKey(id)) {
            return;
        }
        StationData checkInData = checkIn.get(id);
        int dt = t-checkInData.t;
        String route = checkInData.station+"->"+stationName;
        if (trips.containsKey(route)) {
            TripData tripData = trips.get(route);
            tripData.tripCount += 1;
            tripData.totalTime += dt;
        } else {
            TripData tripData = new TripData(route, dt);
            trips.put(route, tripData);
        }
        checkIn.remove(id);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String route = startStation+"->"+endStation;
        TripData tripData = trips.get(route);
        return tripData.totalTime/tripData.tripCount;
    }
}


/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */