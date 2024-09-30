package com.tiwari.priyanka.codejunction.Streams;

import lombok.Builder;
import lombok.Getter;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPractice {

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                Employee.builder().name("shreyas").age(20).salary(200.10).build(),
                Employee.builder().name("shyra").age(32).salary(900.10).build(),
                Employee.builder().name("bittu").age(29).salary(10.10).build(),
                Employee.builder().name("dudu").age(20).salary(100.10).build(),
                Employee.builder().name("shreyas").age(25).salary(102.10).build());






        //Write a Java program to calculate the average of a list of integers using streams.
//        List<Integer> seperateNumbers = Arrays.asList(2, 5, 6, 8, 1, 20, 19);
//        double avg = seperateNumbers.stream().mapToDouble(integer1 -> integer1.doubleValue()).average().orElse(0.0);
//        System.out.println(avg);
//
//
//        Comparator<Employee> comparingByAge = Comparator.comparing(Employee::getAge).thenComparing(Employee::getName).reversed();
//        Map<Integer, List<Double>> collect = employees.stream().collect(Collectors.groupingBy(employee -> employee.getAge(), Collectors.mapping(Employee::getSalary, Collectors.toList())));

        //Map<Boolean, List<Employee>> collect = employees.stream().collect(Collectors.partitioningBy(employee -> employee.getAge() > 21));

//        Map<String, Long> collect = employees.stream().collect(Collectors.groupingBy(StreamPractice::getAgeGroup, Collectors.counting())).entrySet().stream().filter(stringLongEntry -> stringLongEntry.getValue() > 1).collect(Collectors.toMap(stringLongEntry -> stringLongEntry.getKey(), stringLongEntry -> stringLongEntry.getValue()));
//        System.out.println(collect);
//        IntStream.range(1,11).sum();
//
//
//        List<Integer> collect1 = Stream.iterate(Arrays.asList(0, 1) ,objects -> Arrays.asList(objects.get(objects.size() - 1), objects.get(objects.size() - 2) + objects.get(objects.size() - 1))).limit(50).map(integers -> integers.get(0)).collect(Collectors.toList());
//        System.out.println(collect1);


        //System.out.println("bacabc".chars().mapToObj(value -> (char)value).collect(Collectors.toMap(Function.identity(), chars -> 1, (a, b) -> a+b , LinkedHashMap::new)).entrySet().stream().filter(integerEntry -> integerEntry.getValue()==1).findFirst().map(integerEntry -> integerEntry.getKey()).orElse('x'));
        boolean res = isAnagram("rat", "car");
        System.out.println(res);

    }

    private static String getAgeGroup(Employee employee) {
        if(employee.getAge() < 21){
            return "A";
        }else if(employee.getAge() < 31){
            return "B";
        }else{
            return "C";
        }
    }


    private static Integer foo() {
            return null;
    }

    public static boolean isAnagram(String s, String t) {
        Map<Integer, Integer> map1=  new HashMap<>();

       s.chars().forEach(value -> map1.put(value, map1.getOrDefault(value, 0) +1));
       t.chars().forEach(value -> map1.put(value, map1.getOrDefault(value, 0) -1 ));
       return map1.entrySet().stream().allMatch(entry -> entry.getValue() ==0 );
    }



}



