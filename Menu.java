package Homework_WAEManagement;

//菜单类
public class Menu {
    public static void showMenu() {
        System.out.println("\n\n===================================");
        System.out.println("    Welcome to WAEManagement");
        System.out.println("===================================\n\n");
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
        System.out.println("\n\n============================================");
        System.out.println("    Welcome to WAEManagement for student");
        System.out.println("============================================\n\n");
        System.out.println("********************************************");
        System.out.println("        1 - 添加新学生信息");
        System.out.println("        2 - 查询指定学生信息");
        System.out.println("        3 - 显示全体学生信息");
        System.out.println("        4 - 编辑指定学生信息");
        System.out.println("        5 - 删除指定学生信息");
        System.out.println("        6 - 统计学生信息");
        System.out.println("        7 - 获取文本信息");
        System.out.println("        0 - 返回上一级");
        System.out.println("********************************************");
    }

    public static void teacherShowMenu() {
        System.out.println("\n\n============================================");
        System.out.println("    Welcome to WAEManagement for teacher");
        System.out.println("============================================\n\n");
        System.out.println("********************************************");
        System.out.println("        1 - 添加新教工信息");
        System.out.println("        2 - 查询指定教工信息");
        System.out.println("        3 - 显示全体教工信息");
        System.out.println("        4 - 编辑指定教工信息");
        System.out.println("        5 - 删除指定教工信息");
        System.out.println("        6 - 统计教工信息");
        System.out.println("        7 - 获取文本信息");
        System.out.println("        0 - 返回上一级");
        System.out.println("********************************************");
    }
}
