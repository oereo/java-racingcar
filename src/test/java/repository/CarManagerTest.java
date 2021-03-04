package repository;

import domain.Car;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarManagerTest {
    @Test
    void Car_객체를_추가한다() {
        //given
        CarManager carManager = new CarManager();
        Car car = new Car("oereo");

        //when
        carManager.add(car);
        int expected = carManager.size();

        //then
        assertThat(expected).isEqualTo(1);
    }
}