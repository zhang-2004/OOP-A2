import java.io.*;
import java.util.*;

public class Ride implements RiderInterface,Comparator<Visitor> {  //主题公园游乐设施

    private String rideName;   //设施名称
    private int rideStatus = 0;   //设施运行状态    0表示未运行,1表示运行中
    private Employee operator;   //操作员
    public Queue<Visitor> visitorQueue = new LinkedList<>(); // 游客队列
    public List<Visitor> visitorList = new LinkedList<>(); //存储乘坐过游乐设施的游客

    public int maxRider = 0; //最多接纳多少游客
    private int numOfCycles = 0; //记录游乐设施已经运行几次,初始化为0

    public Ride() {
    }

    public Ride(String rideName, int rideStatus, Employee operator) {
        this.rideName = rideName;
        this.rideStatus = rideStatus;
        this.operator = operator;
    }

    public String getRideName() {
        return rideName;
    }

    public void setRideName(String rideName) {
        this.rideName = rideName;
    }

    public int getRideStatus() {
        return rideStatus;
    }

    public void setRideStatus(int rideStatus) {
        this.rideStatus = rideStatus;
    }

    public Employee getOperator() {
        return operator;
    }

    public void setOperator(Employee operator) {
        this.operator = operator;
    }

    public Queue<Visitor> getVisitorQueue() {
        return visitorQueue;
    }

    public void setVisitorQueue(Queue<Visitor> visitorQueue) {
        this.visitorQueue = visitorQueue;
    }

    public int getMaxRider() {
        return maxRider;
    }

    public void setMaxRider(int maxRider) {
        this.maxRider = maxRider;
    }

    @Override
    public void addVisitorToQueue(Visitor visitor){   //向队列中添加访问者
        if(visitor != null){
            visitorQueue.offer(visitor);
            System.out.println(visitor.getName()+"Visitor queue successfully added！");
        }else{
            System.out.println(visitor.getName()+"Visitor queue failed added！");
        }
    }

    @Override
    public void removeVisitorFromQueue(Visitor visitor) { //从队列中移除访问者
        if(visitor != null){
            visitorQueue.remove(visitor);
            System.out.println(visitor.getName()+"The visitor queue was successfully removed！");
        }else{
            System.out.println(visitor.getName()+"The visitor queue was successfully removed！");
        }
    }

    @Override
    public void printQueue() {   //打印队列中等待访问者的列表
        if(visitorQueue.isEmpty()) {
            System.out.println("The current visitor queue is empty！");
        }else {
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("The viewing queue is as follows:");
            for (Visitor visitor : visitorQueue) {
                System.out.println(visitor.toString());
            }
        }
    }

    @Override
    public void addVisitorToHistory(Visitor visitor) {   //添加到游客参观历史中,删除队列中当前游客的数据
        visitorList.add(visitor);
        System.out.println(visitor.getName()+"Visitors have been moved from the visitor queue to the visitor visit history！");
        if(getVisitorQueue().contains(visitor)){
            removeVisitorFromQueue(visitor);
        }
    }

    @Override
    public int checkVisitorFromHistory(Visitor visitor) {   //1表示游客在乘车历史中,0表示游客不在乘车历史中
        int n = visitorList.indexOf(visitor);//查找visitor是否存在,n=-1表示未查找到
        if(n == -1){
            return 0;
        }
        return 1;
    }

    @Override
    public int numberOfVisitors() {
        return visitorList.size();
    }

    @Override
    public void printRideHistory() {
        if(numberOfVisitors() == 0){
            System.out.println("Visitor visit history data is empty！");
        }else{
            Iterator iterator = visitorList.iterator();
            System.out.println("Visitor visit history data are as follows：");
            while (iterator.hasNext()){
                Visitor visitor = (Visitor) iterator.next();
                System.out.println(visitor.toString());
            }
            System.out.println();
        }
    }

    @Override
    public void runOneCycle() {
        if (operator == null) {
            System.out.println("The ride cannot operate without an operator！");
            return ;
        }
        if (visitorQueue.isEmpty()) {
            System.out.println("The ride cannot operate without a queue of visitors！");
            return ;
        }
        //接待游客人数 (当前最多接待游客人数,如果最大)
        int riders =  maxRider > visitorQueue.size() ? visitorQueue.size() : maxRider;

        for (int i = 0; i < riders; i++) {
            // 从队列中移除游客并加入历史记录
            Visitor visitor = visitorQueue.remove();
            visitorList.add(visitor);
        }
        // 增加周期次数
        numOfCycles++;
        System.out.println("Amusement facility operation"+numOfCycles+ "Times, welcome" + riders + "tourist。");
    }

    @Override
    public int compare(Visitor v1, Visitor v2) {
        int result = Integer.compare(v1.getAge(), v2.getAge());  //根据年龄进行比较
        if (result == 0) {  //如果年龄相等,比较票的日期
            return v1.getTicketDate().compareTo(v2.getTicketDate());
        }
        return result;
    }

    public void exportRideHistory(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Visitor visitor : visitorList) {
                writer.write(visitor.toString());
                writer.write("\n");
            }
            System.out.println("Data has been successfully exported! Export file name:"+filename);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void importRideHistory(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] str = line.split("\t");
                String name = str[0].substring(8); // 去掉前缀
               char gender =str[1].charAt(0);
                int age = Integer.parseInt(str[2]);
                String ticketType = str[3];
                String ticketDate = str[4];
                String item = str[5];
                String id = str[6];
                String Phone = str[7];
                Visitor visitor = new Visitor(name, gender, age, ticketType, ticketDate,item,id,Phone);

                if (visitor != null) {
                    addVisitorToQueue(visitor);
                    addVisitorToHistory(visitor);
                }
            }
            System.out.println("Data has been successfully imported! Import file name:"+filename);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
