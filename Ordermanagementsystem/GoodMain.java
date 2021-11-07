package Ordermanagementsystem;
import java.util.*;

import javax.lang.model.util.ElementScanner6;
public class GoodMain {
    protected GoodManger goodManger;
    private WelcomeView view;
    public GoodMain()
    {
        goodManger =new GoodManger();
        view=new WelcomeView();
    }
    /**
     * 对商品的操作（增、删、改、查）
     */
    public void GoodOperate()
    {
        /**
         * 商品类主菜单输入的指令
         */
        int cmd;
        Scanner sc=new Scanner(System.in);
        view.GoodView();
        cmd=1;
        while(cmd!=0)
        {
            cmd=sc.nextInt();
            System.out.println();
            if(cmd==1)
            {
                goodManger.addGood();
                view.GoodView();
            }
            else if(cmd==2)
            {
                System.out.print("请输入要删除的商品编号：");
                goodManger.removerGood(sc.nextInt());
                System.out.println();
                view.GoodView();
            }
            else  if(cmd==3)
            {
                System.out.print("请输入要查询的商品编号：");
                goodManger.showGoodByNo(sc.nextInt());
                System.out.println();
                view.GoodView();
            }
            else if(cmd==4)
            {
                goodManger.showGood();
                view.GoodView();
            }
            else if(cmd==5)
            {
                System.out.print("请输入要修改的商品编号：");
                goodManger.alertGoodByNo(sc.nextInt());
                System.out.println();
                view.GoodView();
            }
            else if(cmd==6) return;
            else
            {
                System.out.print("输入错误！请重新输入：");
                cmd=1;
            }
        }

    }
}
