import java.util.concurrent.ThreadLocalRandom;

public class User extends Entity
{
    private int score, enemiesDefeated = 0;
    private Item selectedItem = null;
    boolean debuffApplied = false;
    
    //constructor
    public User(String n, boolean aggro)
    {
        super(n, aggro);
    }

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
        
        if(selectedItem.getBuff() == "immune") debuffApplied = false;

        //applying debuff
        if(debuffApplied)
        {
            switch(e.getAbility())
            {
                case "weakened":
                    dmgDone = (int)(dmgDone * 0.75);
                    break;
                case "deficient":
                    break;
                case "poisoned":
                    dmgDone = (int)(dmgDone * 0.75);
                    this.changeHPby(-1 * ((int)(this.getMHP() * 0.1)));
                    break;
                case "bleed":
                    this.changeHPby(-1 * ((int)(this.getMHP() * 0.2)));
                    break;
                case "paralyzed":
                    int x = ThreadLocalRandom.current().nextInt(1, 100 + 1);
                    if(x <= 30) {dmgDone = 0;}
                    break;
                case "confused":
                    int y = ThreadLocalRandom.current().nextInt(1, 100 + 1);
                    if(y <= 25)
                    {
                        this.changeHPby((int)(-1 * dmgDone * 0.5));
                        dmgDone = 0;
                    }
                    break;
                case "frozen":
                    selectedItem = null; 
            }
        }

        //use item
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

        //finally
        dmgDone = dmgDone - resist;
        if(dmgDone < 0) {dmgDone = 0;}
        e.changeHPby(-1 * dmgDone);
    }

    @Override
    public String getAbility()
    {
        return(null);
    }

    public int getScore()
    {
        return(this.score);
    }

    public boolean getDBApplied()
    {
        return(this.debuffApplied);
    }

    public Item getSelectedItem()
    {
        return(this.selectedItem);
    }
}