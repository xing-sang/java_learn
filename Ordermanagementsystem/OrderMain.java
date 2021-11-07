package Ordermanagementsystem;
import java.util.*;
public class OrderMain{

    private OrderManger orderManger;
    private WelcomeView view;
    private GoodMain goodMain;

    /**
     * 构造函数
     */
    public OrderMain(GoodMain goodMain)
    {
        this.goodMain=goodMain;
        orderManger =new OrderManger();
        view=new WelcomeView();
    }
    /**
     * 对订单的操作（增、删、改、查）
     */
    public void OrderOperate()
    {
        /**
         * 订单类主菜单输入的指令
         */
        int cmd;
        Scanner sc=new Scanner(System.in);
        view.OrderView();
        cmd=1;
        while(cmd!=0)
        {
            cmd=sc.nextInt();
            System.out.println();
            if(cmd==1)
            {
               
                orderManger.AddOrder(goodMain);
                view.OrderView();
            }
            else if(cmd==2)
            {
                /**
                 * 要删除的订单编号
                 */
                int cmdNo,ans=0;
                System.out.print("请输入要删除的订单编号：");
                cmdNo=sc.nextInt();
                orderManger.removeOrderByNo(cmdNo,goodMain);
                System.out.println();
                view.OrderView();
            }
            else  if(cmd==3)
            {
                System.out.print("请输入要查询的订单编号：");
                orderManger.showOrderByNo(sc.nextInt());
                System.out.println();
                view.OrderView();
            }
            else if(cmd==4)
            {
                orderManger.showOrder();
                view.OrderView();
            }
            else if(cmd==5)
            {
                int cmdNo,ans=0,i=1,p=0;
                System.out.print("请输入要修改的订单编号：");
                cmdNo=sc.nextInt();
                orderManger.alertOrderByNo(cmdNo,goodMain);
                System.out.println();
                view.OrderView();
            }
            else if(cmd==6) return;
            else
            {
                System.out.print("输入错误！请重新输入：");
                cmd=1;
            }
        }

    }
    private void orderShow() {
    }
}
