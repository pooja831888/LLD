//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ParkingLot parkingLot = new ParkingLot("City Center Parking", 2, 5, 3, 2);

        // Create vehicles
        Vehicle car1 = new Car("KA-01-1234");
        Vehicle bike1 = new Bike("KA-02-5678");
        Vehicle truck1 = new Truck("KA-03-9999");


        // Park vehicles
        Ticket ticket1 = parkingLot.parkVehicle(car1);
        Ticket ticket2 = parkingLot.parkVehicle(bike1);
        Ticket ticket3 = parkingLot.parkVehicle(truck1);

        // Display available slots after parking
        parkingLot.displayAvailableSlots();

        // Unpark and calculate fee
        parkingLot.unparkVehicle(ticket1.getTicketId());
        parkingLot.unparkVehicle(ticket2.getTicketId());
    }
}