package Ordermanagementsystem;

import java.util.Scanner;

public class OrderManger {
    
    Scanner sc=new Scanner(System.in);
    private Order[] orders;
    /**
     * 订单数量
     */
    private int orderIndex;
    private static final int LENGTH = 10;

    /**
     * 构造函数
     * @param good
     * @param address
     */
    public OrderManger()
    {
        this.orderIndex=0;
        orders=new Order[LENGTH];
    }

    /**
     * 添加订单
     * @param good
     * @param address
     */
    public void AddOrder(GoodMain goodMain)
    {

        Order order=new Order();
        Good good=new Good();
        System.out.print("请输入商品编号：");

        /**
         * 订单中要操作的商品编号
         */
        int cmdNo=sc.nextInt();
        System.out.print("请输入订单数量：");
        int cmdAmout=sc.nextInt();
        order.setCount(cmdAmout);
        int p=0;
        for(int i=1;i<=goodMain.goodManger.index;i++)
        {
            if(cmdNo==goodMain.goodManger.goods[i].getNo())
            {
                p=2;
                if(goodMain.goodManger.goods[i].getAmout()>=cmdAmout)
                {
                    p=1;
                    good=goodMain.goodManger.goods[i];
                    goodMain.goodManger.goods[i].setAmout(goodMain.goodManger.goods[i].getAmout()-cmdAmout);
                    order.setGood(good);
                }
                else 
                    System.out.println("无法添加，该商品不足！");
                break;
            }

        }
        if(p==0) System.out.println("该商品不存在！");
        else if(p==1)
        {
            System.out.println("请输入其他订单信息：");
            System.out.print("订单编号：");
            order.setNo(sc.nextInt());
            for(int j=1;j<=orderIndex;j++)
                {
                    //if(j==i)continue;
                    if(order.getNo()==orders[j].getNo())
                    {
                        System.out.printf("该编号已存在！已为您自动编号为：%d",orders[orderIndex].getNo()+1);
                        System.out.println();
                        order.setNo(orders[orderIndex].getNo()+1);
                        break;
                    }
                }
            System.out.println();
            System.out.print("姓    名：");
            order.setName(sc.next());
            System.out.println();
            System.out.print("地    址：");
            order.setAddress(sc.next());
            System.out.println();
            System.out.printf("商品单价：%2f",good.getPrice());
            System.out.println();
            System.out.printf("总    价：%2f",good.getPrice()*cmdAmout);
            System.out.println();
            System.out.println("添加成功！");
            order.setGood(good);
            orderIndex+=1;
            if(this.orderIndex>this.orders.length)
            {
                Order[] old=orders;
                orders=new Order[this.orders.length+LENGTH];
                for(int i=1;i<orderIndex;i++)
                {
                    orders[i]=old[i];
                }
            }
            orders[orderIndex]=order;
            System.out.println("订单添加成功！");
        }
    }
/**
 * 通过编号查询订单
 * @param no
 */
    public void showOrderByNo(int no)
    {
        int p=0;
        for(int i=1;i<=orderIndex;i++)
        {
            if(this.orders[i].getNo()==no)
            {
                p=1;
                orders[i].getOrder();
                break;
            }
        }
        if(p==0) System.out.println("查询失败！未找到编号对应的订单");
    }

    /**
     * 通过编号来删除订单
     * @param no
     * @return
     */
    public void removeOrderByNo(int no,GoodMain goodMain)
    {
        int p=0,res=0,ans=0;
        for(int i=1;i<=orderIndex;i++)
        {
            if(orders[i].getNo()==no)
            {
                ans=orders[i].getCount();
                res=orders[i].getGood().getNo();
                for(int j=i;j<orderIndex;j++)
                {
                    orders[j]=orders[j+1];
                }
                p=1;
                orderIndex-=1;
                break;
            }
        }
        if(p==0) System.out.println("删除失败！未找到编号对应的订单！");
        else System.out.println("删除成功！");
        /**
         * 在商品类中找到删除订单对应的商品
        */
        if(res>0&&ans>0)
        {
            for(int i=1;i<=goodMain.goodManger.index;i++)
            {
                if(goodMain.goodManger.goods[i].getNo()==res)
                {
                    goodMain.goodManger.goods[i].setAmout(goodMain.goodManger.goods[i].getAmout()+ans);
                }
            }
        }
    }

    /**
     * 通过编号来修改订单
     * @param no 传入的订单编号
     */
    public void alertOrderByNo(int no,GoodMain goodMain)
    {
        int res=0,cnt=0,cut=0,vis=100000;
        int p=0,q=0,i=0,j=0;
        Order order =new Order();
        for(i=1;i<=orderIndex;i++)
        {
            if(orders[i].getNo()==no)
            {
                p=1;
                //order=orders[i];
                for(j=1;j<=goodMain.goodManger.index;j++)
                    {
                        if(goodMain.goodManger.goods[j].getNo()==orders[i].getGood().getNo())
                        {
                            q=1;
                            vis=goodMain.goodManger.goods[j].getAmout();
                            break;
                        }
                    }
                cut=orders[i].getCount();
                System.out.println("订单编号："+orders[i].getNo());
                System.out.println("商品名称："+orders[i].getGood().getName());
                System.out.println("商品单价："+orders[i].getGood().getPrice());
                System.out.printf("姓    名：%-8s 改为：",orders[i].getName());
                order.setName(sc.next());
                System.out.println();
                System.out.printf("地    址：%-8s 改为：",orders[i].getAddress());
                order.setAddress(sc.next());
                System.out.println();
                System.out.printf("订单数量：%-8d 改为：",orders[i].getCount());
                cnt=sc.nextInt();
                order.setCount(cnt);
                System.out.println();
                System.out.println("总    价："+order.getCount()*orders[i].getGood().getPrice());
                res=cnt-cut;
                if(res>vis)
                {
                    p=2;
                }
                else 
                {
                    orders[i].setName(order.getName());
                    orders[i].setAddress(order.getAddress());
                    orders[i].setCount(order.getCount());
                }
                break;
            }
        }
        if(p==0)System.out.println("无法修改！找不到该订单！");
        else if(p==2) System.out.printf("无法修改！该类商品库存不足（已订：%d，剩余：%d）.",orders[i].getCount(),vis);
        else
        {
            System.out.println("修改成功！");
            if(q==1)
            {
                goodMain.goodManger.goods[j].setAmout(goodMain.goodManger.goods[j].getAmout()-res);
            }
        }
    }

    /**
     * 查询所有订单信息
     */
    public void showOrder()
    {
        if(orderIndex>0)
        {
            System.out.println("订单信息如下：");
            System.out.println(" 序号   订单编号       姓名         地址                       商品名称         单价             数量         总计");
            for(int i=1;i<=orderIndex;i++)
            {
                System.out.printf("%4d    %-15d%-13s%-27s%-17s%-16f %-13d%f",i,orders[i].getNo(),orders[i].getName(),orders[i].getAddress(),
                orders[i].getGood().getName(),orders[i].getGood().getPrice(),orders[i].getCount(),orders[i].getCount()*orders[i].getGood().getPrice());
                System.out.println();
            }
        }
        else
        {
            System.out.println("暂无订单信息！");
        }
    }
}
