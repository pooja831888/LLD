public class Payment {
    private static final double CAR_RATE = 10.0;
    private static final double BIKE_RATE = 5.0;
    private static final double TRUCK_RATE = 15.0;

    public static double calculateFee(Ticket ticket) {
        long duration = ticket.getDuration();
        double rate;

        switch (ticket.getVehicle().getType()) {
            case CAR:
                rate = CAR_RATE;
                break;
            case BIKE:
                rate = BIKE_RATE;
                break;
            case TRUCK:
                rate = TRUCK_RATE;
                break;
            default:
                throw new IllegalArgumentException("Unknown Vehicle Type");
        }
        return rate * Math.ceil(duration / 60.0); // Per minute
    }
}
