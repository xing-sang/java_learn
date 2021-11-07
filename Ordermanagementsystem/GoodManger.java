package Ordermanagementsystem;

import java.util.Scanner;

public class GoodManger {
    Scanner sc=new Scanner(System.in);
    private static final int LENGTH = 10;
    Good[] goods;
    /**
     * 表示数组中商品的数量
     */
    int index;
    /**
     * 商品编号
     */
    private int VauleNo;
    public  GoodManger()
    {
        this.goods=new Good[LENGTH];
        this.index=0;
        this.VauleNo=1;
    }

    /**
     * 获得商品信息
     */
    public Good getGood()
    {
        Good result=goods[index];

        return result;
    }

    /**
     * 添加商品
     */
    public void addGood()
    {
        Good good=new Good();
        System.out.println("请输入商品信息：");
        System.out.print("编号：");
        good.setNo(sc.nextInt());
        for(int i=1;i<=index;i++)
        {
            if(good.getNo()==goods[i].getNo())
            {
                System.out.printf("该编号已存在！已为您自动编号为：%d",goods[index].getNo()+1);
                good.setNo(goods[index].getNo()+1);
                break;
            }
        }
        System.out.println();
        System.out.print("名称：");
        good.setName(sc.next());
        System.out.println();
        System.out.print("单价：");
        good.setPrice(sc.nextInt());
        System.out.println();
        System.out.print("数量：");
        good.setAmout(sc.nextInt());
        System.out.println();
        
        index+=1;
        if(this.index>this.goods.length)
        {
            Good[] old=goods;
            goods=new Good[this.goods.length+LENGTH];
            for(int i=1;i<index;i++)
            {
                goods[i]=old[i];
            }
        }
        goods[index]=good;
        System.out.println("添加成功！");
    }

    /**
     * 删除商品
     */
    public void removerGood(int no)
    {
        int p=0;
        for(int i=1;i<=index;i++)
        {
            if(goods[i].getNo()==no)
            {
                for(int j=i;j<index;j++)
                {
                    goods[j]=goods[j+1];
                }
                p=1;
                index-=1;
                break;
            }
        }
        if(p==1)System.out.println("删除成功！");
        else System.out.println("删除失败！因为没有找到该编号对应的商品！");
    }

    /**
     * 通过编号修改商品
     */
    public void alertGoodByNo(int no)
    {
        int p=0;
        for(int i=1;i<=index;i++)
        {
            if(goods[i].getNo()==no)
            {
                System.out.printf("编号：%-8d 改为：",goods[i].getNo());
                int newNo=sc.nextInt();
                for(int j=1;j<=index;j++)
                {
                    if(j==i)continue;
                    if(newNo==goods[j].getNo())
                    {
                        System.out.printf("该编号已存在！已为您自动编号为：%d",goods[index].getNo()+1);
                        System.out.println();
                        goods[i].setNo(goods[index].getNo()+1);
                        break;
                    }
                }
                System.out.println();
                //goods[i].setNo(newNo);
                System.out.printf("名称：%-8s 改为：",goods[i].getName());
                String newName=sc.next();
                System.out.println();
                goods[i].setName(newName);
                System.out.printf("单价：%-8f 改为：",goods[i].getPrice());
                double newPrice=sc.nextDouble();
                System.out.println();
                goods[i].setPrice(newPrice);
                System.out.printf("数量：%-8d 改为：",goods[i].getAmout());
                int newAmout=sc.nextInt();
                System.out.println();
                goods[i].setAmout(newAmout);
                System.out.println("修改成功！");
                break;
            }
        }
    }

    /**
     * 通过编号查询商品信息
     */
    public void showGoodByNo(int no)
    {
        int  p=0;
        for(int i=1;i<=index;i++)
        {
            if(goods[i].getNo()==no)
            {
                goods[i].getGood();
                p=1;
                break;
            }
        }
        if(p==0)System.out.println("查询失败！因为没有找到该编号对应的商品！");
    }

    /**
     * 查询所有商品信息
     */
    public void showGood()
    {
        if(index>0)
        {
            System.out.println("商品信息如下：");
            System.out.println(" 序号   编号       商品名称         单价          库存");
            for(int i=1;i<=index;i++)
            {
                System.out.printf("%4d    %-11d%-17s%-13f %d",i,goods[i].getNo(),goods[i].getName(),goods[i].getPrice(),goods[i].getAmout());
                System.out.println();
            }
        }
        else
        {
            System.out.println("暂无商品信息！");
        }
    }

}
