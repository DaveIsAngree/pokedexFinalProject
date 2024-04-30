package mainApi;

/**
Holds the data from the main API call
*/
public class PokemonMain {

   
   /**The height of the Pokemon*/
   public int height;
   /**The ID of the Pokemon*/
   public int id;
   /**The name of the Pokemon*/
   public String name;
   /**The "Sprites" data object within the API response*/
   public Sprites sprites;
   /**The weight of the pokemon*/
   public int weight;
   /** The "Species" data object within the API response*/
   public Species species;
   /**The "Types" data object within the API response*/
   public Types[] types;
   
/**
Returns the height of the pokemon

@return The height of the pokemon
*/
   public int getHeight() {      
      return height;
   }

/**
Returns the ID of the pokemon

@reutn The ID of the pokemon
*/   
   public int getId () {
      return id;
   }
   
/**
Returns the name of the pokemon formatted for proper case

@return The name of the pokemon
*/
   public String getName() {
      return name.substring(0, 1).toUpperCase() + name.substring(1);
   }

/**
Returns the "Sprites" data object from the API response

@return The "Sprites" data object from the API response
*/
   public Sprites getSprites(){
      return sprites;
   }
   
/**
Returns the weight of the pokemon

@return the weight of the pokemon
*/   
   public int getWeight () {
      
      return weight;
   }
   
/**
Returns the "Species" data object from the API response

@return The "Species" data object from the API response
*/
   public Species getSpecies () {
      return species;
   }

/**
Returns the "Types" data object from the API response

@return The "Types" data object from the API response
*/   
   public Types[] getTypes(){
      return types;
   }
   
   
}