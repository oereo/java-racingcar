package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DiscriminatorTest {

    @Test
    void _4이상이면_전진한다() {
        //given
        int generatedNumber = 4;

        //when
        boolean expected = Discriminator.isMove(generatedNumber);

        //then
        assertThat(expected).isTrue();
    }

    @Test
    void _3이하이면_움직이지_않는다() {
        //given
        int generatedNumber = 3;

        //when
        boolean expected = Discriminator.isMove(generatedNumber);

        //then
        assertThat(expected).isFalse();
    }
}