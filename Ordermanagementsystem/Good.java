package Ordermanagementsystem;

public class Good {
    /**
     * 编号（int)
     */
    private int no;
    /**
     * 名称(String)
     */
    private String name;
    /**
     * 单价(double)
     */
    private double price;
    /**
     * 数量
     */
    private int amout;

    public Good() {}

    /**
     * 商品编号
     * @return
     */
    public int getNo()
    {
        return this.no;
    }
    public void setNo(int no)
    {
        this.no=no;
    }

    /**
     * 商品数量
     * @return
     */
    public int getAmout()
    {
        return this.amout;
    }
    public void setAmout(int amout)
    {
        this.amout=amout;
    }

    /**
     * 商品单价
     * @return
     */
    public double getPrice()
    {
        return this.price;
    } 
    public void setPrice(double price)
    {
        this.price=price;
    }

    /**
     * 商品名称
     * @return
     */
    public String getName()
    {
        return this.name;
    }
    public void setName(String name)
    {
        this.name=name;
    }

    public void getGood()
    {
        System.out.println("查询成功！商品信息如下：");
        System.out.println("编号："+this.no);
        System.out.println("名称："+this.name);
        System.out.println("单价："+this.price);
        System.out.println("数量："+this.amout);
    }

}
