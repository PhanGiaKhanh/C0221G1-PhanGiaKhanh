package bai7_abstract_class_interface.thuc_hanh.geometric;

import bai6_inheritance.thuc_hanh.shape.Circle;

public class ComparableCircle extends Circle implements Comparable<ComparableCircle>{
    public  ComparableCircle(){
    }
    public ComparableCircle(double radius){
        super(radius);
    }
    public ComparableCircle(double radius, String color, boolean filled) {
        super(radius, color, filled);
    }

//    @Override
//    public int compareTo(ComparableCircle o) {
//        return 0;
//    }
    @Override
    public int compareTo(ComparableCircle o) {
        if (getRadius() > o.getRadius()) return 1;
        else if (getRadius() < o.getRadius()) return -1;
        else return 1;
    }
}