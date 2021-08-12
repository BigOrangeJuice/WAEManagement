package Homework_WAEManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static final int MAX = 1000;//人数上限

    public static void main(String[] args) {

        //提前创建好学生集合和教工集合
        List<Person> students = new ArrayList<>(MAX);
        List<Teacher> teachers = new ArrayList<>(MAX);

        while (true) {
            //主选择界面
            showMenu();
            int select = 0;
            Scanner sc = new Scanner(System.in);
            select = sc.nextInt();
            switch (select) {
                case 1:
                    //学生选择界面
                    studentShowMenu();
                    int S_select = 0;
                    S_select = sc.nextInt();
                    switch (S_select) {
                        case 1://添加功能
                            Student student = new Student();
                            student.plus(students, sc);
                            students.add(student);
                            break;
                        case 2://查询功能
                            System.out.println("请输入你想要查找的学生姓名：");
                            String nameQuery = sc.next();
                            if (Person.judgeExist(students, nameQuery)) {
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
                            if (Person.judgeExist(students, nameModify)) {
                                System.out.println("找到此人！");
                                Student.modify(students, nameModify, sc);
                            } else System.out.println("抱歉，此人不存在！");
                            break;
                        case 5://删除功能
                            System.out.println("请输入你想要删除的学生姓名：");
                            String nameDelete = sc.next();
                            if (Person.judgeExist(students, nameDelete)) {
                                System.out.println("找到此人！");
                                Student.delete(students, nameDelete, sc);
                            } else System.out.println("抱歉，此人不存在！");
                            break;
                        case 6://统计功能
                            Student.statistics(students);
                            break;
                        case 7://保存功能
                            break;
                        case 8://检测功能
                            break;
                        case 0://返回上一级
                            continue;
                        default:
                            System.out.println("尊敬的用户，您的输入有误，请按照规定重新输入！");
                            break;
                    }
                    break;
                case 2:
                    teacherShowMenu();
                    int T_select = 0;
                    T_select = sc.nextInt();
                    switch (T_select) {
                        case 1://添加功能
                            break;
                        case 2://查询功能
                            break;
                        case 3://显示功能
                            break;
                        case 4://编辑功能
                            break;
                        case 5://删除功能
                            break;
                        case 6://统计功能
                            break;
                        case 7://保存功能
                            break;
                        case 8://检测功能
                            break;
                        case 0://返回上一级
                            continue;
                    }
                    break;
                case 0:
                    System.out.println("感谢您的使用，欢迎再来！");
                    return;
                default:
                    System.out.println("尊敬的用户，您的输入有误，请按照规定重新输入！");
                    break;
            }
        }
    }

    public static void showMenu() {
        System.out.println("\n\n    Welcome to WAEManagement\n\n");
        System.out.println("***********************************");
        System.out.println("        近日水电费情况：");
        System.out.println("        水费：3.10 元/m^3");
        System.out.println("        电费：0.588 元/度");
        System.out.println("        节水节电从我做起！！！");
        System.out.println("***********************************");
        System.out.println("***********************************");
        System.out.println("        1 - 学生");
        System.out.println("        2 - 教工");
        System.out.println("        0 - 退出系统");
        System.out.println("***********************************");
    }

    public static void studentShowMenu() {
        System.out.println("\n\n    Welcome to WAEManagement for student\n\n");
        System.out.println("********************************************");
        System.out.println("        1 - 添加新学生信息");
        System.out.println("        2 - 查询指定学生信息");
        System.out.println("        3 - 显示全体学生信息");
        System.out.println("        4 - 编辑指定学生信息");
        System.out.println("        5 - 删除指定学生信息");
        System.out.println("        6 - 统计学生信息");
        System.out.println("        7 - 保存学生信息");
        System.out.println("        8 - 读取学生信息");
        System.out.println("        0 - 返回上一级");
        System.out.println("********************************************");
    }

    public static void teacherShowMenu() {
        System.out.println("\n\n    Welcome to WAEManagement for teacher\n\n");
        System.out.println("********************************************");
        System.out.println("        1 - 添加新教工信息");
        System.out.println("        2 - 查询指定教工信息");
        System.out.println("        3 - 显示全体教工信息");
        System.out.println("        4 - 编辑指定教工信息");
        System.out.println("        5 - 删除指定教工信息");
        System.out.println("        6 - 统计教工信息");
        System.out.println("        7 - 保存教工信息");
        System.out.println("        8 - 读取教工信息");
        System.out.println("        0 - 返回上一级");
        System.out.println("********************************************");
    }
}
