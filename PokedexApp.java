import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Screen;
import java.util.Random;
import java.util.prefs.Preferences;

public class PokedexApp extends Application {

    private TextField searchField;
    private Button searchButton, randomButton;
    private TextArea displayArea;
    private ImageView spriteImageView;
    private CheckBox darkModeToggle;
    private static final String DARK_MODE_KEY = "darkModeEnabled";

    @Override
    public void start(Stage primaryStage) {
        //initialize GUI components
        searchField = new TextField();
        searchField.setPromptText("Enter a Pokémon name or ID to search");
        searchButton = new Button("Search");
        randomButton = new Button("Random Pokémon");
        displayArea = new TextArea();
        displayArea.setEditable(false);
        spriteImageView = new ImageView();
        darkModeToggle = new CheckBox("Dark Mode");

        // retrieves user preference for dark mode
        Preferences prefs = Preferences.userNodeForPackage(PokedexApp.class);
        boolean darkModeEnabled = prefs.getBoolean(DARK_MODE_KEY, false);
        darkModeToggle.setSelected(darkModeEnabled);


        //event handlers
        searchButton.setOnAction(e -> searchPokemon());
        randomButton.setOnAction(e -> getRandomPokemon());
        darkModeToggle.setOnAction(e -> toggleDarkMode());

        //title text
        Text titleText = new Text("Pokédex");
        titleText.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        titleText.setFill(Color.YELLOW);
        titleText.setStroke(Color.BLUE);
        titleText.setStrokeWidth(1.5);

        //top VBox for title, search, random buttons, and dark mode toggle
        VBox topBox = new VBox(10);
        topBox.getChildren().addAll(titleText, searchField, searchButton, randomButton, darkModeToggle);
        topBox.setPadding(new Insets(20));
        VBox.setMargin(randomButton, new Insets(10, 0, 0, 0));

        //center VBox for displaying Pokémon details
        VBox detailsBox = new VBox(10);
        detailsBox.getChildren().addAll(displayArea, spriteImageView);
        detailsBox.setPadding(new Insets(20));

        //borderPane for the overall layout
        BorderPane root = new BorderPane();
        root.setTop(topBox);
        root.setCenter(detailsBox);

        //CSS styling
        root.setStyle("-fx-background-color: #FF0000;"); // Red background

        //creates scene and sets stage
        Scene scene = new Scene(root, 800, Screen.getPrimary().getBounds().getHeight()*.9); //Increased width to 800 pixels
        scene.setFill(Color.RED); //sets scene background color as red
        primaryStage.setScene(scene);
        primaryStage.setTitle("Pokédex");
        primaryStage.show();
    }

    private void searchPokemon() {
        String input = searchField.getText().trim();
        if (!input.isEmpty()) {
            try {
                Pokemon pokemon = new Pokemon(input);
                displayPokemonDetails(pokemon);
            } catch (Exception e) {
                displayArea.setText("Pokemon not found.");
                spriteImageView.setImage(null);
                e.printStackTrace();
            }
        }
    }

    private void getRandomPokemon() {
        Random random = new Random();
        int randomId = random.nextInt(1025) + 1; //generates random ID between 1 and 1025 (there are currently 1025 pokemon)
        try {
            Pokemon pokemon = new Pokemon(String.valueOf(randomId));
            displayPokemonDetails(pokemon);
        } catch (Exception e) {
            displayArea.setText("Error: Failed to retrieve random Pokémon");
            spriteImageView.setImage(null);
            e.printStackTrace();
        }
    }

    private void displayPokemonDetails(Pokemon pokemon) {
        //converts height from decimeters to feet and inches
        int heightDm = pokemon.getHeight();
        int feet = heightDm / 30;  // 1 foot = 30 centimeters (decimeters)
        int inches = (int) Math.round((heightDm % 30) * 0.394);  // 1 inch = 0.394 centimeters (decimeters)



        displayArea.setText("Name: " + pokemon.getName() + "\n" +
                "ID: " + pokemon.getId() + "\n" +
                "Height: " + feet + "\' " + inches + "\"" + "\n" +
                String.format("Weight: %.1f lbs\n", pokemon.getWeight()) +
                "Types: " + String.join(", ", pokemon.getTypes()) + "\n" +
                "Description: " + pokemon.getFlavorText());

        //load and displays sprite image
        Image spriteImage = new Image(pokemon.getSprite());
        spriteImageView.setImage(spriteImage);
    }

    private void toggleDarkMode() {
        boolean darkModeEnabled = darkModeToggle.isSelected();
        Preferences prefs = Preferences.userNodeForPackage(PokedexApp.class);
        prefs.putBoolean(DARK_MODE_KEY, darkModeEnabled);
        
        if (darkModeToggle.isSelected()) {
            //applys dark mode CSS
            displayArea.setStyle("-fx-control-inner-background: #333333; -fx-text-fill: white;");
        } else {
            //applys light mode CSS
            displayArea.setStyle(null); //resets to default
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
