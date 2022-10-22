package lab3;
class Needs{
     boolean eat;
     boolean walk;

     public Needs(boolean eat, boolean walk){
         this.eat = eat;
         this.walk = walk;
     }
     public Needs(boolean eat){
         this.eat=eat;
         this.walk = true;
     }

     public Needs(){
         this.eat=true;
         this.walk = true;
     }

     public void display(){
         System.out.print("Ваша собака хочет: ");
         if (eat) System.out.print("есть, ");
         if (walk) System.out.print("гулять");
         System.out.println("");
     }
}