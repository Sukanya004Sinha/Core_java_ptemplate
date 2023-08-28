package StreamApi;

import java.util.List;

public class Employee {
    private String firstName;
    private String latName;
    private static Double salary;

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", latName='" + latName + '\'' +
                ", salary=" + salary +
                ", projects=" + projects +
                '}';
    }

    private List<String> projects;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLatName() {
        return latName;
    }

    public Employee(String firstName, String latName, Double salary, List<String> projects) {
        this.firstName = firstName;
        this.latName = latName;
        this.salary = salary;
        this.projects = projects;
    }

    public void setLatName(String latName) {
        this.latName = latName;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public List<String> getProjects() {
        return projects;
    }

    public void setProjects(List<String> projects) {
        this.projects = projects;
    }
}
