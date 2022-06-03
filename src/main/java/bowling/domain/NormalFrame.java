package bowling.domain;

public class NormalFrame implements Frame {

  private final int number;


  public NormalFrame(int number) {
    this.number = number;
  }

  public Frame bowl(int fallenPin) {
    Pin pin = new Pin(fallenPin);
    if (pin.strike()) {
      return new NormalFrame(number + 1);
    }
    return this;
  }

}
