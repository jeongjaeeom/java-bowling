package bowling.domain;

import bowling.domain.state.Ready;
import bowling.domain.state.State;
import bowling.exception.GameOverException;

import java.util.Objects;

public class NormalFrame implements Frame {
    public static final int MAX_FRAME_INDEX = 8;

    private final int index;
    private State state;
    private Score score;

    public NormalFrame(int index) {
        this.validate(index);

        this.index = index;
        this.state = new Ready();
    }

    private void validate(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("일반 프레임의 인덱스는 0 이상이어야 합니다.");
        }

        if (index > MAX_FRAME_INDEX) {
            throw new IllegalArgumentException("일반 프레임은 최대 9번 진행할 수 있습니다.");
        }
    }

    public static NormalFrame firstFrame() {
        return new NormalFrame(0);
    }

    public NormalFrame next() {
        return new NormalFrame(index + 1);
    }

    public void pitch(int count) {
        if (this.isFinish()) {
            throw new GameOverException();
        }

        this.state = state.pitch(count);
        createScore();
    }

    @Override
    public String getFallenPins() {
        return state.toString();
    }

    @Override
    public int getScore() {
        return this.score.getScore();
    }

    @Override
    public void calculateScore(int index, int count) {
        if (this.index == index || score.isEndCalculate()) {
            return;
        }

        score.addScore(count);
    }

    public boolean hasScore() {
        return Objects.nonNull(score) && score.isEndCalculate();
    }

    private void createScore() {
        if (!state.isFinish()) {
            return;
        }

        this.score = state.getScore();
    }

    public boolean isFinish() {
        return state.isFinish();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NormalFrame frame = (NormalFrame) o;
        return index == frame.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index);
    }
}