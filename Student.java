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
    public void plus(List<Person> students,Scanner scanner) {
        System.out.println("请输入你想要输入的学生信息：");

        System.out.println("学号：         请输入12位有效数字");
        while(this.getId() == 0) {
            long id = scanner.nextLong() ;
            if (ToolClass.digits(new Student(),id)){
                if(!ToolClass.same(students,id))      this.setId(id);
                else System.out.println("该学号已存在，请重新输入！");
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
        System.out.println("专业班级：      格式：专业-班级");
        while(this.proClass == null) {
            String proClass = scanner.next() ;
            if(ToolClass.styleProClass(proClass))   this.setProClass(proClass);
            else System.out.println("---抱歉，你的输入格式有误，请重新输入---");
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
                electric.setPay(Boolean.getBoolean(result)) ;
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
                water.setPay(Boolean.getBoolean(result)) ;
            }
            else System.out.println("---抱歉，你的输入格式有误，请重新输入---");
        }
        consumptions.add(water) ;

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
                        System.out.printf("应交电费：%.2f 元\n",students.get(i).getConsumptions().get(j).getConsumption()*0.588);
                        System.out.println("是否缴电费：" + (students.get(i).getConsumptions().get(j).isPay() == true ? "已缴" : "未缴"));
                    }
                    if (j == 1) {
                        System.out.println("用水量：" + students.get(i).getConsumptions().get(j).getConsumption() + " 千升");
                        System.out.printf("应交水费：%.2f 元\n",students.get(i).getConsumptions().get(j).getConsumption()*3.10);
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
                    System.out.printf("应交电费：%.2f 元\n",students.get(i).getConsumptions().get(j).getConsumption()*0.588);
                    System.out.println("是否缴电费：" + (students.get(i).getConsumptions().get(j).isPay() == true ? "已缴" : "未缴"));
                }
                if (j == 1) {
                    System.out.println("用水量：" + students.get(i).getConsumptions().get(j).getConsumption() + " 千升");
                    System.out.printf("应交水费：%.2f 元\n",students.get(i).getConsumptions().get(j).getConsumption()*3.10);
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
                        //将元素初始化
                        students.get(i).setId(0);
                        students.get(i).setName(null);
                        students.get(i).setSex('\u0000');
                        students.get(i).setConsumptions(null);

                        System.out.println("请输入新的学生信息：");

                        System.out.println("学号：         请输入12位有效数字");

                        while(students.get(i).getId() == 0) {
                            long id = scanner.nextLong() ;
                            if (ToolClass.digits(new Student(),id)){
                                if(!ToolClass.same(students,id))      students.get(i).setId(id);
                                else System.out.println("该学号已存在，请重新输入！");
                            }
                            else System.out.println("---抱歉，你的输入格式有误，请重新输入---");
                        }

                        System.out.println("姓名：         请按中国人的名字格式输入");
                        while (students.get(i).getName() == null) {
                            String name1 = scanner.next() ;
                            if(ToolClass.styleName(name1))    students.get(i).setName(name1);
                            else System.out.println("---抱歉，你的输入格式有误，请重新输入---");
                        }

                        System.out.println("性别：         男/女");
                        while(students.get(i).getSex() == '\u0000') {
                            char sex = scanner.next().charAt(0) ;
                            if(ToolClass.styleSex(sex)) students.get(i).setSex(sex);
                            else System.out.println("---抱歉，你的输入格式有误，请重新输入---");
                        }

                        System.out.println("专业班级：      格式：专业-班级");
                        if (students.get(i) instanceof Student) {
                            Student student = (Student) students.get(i);
                            while (student.proClass == null) {
                                String proClass = scanner.next();
                                if (ToolClass.styleProClass(proClass)) student.setProClass(proClass);
                                else System.out.println("---抱歉，你的输入格式有误，请重新输入---");
                            }
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
                                electric.setPay(Boolean.getBoolean(result)) ;
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
                                water.setPay(Boolean.getBoolean(result)) ;
                            }
                            else System.out.println("---抱歉，你的输入格式有误，请重新输入---");
                        }
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

    //删除学生信息
    public static void delete(List<Person> students, String name,Scanner scanner) {
        for (int i = 0; i < students.size(); ++i) {
            if (name.equals(students.get(i).getName())) {
                System.out.println("请确认是否要删除" + name + "的信息：(删除后不可恢复，请慎重使用！)");
                System.out.println("1 - 没错，我要删除 | 2 - 我再考虑考虑");

                int target = scanner.nextInt() ;
                switch (target) {
                    case 1:
                        students.remove(i) ;
                        System.out.println("删除成功！");
                    case 2:
                        break;
                }
            }
        }
    }

    //统计学生使用水电情况
    public static void statistics(List<Person> students){
        if (students.size() == 0) {
            System.out.println("-- 暂无学生信息，请先手动添加 --");
        }

        List<Person> students1 = students ;

        //从大到小排序
        for(int i = 0;i < students1.size() - 1;++ i){
            for(int j = 0;j < students1.size() - 1 - i;++ j){
                if(students1.get(j).getConsumptions().get(0).getConsumption() < students1.get(j+1).getConsumptions().get(0).getConsumption()){
                    Person temp = students1.get(j) ;
                    students1.set(j+1,students1.get(j)) ;
                    students1.set(j,temp) ;
                }
            }
        }
        System.out.println("序列\t" + "姓名\t" + "用电量/度\t" + "用水量/m^3\t" + "电费/元\t" + "水费/元\t" + "是否缴电费\t" + "是否缴水费\t" );
        for(int i = 0;i < students1.size();++ i){
            System.out.print(i+1 + "\t\t");
            System.out.print(students1.get(i).getName() + "\t");
            System.out.printf("%.2f\t\t",students1.get(i).getConsumptions().get(0).getConsumption());
            System.out.printf("%.2f\t\t",students1.get(i).getConsumptions().get(1).getConsumption());
            System.out.printf("%.2f\t",students1.get(i).getConsumptions().get(0).getConsumption()*0.588);
            System.out.printf("%.2f\t",students1.get(i).getConsumptions().get(1).getConsumption()*3.10);
            System.out.print(students1.get(i).getConsumptions().get(0).isPay() + "\t\t");
            System.out.println(students1.get(i).getConsumptions().get(1).isPay());
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
