import java.util.Scanner;

public class p15_NeighbourWars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int peshosDamage = Integer.parseInt(scanner.nextLine());
        int goshosDamage = Integer.parseInt(scanner.nextLine());

        int peshosHealth = 100;
        int goshosHealth = 100;
        int heal = 10;
        int turn = 1;

        String pesho = "Pesho";
        String gosho = "Gosho";
        String peshosAttack = "Roundhouse kick";
        String goshosAttack = "Thunderous fist";

        Boolean isAlive = true;

        while (isAlive)
        {
            if (turn % 2 == 1) // Pesho's turn
            {
                goshosHealth -= peshosDamage;

                if (goshosHealth > 0)
                {
                    System.out.printf("%s used %s and reduced %s to %d health.\n", pesho, peshosAttack, gosho, goshosHealth);
                }
            }
            else if (turn % 2 == 0) // Gosho's turn
            {
                peshosHealth -= goshosDamage;

                if (peshosHealth > 0)
                {
                    System.out.printf("%s used %s and reduced %s to %d health.\n", gosho, goshosAttack, pesho, peshosHealth);
                }
            }

            if (goshosHealth <= 0) // Condition when one of the players is dead
            {
                System.out.printf("%s won in %dth round.\n", pesho, turn);
                isAlive = false;
            }
            else if (peshosHealth <= 0)
            {
                System.out.printf("%s won in %dth round.\n", gosho, turn);
                isAlive = false;
            }

            if (turn % 3 == 0) // Healing
            {
                goshosHealth += heal;
                peshosHealth += heal;
            }

            turn++;
        }
    }
}
