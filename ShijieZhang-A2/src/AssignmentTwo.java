import java.util.Collections;

public class AssignmentTwo {

    public static void main(String[] args) {

        AssignmentTwo assignmentTwo = new AssignmentTwo();
        assignmentTwo.partThree();
        assignmentTwo.partFourA();
        assignmentTwo.partFourB();
        assignmentTwo.partFive();
        assignmentTwo.partSix();
        assignmentTwo.partSeven();
    }

    public void partThree(){

        //创建工作人员对象
        Employee employee1 = new Employee("Tom","male",32,"Roller_Coaster_events",8000);//过山车工作人员
        Employee employee2 = new Employee("Sam","male",24,"Water_sports_events",10000);//水上运动工作人员

        //创建设施对象
        Ride ride = new Ride("Roller_Coaster", 1,employee1);   //设施--过山车   运行中
        Ride ride1 = new Ride("Water_sports", 2,employee2);   //设施--水上运动   运行中

        // 创建游客对象
        Visitor v1 = new Visitor("Landon","male", 36, "adult_ticket",   "2024-10-14","Roller_Coaster","V00000001","17769627352");
        Visitor v2 = new Visitor("Shakti",    "female", 30, "adult_ticket",   "2024-11-21","Water_sports",  "V00000002","12241431573");
        Visitor v3 = new Visitor("Dawson",     "male", 18, "student_ticket", "2024-12-13","Water_sports",  "V00000003","1303542514");
        Visitor v4 = new Visitor("Gracia",    "female", 6,  "child_ticket",   "2024-11-17","Roller_Coaster","V00000004","12569875586");
        Visitor v5 = new Visitor("Hollis",     "male", 55, "senior_ticket",  "2024-10-24","Roller_Coaster","V00000005","19155778899");

        // 添加游客到队列
        ride.addVisitorToQueue(v1);
        ride.addVisitorToQueue(v2);
        ride.addVisitorToQueue(v3);
        ride.addVisitorToQueue(v4);
        ride.addVisitorToQueue(v5);

        // 打印队列中的游客
        ride.printQueue();

        // 移除一个游客
        ride.removeVisitorFromQueue(v1);

        // 再次打印队列中的游客
        ride.printQueue();

    }

    public void partFourA(){

        //创建工作人员对象
        Employee employee = new Employee("Tom","male",32,"Roller_Coaster_Rider",8000);  //过山车工作人员
        Employee employee2 = new Employee("Sam","male",24,"Water_sports_events",10000);//水上运动工作人员

        //创建设施对象
        Ride ride = new Ride("Roller_Coaster", 1,employee);
        Ride ride1 = new Ride("Water_sports", 2,employee2);

        //创建游客对象
        Visitor v1 = new Visitor("Landon","male", 36, "adult_ticket",   "2024-10-14","Roller_Coaster","V00000001","17769627352");
        Visitor v2 = new Visitor("Shakti",    "female", 30, "adult_ticket",   "2024-11-21","Water_sports",  "V00000002","12241431573");
        Visitor v3 = new Visitor("Dawson",     "male", 18, "student_ticket", "2024-12-13","Water_sports",  "V00000003","1303542514");
        Visitor v4 = new Visitor("Gracia",    "female", 6,  "child_ticket",   "2024-11-17","Roller_Coaster","V00000004","12569875586");
        Visitor v5 = new Visitor("Hollis",     "male", 55, "senior_ticket",  "2024-10-24","Roller_Coaster","V00000005","19155778899");

        //添加游客至队列
        ride.addVisitorToQueue(v1);
        ride.addVisitorToQueue(v2);
        ride.addVisitorToQueue(v3);
        ride.addVisitorToQueue(v4);
        ride.addVisitorToQueue(v5);

        //将游客添加至历史记录中(并删除在游客队列中删除)
        ride.addVisitorToHistory(v1);
        ride.addVisitorToHistory(v2);
        ride.addVisitorToHistory(v3);
        ride.addVisitorToHistory(v4);
        ride.addVisitorToHistory(v5);

        //打印参观队列的游客信息
        ride.printQueue();

        //检查当前游客是否在历史记录中存在,
        int result = ride.checkVisitorFromHistory(v2); //1表示游客在乘车历史中,0表示游客不在乘车历史中
        if (result == 1){
            System.out.println(v2.getName()+"In the history of current visitor visits！");
        }else{
            System.out.println(v2.getName()+"Not in the current visitor history！");
        }

        System.out.println("Historical number of visitors：" +ride.numberOfVisitors());

        ride.printRideHistory();
    }

    public void partFourB(){

        //创建工作人员对象
        Employee employee = new Employee("Tom","male",32,"Roller_Coaster_Rider",8000);  //过山车工作人员
        Employee employee2 = new Employee("Sam","male",24,"Water_sports_events",10000);//水上运动工作人员

        //创建设施对象
        Ride ride = new Ride("Roller_Coaster", 1,employee);
        Ride ride1 = new Ride("Water_sports", 2,employee2);

        //创建游客对象
        Visitor v1 = new Visitor("Landon","male", 36, "adult_ticket",   "2024-10-14","Roller_Coaster","V00000001","17769627352");
        Visitor v2 = new Visitor("Shakti",    "female", 30, "adult_ticket",   "2024-11-21","Water_sports",  "V00000002","12241431573");
        Visitor v3 = new Visitor("Dawson",     "male", 18, "student_ticket", "2024-12-13","Water_sports",  "V00000003","1303542514");
        Visitor v4 = new Visitor("Gracia",    "female", 6,  "child_ticket",   "2024-11-17","Roller_Coaster","V00000004","12569875586");
        Visitor v5 = new Visitor("Hollis",     "male", 55, "senior_ticket",  "2024-10-24","Roller_Coaster","V00000005","19155778899");

        ride.addVisitorToHistory(v1);
        ride.addVisitorToHistory(v2);
        ride.addVisitorToHistory(v3);
        ride.addVisitorToHistory(v4);
        ride.addVisitorToHistory(v5);

        System.out.println("pre-sort：");
        ride.printRideHistory();

        //排序
        Collections.sort(ride.visitorList,new Ride());

        System.out.println("After sort：");
        ride.printRideHistory();

    }

    public void partFive(){
        //创建工作人员对象
        Employee employee = new Employee("Tom","male",32,"Roller_Coaster_Rider",8000);  //过山车工作人员
        Employee employee2 = new Employee("Sam","male",24,"Water_sports_events",10000);//水上运动工作人员

        //创建设施对象
        Ride ride = new Ride("Roller_Coaster", 1,employee);
        Ride ride1 = new Ride("Water_sports", 2,employee2);

        //创建游客对象
        Visitor v1 = new Visitor("Landon","male", 36, "adult_ticket",   "2024-10-14","Roller_Coaster","V00000001","17769627352");
        Visitor v2 = new Visitor("Shakti",    "female", 30, "adult_ticket",   "2024-11-21","Water_sports",  "V00000002","12241431573");
        Visitor v3 = new Visitor("Dawson",     "male", 18, "student_ticket", "2024-12-13","Water_sports",  "V00000003","1303542514");
        Visitor v4 = new Visitor("Gracia",    "female", 6,  "child_ticket",   "2024-11-17","Roller_Coaster","V00000004","12569875586");
        Visitor v5 = new Visitor("Hollis",     "male", 55, "senior_ticket",  "2024-10-24","Roller_Coaster","V00000005","19155778899");
        Visitor v6 = new Visitor("Armani",  "male", 16, "student_ticket", "2024-10-10","Roller_Coaster","V00000006","12345678911");
        Visitor v7 = new Visitor("Jelena",   "female", 32, "adult_ticket",   "2024-9-19", "Water_sports",  "V00000007","15748968888");
        Visitor v8 = new Visitor("Kerwin",   "male", 21, "student_ticket", "2024-7-21", "Roller_Coaster","V00000008","17897564444");
        Visitor v9 = new Visitor("Sheryl",    "female", 4,  "child_ticket",   "2024-10-20","Roller_Coaster","V00000009","10101234555");
        Visitor v10 = new Visitor("Aminah",   "male", 65, "senior_ticket",  "2024-12-19","Roller_Coaster","V00000010","11111222233");

        ride.addVisitorToQueue(v1);
        ride.addVisitorToQueue(v2);
        ride.addVisitorToQueue(v3);
        ride.addVisitorToQueue(v4);
        ride.addVisitorToQueue(v5);
        ride.addVisitorToQueue(v6);
        ride.addVisitorToQueue(v7);
        ride.addVisitorToQueue(v8);
        ride.addVisitorToQueue(v9);
        ride.addVisitorToQueue(v10);

        ride.printQueue();

        //设置最多容纳游客为4
        ride.setMaxRider(4);

        ride.runOneCycle();

        System.out.println("One period has been executed. Procedure！！！！！");
        ride.printQueue();

        ride.printRideHistory();

    }

    public void partSix(){

        //创建工作人员对象
        Employee employee = new Employee("Tom","male",32,"Roller_Coaster_Rider",8000);  //过山车工作人员
        Employee employee2 = new Employee("Sam","male",24,"Water_sports_events",10000);//水上运动工作人员

        //创建设施对象
        Ride ride = new Ride("Roller_Coaster", 1,employee);
        Ride ride1 = new Ride("Water_sports", 2,employee2);

        //创建游客对象
        Visitor v1 = new Visitor("Landon","male", 36, "adult_ticket",   "2024-10-14","Roller_Coaster","V00000001","17769627352");
        Visitor v2 = new Visitor("Shakti",    "female", 30, "adult_ticket",   "2024-11-21","Water_sports",  "V00000002","12241431573");
        Visitor v3 = new Visitor("Dawson",     "male", 18, "student_ticket", "2024-12-13","Water_sports",  "V00000003","1303542514");
        Visitor v4 = new Visitor("Gracia",    "female", 6,  "child_ticket",   "2024-11-17","Roller_Coaster","V00000004","12569875586");
        Visitor v5 = new Visitor("Hollis",     "male", 55, "senior_ticket",  "2024-10-24","Roller_Coaster","V00000005","19155778899");

        //添加游客至队列
        ride.addVisitorToQueue(v1);
        ride.addVisitorToQueue(v2);
        ride.addVisitorToQueue(v3);
        ride.addVisitorToQueue(v4);
        ride.addVisitorToQueue(v5);

        ride.addVisitorToHistory(v1);
        ride.addVisitorToHistory(v2);
        ride.addVisitorToHistory(v3);
        ride.addVisitorToHistory(v4);
        ride.addVisitorToHistory(v5);

        ride.exportRideHistory("VisitorToHistory");

    }

    public void partSeven(){

        //创建工作人员对象
        Employee employee = new Employee("Tom","male",32,"Roller_Coaster_Rider",8000);  //过山车工作人员
        Employee employee2 = new Employee("Sam","male",24,"Water_sports_events",10000);//水上运动工作人员

        //创建设施对象
        Ride ride = new Ride("Roller_Coaster", 1,employee);
        Ride ride1 = new Ride("Water_sports", 2,employee2);   //设施--水上运动   运行中

        ride.importRideHistory("VisitorToHistory");

        System.out.println("Number of visitors to historical records:"+ride.numberOfVisitors());
        ride.printRideHistory();

    }

}
