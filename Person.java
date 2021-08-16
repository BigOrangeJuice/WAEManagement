package Homework_WAEManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static Homework_WAEManagement.MyFile.writeStatistic;

//公共类为人，有共有的特性，让其继承
public class Person {
    private long id;                 //  学号/教工号
    private String name;            //  姓名
    private char sex;             //  性别
    private List<Consumption> consumptions = new ArrayList<>() ;    //  费用及其缴费情况


    //以下为构造器 - 无参的
    public Person() {
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
        for (Person person : people) {
            if (name.equals(person.name)) return true;
        }
        return false ;
    }

    //统计学生/教工使用水电情况
    public static void statistics(List<Person> people){
        if (people.size() == 0) {
            System.out.println("-- 暂无人员信息，请先手动添加 --");
        }else {

            //从大到小排序(下面使用的是内联变量的知识点)
            for (int i = 0; i < people.size() - 1; ++i) {
                for (int j = 0; j < people.size() - 1 - i; ++j) {
                    if (people.get(j).getConsumptions().get(0).getConsumption() < people.get(j + 1).getConsumptions().get(0).getConsumption()) {
                        Person temp = people.get(j);
                        people.set(j + 1, people.get(j));
                        people.set(j, temp);
                    }
                }
            }
            System.out.println("序列\t" + "姓名\t" + "用电量/度\t" + "用水量/m^3\t" + "电费/元\t" + "水费/元\t" + "是否缴电费\t" + "是否缴水费\t");
            for (int i = 0; i < people.size(); ++i) {
                System.out.print(i + 1 + "\t\t");
                System.out.print(people.get(i).getName() + "\t");
                System.out.printf("%.2f\t\t", people.get(i).getConsumptions().get(0).getConsumption());
                System.out.printf("%.2f\t\t", people.get(i).getConsumptions().get(1).getConsumption());
                System.out.printf("%.2f\t", people.get(i).getConsumptions().get(0).getConsumption() * 0.588);
                System.out.printf("%.2f\t", people.get(i).getConsumptions().get(1).getConsumption() * 3.10);
                System.out.print(people.get(i).getConsumptions().get(0).isPay() + "\t\t");
                System.out.println(people.get(i).getConsumptions().get(1).isPay());
            }
            writeStatistic(people);
        }
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
