package Homework_WAEManagement;

import java.util.List;

public class Teacher extends Person {
    String department;         //工作部门

    //以下为构造器 - 无参的和有参的
    public Teacher() {
    }

    public Teacher(int id, String name, char sex, List<Consumption> consumptions, String department) {
        super(id, name, sex, consumptions);
        this.department = department;
    }

    //以下为setter and getter

    //  工作部门

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
