/**
 * An Entity is the superclass of the User and the Enemy. It has a name, level, healthPoints, debuff, and debuffChance.
 * Variables like attack, defense, and maxHP are calculated based on level.
 * 
 * @author Ash Choi
 */
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

        //entities with "aggro" have more attack than defense
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

    /**
     * Returns name of Entity
     * @return name of Entity
     */
    public String getName()
    {
        return(this.name);
    }
    /**
     * Returns level of Entity
     * @return level of Entity
     */
    public int getLvl()
    {
        return(this.level);
    }
    /**
     * Returns attack value of Entity
     * @return attack of Entity
     */
    public int getAtk()
    {
        return(this.attack);
    }
    /**
     * Returns defense value of Entity
     * @return defense of Entity
     */
    public int getDef()
    {
        return(this.defense);
    }
    /**
     * Returns maxHP of Entity
     * @return maxHP of Entity
     */
    public int getMHP()
    {
        return(this.maxHP);
    }
    /**
     * Returns healthPoints of Entity
     * @return healthPoints of Entity
     */
    public int getHP()
    {
        return(this.healthPoints);
    }
    /**
     * Changes healthPoints of Entity by h. If the resulting healthPoints exceeds maxHP, it is set to maxHP to prevent overflow.
     * @param h Input amount to change HP by
     */
    public void changeHPby(int h)
    {
        this.healthPoints += h;
        if(this.healthPoints > this.maxHP)
        {
            this.healthPoints = this.maxHP;
        }
    }
    /**
     * Returns debuffChance of Entity
     * @return debuffChance of Entity
     */
    public int getDBChance()
    {
        return(this.debuffChance);
    }
    public abstract String getAbility();

    /**
     * Handles leveling-up. Increases level by 1, attack and defense by one, and maxHP by 10. healthPoints are fully restored.
     */
    public void levelUp()
    {
        this.level++;
        this.attack+=3;
        this.defense+=3;
        this.maxHP += 10;
        this.healthPoints = this.maxHP;
        System.out.println("You levelled up! Your current level is now " + this.level);
    }
}