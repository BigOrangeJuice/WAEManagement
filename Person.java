package Homework_WAEManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

//公共类为人，有共有的特性，让其继承
public class Person {
    private long id;                 //  学号/教工号
    private String name;            //  姓名
    private char sex;             //  性别
    private List<Consumption> consumptions = new ArrayList<>() ;    //  费用及其缴费情况


    //以下为构造器 - 无参的和有参的
    public Person() {
    }

    public Person(long id, String name, char sex, List<Consumption> consumptions) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.consumptions = consumptions;
    }

    //以下为setter and getter

    //  学号/教工号
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    //  姓名
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //  性别
    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public List<Consumption> getConsumptions() {
        return consumptions;
    }

    //  费用及其缴费情况
    public void setConsumptions(List<Consumption> consumptions) {
        this.consumptions = consumptions;
    }

    //判断此人是否存在
    public static boolean judgeExist(List<Person> people,String name){
        for(int i = 0;i < people.size();++ i){
            if(name.equals(people.get(i).name))  return true ;
        }
        return false ;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", consumptions=" + consumptions +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && sex == person.sex && name.equals(person.name) && consumptions.equals(person.consumptions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, sex, consumptions);
    }
}
