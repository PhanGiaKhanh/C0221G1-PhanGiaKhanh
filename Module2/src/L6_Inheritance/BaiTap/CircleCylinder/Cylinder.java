package L6_Inheritance.BaiTap.CircleCylinder;

public class Cylinder extends Circle {
    private double height = 0.1;

    public Cylinder (){
    }
    public Cylinder (double height, double radius, String color){
        super(radius, color);
        this.height = height;
    }
    public double getHeight(){
        return height;
    }
    public void setHeight(double height){
        this.height = height;
    }
    public double getVolume(){
        return Math.floor(getPerimeter()*height*100)/100;
    }
    @Override
    public double getArea() {
        return Math.floor(2*Math.PI*getRadius()*(getRadius()+height)*100)/100;
    }
    @Override
    public String toString(){
        return "A Cylinder with heigth = "
                + height
                + super.toString()
                + "\n Volume = "
                + getVolume();
    }
}
