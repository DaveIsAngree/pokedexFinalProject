package mainApi;

import com.google.gson.annotations.SerializedName;

public class Other {

   @SerializedName("official-artwork")
   public OfficialArtwork officialArtwork;
   
   public OfficialArtwork getOfficialArtwork () {
      return officialArtwork;
   }
   
}