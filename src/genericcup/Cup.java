package genericcup;

public class Cup<T extends Fluid> {

    private T content;

    public void fill(T content) {
        this.content = content;
    }

    public T getContent() {
        return this.content;
    }
}

interface Fluid {

}