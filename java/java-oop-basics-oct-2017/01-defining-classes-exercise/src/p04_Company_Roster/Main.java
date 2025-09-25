package p04_Company_Roster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        List<Employee> employees = new ArrayList<>();
        Employee employee = null;
        while (n-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");
            if (tokens.length == 4) {
                employee = new Employee(tokens[0], Double.parseDouble(tokens[1]), tokens[2], tokens[3]);
                employees.add(employee);

            } else if (tokens.length == 5) {
                if (tokens[4].contains("@")) {
                    employee = new Employee(tokens[0], Double.parseDouble(tokens[1]), tokens[2], tokens[3], tokens[4]);
                    employees.add(employee);
                } else {
                    employee = new Employee(tokens[0], Double.parseDouble(tokens[1]),
                            tokens[2], tokens[3], Integer.parseInt(tokens[4]));
                    employees.add(employee);
                }
            } else if (tokens.length == 6) {
                employee = new Employee(tokens[0], Double.parseDouble(tokens[1]),
                        tokens[2], tokens[3], tokens[4], Integer.parseInt(tokens[5]));
                employees.add(employee);
            }
        }

        String highestAvgSalaries = employees
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)))
                .entrySet()
                .stream()
                .max(Comparator.comparingDouble(Map.Entry::getValue))
                .get()
                .getKey();

        System.out.printf("Highest Average Salary: %s\n", highestAvgSalaries);

        System.out.println(employees
                .stream()
                .filter(e -> e.getDepartment().equals(highestAvgSalaries))
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .map(Employee::toString)
                .collect(Collectors.joining("\n")));
    }
}
