package Collection;

import java.util.ArrayList;

public class Test3 {
    public static void main(String[] args){
        ArrayList al = new ArrayList();
        al.add(new Emp(111, "sukanya"));
        al.add(new Student(1,"Sparm"));
        Student s = (Student) al.get(1);
        System.out.println(s.sid+ ""+s.name);
        Object o = al.get(1);
        if(o instanceof Student)
        {
            Student s1 = (Student) o;
                    System.out.println(s1.sid+"" +s1.name);
        }

    }
}
