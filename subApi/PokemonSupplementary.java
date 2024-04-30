package subApi;

/**
Holds the data from the supplementary API call
*/
public class PokemonSupplementary {

   /**The "Color" data object within the API response*/
   public Color color;
   /**The "Evolves_From_Species" data object within the API response*/
   public Evolves_From_Species evolves_from_species;
   /**The "Flavor_Text_Entries" data object within the API response*/
   public Flavor_Text_Entries[] flavor_text_entries;
   
/**
Returns the "Color" data object

@return The "Color" data object
*/
   public Color getColor()
   {
      return color;
   }
   
/**
Returns the "Evolves_From_Species" data object

@return The "Evolves_From_Species" data object
*/
   public Evolves_From_Species getEvolution()
   {
      return evolves_from_species;
   }
   
/**
Returns the "Flavor_Text_Entries" data object

@return The "Flavor_Text_Entries" data object
*/
   public Flavor_Text_Entries[] getFlavor_Text_Entries ()
   {
      return flavor_text_entries;
   }
   
   

}