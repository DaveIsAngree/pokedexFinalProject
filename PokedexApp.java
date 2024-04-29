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
import java.util.Random;

public class PokedexApp extends Application {

    private TextField searchField;
    private Button searchButton, randomButton;
    private TextArea displayArea;
    private ImageView spriteImageView;
    private CheckBox darkModeToggle;

    @Override
    public void start(Stage primaryStage) {
        //initialize GUI components
        searchField = new TextField();
        searchButton = new Button("Search");
        randomButton = new Button("Random Pokémon");
        displayArea = new TextArea();
        displayArea.setEditable(false);
        spriteImageView = new ImageView();
        darkModeToggle = new CheckBox("Dark Mode");

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
        Scene scene = new Scene(root, 800, 600); //Increased width to 800 pixels
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
        double heightFt = heightDm / 30.48; // 1 dm = 0.0328084 ft
        int feet = (int) heightFt;
        double inches = (heightFt - feet) * 12;

        //converts weight from hectograms to pounds
        int weightHg = pokemon.getWeight();
        double weightLbs = weightHg * 0.220462; // 1 hg = 0.220462 lbs

        displayArea.setText("Name: " + pokemon.getName() + "\n" +
                "ID: " + pokemon.getId() + "\n" +
                String.format("Height: %d ft %.1f inches\n", feet, inches) +
                String.format("Weight: %.1f lbs\n", weightLbs) +
                "Types: " + String.join(", ", pokemon.getTypes()) + "\n" +
                "Flavor Text: " + pokemon.getFlavorText());

        //load and displays sprite image
        Image spriteImage = new Image(pokemon.getSprite());
        spriteImageView.setImage(spriteImage);
    }

    private void toggleDarkMode() {
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
