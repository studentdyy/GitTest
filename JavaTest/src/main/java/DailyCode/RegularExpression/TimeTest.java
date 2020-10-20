package DailyCode.RegularExpression;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeTest {

    @Test
    void parseTime() {
        assertThrows(IllegalArgumentException.class,() ->{
            Time.parseTime("21348");
        });
        int[] result = {21,01,59};
        assertArrayEquals(result,Time.parseTime("21:01:59"));
    }
}