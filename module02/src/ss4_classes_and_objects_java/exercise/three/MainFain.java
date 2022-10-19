package ss4_classes_and_objects_java.exercise.three;

public class MainFain {
    public static void main(String[] args) {
        Fan fanOne = new Fan();
        Fan fanTwo = new Fan();

        fanOne.setSpeed(fanOne.Fast);
        fanOne.setRadius(10);
        fanOne.setColor("yellow");
        fanOne.setOn(true);

        fanTwo.setSpeed(fanTwo.Medium);
        fanTwo.setRadius(5);
        fanTwo.setColor("blue");
        fanTwo.setOn(false);

        System.out.print("is Fan One : ");
        System.out.println(fanOne);
         System.out.print("is Fan Two : ");
        System.out.println(fanTwo);

    }
}
