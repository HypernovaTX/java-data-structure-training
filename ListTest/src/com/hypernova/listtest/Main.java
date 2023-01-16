package com.hypernova.listtest;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        arrayListTest();
        vectorClassTest();
        linkedListTest();
        doubleLinkedListTest();
        jdkLinkedListTest();
    }
    private static void arrayListTest() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Jame", "Jones", 123));
        employeeList.add(new Employee("John", "Doe", 4567));
        employeeList.add(new Employee("Mary", "Smith", 22));
        employeeList.add(new Employee("Mike", "Wilson", 3245));

        employeeList.forEach(employee -> System.out.println(employee));

        System.out.println(employeeList.get(1)); // John Doe
        System.out.println(employeeList.isEmpty()); // false
        System.out.println(employeeList.size()); // 4
        // Replace
        employeeList.set(1, new Employee("John", "Adams", 4568));
        System.out.println(employeeList.get(1)); // John Adams

        // Add John Doe back at 4th spot
        employeeList.add(3, new Employee("John", "Doe", 4567));
        employeeList.forEach(employee -> System.out.println(employee));

        // Convert to array
        Employee[] employeeArray = employeeList.toArray(new Employee[employeeList.size()]);
        for (Employee employee: employeeArray) {
            System.out.println(employee);
        }

        System.out.println(employeeList.contains(new Employee("Mary", "Smith", 22))); // False (no equal method, it is not the same instance)
        System.out.println(employeeList.indexOf(new Employee("John", "Doe", 4567))); // 3

        // Remove item from list
        employeeList.remove(2); // Faster than instance, but the system has to shift the entries
        employeeList.forEach(employee -> System.out.println(employee));
    }

    private static void vectorClassTest() {
        List<Employee> employeeList = new Vector<>();
        employeeList.add(new Employee("Jame", "Jones", 123));
        employeeList.add(new Employee("John", "Doe", 4567));
        employeeList.add(new Employee("Mary", "Smith", 22));
        employeeList.add(new Employee("Mike", "Wilson", 3245));

        employeeList.forEach(employee -> System.out.println(employee));
    }

    private static void linkedListTest() {
        // JDK has it built-in, but we're implementing manually to get the gist of linked list
        Employee jameJones = new Employee("Jame", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);

        EmployeeLinkedList list = new EmployeeLinkedList();
        list.addToFront(jameJones);
        list.addToFront(johnDoe);
        list.addToFront(marySmith);
        list.addToFront(mikeWilson);

        list.printList();
        System.out.println(list.getSize());

        list.removeFromFront();
        list.printList();
        System.out.println(list.getSize());
    }

    private static void doubleLinkedListTest() {
        Employee jameJones = new Employee("Jame", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
        EmployeeDoublyLinkedList list = new EmployeeDoublyLinkedList();

        list.addToFront(jameJones);
        list.addToFront(johnDoe);
        list.addToFront(marySmith);
        list.addToFront(mikeWilson);
        list.printList();
        System.out.println(list.getSize());

        Employee billEnd = new Employee("Bill", "End", 78);
        list.addToEnd(billEnd);
        list.printList();
        System.out.println(list.getSize());

        list.removeFromFront();
        list.printList();
        System.out.println(list.getSize());

        list.removeFromEnd();
        list.printList();
        System.out.println(list.getSize());
    }

    private static void jdkLinkedListTest() {
        LinkedList<Employee> list = new LinkedList<>();

        Employee jameJones = new Employee("Jame", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
        Employee billEnd = new Employee("Bill", "End", 78);

        list.addFirst(jameJones);
        list.addFirst(johnDoe);
        list.addFirst(marySmith);
        list.addFirst(mikeWilson);
        list.addLast(billEnd);

        Iterator iteration = list.iterator();
        System.out.print("HEAD > ");
        while (iteration.hasNext()) {
            System.out.print(iteration.next());
            System.out.print(" <=> ");
        }
        System.out.print("null");


    }
}