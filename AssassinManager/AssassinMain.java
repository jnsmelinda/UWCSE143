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

    public boolean graveyardContains(String name) {
        return contains(name, headOfGrave);
    }

    public boolean killRingContains(String name) {
        return contains(name, headOfRing);
    }

    public String winner() {
        if (gameOver()) {
            return headOfRing.name;
        }
        else {
            return null;
        }
    }

    public boolean gameOver() {
        return headOfRing.next == null;
    }

    public void printGraveyard() {
        AssassinNode current = headOfGrave;
        if (headOfGrave != null && headOfGrave.next == null) {
            print(current.name, "was killed by", current.killer);
        }
        else {
            current = reverse(current);
            while (current != null) {
                print(current.name, "was killed by", current.killer);
                current = current.next;
            }
        }
    }

    public void printKillRing() {
        AssassinNode current = headOfRing;
        while (current.next != null){
            print(current.name, "is stalking", current.next.name);
            current = current.next;
        }
        print(current.name, "is stalking", headOfRing.name);
    }

    public void kill(String name) {
        if (!killRingContains(name)) {
            throw new IllegalArgumentException("not in the ring");
        }
        if (gameOver()) {
            throw new IllegalStateException("the game is over");
        }
        if (headOfRing.name.equalsIgnoreCase(name)) {
            killTheFirst();
        }
        else {
            killTheRest(name);
        }
    }

    private void killTheRest(String name) {
        AssassinNode victim;
        AssassinNode current = headOfRing;
        while (current.next != null){
            if (current.next.name.equalsIgnoreCase(name)){
                victim = current.next;
                victim.killer = current.name;
                if (isEmpty(headOfGrave)) {
                    headOfGrave = victim;
                    if (current.next.next == null){
                        current.next = null;
                        break;
                    }
                    current.next = current.next.next;
                    headOfGrave.next = null;
                }
                else {
                    AssassinNode dead = headOfGrave;
                    while (dead.next != null){
                        dead = dead.next;
                    }
                    dead.next = victim;
                    if (current.next.next == null){
                        current.next = null;
                        break;
                    }
                    current.next = current.next.next;
                    dead.next.next = null;
                }
            }
            current = current.next;
        }
    }

    private void killTheFirst(){
        AssassinNode victim;
        victim = headOfRing;
        if (isEmpty(headOfGrave)) {
            headOfGrave = victim;
            victim.killer = getLast(headOfRing).name;
            headOfRing = headOfRing.next;
            headOfGrave.next = null;
        } else {
            AssassinNode current = headOfGrave;
            while (current.next != null) {
                current = current.next;
            }
            current.next = victim;
            victim.killer = getLast(headOfRing).name;
            headOfRing = headOfRing.next;
            current.next.next = null;
        }
    }

    private void print(String name1, String text, String name2){
        System.out.println("    " + name1 + " " + text + " " + name2);
    }

    private AssassinNode reverse(AssassinNode current) {
        AssassinNode prev = null;
        AssassinNode next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        current = prev;
        return current;
    }

    private AssassinNode getLast(AssassinNode current){
        AssassinNode last = null;
        while (current.next != null){
            last = current.next;
            current = current.next;
        }
        return last;
    }

    private boolean contains(String name, AssassinNode current){
        if (current != null) {
            while (current.next != null) {
                if (current.name.equalsIgnoreCase(name) || current.next.name.equalsIgnoreCase(name)) {
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }

    private boolean isEmpty(AssassinNode current) {
        return (current == null);
    }
}
