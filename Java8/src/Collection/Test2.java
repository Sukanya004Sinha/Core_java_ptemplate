package Collection;

import java.util.ArrayList;

public class Test2 {
    public static <object> void main(String[] args) {
        ArrayList al = new ArrayList();
        al.add(new Emp(111, "sukanya"));
        al.add(new Student(1, "Spence"));
        al.add("sparm");
        al.add(10);
        al.add(null);
        System.out.println(al.toString());
        for(Object o: al){
            if(o instanceof Emp){
                Emp e= (Emp) o;
                System.out.println(e.eid+ ""+e.ename);
            }
            if(o instanceof  Student){
                Student s = (Student) o;
                System.out.println(s.sid+ s.name);
            }
            if( o instanceof  Integer)
            {
                System.out.println(0);
            }
            if(o instanceof String){
                System.out.println(o);
            }
            if(o==null){
                System.out.println(o);
            }

            {

            }

        }

    }
}
