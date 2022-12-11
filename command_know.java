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

     public String toString(){
         String s;
         s="Ваша собака знает команды: ";
         if (sit) s=s+"сидеть, ";
         if (to_me) s=s+"ко мне, ";
         if (lie) s=s+"лежать";
         return s;
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