package thread;

public class Increment {
    int count = 0;

    synchronized void increment() {
        count++;
    }
}
