public class Guitar37 implements Guitar {
    public static final String KEYBOARD =
            "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
    private GuitarString[] notes;
    private int counter;

    public Guitar37() {
        notes = new GuitarString[37];

        for (int i = 0; i < KEYBOARD.length(); i++) {
            notes[i] = new GuitarString(440 * Math.pow(2, (i - 24) / 12.0));
        }
        counter = 0;
    }

    @Override
    public void playNote(int pitch) {
        if ((pitch + 24) >= 0 && (pitch + 24) < 37) {
            notes[pitch + 24].pluck();
        }
    }

    @Override
    public boolean hasString(char key) {
        return notes[KEYBOARD.indexOf(key)] != null;
    }

    @Override
    public void pluck(char key) {
        if (!hasString(key)){
            throw new IllegalArgumentException("wrong note");
        }
        notes[KEYBOARD.indexOf(key)].pluck();
    }

    @Override
    public double sample() {
        double sum = 0;
        for (int i = 0; i < notes.length; i++) {
            sum += notes[i].sample();
        }
        return sum;
    }

    @Override
    public void tic() {
        counter++;
        for (int i = 0; i < notes.length; i++){
            notes[i].tic();
        }
    }

    @Override
    public int time() {
        return counter;
    }
}
