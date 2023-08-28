package StreamApi;


import java.util.ArrayList;
import java.util.Comparator;
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
    public static void main(String[] args) throws NoSuchFieldException {
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

        // hort Circuit operations
        List<Employee> shortCircuit =
        employees.
                stream()
                .skip(0)
                .limit(1)
                .collect(Collectors.toList());
        System.out.println(shortCircuit);

        // Finite Data
        Stream.generate(Math::random)
                .limit(5)
                .forEach(value->System.out.println(value));

        // Sorting
        List<Employee> sortedEmployees = employees.stream().sorted((o1, o2) ->
      o1.getFirstName().compareToIgnoreCase(o2.getFirstName()))
                .collect(Collectors.toList());
        System.out.println(sortedEmployees);

        // minimum and maximum
         employees.stream().max(Comparator.comparing
                (Employee::getSalary))
                .orElseThrow(NoSuchFieldException::new);

        //reduce
        Double totalSal =
        employees
                .parallelStream().map(employee -> employee.getSalary())
                .reduce(0.0,Double::sum);
        System.out.println(totalSal +"totalSal ");

    }
}
