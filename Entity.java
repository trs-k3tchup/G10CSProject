public abstract class Entity
{
    private String name, debuff;
    private int level, attack, defense, maxHP, healthPoints, debuffChance;

    //constructor
    public Entity(String n, int l, boolean aggro, int db)
    {
        this.name = n;
        this.debuff = null;
        this.level = l;

        if(aggro)
        {
            this.attack = l * 3;
            this.defense = l * 2;
        } else
        {
            this.attack = l * 2;
            this.defense = l * 3;
        }
        
        this.maxHP = l * 10;
        this.healthPoints = maxHP;
        this.debuffChance = db;
    }
    //constructor (but for user)
    public Entity(String n, boolean aggro)
    {
        this.name = n;
        this.debuff = null;
        this.level = 1;

        if(aggro)
        {
            this.attack = 3;
            this.defense = 2;
        } else
        {
            this.attack = 2;
            this.defense = 3;
        }
        
        this.maxHP = 10;
        this.healthPoints = maxHP;
    }

    //getter setter
    public String getName()
    {
        return(this.name);
    }
    public int getLvl()
    {
        return(this.level);
    }
    public int getAtk()
    {
        return(this.attack);
    }
    public int getDef()
    {
        return(this.defense);
    }
    public int getMHP()
    {
        return(this.maxHP);
    }
    public int getHP()
    {
        return(this.healthPoints);
    }
    public void changeHPby(int h)
    {
        this.healthPoints += h;
        if(this.healthPoints > this.maxHP)
        {
            this.healthPoints = this.maxHP;
        }
    }
    public int getDBChance()
    {
        return(this.debuffChance);
    }
    public abstract String getAbility();

    //level up
    public void levelUp()
    {
        this.level++;
        this.attack++;
        this.defense++;
        this.maxHP += 10;
        this.healthPoints = this.maxHP;
    }
}