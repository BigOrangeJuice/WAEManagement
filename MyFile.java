package Homework_WAEManagement;

import java.io.*;
import java.util.List;

//文件类
public class MyFile {

    //将全体数据写入文件
    public static void write(List<Person> people) {
        FileWriter fw = null;
        BufferedWriter bw = null;
        if ((people.get(0).getId()/ 100000000000L) > 0) {
            try {
                fw = new FileWriter("All_Student.txt");
                bw = new BufferedWriter(fw);

                bw.write("\t学号\t\t姓名\t性别\t专业班级\t\t\t用电量/度\t用水量/m^3\t电费/元\t水费/元\t是否缴电费\t是否缴水费\n");

                bw.newLine();//换行

                for (Person person : people) {
                    if (person instanceof Student student) {
                        bw.write(student.getId() + "\t");
                        bw.write(student.getName() + "\t");
                        bw.write(student.getSex() + "\t\t");
                        bw.write(student.getProClass() + "\t");
                        bw.write(student.getConsumptions().get(0).getConsumption() + "\t\t");
                        bw.write(student.getConsumptions().get(1).getConsumption() + "\t\t");
                        String EC = String.format("%.2f", student.getConsumptions().get(0).getConsumption() * 0.588);
                        bw.write(EC + "\t");
                        String WC = String.format("%.2f", student.getConsumptions().get(1).getConsumption() * 3.10);
                        bw.write(WC + "\t");
                        bw.write(student.getConsumptions().get(0).isPay() + "\t\t");
                        bw.write(student.getConsumptions().get(1).isPay() + "\t\t");
                        bw.newLine();
                    }
                }

                bw.flush();//刷新
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (fw != null) {
                    try {
                        fw.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (bw != null) {
                    try {
                        bw.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        if ((people.get(0).getId()/ 100000L) > 0) {
            try {
                fw = new FileWriter("All_Teacher.txt");
                bw = new BufferedWriter(fw);

                bw.write("教工号\t\t姓名\t性别\t工作部门\t\t\t\t用电量/度\t用水量/m^3\t电费/元\t水费/元\t是否缴电费\t是否缴水费\n");

                bw.newLine();//换行

                for (Person person : people) {
                    if (person instanceof Teacher teacher) {    //模式变量
                        bw.write(teacher.getId() + "\t\t");
                        bw.write(teacher.getName() + "\t");
                        bw.write(teacher.getSex() + "\t\t");
                        bw.write(teacher.getDepartment() + "\t\t\t");
                        bw.write(teacher.getConsumptions().get(0).getConsumption() + "\t\t");
                        bw.write(teacher.getConsumptions().get(1).getConsumption() + "\t\t");
                        String EC = String.format("%.2f", teacher.getConsumptions().get(0).getConsumption() * 0.588);
                        bw.write(EC + "\t");
                        String WC = String.format("%.2f", teacher.getConsumptions().get(1).getConsumption() * 3.10);
                        bw.write(WC + "\t");
                        bw.write(teacher.getConsumptions().get(0).isPay() + "\t\t");
                        bw.write(teacher.getConsumptions().get(1).isPay() + "\t\t");
                        bw.newLine();
                    }
                }

                bw.flush();//刷新
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (fw != null) {
                    try {
                        fw.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (bw != null) {
                    try {
                        bw.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    //将统计数据写入文件
    public static void writeStatistic(List<Person> people) {
        FileWriter fw = null;
        BufferedWriter bw = null;
        if(people.size() != 0) {
            if ((people.get(0).getId() / 100000000000L) > 0) {
                try {
                    fw = new FileWriter("Statistic_Student.txt");
                    bw = new BufferedWriter(fw);

                    bw.write("序列\t姓名\t用电量/度\t用水量/m^3\t电费/元\t水费/元\t是否缴电费\t是否缴水费\n");

                    bw.newLine();//换行

                    for (int i = 0; i < people.size(); i++) {
                        Person person = people.get(i);
                        if (person instanceof Student student) {
                            bw.write((i + 1) + "\t\t");
                            bw.write(student.getName() + "\t");
                            bw.write(student.getConsumptions().get(0).getConsumption() + "\t\t");
                            bw.write(student.getConsumptions().get(1).getConsumption() + "\t\t");
                            String EC = String.format("%.2f", student.getConsumptions().get(0).getConsumption() * 0.588);
                            bw.write(EC + "\t");
                            String WC = String.format("%.2f", student.getConsumptions().get(1).getConsumption() * 3.10);
                            bw.write(WC + "\t");
                            bw.write(student.getConsumptions().get(0).isPay() + "\t\t");
                            bw.write(student.getConsumptions().get(1).isPay() + "\t\t");
                            bw.newLine();
                        }
                    }

                    bw.flush();//刷新
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (fw != null) {
                        try {
                            fw.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (bw != null) {
                        try {
                            bw.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            if ((people.get(0).getId() / 100000L) > 0) {
                try {
                    fw = new FileWriter("Statistic_Teacher.txt");
                    bw = new BufferedWriter(fw);

                    bw.write("序列\t姓名\t用电量/度\t用水量/m^3\t电费/元\t水费/元\t是否缴电费\t是否缴水费\n");

                    bw.newLine();//换行

                    for (int i = 0; i < people.size(); i++) {
                        Person person = people.get(i);
                        if (person instanceof Student student) {
                            bw.write((i + 1) + "\t\t");
                            bw.write(student.getName() + "\t");
                            bw.write(student.getConsumptions().get(0).getConsumption() + "\t\t");
                            bw.write(student.getConsumptions().get(1).getConsumption() + "\t\t");
                            String EC = String.format("%.2f", student.getConsumptions().get(0).getConsumption() * 0.588);
                            bw.write(EC + "\t");
                            String WC = String.format("%.2f", student.getConsumptions().get(1).getConsumption() * 3.10);
                            bw.write(WC + "\t");
                            bw.write(student.getConsumptions().get(0).isPay() + "\t\t");
                            bw.write(student.getConsumptions().get(1).isPay() + "\t\t");
                            bw.newLine();
                        }
                    }

                    bw.flush();//刷新
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (fw != null) {
                        try {
                            fw.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (bw != null) {
                        try {
                            bw.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    //将文件中的数据读出
    public static void read(Person person) throws IOException{
        FileReader fr = null ;
        try {
            if(person instanceof Student) {
                fr = new FileReader("All_Student.txt");
            }
            if(person instanceof Teacher){
                fr = new FileReader("All_Teacher.txt");
            }
            char[] readData = new char[1000] ;

            while(fr.read(readData) != -1){
                fr.read(readData) ;
                System.out.print(readData);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(fr != null){
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
