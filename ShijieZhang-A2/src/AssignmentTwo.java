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
        Employee employee1 = new Employee("Tom",'男',32,"Roller_Coaster_events",8000);//过山车工作人员
        Employee employee2 = new Employee("Sam",'男',24,"Water_sports_events",10000);//水上运动工作人员

        //创建设施对象
        Ride ride = new Ride("Roller_Coaster", 1,employee1);   //设施--过山车   运行中
        Ride ride1 = new Ride("Water_sports", 1,employee2);   //设施--水上运动   运行中

        // 创建游客对象
        Visitor v1 = new Visitor("Mike",'男', 25, "adult_ticket","2024-12-10","Roller_Coaster","V00000001");
        Visitor v2 = new Visitor("Lily",'女', 30, "adult_ticket", "2024-12-11","Water_sports","V00000002");
        Visitor v3 = new Visitor("John",'男', 18, "student_ticket", "2024-12-12","Water_sports","V00000003");
        Visitor v4 = new Visitor("Sarah",'女', 6, "child_ticket", "2024-12-13","Roller_Coaster","V00000004");
        Visitor v5 = new Visitor("David", '男', 60, "senior_ticket", "2024-12-14","Roller_Coaster","V00000005");

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
        Employee employee = new Employee("Tom",'男',32,"Roller_Coaster_Rider",8000);  //过山车工作人员

        //创建设施对象
        Ride ride = new Ride("Roller_Coaster", 1,employee);

        //创建游客对象
        Visitor v1 = new Visitor("Mike",'男', 25, "adult_ticket","2024-12-10","Roller_Coaster","V00000001");
        Visitor v2 = new Visitor("Lily",'女', 30, "adult_ticket", "2024-12-11","Water_sports","V000000012");
        Visitor v3 = new Visitor("John",'男', 18, "student_ticket", "2024-12-12","Water_sports","V00000003");
        Visitor v4 = new Visitor("Sarah",'女', 6, "child_ticket", "2024-12-13","Roller_Coaster","V00000004");
        Visitor v5 = new Visitor("David", '男', 60, "senior_ticket", "2024-12-14","Roller_Coaster","V00000005");

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
            System.out.println(v2.getName()+"在当前游客参观历史中！");
        }else{
            System.out.println(v2.getName()+"不在当前游客参观历史中！");
        }

        System.out.println("游客参观历史人数：" +ride.numberOfVisitors());

        ride.printRideHistory();
    }

    public void partFourB(){

        //创建工作人员对象
        Employee employee = new Employee("Tom",'男',32,"Roller_Coaster_Rider",8000);  //过山车工作人员

        //创建设施对象
        Ride ride = new Ride("Roller_Coaster", 1,employee);

        //创建游客对象
        Visitor v1 = new Visitor("Mike",'男', 25, "adult_ticket","2024-12-10","Roller_Coaster","V00000001");
        Visitor v2 = new Visitor("Lily",'女', 30, "adult_ticket", "2024-12-11","Water_sports","V00000002");
        Visitor v3 = new Visitor("John",'男', 18, "student_ticket", "2024-12-12","Water_sports","V00000003");
        Visitor v4 = new Visitor("Sarah",'女', 6, "child_ticket", "2024-12-13","Roller_Coaster","V00000004");
        Visitor v5 = new Visitor("David", '男', 60, "senior_ticket", "2024-12-14","Roller_Coaster","V00000005");

        ride.addVisitorToHistory(v1);
        ride.addVisitorToHistory(v2);
        ride.addVisitorToHistory(v3);
        ride.addVisitorToHistory(v4);
        ride.addVisitorToHistory(v5);

        System.out.println("排序前：");
        ride.printRideHistory();

        //排序
        Collections.sort(ride.visitorList,new Ride());

        System.out.println("排序后：");
        ride.printRideHistory();

    }

    public void partFive(){
        //创建工作人员对象
        Employee employee = new Employee("Tom",'男',32,"Roller_Coaster_Rider",8000);  //过山车工作人员

        //创建设施对象
        Ride ride = new Ride("Roller_Coaster", 1,employee);

        //创建游客对象
        Visitor v1 = new Visitor("Mike",'男', 25, "adult_ticket","2024-12-10","Roller_Coaster","V00000001");
        Visitor v2 = new Visitor("Lily",'女', 30, "adult_ticket", "2024-12-11","Water_sports","V00000002");
        Visitor v3 = new Visitor("John",'男', 18, "student_ticket", "2024-12-12","Water_sports","V00000003");
        Visitor v4 = new Visitor("Sarah",'女', 6, "child_ticket", "2024-12-13","Roller_Coaster","V00000004");
        Visitor v5 = new Visitor("David", '男', 60, "senior_ticket", "2024-12-14","Roller_Coaster","V00000005");
        Visitor v6 = new Visitor("Mik",'男', 26, "adult_ticket","2024-12-10","Roller_Coaster","V00000006");
        Visitor v7 = new Visitor("Liy",'女', 32, "adult_ticket", "2024-12-9","Water_sports","V00000007");
        Visitor v8 = new Visitor("Jon",'男', 21, "student_ticket", "2024-12-2","Roller_Coaster","V00000008");
        Visitor v9 = new Visitor("Sra",'女', 4, "child_ticket", "2024-12-18","Roller_Coaster","V00000009");
        Visitor v10 = new Visitor("Dav", '男', 65, "senior_ticket", "2024-12-9","Roller_Coaster","V00000010");

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

        System.out.println("一周期已执行完毕！！！！！");
        ride.printQueue();

        ride.printRideHistory();

    }

    public void partSix(){

        //创建工作人员对象
        Employee employee = new Employee("Tom",'男',32,"Roller_Coaster_Rider",8000);  //过山车工作人员

        //创建设施对象
        Ride ride = new Ride("Roller_Coaster", 1,employee);

        //创建游客对象
        Visitor v1 = new Visitor("Mike",'男', 25, "adult_ticket","2024-12-10","Roller_Coaster","V00000001");
        Visitor v2 = new Visitor("Lily",'女', 30, "adult_ticket", "2024-12-11","Water_sports","V00000002");
        Visitor v3 = new Visitor("John",'男', 18, "student_ticket", "2024-12-12","Water_sports","V00000003");
        Visitor v4 = new Visitor("Sarah",'女', 6, "child_ticket", "2024-12-13","Roller_Coaster","V00000004");
        Visitor v5 = new Visitor("David", '男', 60, "senior_ticket", "2024-12-14","Roller_Coaster","V00000005");

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
        Employee employee = new Employee("Tom",'男',32,"Roller_Coaster_Rider",8000);  //过山车工作人员
        Employee employee2 = new Employee("Sam",'男',24,"Water_sports_events",10000);//水上运动工作人员

        //创建设施对象
        Ride ride = new Ride("Roller_Coaster", 1,employee);
        Ride ride1 = new Ride("Water_sports", 1,employee2);   //设施--水上运动   运行中

        ride.importRideHistory("VisitorToHistory");

        System.out.println("游客参观历史记录数量:"+ride.numberOfVisitors());
        ride.printRideHistory();

    }

}
