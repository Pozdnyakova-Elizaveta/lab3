package lab3;
class Command_know{
     boolean sit;
     boolean to_me;
     boolean lie;

     public Command_know(boolean sit, boolean to_me, boolean lie){
         this.sit = sit;
         this.to_me = to_me;
         this.lie=lie;
     }
     public Command_know(boolean sit){
         this.sit=sit;
     }

     public Command_know(){
     }

     public void display(){
         System.out.print("Ваша собака знает команды: ");
         if (sit) System.out.print("сидеть, ");
         if (to_me) System.out.print("ко мне, ");
         if (lie) System.out.print("лежать");
         System.out.println("");
     }
}