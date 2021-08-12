package Homework_WAEManagement;

public class Consumption {
    private double consumption;    //  用量
    private boolean pay;          //  是否缴费

    //以下为构造器 - 无参的和有参的
    public Consumption() {
    }

    public Consumption(double consumption, boolean pay) {
        this.consumption = consumption;
        this.pay = pay;
    }

    //以下为setter and getter

    //  用量
    public double getConsumption() {
        return consumption;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    //  是否缴费
    public boolean isPay() {
        return pay;
    }

    public void setPay(boolean pay) {
        this.pay = pay;
    }

    @Override
    public String toString() {
        return "Consumption{" +
                "consumption=" + consumption +
                ", pay=" + pay +
                '}';
    }
}
