public class ParkingSlot {

    private int slotNumber;
    private Vehicle vehicle;
    private VehicleType size;

    public ParkingSlot(int slotNumber, VehicleType size) {
        this.slotNumber = slotNumber;
        this.size = size;
    }

    public boolean isOccupied() {
        return vehicle != null;
    }

    public synchronized void park(Vehicle vehicle) {
        if(!isOccupied() && vehicle.getVehicleType() == size){
            this.vehicle = vehicle;
        }else{
            throw new IllegalArgumentException("Slot " + slotNumber + " is occupied");
        }
    }

    public synchronized void unpark(Vehicle vehicle) {
        this.vehicle = null;
    }

    public VehicleType getSize() {
        return size;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getSlotNumber() {
        return slotNumber;
    }
}
