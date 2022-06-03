import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

class Project
{
    public static void main(String[] args)
    {
        //read enemy.csv file and create enemytypes
        File enemyList = new File("G10CSProject\\Data\\enemies.csv");
        try (FileReader fr = new FileReader(enemyList))
        {
            BufferedReader reader = new BufferedReader(fr);
            String line;
            while((line = reader.readLine()) != null)
            {
                String details[] = line.split(",");
                new EnemyType(details[0], details[1], Integer.parseInt(details[2]), Boolean.parseBoolean(details[3]), details[4]);
            }
        } catch (IOException e1)
        {
            e1.printStackTrace();
        }

        //read items.csv file and create items
        File itemList = new File("G10CSProject\\Data\\items.csv");
        try (FileReader fr = new FileReader(itemList))
        {
            BufferedReader reader = new BufferedReader(fr);
            String line;
            while((line = reader.readLine()) != null)
            {
                String details[] = line.split(",");
                new Item(details[0], details[1], Integer.parseInt(details[2]), Integer.parseInt(details[3]), Integer.parseInt(details[4]), details[5]);
            }
        } catch (IOException e1)
        {
            e1.printStackTrace();
        }
    }
}