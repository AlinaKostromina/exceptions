public class Tshirt extends Product {
    private String color;
    private String size;

//    public Tshirt () {
//        super();
//    }

    public Tshirt(int id, String name, int price, String color, String size) {
        super(id, name, price);
        this.color = color;
        this.size = size;
    }
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}