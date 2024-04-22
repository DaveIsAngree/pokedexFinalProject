package subApi;

public class Evolves_From_Species {

   public String name;
   
   public String getEvolutionName()
   {
         return name.substring(0, 1).toUpperCase() + name.substring(1);
   }
   
}