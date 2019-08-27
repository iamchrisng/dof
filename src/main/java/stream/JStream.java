package stream;

import stream.model.Employee;

import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JStream {

    public static void main(String[] args) {
        String[] strings = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

        System.out.println("-------\nRunning sequential\n-------");
        run(Arrays.stream(strings).sequential());

        System.out.println("-------\nRunning parallel\n-------");
        run(Arrays.stream(strings).parallel());

        List<Employee> employees = Arrays.asList(
                new Employee(1276, "FFF", 2000.00),
                new Employee(7865, "AAA", 1200.00),
                new Employee(4975, "DDD", 3000.00),
                new Employee(4499, "CCC", 1500.00),
                new Employee(9937, "GGG", 2800.00),
                new Employee(5634, "HHH", 1100.00),
                new Employee(9276, "BBB", 3200.00),
                new Employee(6852, "EEE", 3400.00));

        System.out.println("\n-------Original List-------");
        printList(employees);

        // Using sequential stream
        long start = System.currentTimeMillis();
        List<Employee> sortedItems = employees.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .collect(Collectors.toList());
        long end = System.currentTimeMillis();

        System.out.println("\nSorted using sequential stream");
        printList(sortedItems);
        System.out.printf("Total the time taken process: %d milisec.\n", (end - start));

        // Using parallel stream
        start = System.currentTimeMillis();
        List<Employee> anotherSortedItems = employees.parallelStream()
                .sorted(Comparator.comparing(Employee::getName))
                .collect(Collectors.toList());
        end = System.currentTimeMillis();

        System.out.println("\nSorted using parallel stream");
        printList(anotherSortedItems);
        System.out.printf("Total the time taken process: %d milisec.\n", (end - start));

        double totalSal = employees.parallelStream()
                .map(e -> e.getSalary())
                .reduce(0.00, (a1, a2) -> a1 + a2);
        System.out.printf("\nTotal Salary expense: %s\n", totalSal);
        Optional<Employee> maxSal = employees.parallelStream()
                .reduce((Employee e1, Employee e2) -> e1.getSalary() < e2.getSalary() ? e2 : e1);
        maxSal.ifPresent(employee -> System.out.println(employee.toString()));
    }

    private static void printList(List<Employee> list) {
        for (Employee e : list)
            System.out.println(e.toString());
    }

    private static void run(Stream<String> stream) {
        long start, end;
        start = System.currentTimeMillis();
        stream.forEach(s -> {
            System.out.println(LocalTime.now() + " - value: " + s + " - thread: " + Thread.currentThread().getName());
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        end = System.currentTimeMillis();
        System.out.printf("Stream Time Taken: %d\n", (end - start));
    }
}
