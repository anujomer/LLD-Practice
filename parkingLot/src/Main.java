public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        ParkingLot pk = ParkingLot.getInstance();
        pk.addParkingLevel(new ParkingLevels(1, 10));
        pk.addParkingLevel(new ParkingLevels(2, 10));

        Vehicle car1 = new Car("37838");
        Vehicle car2 = new Car("37839");
        Vehicle bik3 = new Bike("37840");

        pk.display();

        pk.parkVehichle(car1);
        pk.display();

        pk.parkVehichle(car2);
        pk.display();

        pk.parkVehichle(bik3);
        pk.display();

        pk.unparkVehichle(car1);
        pk.display();
    }
}