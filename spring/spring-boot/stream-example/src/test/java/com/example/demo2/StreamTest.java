package com.example.demo2;

import com.example.demo2.dto.Employee;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class StreamTest {

    static Employee[] arrayOfEmps = {
            new Employee(1, "Jeff Bezos", 100000.0),
            new Employee(2, "Bill Gates", 200000.0),
            new Employee(3, "Mark Zuckerberg", 300000.0)
    };


    @Test
    void contextLoads() {



        List<Employee> empList = Arrays.asList(arrayOfEmps);
        empList.stream().forEach(e -> e.salaryIncrement(10.0));

        assertThat(empList.get(0).getSalary(), is(110000.0));

    }

    @Test
    public void mapTest(){


        List<Long> ids =  Stream.of(arrayOfEmps).map(Employee::getId).collect(Collectors.toList());


        assertThat(2L, is(ids.get(1)));

    }

    @Test
    public void whenFilterEmployeesThenGetFilterdStream(){

       List<Long> ids = Stream.of(arrayOfEmps).map(Employee::getId).filter(id -> id > 1).collect(Collectors.toList());

       for(Long id : ids){
           System.out.println(id);
       }

    }

    @Test
    public void whenStreamToArrayThenGetArray(){
        Employee[] employees = Arrays.asList(arrayOfEmps).stream().toArray(Employee[]::new);

        assertThat(employees[0].getId(), is(1L));
        assertThat(employees[1].getId(), is(2L));
        assertThat(employees[2].getId(), is(3L));
    }

    @Test
    public void whenIncrementSalaryUsingPeekThenApplyNewSalary(){

        List<Employee> empList = Arrays.asList(arrayOfEmps);

        empList.stream().peek(e -> e.salaryIncrement(10.0)).peek(System.out::println).collect(Collectors.toList());
    }

    @Test
    public void whenStreamCountThenGetElementCount(){
        Long empCount = Arrays.asList(arrayOfEmps).stream().filter(e -> e.getSalary() > 200000).count();

        assertThat(empCount, is(1L));
    }

    @Test
    public void whenLimitInfiniteStreamThenGetFiniteElements(){

        Integer[] numbers = {1,2,3,4,5,6,7,8,9,10};

        List<Integer> collect =  Stream.of(numbers).skip(3).limit(5).collect(Collectors.toList());

        for(Integer number : collect){
            System.out.println(number);
        }


        assertThat(collect, is(Arrays.asList(4,5,6,7,8)));
    }

    @Test
    public void whenFindFirstThenGetFirstEmployeeInStream(){

        Employee employee = Stream.of(arrayOfEmps).filter(e -> e != null).filter(e -> e.getSalary() > 100000).findFirst().orElse(null);


        assertThat(employee.getSalary(), is(200000.0));
    }

    @Test
    public void whenSortStreamThenGetSortedStream(){
        List<Employee> employees = Arrays.asList(arrayOfEmps).stream().sorted((e1,e2) -> e1.getName().compareTo(e2.getName())).collect(Collectors.toList());

        assertThat(employees.get(0).getName(), is("Bill Gates"));
    }

    @Test
    public void whenFindMinThenGetMinElementFormStream(){
        List<Integer> intList = Arrays.asList(1,3,5,7,10);

        boolean allEven = intList.stream().allMatch(i -> i%2 == 0);
        boolean oneEven = intList.stream().anyMatch(i -> i%2 == 0);
        boolean noneMultipleOfThree = intList.stream().noneMatch(i -> i%3 == 0);

        assertThat(allEven, is(false));
        assertThat(oneEven, is(true));
        assertThat(noneMultipleOfThree, is(false));
    }

    @Test
    public void whenStreamGroupingByThenGetMap(){
        Map<Character, List<Employee>> groupByAlphabet = Arrays.asList(arrayOfEmps).stream().collect(
                Collectors.groupingBy(e -> new Character(e.getName().charAt(0))));

//        for (Map.Entry<Character, List<Employee>> entry : groupByAlphabet.entrySet())
//            System.out.println("Key = " + entry.getKey() +
//                    ", Value = " + entry.getValue());

        assertThat(groupByAlphabet.get('B').get(0).getName(), is("Bill Gates"));



    }



}
