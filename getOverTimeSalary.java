public class getOverTimeSalary {
    //一月工作天数
    static final int workDays = 26;

    //一天工作小时数
    static final int workHours = 8;

    public static float getOverTimeSalary(int monthlySalary, int overtimeHours){
        float extraSalary = 0;
        if(overtimeHours >= 10){
            extraSalary = 4 * overtimeHours;
        }
        else {
            float hourSalary = (float) (monthlySalary / workDays / workHours * 1.5);
            extraSalary = hourSalary * overtimeHours;
        }

        return extraSalary;
    }

    public static void main(String[] args){
        int monthlySalary = 1000;
        int overtimeHours = 15;
        float money =  getOverTimeSalary(monthlySalary, overtimeHours);

        System.out.printf("%d月薪的加班费，加班%d小时的加班费为：%s", monthlySalary,
                overtimeHours, money);
    }
}
