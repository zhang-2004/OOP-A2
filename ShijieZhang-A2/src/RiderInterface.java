public interface RiderInterface {

    void addVisitorToQueue(Visitor visitor);   //向队列中添加访问者
    void removeVisitorFromQueue(Visitor visitor);  //从队列中移除访问者
    void printQueue();  //打印队列中等待访问者的列表
    void runOneCycle();  //设施运行一周期
    void addVisitorToHistory(Visitor visitor); // 将游客添加到乘车历史记录中
    int checkVisitorFromHistory(Visitor visitor);  //检查游客是否在乘车历史记录中  1表示在,0表示不在
    int numberOfVisitors();  //返回游客历史记录中的游客数量
    void printRideHistory(); //打印乘坐游乐设施的访问列表



}
