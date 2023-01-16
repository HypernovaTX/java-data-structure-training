import java.util.*;

public class Main {
    public static void main(String[] args) {
        simpleArrayHashtableTest();
        chainedHashtableTest();
        JDKHashTableTest();
        removeDuplicateValueInList();
    }

    public static void simpleArrayHashtableTest() {
        Employee jameJones = new Employee("Jame", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
        Employee billEnd = new Employee("Bill", "End", 78);

        SimpleArrayHashtable ht = new SimpleArrayHashtable(10);
        ht.put("Jones", jameJones);
        ht.put("Doe", johnDoe);
        ht.put("Wilson", mikeWilson);
        ht.put("Smith", marySmith);
        ht.put("End", billEnd);

        ht.printHashtable();

        System.out.println("Retrieve key Wilson: " + ht.get("Wilson"));
        System.out.println("Retrieve key Smith: " + ht.get("Smith"));
        System.out.println("Retrieve key End: " + ht.get("End"));

        ht.remove("End");
        ht.printHashtable();
    }

    public static void chainedHashtableTest() {
        Employee jameJones = new Employee("Jame", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
        Employee billEnd = new Employee("Bill", "End", 78);

        ChainedHashtable ht = new ChainedHashtable();
        ht.put("Jones", jameJones);
        ht.put("Doe", johnDoe);
        ht.put("Wilson", mikeWilson);
        ht.put("Smith", marySmith);
        ht.put("End", billEnd);

        ht.printHashtable();

        System.out.println("Retrieve key Wilson: " + ht.get("Wilson"));
        System.out.println("Retrieve key Smith: " + ht.get("Smith"));
        System.out.println("Retrieve key End: " + ht.get("End"));

        ht.remove("End");
        ht.printHashtable();
    }

    public static void JDKHashTableTest() {
        Employee jameJones = new Employee("Jame", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
        Employee billEnd = new Employee("Bill", "End", 78);

        Map<String, Employee> hashMap = new HashMap<String, Employee>();
        hashMap.put("Jones", jameJones);
        hashMap.put("Doe", johnDoe);
        hashMap.put("Wilson", mikeWilson);
        hashMap.put("Smith", marySmith);
        hashMap.put("End", billEnd);
        hashMap.putIfAbsent("Smith", billEnd);

        System.out.println(hashMap.containsKey("Doe"));
        System.out.println(hashMap.containsValue(jameJones));
        Iterator<Employee> iterator = hashMap.values().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


        hashMap.forEach((k, v) -> System.out.println("key = " + k + ". Employee = " + v));
    }

    public static void removeDuplicateValueInList() {
        Employee jameJones = new Employee("Jame", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
        Employee billEnd = new Employee("Bill", "End", 78);

        LinkedList<Employee> employees = new LinkedList<>();
        employees.add(jameJones);
        employees.add(jameJones);
        employees.add(johnDoe);
        employees.add(marySmith);
        employees.add(marySmith);
        employees.add(mikeWilson);
        employees.add(billEnd);
        employees.add(billEnd);

        System.out.println("Before duplicate removal");
        employees.forEach(e -> System.out.println(e));

        HashMap<Integer, Employee> employeeTable = new HashMap<>();
        ListIterator<Employee> iterator = employees.listIterator();
        List<Employee> remove = new ArrayList<>();

        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employeeTable.containsKey(employee.getId())) {
                remove.add(employee);
            } else {
                employeeTable.put(employee.getId(), employee);
            }
        }

        for (Employee employee: remove) {
            employees.remove(employee);
        }

        System.out.println("After duplicate removal");
        employees.forEach(e -> System.out.println(e));
    }
}