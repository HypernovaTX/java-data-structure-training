package com.hypernova.listtest;

public class EmployeeDoublyLinkedList {
    private EmployeeDoublyNode head;
    private EmployeeDoublyNode tail;
    private int size;

    public void addToFront(Employee employee) {
        EmployeeDoublyNode node = new EmployeeDoublyNode(employee);
        node.setNext(head);

        if (head == null) {
            tail = node;
        } else {
            head.setPrev(node);
        }

        head = node;
        size ++;
    }

    public boolean addBefore(Employee newEmployee, Employee existingEmployee) {
        if (head == null) {
            return false;
        }

        // find the existing employee
        EmployeeDoublyNode current = head;
        while (current != null && !current.getEmployee().equals(existingEmployee)) {
            current = current.getNext();
        }
        if (current == null) {
            return false;
        }

        EmployeeDoublyNode newNode = new EmployeeDoublyNode(newEmployee);
        newNode.setPrev(current.getPrev());
        newNode.setNext(current);
        current.setPrev(newNode);

        if (head == current) {
            head = current;
        } else {
            newNode.getPrev().setNext(newNode);
        }
        size ++;
        return true;
    }

    public void addToEnd(Employee employee) {
        EmployeeDoublyNode node = new EmployeeDoublyNode(employee);
        if (tail == null) {
            head = node;
        } else {
            tail.setNext(node);
            node.setPrev(tail);
        }
        tail = node;
        size ++;
    }

    public EmployeeDoublyNode removeFromFront() {
        if (isEmpty()) {
            return null;
        }

        EmployeeDoublyNode removedNode = head;

        if (head.getNext() == null) {
            tail = null;
        } else {
            head.getNext().setPrev(null);
        }

        head = head.getNext();
        size --;
        // removedNode.setNext(null);
        return removedNode;
    }

    public EmployeeDoublyNode removeFromEnd() {
        if (isEmpty()) {
            return null;
        }

        EmployeeDoublyNode removedNode = tail;

        if (tail.getPrev() == null) {
            head = null;
        } else {
            tail.getPrev().setNext(null);
        }

        tail = tail.getPrev();
        size --;
        return removedNode;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void printList() {
        EmployeeDoublyNode current = head;
        System.out.println("HEAD -> ");
        while (current != null) {
            System.out.println(current);
            System.out.println(" <=> ");
            current = current.getNext();
        }
        System.out.println("NULL");
    }
}
