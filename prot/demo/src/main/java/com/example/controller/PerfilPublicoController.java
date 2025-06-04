package com.example.controller;

import com.example.model.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.event.ActionEvent;
import com.example.model.ChatManager;

public class PerfilPublicoController {

    @FXML private Label nombreLabel;
    @FXML private Label correoLabel;
    @FXML private Label telefonoLabel;
    @FXML private Label ubicacionLabel;
    @FXML private Label edadLabel;
    @FXML private Label biografiaLabel;
    @FXML private VBox metasList;
    @FXML private Label frustracionesLabel;
    @FXML private Label motivacionesLabel;
    @FXML private VBox personalidadList;
    @FXML private Circle fotoPerfil;

    private Usuario usuario;

    // Establece la información del usuario en la vista pública
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;

        nombreLabel.setText(usuario.getNombre());
        correoLabel.setText("Correo: " + usuario.getCorreo());
        telefonoLabel.setText("Teléfono: " + usuario.getTelefono());
        ubicacionLabel.setText("Ubicación: " + usuario.getUbicacion());
        edadLabel.setText("Edad: " + usuario.getEdad() + " años");
        biografiaLabel.setText(usuario.getBiografia());
        frustracionesLabel.setText(usuario.getFrustraciones());
        motivacionesLabel.setText(usuario.getMotivaciones());

        metasList.getChildren().clear();
        for (String meta : usuario.getMetas().split("\n")) {
            metasList.getChildren().add(new Label("• " + meta));
        }

        personalidadList.getChildren().clear();
        for (String rasgo : usuario.getPersonalidad()) {
            TextField tf = new TextField(rasgo);
            tf.setEditable(false);
            personalidadList.getChildren().add(tf);
        }
    }

    // Acción al hacer clic en el botón "Enviar mensaje"
    @FXML
    public void enviarMensaje(ActionEvent event) {
    ChatManager.abrirChatPrivadoCon(usuario, event);
}
}
