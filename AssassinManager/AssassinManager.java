import java.util.List;

public class AssassinManager {

    private AssassinNode headOfGrave;
    private AssassinNode headOfRing;

    public AssassinManager(List<String> names) {
        if (names.isEmpty()) {
            throw new IllegalArgumentException("empty list");
        }
        headOfRing = null;

        AssassinNode current = headOfRing;
        for (int i = names.size()-1; i >= 0; i--) {
            current = new AssassinNode(names.get(i), current);
        }
        headOfRing = current;
    }

    public boolean gameOver() {
        return headOfRing.next == null;
    }

    public void printGraveyard() {
    }

    public String winner() {
        if (gameOver()) {
            return headOfRing.name;
        }
        else {
            return null;
        }
    }

    public void printKillRing() {
        AssassinNode current = headOfRing;
        AssassinNode last = null;
        while (current.next != null){
            System.out.println("    " + current.name + " is stalking " + current.next.name);
            current = current.next;
            if (current.next == null){
                last = current;
            }
        }
        System.out.println("    " + last.name + " is stalking " + headOfRing.name);

    }

    public boolean graveyardContains(String name) {
        return contains(name, headOfGrave);
    }

    public boolean killRingContains(String name) {
        return contains(name, headOfRing);
    }

    public void kill(String name) {
    }

    private boolean contains(String name, AssassinNode current){
        while (current.next != null) {
            if (current.name.equalsIgnoreCase(name) || current.next.name.equalsIgnoreCase(name)){
                return true;
            }
            current = current.next;
        }
        return false;
    }
}
