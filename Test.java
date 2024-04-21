public class Test
{
   
   public static void main (String[] args)
   {
      Pokemon test = new Pokemon("123");
      
      System.out.println(test.getName());
      System.out.println(test.getId());
      System.out.println(test.getHeight());
      System.out.println(test.getEvolution());
      System.out.print(test.getFlavorText());
/*
      System.out.println("ID: " + p.getId());
      System.out.println("Height: " + p.getHeight());
      System.out.println("Weight: " + p.getWeight());
      System.out.println("Sprite URL: " + p.getSprites().getOther().getOfficialArtwork().getFront_Default());
      System.out.print("Species URL: " + p.getSpecies().getUrl());  
*/
   }
   
}