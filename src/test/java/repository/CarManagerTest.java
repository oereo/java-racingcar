package repository;

import domain.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.exception.NotDuplicateNameException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class CarManagerTest {

    private CarManager carManager;

    @BeforeEach
    void setup() {
        carManager = new CarManager();
    }

    @Test
    void Car_객체를_추가한다() {
        //given
        Car car = new Car("oereo");

        //when
        carManager.add(car);
        int expected = carManager.size();

        //then
        assertThat(expected).isEqualTo(1);
    }

    @Test
    void 중복되는_이름의_Car_객체를_추가를_하면_NotDuplicateNameException을_던진다() {
        //given
        Car oereo = new Car("oereo");
        Car pkalsh = new Car("pkalsh");
        Car kouz95 = new Car("kouz95");
        Car pkalsh2 = new Car("pkalsh");

        //when
        carManager.add(oereo);
        carManager.add(pkalsh);
        carManager.add(kouz95);

        //then
        assertThatExceptionOfType(NotDuplicateNameException.class)
            .isThrownBy(() -> carManager.add(pkalsh2));
    }
}