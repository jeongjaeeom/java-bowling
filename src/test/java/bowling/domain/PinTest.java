package bowling.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PinTest {

  @Test
  @DisplayName("넘어진 볼링 핀 생성")
  void created() {
    assertThat(new Pin("10")).isEqualTo(new Pin(10));
  }

  @DisplayName("넘어진 볼링 핀 0 ~ 10개 아닌 경우 예외 처리")
  @ParameterizedTest
  @ValueSource(ints = {-1, 11})
  void givenNegativeNumber_ShouldException(int input) {
    assertThatIllegalArgumentException().isThrownBy(() -> new Pin(input));
  }
}