
package Ordermanagementsystem;
public class WelcomeView{
    /**
     * 主菜单
     */
    public void MainView()
    {
        System.out.println();
        System.out.println("****************欢迎使用商品--订单管理系统***************");
        System.out.println("*                     1.商品操作                        *");
        System.out.println("*                     2.订单操作                        *");
        System.out.println("*                     3.退出系统                        *");
        System.out.println("*                                                       *");
        System.out.println("*   （注意：系统中的商品名称、地址、姓名等请使用英文）  *");
        for(int i=1;i<=57;i++)
        {
            System.out.print('*');
        }
        System.out.println();
        System.out.print("请选择：");
    }

    /**
     * 商品类主菜单
     */
    public void GoodView()
    {
        System.out.println();
        System.out.println("**********商品管理系统****************");
        System.out.println("*          1.添加商品                *");
        System.out.println("*          2.删除商品                *");
        System.out.println("*          3.通过编号查询商品        *");
        System.out.println("*          4.查询所有商品            *");
        System.out.println("*          5.修改商品                *");
        System.out.println("*          6.退出系统                *");
        for(int i=1;i<=38;i++)
        {
            System.out.print('*');
        }
        System.out.println();
        System.out.print("请选择：");
    }

    /**
     * 订单类主菜单
     */
    public void OrderView()
    {
        System.out.println();
        System.out.println("**********订单管理系统****************");
        System.out.println("*          1.添加订单                *");
        System.out.println("*          2.删除订单                *");
        System.out.println("*          3.通过编号查询订单        *");
        System.out.println("*          4.查询所有订单            *");
        System.out.println("*          5.修改订单                *");
        System.out.println("*          6.退出系统                *");
        for(int i=1;i<=38;i++)
        {
            System.out.print('*');
        }
        System.out.println();
        System.out.print("请选择：");
    }
}