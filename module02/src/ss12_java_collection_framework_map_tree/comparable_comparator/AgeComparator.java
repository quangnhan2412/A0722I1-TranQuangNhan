package ss12_java_collection_framework_map_tree.comparable_comparator;


import java.util.Comparator;

public class AgeComparator implements Comparator<Students> {


    @Override
    public int compare(Students student1, Students student2) {
        if (student1.getAge() > student2.getAge()) {
            return 1;
        } else if (student1.getAge() == student2.getAge()) {
            return 0;
        } else {
            return -1;
        }
    }
}


