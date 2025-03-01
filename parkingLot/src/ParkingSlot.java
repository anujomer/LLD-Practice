public class ParkingSlot {
    int slotNumber;
    Vehicle parkedVehicle;
    VehicleTypeEnum size;

    ParkingSlot(int slotNumber, VehicleTypeEnum size) {
        this.slotNumber = slotNumber;
        this.size = size;
    }

    public boolean isAvailable(){
        if(parkedVehicle == null){
            return true;
        }else{
            return false;
        }
    }

    public void park(Vehicle vehicle) {
        if(isAvailable() && size == vehicle.getType()){
            this.parkedVehicle = vehicle;
        }
        else{
            throw new IllegalArgumentException("Invalid vehicle type or spot already occupied.");
        }

    }

    public void unpark() {
        parkedVehicle = null;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public VehicleTypeEnum getSize() {
        return size;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }
}
