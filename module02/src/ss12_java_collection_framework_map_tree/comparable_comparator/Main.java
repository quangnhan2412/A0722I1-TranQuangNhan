package ss12_java_collection_framework_map_tree.comparable_comparator;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Students student = new Students("Kien", 30, "HT");
        Students student1 = new Students("Nam", 26, "HN");
        Students student2 = new Students("Anh", 39, "HT");
        Students student3 = new Students("Anh", 38, "HT");

        List<Students> list = new ArrayList<>();
        list.add(student);
        list.add(student1);
        list.add(student2);
        list.add(student3);

        Collections.sort(list);
        for (Students st : list
        ) {
            System.out.println(st.toString());
        }


        AgeComparator ageComparator = new AgeComparator();
        Collections.sort(list,ageComparator);
        System.out.println("So sanh theo tuoi:");
        for(Students st : list){
            System.out.println(st.toString());
        }
    }
}
