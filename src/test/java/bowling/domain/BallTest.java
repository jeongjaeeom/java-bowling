package bowling.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BallTest {

  @Test
  @DisplayName("볼 생성")
  void created() {
    assertThat(new Ball("10")).isEqualTo(new Ball(10));
  }

  @DisplayName("볼 점수 0 ~ 10점이 아닌 경우 예외 처리")
  @ParameterizedTest
  @ValueSource(ints = {-1, 11})
  void givenNegativeNumber_ShouldException(int input) {
    assertThatIllegalArgumentException().isThrownBy(() -> new Ball(input));
  }
}