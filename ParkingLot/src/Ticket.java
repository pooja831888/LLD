public class Ticket {
   final private String ticketId;
    private Vehicle vehicle;
    private long startTime;
    private ParkingSlot slot;

    public Ticket(String ticketId, Vehicle vehicle, ParkingSlot slot) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.slot = slot;
        this.startTime = System.currentTimeMillis();
    }

    public long getDuration() {
        return (System.currentTimeMillis() - startTime) / 1000; // Duration in seconds
    }

    public ParkingSlot getSlot() {
        return slot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public String getTicketId() {
        return ticketId;
    }
}
