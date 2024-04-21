package subApi;

public class PokemonSupplementary {

   public Color color;
   public Evolves_From_Species evolves_from_species;
   public Flavor_Text_Entries[] flavor_text_entries;
   
   public Color getColor()
   {
      return color;
   }
   
   public Evolves_From_Species getEvolution()
   {
      return evolves_from_species;
   }
   
   public Flavor_Text_Entries[] getFlavor_Text_Entries ()
   {
      return flavor_text_entries;
   }
   
   

}