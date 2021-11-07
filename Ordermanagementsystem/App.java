package Ordermanagementsystem;
import java.util.*;

import javax.lang.model.util.ElementScanner6;
public class App{
    public static void main(String[] args)
    {
        /**
         * 程序结构：
         *            | --OrderMain类 <--OrderManger类 <--Order类
         *            |       |
         *   App类 <--|       |(GoodMain类作为OrderMain类的成员)
         *            |       |
         *            |--GoodMain类 <--GoodManger类 <--Good类
         */

        GoodMain goodMain;
        OrderMain orderMain;
        goodMain=new GoodMain();
        orderMain=new OrderMain(goodMain);//将商品管理类的地址传入订单管理类中，方便订单变化时即时更新商品状态
        WelcomeView view=new WelcomeView();
        view.MainView();
        Scanner sc=new Scanner(System.in);
        /**
         * 主菜单输入的指令
         */
        int cmd=1;
        while(cmd!=0)
        {
            cmd=sc.nextInt();
            System.out.println();
            if(cmd==1)
            {
                //view.GoodView();
                goodMain.GoodOperate();
                view.MainView();
            }
            else if(cmd==2)
            {
                //view.OrderView();
                //OrderMain orderMain=new OrderMain();
                orderMain.OrderOperate();
                view.MainView();
            }
            else if(cmd==3) System.exit(0);
            else
            {
                System.out.print("输入错误！请重新输入：");
            }
        }

    }
}