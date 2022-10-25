package ss7_abstractclass_interface.geometric_resizeable;

public class Square extends Rectangle implements Resizeable{
    public Square() {

    }

    public Square(double side){
        super(side,side);
    }

    public Square(String color, boolean filled, double width, double height) {
        super(color, filled, width, height);
    }

public double getSide(){
        return getWidth();
}
public void setSide(double side){
        setWidth(side);
        setHeight(side);
}

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
    }

    @Override
    public void setHeight(double height) {
        super.setHeight(height);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public double resize(double percent) {
        return super.resize(percent);
    }
}
