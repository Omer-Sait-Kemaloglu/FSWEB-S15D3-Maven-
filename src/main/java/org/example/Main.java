package org.example;

import org.example.entity.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Employee> employees = new LinkedList<>(List.of(
                new Employee(1, "Dogancan", "Kinik"),
                new Employee(1, "Dogancan", "Kinik"),
                new Employee(2, "Seyyit Battal", "Arvas"),
                new Employee(2, "Seyyit Battal", "Arvas"),
                new Employee(3, "Anil", "Ensari"),
                new Employee(3, "Anil", "Ensari"),
                new Employee(4, "Burak", "Cevizli"),
                null
        ));

        System.out.println("Duplicates: " + findDuplicates(employees));
        System.out.println("Uniques: " + findUniques(employees));
        System.out.println("After Removing Duplicates: " + removeDuplicates(employees));
    }

    public static List<Employee> findDuplicates(List<Employee> employees) {
        Map<Employee, Integer> countMap = new HashMap<>();
        List<Employee> duplicates = new ArrayList<>();

        for (Employee emp : employees) {
            if (emp == null) continue;
            countMap.put(emp, countMap.getOrDefault(emp, 0) + 1);
        }

        for (Map.Entry<Employee, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > 1) {
                duplicates.add(entry.getKey());
            }
        }

        return duplicates;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> employees) {
        Map<Employee, Integer> countMap = new HashMap<>();
        Map<Integer, Employee> uniqueMap = new HashMap<>();

        for (Employee emp : employees) {
            if (emp == null) continue;
            countMap.put(emp, countMap.getOrDefault(emp, 0) + 1);
        }

        for (Employee emp : countMap.keySet()) {
            if (countMap.get(emp) == 1) {
                uniqueMap.put(emp.getId(), emp);
            }
        }

        return uniqueMap;
    }

    public static List<Employee> removeDuplicates(List<Employee> employees) {
        Map<Employee, Integer> countMap = new HashMap<>();
        List<Employee> result = new ArrayList<>();

        for (Employee emp : employees) {
            if (emp == null) continue;
            countMap.put(emp, countMap.getOrDefault(emp, 0) + 1);
        }

        for (Map.Entry<Employee, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }

        return result;
    }
}
