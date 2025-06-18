import java.util.ArrayList;
import java.util.List;

public class ParkingFloor {
    private int floorNumber;
    private List<ParkingSlot> slots;

    public ParkingFloor(int floorNumber, int carSlots, int bikeSlots, int truckSlots) {
        this.floorNumber = floorNumber;
        slots = new ArrayList<>();
        int slotNumber = 1;

        for (int i = 0; i < carSlots; i++) {
            slots.add(new ParkingSlot(slotNumber++, VehicleType.CAR));
        }
        for (int i = 0; i < bikeSlots; i++) {
            slots.add(new ParkingSlot(slotNumber++, VehicleType.BIKE));
        }
        for (int i = 0; i < truckSlots; i++) {
            slots.add(new ParkingSlot(slotNumber++, VehicleType.TRUCK));
        }
    }

    public ParkingSlot findAvailableSlot(Vehicle vehicle) {
        for (ParkingSlot slot : slots) {
            if (slot.canFitVehicle(vehicle)) {
                return slot;
            }
        }
        return null;
    }

    public void displayAvailableSlots() {
        System.out.println("Available Slots on Floor " + floorNumber);
        for (ParkingSlot slot : slots) {
            if (slot.isAvailable()) {
                System.out.println("Slot " + slot.getSlotNumber() + " - " + slot.getSlotType());
            }
        }
    }
}
