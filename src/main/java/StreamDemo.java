import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Seva Nardin
 */
public class StreamDemo {

    private static class Person {
        private String name;
        private int age;
        private String position;

        public Person(String name, int age, String position) {
            this.name = name;
            this.age = age;
            this.position = position;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getPosition() {
            return position;
        }
    }


    public static void main(String[] args) {

        List<Person> persons = new ArrayList<>(Arrays.asList(
                new Person("Seva", 43, "Master"),
                new Person("Marina", 40, "Master"),
                new Person("Fedor", 6, "Slave"),
                new Person("Shmonya", 6, "Slave")
        ));

//        List<Person> masters = new ArrayList<>();
//
//        for(Person p : persons) {
//            if(p.position.equals("Master")) {
//                masters.add(p);
//            }
//        }
//
//        Collections.sort(masters, new Comparator<Person>() {
//            @Override
//            public int compare(Person p1, Person p2) {
//                return p1.age - p2.age;
//            }
//        });
//
//        List<String> masterName = new ArrayList<>();
//
//        for(Person p : masters) {
//            masterName.add(p.getName());
//        }
//
//        System.out.println(masterName);

        List<String> masterName = persons.stream()
                .filter(p -> p.position.equals("Master"))
                .sorted((p1, p2) -> p1.age - p2.age)
                .map(p -> p.name)
                .collect(Collectors.toList());

        System.out.println(masterName);

    }

}
