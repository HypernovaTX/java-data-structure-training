import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        arrayStackTest();
        linkedListStackTest();
        palindromeStackChallenge();
        arrayQueueTest();
    }

    public static void arrayStackTest() {
        System.out.println("+++++ ARRAY STACK +++++");
        ArrayStack stack = new ArrayStack(10);
        stack.push(new Employee("Jane", "Jones", 123));
        stack.push(new Employee("John", "Doe", 12312));
        stack.push(new Employee("Jimmy", "McGill", 2343));
        stack.push(new Employee("Mike", "Ehrentraut", 234));
        stack.push(new Employee("James", "May", 7562));
        stack.push(new Employee("Jeremy", "Clarkson", 87807));
        stack.push(new Employee("Bill", "End", 6757));

        System.out.println("== Print Stack ==");
        stack.printStack();
        System.out.println("== Stack Size ==");
        System.out.println(stack.size());
        System.out.println("== Stack Top ==");
        System.out.println(stack.peek());

        stack.pop();
        System.out.println("== Stack Top After Pop ==");
        System.out.println(stack.peek());

        System.out.println("++++++++++");
    }

    public static void linkedListStackTest() {
        System.out.println("+++++ LINKED LIST STACK +++++");
        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 12312);
        Employee jimmyMcGill = new Employee("Jimmy", "McGill", 2343);
        Employee mikeEhrentraut = new Employee("Mike", "Ehrentraut", 234);
        Employee jamesMay = new Employee("James", "May", 7562);
        Employee jeremyClarkson = new Employee("Jeremy", "Clarkson", 87807);
        Employee billEnd = new Employee("Bill", "End", 6757);

        LinkedStack stack = new LinkedStack();
        stack.push(janeJones);
        stack.push(johnDoe);
        stack.push(jimmyMcGill);
        stack.push(mikeEhrentraut);
        stack.push(jamesMay);
        stack.push(jeremyClarkson);
        stack.push(billEnd);

        System.out.println("== Print Stack ==");
        stack.printStack();
        System.out.println("== Stack Size ==");
        System.out.println(stack.size());
        System.out.println("== Stack Top ==");
        System.out.println(stack.peek());

        stack.pop();
        System.out.println("== Stack Top After Pop ==");
        System.out.println(stack.peek());

        System.out.println("++++++++++");
    }

    public static void palindromeStackChallenge() {
        System.out.println("+++++ PALINDROME STACK CHALLENGE +++++");
        boolean result0 = isPalindrome("Race car");
        System.out.println("\"Race car\": " + result0);
        boolean result1 = isPalindrome("Hello");
        System.out.println("\"Hello\": " + result1);
        boolean result2 = isPalindrome("Rats live on no evil star.");
        System.out.println("\"Rats live on no evil star.\": " + result2);
        boolean result3 = isPalindrome("345");
        System.out.println("\"345\": " + result3);
        boolean result4 = isPalindrome("2112");
        System.out.println("\"2112\": " + result4);
        System.out.println("++++++++++");
    }

    public static boolean isPalindrome(String input) {
        // Filter the inputs
        input = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        LinkedList<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < input.length(); i ++) {
            stack.push(input.charAt(i));
        }
        for (int j = 0; j < input.length(); j ++) {
            char charFromInput = input.charAt(j);
            char charFromStack = stack.pop();
            if (charFromStack != charFromInput) {
                return false;
            }
        }
        return true;
    }

    public static void arrayQueueTest() {
        System.out.println("+++++ ARRAY QUEUE +++++");
        ArrayQueue queue = new ArrayQueue(10);
        queue.add(new Employee("Jane", "Jones", 123));
        queue.add(new Employee("John", "Doe", 12312));
        queue.add(new Employee("Jimmy", "McGill", 2343));
        queue.add(new Employee("Mike", "Ehrentraut", 234));
        queue.add(new Employee("James", "May", 7562));
        queue.add(new Employee("Jeremy", "Clarkson", 87807));
        queue.add(new Employee("Bill", "End", 6757));

        System.out.println("== Print Queue ==");
        queue.printQueue();
        System.out.println("== Queue Size ==");
        System.out.println(queue.size());
        System.out.println("== Queue Front ==");
        System.out.println(queue.peek());

        queue.remove();
        queue.remove();
        System.out.println("== Queue Front After 2 Removes ==");
        System.out.println(queue.peek());

        System.out.println("++++++++++");
    }
}