import java.util.ArrayList;
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
}
