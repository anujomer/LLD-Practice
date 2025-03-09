public class Main {
    public static void main(String[] args) {
       ParkingLot parkingLot = ParkingLot.getInstance();
       parkingLot.AddLevels(new ParkingLevel(1,1));
        //parkingLot.AddLevels(new ParkingLevel(2,10));

        Car c1 = new Car("ghytfv");
        Car c2 = new Car("gfghjnbg");
        Bike bike = new Bike("ghykjhyg");
        parkingLot.printParkingLot();
        Thread thread1 = new Thread(()->{
            boolean v =  parkingLot.park(c1);
            System.out.println("c1" + v);
        });

        Thread thread2 = new Thread(()->{
           boolean v =  parkingLot.park(c2);
           System.out.println("c2" + v);
        });
        thread1.start();
        parkingLot.printParkingLot();
        thread2.start();
        try{
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        parkingLot.park(bike);
        parkingLot.unpark(c2);
        System.out.println("hjj");
        parkingLot.printParkingLot();

    }
}