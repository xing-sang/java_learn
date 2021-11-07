package Ordermanagementsystem;

public class Order {
    private int no;
    private Good good;
    private String address;
    private int count;
    private double totalPrice;
    private String name;
    
    public Order(){}

    //编号
    public void setNo(int no)
    {
        this.no=no;
    }
    public int getNo()
    {
        return no;
    }

    //地址
    public void setAddress(String address)
    {
        this.address=address;
    }
    public String getAddress()
    {
        return address;
    }

    //数量
    public void setCount(int count)
    {
        this.count=count;
    }
    public int getCount()
    {
        return count;
    }

    //总价
    public void settotalPrice(double totalPrice)
    {
        this.totalPrice=totalPrice;
    }
    public double gettotalPrice()
    {
        return totalPrice;
    }

    /**
     * 获得商品
     * @return
     */
    public Good getGood()
    {
        return this.good;
    }
    public void setGood(Good good)
    {
        this.good=good;
    }

    /**
     * 获得订单信息
     * @return
     */
    public void getOrder()
    {
        System.out.println("查询成功！信息如下：");
        System.out.println("订单编号："+this.no);
        System.out.println("姓    名："+this.name);
        System.out.println("商品名称："+this.good.getName());
        System.out.println("地    址："+this.address);
        System.out.println("商品单价："+this.good.getPrice());
        System.out.println("商品单数："+this.count);
        System.out.println("合    计："+this.count*this.good.getPrice());
    }

    /**
     * 姓名
     */
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name=name;
    }
}
