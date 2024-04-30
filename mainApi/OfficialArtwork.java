package mainApi;

/**
Represents the "Official-Artwork" data object within the API response
Nested within the Other data object
*/
public class OfficialArtwork {

/**
Represents the "front_default" data object within the API response
*/
   public String front_default;
   
/**
Returns the "front_default" data object within the API response

@return The "front_default" data object within the API response
*/
   public String getFront_Default(){
      return front_default;
   }
   
}