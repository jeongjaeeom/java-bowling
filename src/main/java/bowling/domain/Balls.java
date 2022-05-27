package bowling.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Balls {

  private final List<Ball> balls;

  private Balls(List<Ball> balls) {
    this.balls = balls;
  }

  public static Balls ofNumbers(List<Integer> balls) {
    return of(balls.stream()
        .map(Ball::new)
        .collect(Collectors.toList()));
  }

  public static Balls of(List<Ball> balls) {
    return new Balls(balls);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Balls balls1 = (Balls) o;
    return Objects.equals(balls, balls1.balls);
  }

  @Override
  public int hashCode() {
    return Objects.hash(balls);
  }
}
