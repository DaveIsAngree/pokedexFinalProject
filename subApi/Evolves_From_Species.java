package subApi;

/**
Represents the "Evolves_From_Species" data object returned from the API
*/
public class Evolves_From_Species {

   /**The name of the pokemon from which the target pokemon evolves*/
   public String name;
   
/**
Returns the name of the pokemon from which the target pokemon evolves

@return The name of the pokemon from which the target pokemon evolves
*/
   public String getEvolutionName()
   {
         return name.substring(0, 1).toUpperCase() + name.substring(1);
   }
   
}