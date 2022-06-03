import java.util.concurrent.ThreadLocalRandom;
/**
 * The User class is a subclass of Entity and represents the User. The User has a score, enemiesDefeated, and can use items.
 * 
 * @author Ash Choi
 */
public class User extends Entity
{
    private int score, enemiesDefeated = 0;
    private Item selectedItem = null;
    boolean debuffApplied = false;
    
    //constructor
    public User(String n, boolean aggro)
    {
        super(n, aggro);
        score = 0;
        enemiesDefeated = 0;
        selectedItem = null;
    }

    /**
     * Attacks another Entity. Damage dealt is calculated based on stats of both attacker and victim.
     * Enemy debuff may be applied based on random chance.
     * @param e Input Entity to be attacked
     */
    public void attackEntity(Entity e)
    {
        int dmgDone = this.getAtk();
        int resist = e.getDef();

        //determine if enemy debuff will be applied or not
        int randInt = ThreadLocalRandom.current().nextInt(1, 100 + 1);
        debuffApplied = false;
        if(randInt <= e.getDBChance())
        {
            debuffApplied = true;
        }
        /*
        //cancel debuff if selected item gives you immunity
        if(this.selectedItem.getBuff().equals("immune"))
        {
            debuffApplied = false;
        }
        */
        //applying debuff
        if(debuffApplied)
        {
            switch(e.getAbility())
            {
                case "weakened":
                    dmgDone = (int)(dmgDone * 0.75);
                    System.out.println(e.getName() + " caused you to be weakened! Your attack went down!");
                    break;
                case "deficient":
                    System.out.println(e.getName() + " caused you to be deficient! Your defense went down!");
                    break;
                case "poisoned":
                    dmgDone = (int)(dmgDone * 0.75);
                    this.changeHPby(-1 * ((int)(this.getMHP() * 0.1)));
                    System.out.println(e.getName() + " poisoned you! All stats went down!");
                    break;
                case "bleed":
                    this.changeHPby(-1 * ((int)(this.getMHP() * 0.2)));
                    System.out.println(e.getName() + " caused you to bleed! You suffered some damage!");
                    break;
                case "paralyzed":
                    int x = ThreadLocalRandom.current().nextInt(1, 100 + 1);
                    if(x <= 30) {dmgDone = 0; System.out.println(e.getName() + " paralyzed you! Your attack missed!");}
                    break;
                case "confused":
                    int y = ThreadLocalRandom.current().nextInt(1, 100 + 1);
                    if(y <= 25)
                    {
                        this.changeHPby((int)(-1 * dmgDone * 0.5));
                        dmgDone = 0;
                        System.out.println(e.getName() + " confused you! You accidentally hit yourself!");
                    }
                    break;
                case "frozen":
                    selectedItem = null; 
                    System.out.println(e.getName() + " froze you! You were prevented from using items!");
            }
        }
        /*
        //item hp effects are applied
        if(selectedItem != null)
        {
            if(selectedItem.getName() != "Twin Popsicle")
            {
                this.changeHPby(selectedItem.getUHeal());
                e.changeHPby(selectedItem.getEHeal());
                this.changeHPby((int)((selectedItem.getPHeal() * 0.01) * this.getMHP()));
            } else
            {
                int healAmt = (int)(selectedItem.getPHeal() * 0.01 * this.getMHP());
                this.changeHPby(healAmt);
                e.changeHPby(healAmt);
            }
        }
        //cycle through buffs
        String buff = selectedItem.getBuff();
        if(buff != null)
        {
            switch(buff)
            {
                case "supercharged":
                    dmgDone += (int)(dmgDone * 0.5);
                    break;
                case "strength":
                    dmgDone += (int)(dmgDone * 0.5);
                    break;
            }
        }

        if(selectedItem != null) selectedItem.used();

        //finally */
        dmgDone = dmgDone - resist;
        if(dmgDone < 0) {dmgDone = 0;}
        e.changeHPby(-1 * dmgDone);
        System.out.println("You dealt " + dmgDone + " damage to " + e.getName() + "!");
    }

    @Override
    public String getAbility()
    {
        return(null);
    }
    /**
     * Returns score of User
     * @return score of User
     */
    public int getScore()
    {
        return(this.score);
    }
    /**
     * Returns debuffApplied state of User
     * @return debuffApplied of User
     */
    public boolean getDBApplied()
    {
        return(this.debuffApplied);
    }
    /**
     * Returns selectedItem of User
     * @return selectedItem of User
     */
    public Item getSelectedItem()
    {
        return(this.selectedItem);
    }
    /**
     * Returns enemiesDefeated of User
     * @return enemiesDefeated of User
     */
    public int getKills()
    {
        return(this.enemiesDefeated);
    }
    /**
     * Increases enemiesDefeated by 1 and score by 500
     */
    public void increaseKills()
    {
        this.enemiesDefeated++;
        this.score += 500;
    }
}