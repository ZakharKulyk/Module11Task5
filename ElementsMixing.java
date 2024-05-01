package Task5;

import java.util.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;


public class ElementsMixing {
    public static void main(String[] args) {
        Stream<Integer> first = Stream.of(1, 2);
        Stream<Integer> second = Stream.of(8, 10, 3, 0);

        Stream<Integer> zip = zip(first, second);
        zip.forEach(number -> System.out.println(number));


    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        List<T> firstStreamAsList = first.collect(Collectors.toList());
        List<T> secondStreamAsList = second.collect(Collectors.toList());

        List<T> mixedList = new ArrayList<>();

        int sizeOfFirstList = firstStreamAsList.size();
        int sizeOfSecondList = secondStreamAsList.size();
        int min = Math.min(sizeOfFirstList, sizeOfSecondList);

        List<T> collect = firstStreamAsList.stream()
                .limit(min)
                .collect(Collectors.toList());
        List<T> collect1 = secondStreamAsList.stream()
                .limit(min)
                .collect(Collectors.toList());

        List<T> result = Stream.iterate(0, n -> n + 1)
                .limit(min)
                .flatMap(n -> Stream.of(collect.get(n), collect1.get(n)))
                .collect(Collectors.toList());

        return result.stream();
    }


}
