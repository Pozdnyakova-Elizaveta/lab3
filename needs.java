package lab3;
class Needs{
     private boolean eat;
     private boolean walk;

     public Needs(boolean eat, boolean walk){
         this.eat = eat;
         this.walk = walk;
     }
     public Needs(boolean eat){
         this.eat=eat;
         walk = true;
     }

     public Needs(){
         eat=true;
         walk = true;
     }

     public void display(){
         System.out.print("Ваша собака хочет: ");
         if (eat) System.out.print("есть, ");
         if (walk) System.out.print("гулять");
         System.out.println("");
     }
     public boolean get_eat(){
         return eat;
     }
     public boolean get_walk(){
         return walk;
     }
     public void set_eat(boolean eat){
         this.eat=eat;
     }
     public void set_walk(boolean walk){
         this.walk=walk;
     }
}