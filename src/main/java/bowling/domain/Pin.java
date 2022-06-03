package bowling.domain;

import java.util.Objects;

public class Pin {

  public static final int MIN_PIN = 0;
  public static final int MAX_PIN = 10;
  private final int fallenPin;

  public Pin(String fallenPin) {
    this(Integer.parseInt(fallenPin));
  }

  public Pin(int fallenPin) {
    if (fallenPin < MIN_PIN || fallenPin > MAX_PIN) {
      throw new IllegalArgumentException("볼링핀은 0 ~ 10 개 사이여야 합니다.");
    }
    this.fallenPin = fallenPin;
  }

  public boolean strike() {
    return fallenPin == MAX_PIN;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Pin pin1 = (Pin) o;
    return fallenPin == pin1.fallenPin;
  }

  @Override
  public int hashCode() {
    return Objects.hash(fallenPin);
  }
}
