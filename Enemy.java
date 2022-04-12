import java.util.concurrent.ThreadLocalRandom;

public class Enemy extends Entity
{
    String ability;

    //constructor
    public Enemy(String n, int l, boolean aggro, int db, String a)
    {
        super(n, l, aggro, db);
        ability = a;
    }

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

    public String getAbility()
    {
        return(ability);
    }
}