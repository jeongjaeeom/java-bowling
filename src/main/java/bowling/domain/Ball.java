package bowling.domain;

import java.util.Objects;

public class Ball {

  public static final int MIN_SCORE = 0;
  public static final int MAX_SCORE = 10;
  private final int score;

  public Ball(String score) {
    this(Integer.parseInt(score));
  }

  public Ball(int score) {
    if (score < MIN_SCORE || score > MAX_SCORE) {
      throw new IllegalArgumentException("볼링 점수는 0 ~ 10 사이여야 합니다.");
    }
    this.score = score;
  }

  public boolean strike() {
    return score == MAX_SCORE;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Ball ball = (Ball) o;
    return score == ball.score;
  }

  @Override
  public int hashCode() {
    return Objects.hash(score);
  }
}
