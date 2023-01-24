import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.*;
import static org.junit.Assert.assertNotEquals;

public class test1 {
    @Test
    public void testBookingLuxuryDoubleRoom() {
        int roomNumber = 1;
        boolean isRoomAvailable = Hotel.hotel_ob.luxury_doublerrom[roomNumber - 1] == null;
        assertEquals(true, isRoomAvailable);
    }

    @Test
    public void testBookingDeluxeDoubleRoom() {
        int roomNumber = 11;
        boolean isRoomAvailable = Hotel.hotel_ob.deluxe_doublerrom[roomNumber - 11] == null;
        assertEquals(true, isRoomAvailable);
    }

    @Test
    public void testBookingLuxurySingleRoom() {
        int roomNumber = 31;
        boolean isRoomAvailable = Hotel.hotel_ob.luxury_singleerrom[roomNumber - 31] == null;
        assertEquals(true, isRoomAvailable);
    }

    @Test
    public void testBookingDeluxeSingleRoom() {
        int roomNumber = 41;
        boolean isRoomAvailable = Hotel.hotel_ob.deluxe_singleerrom[roomNumber - 41] == null;
        assertEquals(true, isRoomAvailable);
    }
}
