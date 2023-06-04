package optionalclass;

import java.util.Optional;

public class optionalExample {
    public static Optional<String> getName() {
        String name = "Sukanya";
        return Optional.ofNullable(name);
    }

    public static void main(String[] args) {
        // optional class is a container it represents both the  states if value is present or its empty
        // it's a way to handle null checks
        //A container object which may or may not contain a non-null value. If a value is present, isPresent() will return true and get() will return the value.
        // Additional methods that depend on the presence or absence of a contained value are provided, such as orElse() (return a default value if value not present)
        // and ifPresent() (execute a block of code if the value is present).
        String str = null;
        // String str = "java is my favourite";
//        if(str==null){
//            System.out.println("this is null object");
//        }
//        else{
//            System.out.println(str.length());
//        }

        Optional<String> optional = Optional.ofNullable(str);
        System.out.println(optional.isPresent());
        // System.out.println(optional.get());
        System.out.println(optional.orElse("No value in this object"));
        Optional<String> nameOptional = getName();
        System.out.println(nameOptional.orElse("null return"));

    }
}
