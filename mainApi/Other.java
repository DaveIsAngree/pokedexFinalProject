package mainApi;

import com.google.gson.annotations.SerializedName;

/**
Represents the nested "Other" data object within the API response
Nested within the Sprites data object
*/
public class Other {

/**
Represents the "Official-Artwork" data object within the API response
*/
   @SerializedName("official-artwork")
   public OfficialArtwork officialArtwork;
   
/**
Returns the "Official-Artwork" data object within the API response

@return The "Official-Artwork" data object within the API response
*/
   public OfficialArtwork getOfficialArtwork () {
      return officialArtwork;
   }
   
}