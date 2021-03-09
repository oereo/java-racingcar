package racingcar.repository;

import racingcar.domain.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.repository.exception.NotDuplicateNameException;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

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
        List<Car> carList = List.of(car);

        //when
        carManager.addAllCars(carList);
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

        List<Car> carList = List.of(oereo, pkalsh, kouz95, pkalsh2);

        //when
        //then
        assertThatExceptionOfType(NotDuplicateNameException.class)
            .isThrownBy(() -> carManager.addAllCars(carList));
    }

    @Test
    void 랜덤_숫자_리스트를_넘기면_기준에_따라_플레이어가_이동한다() {
        //given
        Car oereo = new Car("oereo");
        Car pkalsh = new Car("pkalsh");
        Car kouz95 = new Car("kouz95");

        List<Car> carList = List.of(oereo, pkalsh, kouz95);
        carManager.addAllCars(carList);

        //when
        List<Integer> randomNumberList = List.of(4, 4, 2);
        carManager.moveAllCars(randomNumberList);

        //then
        assertThat(oereo.getPosition()).isEqualTo(1);
        assertThat(pkalsh.getPosition()).isEqualTo(1);
        assertThat(kouz95.getPosition()).isEqualTo(0);
    }

}