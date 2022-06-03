import java.util.ArrayList;
/**
 * Items can be used by the User to give them an advantage in battle. Items have a name, buff, user and enemy heal, percentheal, and description.
 * 
 * @author Ash Choi
 */
public class Item
{
    private static ArrayList<Item> itemList = new ArrayList<Item>();
    private String itemName, buff, description;
    private int amount, userHeal, enemyHeal, percentHeal;

    public Item(String n, String b, int u, int e, int p, String d)
    {
        this.itemName = n;
        this.buff = b;
        this.userHeal = u;
        this.enemyHeal = e;
        this.percentHeal = p;
        this.description = d;
        this.amount = 0;
        itemList.add(this);
    }

    /**
     * Returns name of Item
     * @return name of Item
     */
    public String getName()
    {
        return(this.itemName);
    }
    /**
     * Returns buff of Item
     * @return buff of Item
     */
    public String getBuff()
    {
        return(this.buff);
    }
    /**
     * Returns userHeal of Item
     * @return userHeal of Item
     */
    public int getUHeal()
    {
        return(this.userHeal);
    }
    /**
     * Returns enemyHeal of Item
     * @return enemyHeal of Item
     */
    public int getEHeal()
    {
        return(this.enemyHeal);
    }
    /**
     * Returns percentHeal of Item
     * @return percentHeal of Item
     */
    public int getPHeal()
    {
        return(this.percentHeal);
    }
    /**
     * Returns description of Item
     * @return description of Item
     */
    public String getDesc()
    {
        return(this.description);
    }
    /**
     * Returns amount of Item
     * @return amount of Item
     */
    public int getAmt()
    {
        return(this.amount);
    }
    /**
     * Deceases the amount of an Item by 1
     */
    public void used()
    {
        this.amount -= 1;
    }
}