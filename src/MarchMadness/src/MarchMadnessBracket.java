import java.util.*;

public class MarchMadnessBracket
{
        public static Random r = new Random();
        public static Integer jew = r.nextInt(2);
        public static void main(String[] args)
        {
                beAJew();
        }
        public static void beAJew(){

                Scanner input = new Scanner(System.in);

                System.out.println("Enter a team: ");
                String team1 = input.next();

                System.out.println("Enter second team: ");
                String team2 = input.next();
                r = new Random();
                jew = r.nextInt(2);
                System.out.println(jew);
                jew = jew + 1;
                System.out.println(jew);
                if(jew==1){
                        System.out.println(team1 + " wins");
                }

                if(jew==2){
                        System.out.println(team2 + " wins");
                }
                beAJew();

        }
}
