package mainApi;

public class PokemonMain {

   public int height;
   public int id;
   public String name;
   public Sprites sprites;
   public int weight;
   public Species species;
   public Types[] types;
   
   
   public int getHeight() {
      return height;
   }
   
   public int getId () {
      return id;
   }
   
   public String getName() {
      return name.substring(0, 1).toUpperCase() + name.substring(1);
   }
   
   public Sprites getSprites(){
      return sprites;
   }
   
   
   public int getWeight () {
      return weight;
   }
   
   public Species getSpecies () {
      return species;
   }
   
   public Types[] getTypes(){
      return types;
   }
   
   
}