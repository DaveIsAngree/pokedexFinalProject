package mainApi;

/**
Holds the "Type" data object from the API response
*/
public class Type
{
   /**The type name of the pokemon*/
   public String name;

/**
Returns the type name of the pokemon

@return The type name of the pokemon
*/
   public String getTypeName(){
      return name;
   }
}