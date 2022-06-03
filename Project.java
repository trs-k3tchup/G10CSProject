import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

class Project
{
    public static void main(String[] args)
    {
        //read enemy.csv file and create enemytypes
        File enemyList = new File("Data\\enemies.csv");
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

        Scanner sc = new Scanner(System.in);
        String answer;

        //the main stuff ooh baby
        //the real bread and butter
        //thunder mountain baby

        System.out.println("What is your name, adventurer?");
        String name = sc.nextLine();
        System.out.println("Will you play aggressively or defensively? (agr/def)");
        answer = sc.nextLine();
        boolean isAggro = true;
        if(!answer.toLowerCase().equals("agr") && !answer.toLowerCase().equals("def"))
        {
            do
            {
                System.out.println("Invalid input. Will you play aggressively or defensively? (agr/def)");
                answer = sc.nextLine();
            } while(!answer.toLowerCase().equals("agr") && !answer.toLowerCase().equals("def"));
        }
        switch(answer)
        {
            case "agr":
                isAggro = true;
            case "def":
                isAggro = false;
        }

        User player = new User(name, isAggro);
        Enemy currentEnemy;
        System.out.println("Welcome, " + player.getName() + "!");
        //EnemyType.generate();

        //main loop
        while(player.getHP() > 0)
        {
            int enemyType = ThreadLocalRandom.current().nextInt(0, 15);
            currentEnemy = new Enemy(EnemyType.getTypeByIndex(enemyType).getName(),
                                    player.getLvl(),
                                    EnemyType.getTypeByIndex(enemyType).isAggro(),
                                    EnemyType.getTypeByIndex(enemyType).getDBChance(),
                                    EnemyType.getTypeByIndex(enemyType).getDebuff(),
                                    EnemyType.getTypeByIndex(enemyType).getDesc());
            
            System.out.println(currentEnemy.getName() + " blocks your way. What will you do?");
            System.out.println("1. Check");
            System.out.println("2. Fight");
            System.out.println("3. Item");
            answer = sc.nextLine();
        }
    }
}