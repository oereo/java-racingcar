package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void moveTest() {
        //given
        Car car = new Car("name");
        int prev = car.getPosition();

        //when
        car.move();
        int current = car.getPosition();

        //then
        assertThat(current).isEqualTo(prev + 1);
    }
}