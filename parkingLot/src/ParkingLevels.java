import java.util.ArrayList;
import java.util.List;

public class ParkingLevels {
    private int parkingLevel;
    private List<ParkingSlot> parkingSlots;

    public ParkingLevels(int parkingLevel, int slots) {
        this.parkingLevel = parkingLevel;
        parkingSlots = new ArrayList<ParkingSlot>(slots);

        double small = 0.50;
        double medium= 0.40;
        double large= 0.10;

        int bikes = (int)(small*slots);
        int cars = (int)(medium*slots);


        for(int i = 1
            ; i <= bikes; i++){
            parkingSlots.add(new ParkingSlot(i,VehicleTypeEnum.SMALL));
        }
        for(int i = bikes + 1; i <= bikes + cars; i++){
            parkingSlots.add(new ParkingSlot(i,VehicleTypeEnum.MEDIUM));
        }
        for(int i = bikes + cars + 1; i <= slots; i++){
            parkingSlots.add(new ParkingSlot(i,VehicleTypeEnum.LARGE));
        }
    }

    public boolean parkVehicle(Vehicle vehicle){
        for(ParkingSlot pk : parkingSlots){
            if(pk.isAvailable() && pk.getSize() == vehicle.getType()){
                pk.park(vehicle);
                return true;
            }
        }
        return false;
    }

    public boolean unparkVehicle(Vehicle vehicle){
        for(ParkingSlot pk : parkingSlots){
           if(vehicle.getType() == pk.getSize() && pk.getParkedVehicle().equals(vehicle)){
               pk.unpark();
               return true;
           }
        }
        return false;
    }

    public void displayParkingSlots(){
        for(ParkingSlot pk : parkingSlots){
            if(pk.isAvailable()){
//                System.out.println("ParkLevel: " + parkingLevel + " SlotNumber: " + pk.getSlotNumber());
                System.out.println("Spot " + pk.getSlotNumber() + ": " + (pk.isAvailable() ? "Available For"  : "Occupied By ")+" "+pk.getSize());
            }
        }
        System.out.println("*****");
    }

}
