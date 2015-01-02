package hello;

public class Locking {
    private final String result;
    public Locking(String content) {
        this.result = content;
    }
    public String getResult() {
        return result;
    }
}
