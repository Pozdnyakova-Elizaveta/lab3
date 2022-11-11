package lab3;
class Command_know{
     private boolean sit;
     private boolean to_me;
     private boolean lie;

     public Command_know(boolean sit, boolean to_me, boolean lie){
         this.sit = sit;
         this.to_me = to_me;
         this.lie=lie;
     }
     public Command_know(boolean sit){
         this.sit=sit;
         to_me = false;
         lie=false;
     }

     public Command_know(){
         sit=false;
         to_me = false;
         lie=false;
     }

     public void display(){
         System.out.print("Ваша собака знает команды: ");
         if (sit) System.out.print("сидеть, ");
         if (to_me) System.out.print("ко мне, ");
         if (lie) System.out.print("лежать");
         System.out.println("");
     }
     public boolean get_sit(){
         return sit;
     }
     public boolean get_to_me(){
         return to_me;
     }
     public boolean get_lie(){
         return lie;
     }
     public void set_sit(boolean sit){
         this.sit=sit;
     }
     public void set_to_me(boolean to_me){
         this.to_me=to_me;
     }
     public void set_lie(boolean lie){
         this.lie=lie;
     }
}