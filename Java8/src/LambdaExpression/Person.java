package LambdaExpression;


import java.util.ArrayList;
import java.util.List;

public class Person {
    String name;
    int age;
    String emailAddress;
    Sex gender;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Sex getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", emailAddress='" + emailAddress + '\'' +
                ", gender=" + gender +
                '}';
    }

    public void setGender(Sex gender) {
        this.gender = gender;
    }

    public enum Sex {
        MALE,FEMALE;
    }

    public Person() {
    }

    public Person(String name, int age, String emailAddress, Sex gender) {
        this.name = name;
        this.age = age;
        this.emailAddress = emailAddress;
        this.gender = gender;
    }

    public void printPerson() {
        System.out.println(this.toString());
    }
    public static List<Person> generateDefaultList() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Sukanya", 20,"sukanya.sinha@gmail.com", Sex.FEMALE));
        people.add(new Person("Spence", 35,"spence@gmal.com", Sex.MALE));
        people.add(new Person("Sparm", 12,"sparm@gmail.com", Sex.MALE));
        return people;
    }


}
