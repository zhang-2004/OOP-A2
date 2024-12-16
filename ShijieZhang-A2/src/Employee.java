public class Employee extends Person{  //主题公园工作人员

    private String jobPosition;  // 工作职位
    private int salary;  //薪资

    public Employee() {
    }

    public Employee(String name, String gender, int age, String jobPosition, int salary) {
        super(name, gender, age);
        this.jobPosition = jobPosition;
        this.salary = salary;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return  "Employee:" + super.toString() + "\t" + jobPosition + "\t" + salary;
    }
}
