import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private List<ParkingLevels> parkingLevelsList;
    private static ParkingLot parkingLotObj;
    private ParkingLot(){
        parkingLevelsList = new ArrayList<ParkingLevels>();
    }

    public static ParkingLot getInstance(){
        if(parkingLotObj == null){
            parkingLotObj = new ParkingLot();
        }
        return parkingLotObj;
    }

    public void addParkingLevel(ParkingLevels parkingLevel){
        parkingLevelsList.add(parkingLevel);
    }

    public boolean parkVehichle(Vehicle vehicle){
        for(ParkingLevels parkingLevel : parkingLevelsList){
            if(parkingLevel.parkVehicle(vehicle)){
                return true;
            }
        }
        return false;
    }

    public boolean unparkVehichle(Vehicle vehicle){
        for(ParkingLevels parkingLevel : parkingLevelsList){
            if(parkingLevel.unparkVehicle(vehicle)){
                return true;
            }
        }
        return false;
    }

    public void display(){
        for(ParkingLevels parkingLevel : parkingLevelsList){
            parkingLevel.displayParkingSlots();
        }
    }
}
