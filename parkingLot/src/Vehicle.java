public abstract class Vehicle {
    private String licensePlate;
    private VehicleTypeEnum vehicleType;
    public Vehicle(String licensePlate, VehicleTypeEnum vehicleType) {
        this.licensePlate = licensePlate;
        this.vehicleType = vehicleType;
    };
    public VehicleTypeEnum getType() {
        return vehicleType;
    }
}
