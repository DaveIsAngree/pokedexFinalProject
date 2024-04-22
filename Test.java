public class Test
{
   
   public static void main (String[] args)
   {
      
      
      for (int i = 1; i<=5; i++){
         Pokemon test = new Pokemon(Integer.toString(i));
         
         System.out.println("\n******************");
         System.out.println("Name: " + test.getName());
         System.out.println("ID: " + test.getId());
         System.out.println("Height: " + test.getHeight());
         System.out.println("Weight: " + test.getWeight());
         System.out.println("Sprite: " + test.getSprite());
         System.out.println("Color: " + test.getColor());
         System.out.println("Evolves From: " + test.getEvolution());
         System.out.println(test.getFlavorText());
         System.out.println("******************\n");
         
      }
      

   }
   
}