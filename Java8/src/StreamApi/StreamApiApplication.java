package StreamApi;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApiApplication {
    static List<Employee> employees = new ArrayList<>();
    static {
        employees.add(new Employee("Spence", "Lovecer", 5000.0, List.of("Project 1", "Project 2")));
        employees.add(new Employee("Sukanya", "Sinha", 6000.0, List.of("Project 2", "Project 3")));
        employees.add(new Employee("Sparm", "boy", 5500.0, List.of("Project 3", "Project 4")));

    }
    public static void main(String[] args){
        //Stream.of(employees);
        //foreach
        //employees.stream().forEach(employee -> System.out.println(employee));
//        // map
//       List<Employee> increasedSal =
//        employees.stream()
//                .map(employee -> new Employee(
//                        employee.getFirstName(),
//                        employee.getLatName(),
//                        employee.getSalary() *1.10,
//                        employee.getProjects()
//
//                )).collect(Collectors.toList());
        // map
          Set<Employee> increasedSal =
                employees.stream()
                        .map(employee -> new Employee(
                                employee.getFirstName(),
                                employee.getLatName(),
                                employee.getSalary() *1.10,
                                employee.getProjects()

                        )).collect(Collectors.toSet());
                    //  System.out.println(increasedSal);

                       //Filter
        List<Employee> filterEmployee =
        employees.stream().filter(employee -> employee.getSalary() > 1000000.0)
                .map(employee -> new Employee(
                       employee.getFirstName(),
                       employee.getLatName(),
                        employee.getSalary() *1.10,
                        employee.getProjects()

                )) .collect(Collectors.toList());
              // System.out.println(filterEmployee);

        //FindFirst
        Employee findFirstEmployee =
                employees
                        .stream()
                        .filter(employee -> employee.getSalary()> 9000.0)
                        .map(employee -> new Employee
                                        (employee.getFirstName(),
                                                employee.getLatName(),
                                                employee.getSalary() *1.10,
                                                employee.getProjects()
                                        ))
                        .findFirst().orElse(null);
           System.out.println(findFirstEmployee);

//FlatMap
        String projects =
        employees.stream()
                .map(employee -> employee.getProjects())
                .flatMap(strings -> strings.stream())
                .collect(Collectors.joining(","));
        System.out.println(projects);
    }
}
