package com.example.controller;

import java.io.IOException;

import com.example.model.Animal;
import com.example.model.ChatManager;
import com.example.model.Donacion;
import com.example.model.Usuario;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class MainController {

    @FXML
    private StackPane contentPane;

    @FXML
    private Button btnGestionPerfil;

    @FXML
    private Button btnPrincipal;

    @FXML
    private Button btnDonar;

    @FXML
    private Button btnHistorial;

    @FXML
    private Button btnForo;

    @FXML
    private Button btnMensajes;

    @FXML
    private Button btnLogout;

    @FXML
    public void initialize() {
        loadView("PrincipalView.fxml");

        btnPrincipal.setOnAction(e -> loadView("PrincipalView.fxml"));
        btnGestionPerfil.setOnAction(e -> loadGestionPerfil());
        btnDonar.setOnAction(e -> loadDonarView());
        btnHistorial.setOnAction(e -> loadHistorialView());
        btnForo.setOnAction(e -> loadForoView());
        btnMensajes.setOnAction(e -> loadMensajesView());
        btnLogout.setOnAction(e -> handleLogout());
    }

    public void loadView(String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/view/" + fxml));
            Pane view = loader.load();

            Object controller = loader.getController();
            if (controller instanceof ChatController) {
                ((ChatController) controller).setMainController(this);
            } else if (controller instanceof DonarController) {
                ((DonarController) controller).setMainController(this);
            } else if (controller instanceof ForoController) {
                ((ForoController) controller).setMainController(this);
            } else if (controller instanceof DonacionController) {
                ((DonacionController) controller).setMainController(this);
            }

            contentPane.getChildren().setAll(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadGestionPerfil() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/view/GestionPerfilView.fxml"));
            Pane view = loader.load();
            contentPane.getChildren().setAll(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadDonarView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/view/DonarView.fxml"));
            Pane view = loader.load();

            DonarController controller = loader.getController();
            controller.setMainController(this);

            contentPane.getChildren().setAll(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadHistorialView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/view/HistorialView.fxml"));
            Pane view = loader.load();
            contentPane.getChildren().setAll(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadForoView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/view/ForoView.fxml"));
            Pane view = loader.load();

            ForoController controller = loader.getController();
            controller.setMainController(this);

            contentPane.getChildren().setAll(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadMensajesView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/view/mensajes.fxml"));
            Pane view = loader.load();

            contentPane.getChildren().setAll(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadDonacionView(Animal animal) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/view/DonacionView.fxml"));
            Pane view = loader.load();

            DonacionController controller = loader.getController();
            controller.setAnimal(animal);
            controller.setMainController(this);

            contentPane.getChildren().setAll(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void loadPagoView(Donacion donacion) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/view/PagoView.fxml"));
            Pane view = loader.load();

            PagoController controller = loader.getController();
            controller.setDonacion(donacion);
            controller.setMainController(this);

            contentPane.getChildren().setAll(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarChatPrivado(Usuario usuario) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/view/ChatPrivadoView.fxml"));
            Pane view = loader.load();

            ChatController controller = loader.getController();
            controller.setUsuarioConectado(usuario);
            controller.setMainController(this);
            controller.setHistorial(ChatManager.obtenerHistorial(usuario));

            contentPane.getChildren().setAll(view);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mostrarPerfilPublico(Usuario usuario) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/view/PerfilPublicoView.fxml"));
            Pane view = loader.load();

            PerfilPublicoController controller = loader.getController();
            controller.setUsuario(usuario);

            contentPane.getChildren().setAll(view);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void handleLogout() {
        System.out.println("Cerrando sesión...");
        // Aquí puedes agregar la lógica para cerrar sesión
        // Por ejemplo, volver a la pantalla de login
        System.exit(0); // Por ahora solo cerramos la aplicación
    }
}