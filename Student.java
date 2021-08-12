package Homework_WAEManagement;

import javax.swing.text.html.HTMLDocument;
import java.util.*;

public class Student extends Person {
    private String proClass;       //专业班级

    //以下为构造器 - 无参的和有参的
    public Student() {
    }

    public Student(int id, String name, char sex, List<Consumption> consumptions, String proClass) {
        super(id, name, sex, consumptions);
        this.proClass = proClass;
    }

    //以下为setter and getter

    //  专业班级

    public String getProClass() {
        return proClass;
    }

    public void setProClass(String proClass) {
        this.proClass = proClass;
    }

    //添加学生信息
    public void plus(Scanner scanner) {
        System.out.println("请输入你想要输入的学生信息：");

        System.out.println("学号：         请输入12位有效数字");
        while(this.getId() == 0) {
            long id = scanner.nextLong() ;
            if (ToolClass.digits(new Student(),id)) this.setId(id);
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
        System.out.println("专业班级：      格式：专业-班级");
        while(this.proClass == null) {
            String proClass = scanner.next() ;
            if(ToolClass.styleProClass(proClass))   this.setProClass(proClass);
            else System.out.println("---抱歉，你的输入格式有误，请重新输入---");
        }

        //有多个消费品的用量和缴费情况，创建消费品集合
        List<Consumption> consumptions = new ArrayList<>();

        Consumption consumptionE = new Consumption() ;
        consumptions.add(consumptionE) ;

        Consumption consumptionW = new Consumption() ;
        consumptions.add(consumptionW) ;

        System.out.println(consumptions.size());

        //用电情况
        Consumption electric = new Consumption();
        System.out.println("用电量：");
        while(this.getConsumptions().get(0).getConsumption() == 0.0){
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
                electric.setPay(Boolean.getBoolean(result)) ;
            }
            else System.out.println("---抱歉，你的输入格式有误，请重新输入---");
        }
        consumptionE = electric;

        //用水情况
        Consumption water = new Consumption();
        System.out.println("用水量：");
        while(this.getConsumptions().get(1).getConsumption() == 0.0){
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
                water.setPay(Boolean.getBoolean(result)) ;
            }
            else System.out.println("---抱歉，你的输入格式有误，请重新输入---");
        }
        consumptionW = water;

        this.setConsumptions(consumptions);
    }

    //查询学生信息
    public static void query(List<Person> students, String name) {
        for (int i = 0; i < students.size(); ++i) {
            if (name.equals(students.get(i).getName())) {
                System.out.println("学号：" + students.get(i).getId());
                System.out.println("姓名：" + students.get(i).getName());
                System.out.println("性别：" + students.get(i).getSex());
                System.out.println("专业班级：" + "\t");
                if (students.get(i) instanceof Student) {
                    Student student = (Student) students.get(i);
                    System.out.println("专业班级：" + student.proClass);
                }
                for (int j = 0; j < students.get(i).getConsumptions().size(); ++j) {
                    if (j == 0) {
                        System.out.println("用电量：" + students.get(i).getConsumptions().get(j).getConsumption() + " 度");
                        System.out.println("是否缴电费：" + (students.get(i).getConsumptions().get(j).isPay() == true ? "已缴" : "未缴"));
                    }
                    if (j == 1) {
                        System.out.println("用水量：" + students.get(i).getConsumptions().get(j).getConsumption() + " 千升");
                        System.out.println("是否缴水费：" + (students.get(i).getConsumptions().get(j).isPay() == true ? "已缴" : "未缴"));
                    }
                }
            }
        }
    }

    //显示全体学生信息
    public static void show(List<Person> students) {
        if (students.size() == 0) {
            System.out.println("-- 暂无学生信息，请先手动添加 --");
        }
        for (int i = 0; i < students.size(); ++i) {
            System.out.println("============ " + "No." + (i + 1) + " ============");
            System.out.println("学号：" + students.get(i).getId());
            System.out.println("姓名：" + students.get(i).getName());
            System.out.println("性别：" + students.get(i).getSex());
            System.out.println("专业班级：" + "\t");
            if (students.get(i) instanceof Student) {
                Student student = (Student) students.get(i);
                System.out.println("专业班级：" + student.proClass);
            }
            for (int j = 0; j < students.get(i).getConsumptions().size(); ++j) {
                if (j == 0) {
                    System.out.println("用电量：" + students.get(i).getConsumptions().get(j).getConsumption() + " 度");
                    System.out.println("是否缴电费：" + (students.get(i).getConsumptions().get(j).isPay() == true ? "已缴" : "未缴"));
                }
                if (j == 1) {
                    System.out.println("用水量：" + students.get(i).getConsumptions().get(j).getConsumption() + " 千升");
                    System.out.println("是否缴水费：" + (students.get(i).getConsumptions().get(j).isPay() == true ? "已缴" : "未缴"));
                }
            }
        }
    }

    //编辑学生信息
    public static void modify(List<Person> students, String name,Scanner scanner) {
        for (int i = 0; i < students.size(); ++i) {
            if (name.equals(students.get(i).getName())) {
                System.out.println("请确认是否要编辑" + name + "的信息：");
                System.out.println("1 - 当然，我确定 | 2 - 我再考虑考虑");
                int target = scanner.nextInt() ;
                switch (target){
                    case 1:
                        System.out.println("请输入新的学生信息：");

                        System.out.println("学号：         请输入12位有效数字");
                        students.get(i).setId(scanner.nextLong());
                        System.out.println("姓名：         请按中国人的名字格式输入");
                        students.get(i).setName(scanner.next());
                        System.out.println("性别：         男/女");
                        students.get(i).setSex(scanner.next().charAt(0));
                        System.out.println("专业班级：      格式：专业-班级");
                        if (students.get(i) instanceof Student) {
                            Student student = (Student) students.get(i);
                            student.proClass = scanner.next() ;
                        }

                        //有多个消费品的用量和缴费情况，创建消费品集合
                        List<Consumption> consumptions = new ArrayList<>();

                        //用电情况
                        Consumption electric = new Consumption();
                        System.out.println("用电量：");
                        electric.setConsumption(scanner.nextDouble());
                        System.out.println("是否缴费：   true - 已缴 | false - 未缴");
                        electric.setPay(scanner.nextBoolean());
                        consumptions.add(electric);

                        //用水情况
                        Consumption water = new Consumption();
                        System.out.println("用水量：");
                        water.setConsumption(scanner.nextDouble());
                        System.out.println("是否缴费：   true - 已缴 | false - 未缴");
                        water.setPay(scanner.nextBoolean());
                        consumptions.add(water);

                        students.get(i).setConsumptions(consumptions);
                        System.out.println("修改成功，已自动生效");
                        break;
                    case 2:
                        break;
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "proClass='" + proClass + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return proClass.equals(student.proClass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), proClass);
    }
}
