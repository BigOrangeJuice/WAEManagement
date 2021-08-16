package Homework_WAEManagement;

import java.util.List;

//工具类
public class ToolClass {
    //判断位数
    public static boolean digits(Person person,long id) {
        if (person instanceof Student) {
            byte number = (byte) (id / 100000000000L);
            if (number > 0 && number < 10) return true;
        }
        if (person instanceof Teacher) {
            byte number = (byte) (id / 100000L);
            return number > 0 && number < 10;
        }
        return false ;
    }

    //学号/教工号查重
    public static boolean same(List<Person> people, long id) {
        for (Person person : people) {
            if (id == person.getId()) return false;
        }
        return true;
    }

    //判断名字格式
    public static boolean styleName(String name){
        char[] array = name.toCharArray() ;
        for (char c : array) {
            if (!isChinese(c)) return false;
        }
        return true ;
    }

    //判断性别格式
    public static boolean styleSex(char sex){
        if (isChinese(sex)){
            return sex == '男' || sex == '女';
        }
        return false ;
    }

    //判断是否为汉字
    public static boolean isChinese(char ch){
        return String.valueOf(ch).matches("[\u4e00-\u9fa5]") ;
    }

    //判断专业班级的格式
    public static boolean styleProClass(String proClass){
        return proClass.indexOf('-') != -1;
    }

    //判断用水量和用电量的格式
    public static boolean styleConsumption(double consumption){
        return !(consumption < 0);
    }
}
