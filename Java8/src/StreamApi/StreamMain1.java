package StreamApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMain1 {
    public static void main(String[] args) {

        //a) create a list and filter all even numbers from list
        // List<Integer> list1 = List.of(2,4,50,44,6,11,23,556,43,22,46);
        //list1.add(45); we cant add in it cos list.of is a immutable
//2 way to create a list
        List<Integer> list2 = new ArrayList<>();
        list2.add(12);
        list2.add(24);
        list2.add(43);
        list2.add(99);
        list2.add(191);
// 3 way to create a list
        // List<Integer> list3 =   Arrays.asList(23,45,67,88,89,65,34);
        // without stream
        List<Integer> listEven = new ArrayList<>();
        for (Integer i : list2) {
            if (i % 2 == 0) {
                listEven.add(i);
            }
        }
        System.out.println(list2);
        System.out.println(listEven);

        //using stream API
       Stream<Integer> stream =  list2.stream();
       List<Integer> newList= stream.filter(i-> i%2==0).collect(Collectors.toList());
       System.out.println(newList);
       List<Integer> newList1 = list2.stream().filter(i-> i%2==0).collect(Collectors.toList());
        System.out.println(newList1);
        List<Integer> newList2 = list2.stream().filter(i-> i>90).collect(Collectors.toList());
       System.out.println(newList2);
    }
}