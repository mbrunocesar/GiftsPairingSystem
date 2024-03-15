package model;

public class Gift {

    public int size;
    public String shape;

    public Gift(int size, String shape) {
        this.size = size;
        this.shape = shape;
    }

    public void print() {
        System.out.println("model.Gift: " + size + " - " + shape);
    }

    public boolean hasSameValues(Gift comparable) {
        return comparable.shape.equals(shape) && comparable.size == size;
    }

}
