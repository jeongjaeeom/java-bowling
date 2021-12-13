package bowling.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @Test
    void 이름을_생성한다() {
        //given
        //when
        //then
        assertThat(Name.from("abc")).isEqualTo(Name.from("abc"));
    }

    @Test
    void 이름의_길이가_3초과면_IllegalArgumentException_이_발생한다() {
        //given
        //when
        //then
        assertThatThrownBy(() -> Name.from("abcd"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
