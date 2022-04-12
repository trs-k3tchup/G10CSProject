import java.util.ArrayList;

public class Item
{
    private static ArrayList<Item> itemList = new ArrayList<Item>();
    private String itemName, buff;
    private int amount, userHeal, enemyHeal, percentHeal;

    public Item(String n, String b, int u, int e, int p)
    {
        this.itemName = n;
        this.buff = b;
        this.userHeal = u;
        this.enemyHeal = e;
        this.percentHeal = p;
        this.amount = 0;
        itemList.add(this);
    }

    //getter setter
    public String getName()
    {
        return(this.itemName);
    }
    public String getBuff()
    {
        return(this.buff);
    }
    public int getUHeal()
    {
        return(this.userHeal);
    }
    public int getEHeal()
    {
        return(this.enemyHeal);
    }
    public int getPHeal()
    {
        return(this.percentHeal);
    }
    public void used()
    {
        this.amount -= 1;
    }
}