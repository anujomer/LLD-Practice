import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private List<ParkingLevel> parkingLevels;
    private static ParkingLot parkingLot;
    private ParkingLot() {
        parkingLevels = new ArrayList<>();
    }

    public void AddLevels(ParkingLevel parkingLevel) {
        parkingLevels.add(parkingLevel);
    }

    public synchronized static ParkingLot getInstance(){
        if(parkingLot == null){
            parkingLot = new ParkingLot();
        }
        return parkingLot;
    }

    public boolean park(Vehicle vehicle){
        for(ParkingLevel parkingLevel : parkingLevels){
           if(parkingLevel.park(vehicle)){
               return true;
           }
        }
        return false;
    }

    public boolean unpark(Vehicle vehicle){
        for(ParkingLevel parkingLevel : parkingLevels){
            if(parkingLevel.unpark(vehicle)){
                return true;
            }
        }
        return false;
    }

    public void printParkingLot(){
        for(ParkingLevel parkingLevel : parkingLevels){
            parkingLevel.displayParkingSlots();
        }
    }

}
