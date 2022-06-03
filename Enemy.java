import java.util.concurrent.ThreadLocalRandom;
/**
 * An Enemy is an automatically generated Entity for the User to fight.
 * Enemies have a debuff ability and a debuffChance, which may be applied to the user.
 * 
 * @author Ash Choi
 */
public class Enemy extends Entity
{
    private String ability;
    private String description;

    //constructor
    public Enemy(String n, int l, boolean aggro, int db, String a, String d)
    {
        super(n, l, aggro, db);
        ability = a;
        description = d;
    }
    /**
     * Attacks another Entity. Damage dealt is calculated based on stats of both attacker and victim.
     * Checks the User for buffs and debuffs.
     * @param u
     */
    public void attackEntity(User u)
    {
        int dmgDone = this.getAtk();
        int resist = u.getDef();

        //check for debuff
        if(u.getDBApplied())
        {
            switch(ability)
            {
                case "deficient":
                    resist = (int)(resist * 0.75);
                    break;
                case "poisoned":
                    resist = (int)(resist * 0.75);
                    break;
            }
        }
        //check for item buff
        if(u.getSelectedItem() != null)
        {
            switch(u.getSelectedItem().getBuff())
            {
                case "supercharged":
                    resist += (int)(resist * 0.5);
                    break;
                case "tough":
                    resist += (int)(resist * 0.5);
                    break;
                case "evasive":
                    int x = ThreadLocalRandom.current().nextInt(1, 100 + 1);
                    if(x < 50) dmgDone = 0;
            }
        }
        
        //finally
        dmgDone = dmgDone - resist;
        if(dmgDone < 0) dmgDone = 0;
        u.changeHPby(-1 * dmgDone);
    }
    /**
     * Returns ability of Enemy
     * @return ability of Enemy
     */
    public String getAbility()
    {
        return(ability);
    }
    /**
     * Returns description of Enemy
     * @return description of Enemy
     */
    public String getDesc()
    {
        return(description);
    }
}