package bowling.domain;

import java.util.ArrayList;
import java.util.List;

public class NormalFrame implements Frame {

  private final List<Ball> balls = new ArrayList<>();
  private boolean turnOver;

  public void bowl(int score) {
    new Ball(score);
  }

  public boolean isTurnOver() {
    return turnOver;
  }
}
