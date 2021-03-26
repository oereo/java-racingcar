package racingcar.repository;

import racingcar.domain.car.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarDto;
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
        Car car = new Car("oer");
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
        Car oereo = new Car("oer");
        Car pkalsh = new Car("pka");
        Car kouz95 = new Car("kouz");
        Car pkalsh2 = new Car("pka");

        List<Car> carList = List.of(oereo, pkalsh, kouz95, pkalsh2);

        //when
        //then
        assertThatExceptionOfType(NotDuplicateNameException.class)
            .isThrownBy(() -> carManager.addAllCars(carList));
    }

//    @Test
//    void 랜덤_숫자_리스트를_넘기면_기준에_따라_플레이어가_이동한다() {
//        //given
//        Car oereo = new Car("oer");
//        Car pkalsh = new Car("pka");
//        Car kouz95 = new Car("kouz");
//
//        List<Car> carList = List.of(oereo, pkalsh, kouz95);
//        carManager.addAllCars(carList);
//
//        //when
//        List<CarDto> randomNumberList =
//                List.of(new CarDto(oereo),
//                        new CarDto(pkalsh),
//                        new CarDto(kouz95));
//
//        carManager.moveAllCars(randomNumberList);
//
//        //then
//        assertThat(oereo.getPosition()).isEqualTo(1);
//        assertThat(pkalsh.getPosition()).isEqualTo(0);
//        assertThat(kouz95.getPosition()).isEqualTo(1);
//    }

    @Test
    void dto에_존재하는_car_객체가_CarManager의_collection에_존재하는_car_객체와_같다() {
        //given
        Car oereo = new Car("oer");
        Car pkalsh = new Car("pka");
        Car kouz95 = new Car("kouz");

        List<Car> carList = List.of(oereo, pkalsh, kouz95);
        carManager.addAllCars(carList);

        //when
        List<CarDto> randomNumberList = carManager.generateCarDtos();

        //then
        for (int i = 0; i < carList.size(); i++) {
            assertThat(carList.get(i) == randomNumberList.get(i).getCar())
                    .isTrue();
        }
    }

    @Test
    void 승자가_한명일_때_그_이름을_출력한다() {
        //given
        Car oereo = new Car("oer");
        Car pkalsh = new Car("pka");
        Car kouz95 = new Car("kouz");

        List<Car> carList = List.of(oereo, pkalsh, kouz95);
        carManager.addAllCars(carList);
        pkalsh.move();

        //when
        String winnerMessage = carManager.createWinnerMessage();

        //then
        assertThat(winnerMessage).isEqualTo("pka");
    }

    @Test
    void 승자가_두명이상일_때_그_이름들을_comma로_구분하여_출력한다() {
        //given
        Car oereo = new Car("oer");
        Car pkalsh = new Car("pka");
        Car kouz95 = new Car("kouz");

        List<Car> carList = List.of(oereo, pkalsh, kouz95);
        oereo.move();
        pkalsh.move();
        kouz95.move();
        carManager.addAllCars(carList);

        //when
        String winnerMessage = carManager.createWinnerMessage();

        //then
        assertThat(winnerMessage).isEqualTo("oer, pka, kouz");
    }

}