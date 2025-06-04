package com.example.controller;

import com.example.model.Animal;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

import java.util.Arrays;
import java.util.List;

public class DonarController {

    @FXML
    private VBox animalList;

    @FXML
    private MainController mainController;

    @FXML
    public void initialize() {
        List<Animal> animales = Arrays.asList(
            new Animal("Max", "Cachorro activo", "Perro", "Disponible", "/images/max.png"),
            new Animal("Luna", "Gatita tierna", "Gato", "Adoptada", "/images/luna.png"),
            new Animal("Peppa", "Cerdita valiente", "Cerdo", "Disponible", "/images/peppa.png")
        );

        for (Animal animal : animales) {
            animalList.getChildren().add(createAnimalCard(animal));
        }
    }

    private HBox createAnimalCard(Animal animal) {
        Label nameLabel = new Label(animal.getNombre());
        nameLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        
        Label descLabel = new Label(animal.getDescripcion());
        descLabel.setWrapText(true);

        VBox infoBox = new VBox(5, nameLabel, descLabel);
        infoBox.setPrefWidth(400);

        Button btnSeleccionar = new Button("Seleccionar");
        btnSeleccionar.setOnAction(e -> {
            if (mainController != null) {
                mainController.loadDonacionView(animal);
            }
        });

        Button btnExpediente = new Button("Expediente");
        HBox buttonBox = new HBox(10, btnSeleccionar, btnExpediente);

        VBox rightBox = new VBox(10, buttonBox);
        rightBox.setAlignment(Pos.CENTER_RIGHT);

        HBox card = new HBox(20, infoBox, rightBox);
        card.setPadding(new Insets(10));
        card.setStyle("-fx-border-color: lightgray; -fx-border-radius: 5px;");
        return card;
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

}

