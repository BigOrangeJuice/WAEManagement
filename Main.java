package Homework_WAEManagement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Homework_WAEManagement.Menu.*;
import static Homework_WAEManagement.MyFile.read;
import static Homework_WAEManagement.MyFile.write;
import static Homework_WAEManagement.Person.judgeExist;

public class Main {

    public static final int MAX = 1000;//人数上限

    public static void main(String[] args) {

        //提前创建好学生集合和教工集合
        List<Person> students = new ArrayList<>(MAX);
        List<Person> teachers = new ArrayList<>(MAX);

        while (true) {
            //主选择界面
            showMenu();
            int select ;
            Scanner sc = new Scanner(System.in);
            select = sc.nextInt();
            switch (select) {
                case 1 -> {
                    //学生选择界面
                    studentShowMenu();
                    int S_select ;
                    S_select = sc.nextInt();
                    switch (S_select) {
                        case 1://添加功能
                            Student student = new Student();
                            student.plus(students, sc);
                            students.add(student);
                            write(students);
                            break;
                        case 2://查询功能
                            System.out.println("请输入你想要查找的学生姓名：");
                            String nameQuery = sc.next();
                            if (judgeExist(students, nameQuery)) {
                                System.out.println("找到此人！");
                                Student.query(students, nameQuery);
                            } else System.out.println("抱歉，此人不存在！");
                            break;
                        case 3://显示功能
                            Student.show(students);
                            break;
                        case 4://编辑功能
                            System.out.println("请输入你想要编辑的学生姓名：");
                            String nameModify = sc.next();
                            if (!judgeExist(students, nameModify)) {
                                System.out.println("抱歉，此人不存在！");
                            } else {
                                System.out.println("找到此人！");
                                Student.modify(students, nameModify, sc);
                            }
                            write(students);
                            break;
                        case 5://删除功能
                            System.out.println("请输入你想要删除的学生姓名：");
                            String nameDelete = sc.next();
                            if (!judgeExist(students, nameDelete)) {
                                System.out.println("抱歉，此人不存在！");
                            } else {
                                System.out.println("找到此人！");
                                Student.delete(students, nameDelete, sc);
                            }
                            write(students);
                            break;
                        case 6://统计功能
                            Student.statistics(students);
                            break;
                        case 7://获取功能
                            try {
                                read(new Student());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        case 0://返回上一级
                            continue;
                        default:
                            System.out.println("尊敬的用户，您的输入有误，请按照规定重新输入！");
                            break;
                    }
                }
                case 2 -> {
                    //教工选择界面
                    teacherShowMenu();
                    int T_select ;
                    T_select = sc.nextInt();
                    switch (T_select) {
                        case 1://添加功能
                            Teacher teacher = new Teacher();
                            teacher.plus(students, sc);
                            teachers.add(teacher);
                            write(teachers);
                            break;
                        case 2://查询功能
                            System.out.println("请输入你想要查找的教工姓名：");
                            String nameQuery = sc.next();
                            if (!judgeExist(teachers, nameQuery)) {
                                System.out.println("抱歉，此人不存在！");
                            } else {
                                System.out.println("找到此人！");
                                Teacher.query(teachers, nameQuery);
                            }
                            break;
                        case 3://显示功能
                            Teacher.show(teachers);
                            break;
                        case 4://编辑功能
                            System.out.println("请输入你想要编辑的教工姓名：");
                            String nameModify = sc.next();
                            if (judgeExist(teachers, nameModify)) {
                                System.out.println("找到此人！");
                                Teacher.modify(teachers, nameModify, sc);
                            } else System.out.println("抱歉，此人不存在！");
                            write(teachers);
                            break;
                        case 5://删除功能
                            System.out.println("请输入你想要删除的教工姓名：");
                            String nameDelete = sc.next();
                            if (!judgeExist(teachers, nameDelete)) {
                                System.out.println("抱歉，此人不存在！");
                            } else {
                                System.out.println("找到此人！");
                                Teacher.delete(teachers, nameDelete, sc);
                            }
                            write(teachers);
                            break;
                        case 6://统计功能
                            Teacher.statistics(teachers);
                            break;
                        case 7://获取功能
                            try {
                                read(new Teacher());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        case 0://返回上一级
                            continue;
                        default:
                            System.out.println("尊敬的用户，您的输入有误，请按照规定重新输入！");
                            break;
                    }
                }
                case 0 -> {
                    System.out.println("感谢你的使用，欢迎再来！！！");
                    return;
                }
                default -> System.out.println("抱歉您的输入有误，请按照规定重新输入！");
            }
        }

    }
}
