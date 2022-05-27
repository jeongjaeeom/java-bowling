package bowling.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class NormalFrameTest {

  @Test
  void name() {
    NormalFrame frame = new NormalFrame();
    frame.bowl(new Ball(10));
  }
}