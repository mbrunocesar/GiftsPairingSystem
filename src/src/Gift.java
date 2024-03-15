public class Gift {

    int size;
    String shape;

    public Gift(int size, String shape) {
        this.size = size;
        this.shape = shape;
    }

    public void print() {
        System.out.println("Gift: " + size + " - " + shape);
    }

    public boolean haveSameParams(Gift comparable) {
        return comparable.shape.equals(shape) && comparable.size == size;
    }

}
