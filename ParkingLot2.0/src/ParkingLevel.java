import java.util.ArrayList;
import java.util.List;

public class ParkingLevel {
    private Integer floor;
    private List<ParkingSlot> parkingSlots;

    public ParkingLevel(Integer floor, int slots) {
        this.floor = floor;
        parkingSlots = new ArrayList<ParkingSlot>(slots);

        double bike = 0.60;
        double car = 0.40;

        for(int i = 0; i < bike*slots ; i++){
            parkingSlots.add(new ParkingSlot(i,VehicleType.SMALL));
        }
        for(int i = (int)(bike*slots); i < slots ; i++){
            parkingSlots.add(new ParkingSlot(i,VehicleType.MEDIUM));
        }

    }

    public synchronized boolean park(Vehicle vehicle){
        for(ParkingSlot parkingSlot : parkingSlots){
            if(!parkingSlot.isOccupied() && vehicle.getVehicleType().equals(parkingSlot.getSize())){
                parkingSlot.park(vehicle);
                return true;
            }
        }
        return false;
    }

    public synchronized boolean unpark(Vehicle vehicle){
        for(ParkingSlot parkingSlot : parkingSlots){
            if(parkingSlot.isOccupied() && parkingSlot.getVehicle().equals(vehicle)){
                parkingSlot.unpark(vehicle);
                return true;
            }
        }
        return false;
    }

    public void displayParkingSlots(){
        for(ParkingSlot pk : parkingSlots){
            //if(pk.isOccupied()){
//                System.out.println("ParkLevel: " + parkingLevel + " SlotNumber: " + pk.getSlotNumber());
                System.out.println("Spot " + pk.getSlotNumber() + ": " + (!pk.isOccupied() ? "Available For"  : "Occupied By ")+" "+pk.getSize());
            //}
        }
        System.out.println("****************");
    }

}
