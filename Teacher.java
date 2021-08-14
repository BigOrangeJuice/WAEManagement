package Homework_WAEManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Teacher extends Person {
    private String department;         //工作部门

    //以下为构造器 - 无参的
    public Teacher() {
    }

    //以下为setter and getter

    //  工作部门

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    //添加教工信息
    public void plus(List<Person> teachers, Scanner scanner) {
        System.out.println("请输入你想要添加的教工信息：");

        System.out.println("教工号：         请输入6位有效数字");
        while(this.getId() == 0) {
            long id = scanner.nextLong() ;
            if (ToolClass.digits(new Teacher(),id)){
                if(ToolClass.same(teachers, id))      this.setId(id);
                else System.out.println("该教工号已存在，请重新输入！");
            }
            else System.out.println("---抱歉，你的输入格式有误，请重新输入---");
        }
        System.out.println("姓名：         请按中国人的名字格式输入");
        while (this.getName() == null) {
            String name = scanner.next() ;
            if(ToolClass.styleName(name))    this.setName(name);
            else System.out.println("---抱歉，你的输入格式有误，请重新输入---");
        }
        System.out.println("性别：         男/女");
        while(this.getSex() == '\u0000') {
            char sex = scanner.next().charAt(0) ;
            if(ToolClass.styleSex(sex)) this.setSex(sex);
            else System.out.println("---抱歉，你的输入格式有误，请重新输入---");
        }
        System.out.println("工作部门：      格式：" + "(尽可能短而见名知义，控制在6-7个字)");
        this.setDepartment(scanner.next());

        //有多个消费品的用量和缴费情况，创建消费品集合
        List<Consumption> consumptions = new ArrayList<>();

        //用电情况
        Consumption electric = new Consumption();
        System.out.println("用电量：");

        while(electric.getConsumption() == 0.0){
            double consumption = scanner.nextDouble() ;
            if(consumption == 0.0) consumption = 0.000001 ;
            if(ToolClass.styleConsumption(consumption))    electric.setConsumption(consumption);
            else System.out.println("---抱歉，你的输入格式有误，请重新输入---");
        }
        if (electric.getConsumption() == 0.000001)  electric.setConsumption(0);
        System.out.println("是否缴费：   true - 已缴 | false - 未缴");
        String str1 = null ;
        while(str1 == null) {
            String result = scanner.next() ;
            if(result.equals("true") || result.equals("false")){
                str1 = result ;
                electric.setPay(Boolean.parseBoolean(result)) ;
            }
            else System.out.println("---抱歉，你的输入格式有误，请重新输入---");
        }
        consumptions.add(electric);

        //用水情况
        Consumption water = new Consumption();
        System.out.println("用水量：");
        while(water.getConsumption() == 0.0){
            double consumption = scanner.nextDouble() ;
            if(consumption == 0.0) consumption = 0.000001 ;
            if(ToolClass.styleConsumption(consumption))    water.setConsumption(consumption);
            else System.out.println("---抱歉，你的输入格式有误，请重新输入---");
        }
        if (water.getConsumption() == 0.000001) water.setConsumption(0);
        System.out.println("是否缴费：   true - 已缴 | false - 未缴");
        String str2 = null ;
        while(str2 == null) {
            String result = scanner.next() ;
            if(result.equals("true") || result.equals("false")){
                str2 = result ;
                water.setPay(Boolean.parseBoolean(result)) ;
            }
            else System.out.println("---抱歉，你的输入格式有误，请重新输入---");
        }
        consumptions.add(water) ;

        this.setConsumptions(consumptions);
    }

    //查询教工信息
    public static void query(List<Person> teachers, String name) {
        for (Person person : teachers) {
            if (name.equals(person.getName())) {
                System.out.println("教号：" + person.getId());
                System.out.println("姓名：" + person.getName());
                System.out.println("性别：" + person.getSex());
                if (person instanceof Teacher teacher) {
                    System.out.println("工作部门：" + teacher.department);
                }
                for (int j = 0; j < person.getConsumptions().size(); ++j) {
                    if (j == 0) {
                        System.out.println("用电量：" + person.getConsumptions().get(j).getConsumption() + " 度");
                        System.out.printf("应交电费：%.2f 元\n", person.getConsumptions().get(j).getConsumption() * 0.588);
                        System.out.println("是否缴电费：" + (person.getConsumptions().get(j).isPay() ? "已缴" : "未缴"));
                    }
                    if (j == 1) {
                        System.out.println("用水量：" + person.getConsumptions().get(j).getConsumption() + " 千升");
                        System.out.printf("应交水费：%.2f 元\n", person.getConsumptions().get(j).getConsumption() * 3.10);
                        System.out.println("是否缴水费：" + (person.getConsumptions().get(j).isPay() ? "已缴" : "未缴"));
                    }
                }
            }
        }
    }

    //显示全体教工信息
    public static void show(List<Person> teachers) {
        if (teachers.size() == 0) {
            System.out.println("-- 暂无教工信息，请先手动添加 --");
        }
        for (int i = 0; i < teachers.size(); ++i) {
            System.out.println("============ " + "No." + (i + 1) + " ============");
            System.out.println("教工号：" + teachers.get(i).getId());
            System.out.println("姓名：" + teachers.get(i).getName());
            System.out.println("性别：" + teachers.get(i).getSex());
            if (teachers.get(i) instanceof Teacher teacher) {
                System.out.println("工作部门：" + teacher.department);
            }
            for (int j = 0; j < teachers.get(i).getConsumptions().size(); ++j) {
                if (j == 0) {
                    System.out.println("用电量：" + teachers.get(i).getConsumptions().get(j).getConsumption() + " 度");
                    System.out.printf("应交电费：%.2f 元\n",teachers.get(i).getConsumptions().get(j).getConsumption()*0.588);
                    System.out.println("是否缴电费：" + (teachers.get(i).getConsumptions().get(j).isPay() ? "已缴" : "未缴"));
                }
                if (j == 1) {
                    System.out.println("用水量：" + teachers.get(i).getConsumptions().get(j).getConsumption() + " 千升");
                    System.out.printf("应交水费：%.2f 元\n",teachers.get(i).getConsumptions().get(j).getConsumption()*3.10);
                    System.out.println("是否缴水费：" + (teachers.get(i).getConsumptions().get(j).isPay() ? "已缴" : "未缴"));
                }
            }
        }
    }

    //编辑教工信息
    public static void modify(List<Person> teachers, String name,Scanner scanner) {
        for (int i = 0; i < teachers.size(); ++i) {
            if (name.equals(teachers.get(i).getName())) {
                System.out.println("请确认是否要编辑" + name + "的信息：");
                System.out.println("1 - 当然，我确定 | 2 - 我再考虑考虑");

                int target = scanner.nextInt() ;
                switch (target){
                    case 1:
                        //将元素初始化
                        teachers.get(i).setId(0);
                        teachers.get(i).setName(null);
                        teachers.get(i).setSex('\u0000');
                        teachers.get(i).setConsumptions(null);

                        System.out.println("请输入新的教工信息：");

                        System.out.println("教工号：         请输入6位有效数字");

                        while(teachers.get(i).getId() == 0) {
                            long id = scanner.nextLong() ;
                            if (ToolClass.digits(new Teacher(),id)){
                                if(ToolClass.same(teachers, id))      teachers.get(i).setId(id);
                                else System.out.println("该教工号已存在，请重新输入！");
                            }
                            else System.out.println("---抱歉，你的输入格式有误，请重新输入---");
                        }

                        System.out.println("姓名：         请按中国人的名字格式输入");
                        while (teachers.get(i).getName() == null) {
                            String name1 = scanner.next() ;
                            if(ToolClass.styleName(name1))    teachers.get(i).setName(name1);
                            else System.out.println("---抱歉，你的输入格式有误，请重新输入---");
                        }

                        System.out.println("性别：         男/女");
                        while(teachers.get(i).getSex() == '\u0000') {
                            char sex = scanner.next().charAt(0) ;
                            if(ToolClass.styleSex(sex)) teachers.get(i).setSex(sex);
                            else System.out.println("---抱歉，你的输入格式有误，请重新输入---");
                        }

                        System.out.println("工作部门：      格式：" + "(尽可能短而见名知义)");
                        if (teachers.get(i) instanceof Teacher teacher) {
                            String department = scanner.next();
                            teacher.setDepartment(department);
                        }

                        //有多个消费品的用量和缴费情况，创建消费品集合
                        List<Consumption> consumptions = new ArrayList<>();

                        //用电情况
                        Consumption electric = new Consumption();
                        System.out.println("用电量：");
                        while(electric.getConsumption() == 0.0){
                            double consumption = scanner.nextDouble() ;
                            if(ToolClass.styleConsumption(consumption))    electric.setConsumption(consumption);
                            else System.out.println("---抱歉，你的输入格式有误，请重新输入---");
                        }
                        System.out.println("是否缴费：   true - 已缴 | false - 未缴");
                        String str1 = null ;
                        while(str1 == null) {
                            String result = scanner.next() ;
                            if(result.equals("true") || result.equals("false")){
                                str1 = result ;
                                electric.setPay(Boolean.parseBoolean(result)) ;
                            }
                            else System.out.println("---抱歉，你的输入格式有误，请重新输入---");
                        }
                        consumptions.add(electric);

                        //用水情况
                        Consumption water = new Consumption();
                        System.out.println("用水量：");
                        while(water.getConsumption() == 0.0){
                            double consumption = scanner.nextDouble() ;
                            if(ToolClass.styleConsumption(consumption))    water.setConsumption(consumption);
                            else System.out.println("---抱歉，你的输入格式有误，请重新输入---");
                        }
                        System.out.println("是否缴费：   true - 已缴 | false - 未缴");
                        String str2 = null ;
                        while(str2 == null) {
                            String result = scanner.next() ;
                            if(result.equals("true") || result.equals("false")){
                                str2 = result ;
                                water.setPay(Boolean.parseBoolean(result)) ;
                            }
                            else System.out.println("---抱歉，你的输入格式有误，请重新输入---");
                        }
                        consumptions.add(water);

                        teachers.get(i).setConsumptions(consumptions);
                        System.out.println("修改成功，已自动生效");
                        break;
                    case 2:
                        break;
                }
            }
        }
    }

    //删除教工信息
    public static void delete(List<Person> teachers, String name,Scanner scanner) {
        for (int i = 0; i < teachers.size(); ++i) {
            if (name.equals(teachers.get(i).getName())) {
                System.out.println("请确认是否要删除" + name + "的信息：(删除后不可恢复，请慎重使用！)");
                System.out.println("1 - 没错，我要删除 | 2 - 我再考虑考虑");

                int target = scanner.nextInt() ;
                switch (target) {
                    case 1:
                        teachers.remove(i) ;
                        System.out.println("删除成功！");
                    case 2:
                        break;
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "department='" + department + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Teacher teacher = (Teacher) o;
        return department.equals(teacher.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), department);
    }
}
