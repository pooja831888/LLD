public class ParkingSlot {
    private int slotNumber;
    private VehicleType slotType;
    private boolean isOccupied;
    private Vehicle vehicle;

    public ParkingSlot(int slotNumber, VehicleType slotType) {
        this.slotNumber = slotNumber;
        this.slotType = slotType;
        this.isOccupied = false;
    }

    public boolean isAvailable() {
        return !isOccupied;
    }

    public boolean canFitVehicle(Vehicle vehicle) {
        return isAvailable() && vehicle.getType() == this.slotType;
    }

    public void park(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isOccupied = true;
    }

    public void unpark() {
        this.vehicle = null;
        this.isOccupied = false;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public VehicleType getSlotType() {
        return slotType;
    }
}
