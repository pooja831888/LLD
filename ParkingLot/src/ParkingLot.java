import java.util.*;

public class ParkingLot {
    private String parkingLotName;
    private List<ParkingFloor> floors;
    private Map<String, Ticket> activeTickets;

    public ParkingLot(String parkingLotName, int numberOfFloors, int carSlots, int bikeSlots, int truckSlots) {
        this.parkingLotName = parkingLotName;
        this.floors = new ArrayList<>();
        this.activeTickets = new HashMap<>();

        for (int i = 1; i <= numberOfFloors; i++) {
            floors.add(new ParkingFloor(i, carSlots, bikeSlots, truckSlots));
        }
    }

    // Park a vehicle and generate a ticket
    public Ticket parkVehicle(Vehicle vehicle) {
        for (ParkingFloor floor : floors) {
            ParkingSlot slot = floor.findAvailableSlot(vehicle);
            if (slot != null) {
                slot.park(vehicle);
                String ticketId = UUID.randomUUID().toString();
                Ticket ticket = new Ticket(ticketId, vehicle, slot);
                activeTickets.put(ticketId, ticket);
                System.out.println("Vehicle parked in slot: " + slot.getSlotNumber());
                return ticket;
            }
        }
        System.out.println("No available slot for this vehicle type.");
        return null;
    }

    // Unpark a vehicle and calculate fee
    public double unparkVehicle(String ticketId) {
        Ticket ticket = activeTickets.get(ticketId);
        if (ticket == null) {
            System.out.println("Invalid Ticket ID!");
            return -1;
        }

        ParkingSlot slot = ticket.getSlot();
        slot.unpark();
        double fee = Payment.calculateFee(ticket);
        activeTickets.remove(ticketId);
        System.out.println("Vehicle unparked. Fee: $" + fee);
        return fee;
    }

    // Display available slots on all floors
    public void displayAvailableSlots() {
        for (ParkingFloor floor : floors) {
            floor.displayAvailableSlots();
        }
    }

}
