package StreamApi;

import java.awt.*;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamObject {
    public static void main(String[] args) {

        //Stream Api -
        //blank
        Stream<Object> emptyStream = Stream.empty();
        emptyStream.forEach(e -> {
            System.out.println(e);
        });
        // Arrays , object collection
        String names[] = {"Sparm", "Sukanya", "Sss", "Tom"};
        Stream<String> stream1 = Stream.of(names);
        stream1.forEach(action -> {
            System.out.println(action);
        });
        // 3 builder
        Stream<Object> streamBuilder = Stream.builder().build();
        //
        //IntStream stream = Arrays.stream(new int[] {2,3,4,5,6,7});
        IntStream  stream =  Arrays.stream(new int[] {9,8,7,6,5,4,3,2,1});
        stream.forEach(e-> {
        System.out.println(e);
    });
        List <Integer> list2 = new ArrayList<>();
        list2.add(12);
        list2.add(34);
        list2.add(33);
        list2.add(78);
        Stream<Integer> stream2 = list2.stream();
        stream2.forEach(e->{
            System.out.println(e);
        });


    }
}
