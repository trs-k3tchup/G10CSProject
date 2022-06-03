import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/**
 * EnemyTypes serve as templates for generating Enemies.
 * 
 * @author Ash Choi
 */
public class EnemyType
{
    private static ArrayList<EnemyType> enemyList = new ArrayList<EnemyType>();
    private String name, debuff, description;
    private boolean aggro;
    private int debuffChance;

    public EnemyType(String n, String db, int dbC, boolean a, String d)
    {
        name = n;
        debuff = db;
        debuffChance = dbC;
        aggro = a;
        description = d;
        enemyList.add(this);
    }

    /**
     * Returns name of EnemyType
     * @return name of EnemyType
     */
    public String getName()
    {
        return(this.name);
    }
    /**
     * Returns debuff of EnemyType
     * @return debuff of EnemyType
     */
    public String getDebuff()
    {
        return(this.debuff);
    }
    /**
     * Returns debuffChance of EnemyType
     * @return debuffChance of EnemyType
     */
    public int getDBChance()
    {
        return(this.debuffChance);
    }
    /**
     * Returns aggro state of EnemyType
     * @return aggro state of EnemyType
     */
    public boolean isAggro()
    {
        return(this.aggro);
    }
    /**
     * Returns description of EnemyType
     * @return description of EnemyType
     */
    public String getDesc()
    {
        return(this.description);
    }
    /**
     * Returns size of enemyList
     * @return size of enemyList
     */
    public static int getListSize()
    {
        return(enemyList.size());
    }
    /**
     * Returns an EnemyType given an index
     * @param index Index to search for
     * @return EnemyType
     */
    public static EnemyType getTypeByIndex(int index)
    {
        return enemyList.get(index);
    }
}
