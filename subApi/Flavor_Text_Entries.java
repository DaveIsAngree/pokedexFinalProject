package subApi;

/**
Represents the "Flavor_Text_Entries" data object within the API response
*/
public class Flavor_Text_Entries {

   /**The text of the flavor_text*/
   public String flavor_text;
   /**Represents the "Language" object returned from the API*/
   public Language language;

/**
Returns the formated flavor text for the pokemon

@return The formated flavor text for the pokemon
*/
   public String getFlavor_Text()
   {
      
      String replaceTarget = "";
      String editedFlavorText = flavor_text.replace(replaceTarget, "\n");
      return editedFlavorText;
   }
   
/**
Returns the "Language" object

@return The "Language" object
*/
   public Language getLanguage()
   {
      return language;
   }
   
}