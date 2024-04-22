package subApi;

public class Flavor_Text_Entries {

   public String flavor_text;
   public Language language;

   public String getFlavor_Text()
   {
      
      String replaceTarget = "";
      String editedFlavorText = flavor_text.replace(replaceTarget, "\n");
      return editedFlavorText;
   }
   
   public Language getLanguage()
   {
      return language;
   }
   
}