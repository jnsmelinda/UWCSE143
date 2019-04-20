import java.util.LinkedList;
import java.util.Queue;

public class GuitarString {

    public final int SAMPLE_RATE = 44100;
    public final double ENERGY_DECAY_FACTOR = 0.996;
    private Queue<Double> ringBuffer;

    public GuitarString(double frequency) throws IllegalAccessException {
        if (frequency < 0) {
            throw new IllegalAccessException("frequency < 0");
        }

        ringBuffer = new LinkedList<>();
        int capacity = (int)Math.round(SAMPLE_RATE / frequency);

        for (int i = 0; i < capacity; i++) {
            ringBuffer.add(0.0);
        }

        if (ringBuffer.size() < 2) {
            throw new IllegalAccessException("ringbuffer size < 2");
        }
    }

    GuitarString(double[] init) throws IllegalAccessException {
        if (init.length < 2) {
            throw new IllegalAccessException("array size < 2");
        }

        ringBuffer = new LinkedList<>();
        for (double element : init) {
            ringBuffer.add(element);
        }
    }

    public void pluck(){
        for (int i = 0; i < ringBuffer.size(); i++) {
            ringBuffer.poll();
            ringBuffer.add(Math.random() - 0.5);
        }
    }

    public void tic(){
        double temp = ringBuffer.poll();
        ringBuffer.add(((temp + ringBuffer.peek()) / 2) * ENERGY_DECAY_FACTOR);
    }

    public double sample(){
        return ringBuffer.peek();
    }
}
