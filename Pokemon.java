import java.net.URL;
import java.util.Scanner;
import java.util.ArrayList;
import com.google.gson.Gson;
import mainApi.PokemonMain;
import subApi.PokemonSupplementary;

/**
Creates a Pokemon object and stores associated data
*/
public class Pokemon
{

   /**Holds data read from the main (first) API call*/
   private String mainData;
   /**Holds data read from the sub (second) API call*/
   private String subData;
   
   
   //Data for the Pokemon object
   
   /**The height of the Pokemon*/
   private int height;
   /**The ID of the Pokemon*/
   private int id;
   /**The name of the Pokemon*/
   private String name;
   /**The weight of the Pokemon*/
   private double weight;
   /**The URL address for the sprite of the Pokemon*/
   private String sprite;
   /**The flavor text (description) of the Pokemon*/
   private String flavorText;
   /**The color key for the Pokemon*/
   private String color;
   /**The species from which the Pokemon evolves*/
   private String evolution;
   /**The "types" for the Pokemon*/
   private ArrayList<String> pokemonTypes = new ArrayList<String>();
   
   
   
/**
Creates a Pokemon object by passing the Pokemon's name or ID number to the API

@param pokemonQuery The Pokemon's name or ID number to the API
*/   
   public Pokemon (String pokemonQuery)
   {
   
      //IO try/catch
      try {
         URL url = new URL("https://pokeapi.co/api/v2/pokemon/" + pokemonQuery);
         Scanner scanner = new Scanner(url.openStream());
         mainData = scanner.nextLine();
      }
      catch (Exception e) { //Exception handling
         System.out.print("Pokemon Not Found ");
      }
      
      Gson pokemonMainGson = new Gson(); //Create a new Gson object
         
      PokemonMain p = pokemonMainGson.fromJson(mainData, PokemonMain.class); //Parse the data
      
      
      //IO try/catch
      try {
         URL url = new URL(p.getSpecies().getUrl());
         Scanner scanner = new Scanner(url.openStream());
         subData = scanner.nextLine();
      }
      catch (Exception e) { //Exception handling
         System.out.print("Pokemon Not Found ");
      } 
      Gson pokemonSubGson = new Gson();
      PokemonSupplementary s = pokemonSubGson.fromJson(subData, PokemonSupplementary.class);

      //Set the information for the Pokemon
      this.name = p.name.substring(0, 1).toUpperCase() + p.name.substring(1);
      this.id = p.getId();
      this.height = p.getHeight();
      this.weight = p.getWeight() * 0.220462; // 1 hg = 0.220462 lbs
      this.sprite = p.getSprites().getOther().getOfficialArtwork().getFront_Default();
      this.color = s.getColor().getColorName();
      if (s.evolves_from_species != null)
         this.evolution = s.getEvolution().getEvolutionName();
      else
         this.evolution = "Base Evolution";
      
      this.flavorText = s.getFlavor_Text_Entries()[findFlavorText(s.getFlavor_Text_Entries().length, s)].getFlavor_Text();
      this.pokemonTypes = setTypes(p.getTypes().length, p);
      

   }
   
/**
Iterates through the pokemon types returned by the API call and adds them to the array list

@param arrayLegnth The number of items to iterate over, should normally be set to the total legnth of the types array
@param p The Pokemon main api gson object
@return The filled arraylist of pokemon types
*/
   public ArrayList<String> setTypes(int arrayLegnth, PokemonMain p)
   {
      for (int i = 0; i < arrayLegnth; i++)
         pokemonTypes.add(p.getTypes()[i].getType().getTypeName());
      return pokemonTypes;
   }
   
/**
Iterates through the flavor text enteries seaching for the first english version

@param arrayLegnth The number of items to iterate over, should normally be set to the total legnth of the flavor_text_entries array
@param s The Pokemon sub api gson object
@return The index location of the first english flavor text
*/
      
   public int findFlavorText(int arrayLegnth, PokemonSupplementary s)
   {
      String enFlavorText = s.getFlavor_Text_Entries()[0].getLanguage().getLanguageName();
      int indexLocation = 0;
      
      for (int i = 1; i < arrayLegnth; i++)
         if (!enFlavorText.equals("en"))
         {
            enFlavorText = s.getFlavor_Text_Entries()[i].getLanguage().getLanguageName();
            indexLocation++;
         }
         else
            break;
      
      return indexLocation;
      
   }
            
/**
Returns the name of the pokemon

@return The name of the pokemon
*/     
   public String getName()
   {
         return name;
   }
   
/**
Returns the ID of the Pokemon

@return The ID of the Pokemon
*/
   public int getId()
   {
      return id;
   }

/**
Returns the height of the Pokemon

@return the height of the Pokemon
*/   
   public int getHeight()
   {
      return height;
   }
   
/**
Returns the weight of the Pokemon

@return the weight of the Pokemon
*/
   public double getWeight()
   {
      return weight;
   }
   
/**
Returns the color of the Pokemon

@return The color of the Pokemon
*/
   public String getColor()
   {
      return color;
   }
   
/**
Returns the Pokemon from which the target Pokemon evloves

@return The Pokemon from which the target Pokemon evloves
*/ 
   public String getEvolution()
   {
      if (evolution != null )
         return evolution;
      else
         return "null";
   }
   
/**
Returns the URL for the sprite of the Pokemon

@return the URL for the sprite of the Pokemon
*/
   public String getSprite()
   {
      return sprite;
   }
   
/**
Returns the flavor text for the Pokemon

@return The flavor text for the Pokemon
*/
   public String getFlavorText()
   {
      return flavorText;
   }
   
/**
Returns the types list for the Pokemon

@return The types list for the Pokemon
*/
   public ArrayList<String> getTypes()
   {
      return pokemonTypes;
   }
   


}