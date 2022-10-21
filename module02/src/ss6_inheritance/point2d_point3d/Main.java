package ss6_inheritance.point2d_point3d;

public class Main {
    public static void main(String[] args) {
        Point2D point2D = new Point2D();
        System.out.println(point2D);

        point2D = new Point2D(15.0f, 5.0f);
        System.out.println(point2D);

        Point3D point3D = new Point3D(5,6,7);
        System.out.println(point3D);

        point3D.setXYZ(6.3f, 7.3f, 8.3f );
        System.out.println(point3D);
    }
}
