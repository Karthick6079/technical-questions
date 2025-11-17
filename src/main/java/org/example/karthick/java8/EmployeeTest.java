package org.example.karthick.java8;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

public class EmployeeTest {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Yanksha", 28, 123, "F", "HR", "Blore", LocalDate.of(2020, 12, 1)));
        employees.add(new Employee(2, "Francesca", 29, 120, "F", "HR", "Hyderabad", LocalDate.of(2015,8,12)));
        employees.add(new Employee(3, "Ramesh", 30, 115, "M", "HR", "Chennai", LocalDate.of(2014,7,12)));
        employees.add(new Employee(4, "Melanie", 32, 125, "F", "HR", "Chennai", LocalDate.of(2013, 11, 9)));

        employees.add(new Employee(5, "Padma", 22, 150, "F", "IT", "Noida", LocalDate.of(2013,4,23)));
        employees.add(new Employee(6, "Milad", 27, 140, "M", "IT", "Gurugram", LocalDate.of(2017, 12, 17)));
        employees.add(new Employee(7, "Uzma", 26, 130, "F", "IT", "Pune", LocalDate.of(2016, 6, 12)));
        employees.add(new Employee(8, "Ali", 23, 145, "M", "IT", "Trivandam", LocalDate.of(2015, 1, 8)));
        employees.add(new Employee(9, "Ram", 25, 160, "M", "IT", "Blore", LocalDate.of(2010, 12,8)));
        employees.add(new Employee(10, "Kumar", 25, 160, "M", "IT", "Chennai", LocalDate.of(2010, 12,8)));

        sortEmployeesByExperience(employees);
        groupEmployeesByExperienceRange(employees);
        groupEmployeesByCity(employees);
        employeesOperations(employees);

    }

    private static void sortEmployeesByExperience(List<Employee> employees) {
        List<String> sortedByExperience =  employees.stream()
                .sorted(Comparator.comparingInt((Employee e) -> Period.between(e.getJoiningDate(), LocalDate.now()).getYears()).reversed().thenComparing(Employee::getJoiningDate))
                .map(e -> e.getName() + " - " + Period.between(e.getJoiningDate(), LocalDate.now()).getYears()+ " years, joined " + e.getJoiningDate())
                .toList();

        sortedByExperience.forEach(System.out::println);
    }

    private static void employeesOperations(List<Employee> employees){
        System.out.println("---------------------------------------------");
        System.out.println("Count employees by Department");
        Map<String, Long> employeesCountByDepartmentMap = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()));

        employeesCountByDepartmentMap.forEach((key, value) -> System.out.println(key + " : "+ value));

        System.out.println("---------------------------------------------");
        System.out.println("Count male and female employees in organisation");
        Map<String, Long> maleFemaleCountMap = employees.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

        maleFemaleCountMap.forEach((key, value) -> System.out.println(key + " : "+ value));

        System.out.println("---------------------------------------------");
        System.out.println("Find the count of male and female employees in each department");
        Map<String, Map<String, Long>> maleFemaleCountByDeptMap = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDeptName, Collectors.groupingBy(Employee::getGender,Collectors.counting())));

        maleFemaleCountByDeptMap.forEach((key, value) -> {
            System.out.println(key + " : "+ value);
        });

        System.out.println("---------------------------------------------");
        System.out.println("Print department name from Employees");
        employees.stream().map(Employee::getDeptName).distinct().forEach(System.out::println);

        System.out.println("---------------------------------------------");
        System.out.println("Print employees whose age is greater than 28");
        employees.stream().filter(employee -> employee.getAge() >= 28).forEach(System.out::println);

        System.out.println("---------------------------------------------");
        System.out.println("Print employees whose age is less than 28");
        employees.stream().filter(employee -> employee.getAge() < 28).forEach(System.out::println);

        System.out.println("---------------------------------------------");
        System.out.println("Print avg age of male and female employees in organisation");
        Map<String, Double> maleFemaleAvgMap = employees.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
        maleFemaleAvgMap.forEach((key, value) -> System.out.println(key + " : "+ value));

        System.out.println("---------------------------------------------");
        System.out.println("Print the average age of male and female employees in each department");
        Map<String, Map<String, Double>> maleFemaleAvgByDeptMap = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDeptName, Collectors.groupingBy(Employee::getGender,Collectors.averagingInt(Employee::getAge))));

        maleFemaleAvgByDeptMap.forEach((key, value) -> {
            System.out.println(key + " : "+ value);
        });

        System.out.println("---------------------------------------------");
        System.out.println("Find longest serving employee in organisation");
        Optional<Employee> employee = employees.stream().max(Comparator.comparingInt((Employee e) -> Period.between(e.getJoiningDate(), LocalDate.now()).getYears()).thenComparing(Employee::getJoiningDate));
        employee.ifPresent(System.out::println);

        System.out.println("---------------------------------------------");
        System.out.println("Find recently joined employee in organisation");
        Optional<Employee> latestEmployee = employees.stream().min(Comparator.comparingInt((Employee e) -> Period.between(e.getJoiningDate(), LocalDate.now()).getYears()).thenComparing(Employee::getJoiningDate));
        latestEmployee.ifPresent(System.out::println);

        System.out.println("---------------------------------------------");
        System.out.println("Find longest serving employee in each department");
        employees.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.maxBy(Comparator.comparingInt((Employee e) -> Period.between(e.getJoiningDate(), LocalDate.now()).getYears()).thenComparing(Employee::getJoiningDate))))
                .forEach((dept_name, empOp) -> empOp.ifPresent( emp -> System.out.println(dept_name + "-->" + emp)));

        System.out.println("---------------------------------------------");
        System.out.println("Find youngest employee in each department");
        employees.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.minBy(Comparator.comparingInt((Employee e) -> Period.between(e.getJoiningDate(), LocalDate.now()).getYears()).thenComparing(Employee::getJoiningDate))))
                .forEach((dept_name, empOp) -> empOp.ifPresent( emp -> System.out.println(dept_name + "-->" + emp)));

        System.out.println("---------------------------------------------");
        System.out.println("Find department name which has highest employee");
        employees.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).ifPresent(System.out::println);

        System.out.println("---------------------------------------------");
        System.out.println("Find any employee from HR Department");
        employees.stream().filter( emp -> emp.getDeptName().equalsIgnoreCase("HR")).findAny().ifPresent(System.out::println);

        System.out.println("---------------------------------------------");
        System.out.println("Department names where the number of employees in the department is over 3 :: ");
        employees.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting())).entrySet().stream()
                .filter( entry ->entry.getValue() > 3).forEach(System.out::println);

        System.out.println("---------------------------------------------");
        System.out.println("Employees in Blore and their name is sorted");
        employees.stream().filter(emp -> emp.getCity().equalsIgnoreCase("Blore"))
                .sorted(Comparator.comparing(Employee::getName))
                .forEach(System.out::println);

        System.out.println("----------------------------------------------");
        System.out.println("Sorting a Stream by age and name fields");
        employees.stream().sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getAge)).forEach(System.out::println);

        System.out.println("----------------------------------------------");
        System.out.println("Print employees by Sorting Salary");
        employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).forEach(System.out::println);

        System.out.println("----------------------------------------------");
        System.out.println("Find 2nd highest Salary from organisation");
        employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(1).limit(1).forEach(System.out::println);

        System.out.println("----------------------------------------------");
        System.out.println("Find n-th highest Salary from organisation");
        int n = 5;
        employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(n-1).limit(1).forEach(System.out::println);

        System.out.println("----------------------------------------------");
        System.out.println("Find top 2 highest Salary for each department");

        employees.stream().collect(Collectors.groupingBy(Employee::getDeptName))
                .forEach( (dept, emps) ->{
                    emps.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).limit(2).forEach( emp -> {
                        System.out.println(dept+ " --> " + emp);
                    });
                });

        System.out.println("----------------------------------------------");
        System.out.println("Find a average salary from each department and find employees whose salary greater than that");

        Map<String, Double> avgSalary = employees.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.averagingLong(Employee::getSalary)));
        avgSalary.forEach((dept, avg) -> System.out.println(dept + " --> " + avg));

        Map<String, List<Employee>> grouped = employees.stream().filter(e -> e.getSalary() > avgSalary.get(e.getDeptName()))
                .collect(Collectors.groupingBy(Employee::getDeptName));

        grouped.forEach((dept, emps) ->{
            System.out.println(dept + " --> " + emps.stream().map(Employee::getName).collect(Collectors.joining(", ")));
        });

        employees.stream().filter( e -> e.getSalary() > avgSalary.get(e.getDeptName()))
                .collect( Collectors.groupingBy(Employee::getDeptName))
                .forEach( (dept, emps) -> emps.forEach( e -> System.out.println(dept+ " --> " + e)));

        System.out.println("----------------------------------------------");
        System.out.println("Find highest salary from each department");
        employees.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.maxBy(Comparator.comparingLong(Employee::getSalary))))
                .forEach((dept, emps) -> emps.ifPresent( emp -> System.out.println(dept+ " --> " + emp)));

        System.out.println("----------------------------------------------");
        System.out.println("Find lowest salary from each department");
        employees.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.minBy(Comparator.comparingLong(Employee::getSalary))))
                .forEach((dept, emps) -> emps.ifPresent( emp -> System.out.println(dept+ " --> " + emp)));


        System.out.println("----------------------------------------------");
        System.out.println("Find highest salary from each department(Handle Max salary ties)");

        employees.stream().collect(Collectors.groupingBy(Employee::getDeptName,
                Collectors.collectingAndThen( Collectors.toList(), list -> {
                    long maxSalary = list.stream().mapToLong(Employee::getSalary).max().orElse(0);
                    return list.stream().filter( e -> e.getSalary() == maxSalary).collect(Collectors.toList());
                }))).forEach((dept, emps) -> emps.forEach( emp -> System.out.println(dept+ " --> " + emp)));;

        System.out.println("----------------------------------------------");
        System.out.println("Sort the employee salary by each department");
        employees.stream().collect(Collectors.groupingBy(Employee::getDeptName,
                Collectors.collectingAndThen(Collectors.toList(), list -> list.stream().sorted(Comparator.comparing(Employee::getSalary)))))
                .forEach((dept, emps) -> {
                    System.out.println(dept);
                    emps.forEach(System.out::println);
                });

    }






    private static void groupEmployeesByExperienceRange(List<Employee> employees) {

        LocalDate today = LocalDate.now();

         Map<String, List<Employee>> employeesRangeByExperience = employees.stream().collect(Collectors.groupingBy((e -> {
            int years = Period.between(e.getJoiningDate(), today).getYears();

            if(years <= 5) return "0-5 Years";
            else if(years <= 10 ) return "6-10 Years";
            else if(years <= 15) return  "11-15 Years";
            else return "16+ Years";
        })));

        System.out.println("Employees group by experience range");


         employeesRangeByExperience.forEach((range, emps) ->{
             System.out.println(range + " - " + emps.stream().map(Employee::getName).collect(Collectors.joining(",")));
         });

//        sortedByExperience.forEach(System.out::println);
    }


    private static void groupEmployeesByCity(List<Employee> employees){
        System.out.println("---------------------------------------");
        Map<String, List<Employee>> groupedByCity = employees.stream()
                .collect(Collectors.groupingBy(Employee::getCity));
        groupedByCity.forEach((city, emps) -> {
            System.out.println(city + "->" + emps);
        });
        System.out.println("---------------------------------------");
        groupedByCity.forEach((city, emps) -> {
          emps.forEach( employee -> {
              System.out.println(city + " --> " + employee);
          });
        });
        System.out.println("---------------------------------------");
        System.out.println("Flatten the grouped values and list it as plain");

        groupedByCity.values().stream().flatMap(List::stream).forEach(System.out::println);
    }
}
