package es.ieslosmontecillos.appusotextoboton;

import es.ieslosmontecillos.componentes_gallegomario.CampoTextoBoton;
import es.ieslosmontecillos.componentes_gallegomario.CampoTextoNumerico;
import es.ieslosmontecillos.componentes_gallegomario.SelectorDeslizamiento;
import es.ieslosmontecillos.componentes_gallegomario.Temporizador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class AppUsoTextoBotonController implements Initializable {

    // Componentes predeterminados
    @FXML
    Label txtLabel;
    @FXML
    private Button comenzar;


    // Componentes personalizados
    // CampoTextoBoton
    @FXML
    private CampoTextoBoton txtFld1;
    @FXML
    private CampoTextoBoton txtFld2;
    // SelectorDeslizamiento
    @FXML
    private SelectorDeslizamiento selectorDeslizamiento;
    // CampoTextoNumerico
    @FXML
    private CampoTextoNumerico campoTextoNumerico;
    // Temporizador
    @FXML
    private Temporizador temporizador;


    // Creación lista para selectorDeslizamiento
    String[] colores = new String[]{"rojo", "azul", "verde", "amarillo",
            "rosa", "morado", "blanco",
            "negro", "gris", "violeta"};
    ArrayList<String> contenidoSelectorDeslz = new ArrayList<String>(Arrays.asList(colores));


    // Evento botón para el CampoTextoBoton nombre
    @FXML
    public void nombreLabel(ActionEvent actionEvent) {
        txtLabel.setText("Se ha introducido el nombre: " + txtFld1.getText());
    }


    // Evento botón para el CampoTextoBoton apellido
    @FXML
    public void apellidoLabel(ActionEvent actionEvent) {
        txtLabel.setText("Se ha introducido el apellido: " + txtFld2.getText());
    }

    // Evento botón para activar/pausar/resumir el temporizador
    @FXML
    public void onActionComenzar(ActionEvent actionEvent){

        if(temporizador.getTiempo() != 0) {
            System.out.println(temporizador.getTiempo());
            if (comenzar.getText().equals("▶")) {
                if (campoTextoNumerico.getText().isEmpty())
                    // Resume el temporizador
                    temporizador.resumirTemporizador();
                else {
                    // Establece el tiempo del temporizador
                    temporizador.setTiempo(Integer.parseInt(campoTextoNumerico.getText()));

                    // Limpia el contenido y deshabilita el componente CampoTextoNumerico
                    campoTextoNumerico.clear();
                    campoTextoNumerico.setDisable(true);

                    // Comienza el temporizador
                    temporizador.comienzaTemporizador();
                }
                comenzar.setText("⏸");
            } else {
                // Pausa el temporizador
                temporizador.pausarTemporizador();
                comenzar.setText("▶");
            }
        } else {
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("ATENCIÓN");
            alerta.setHeaderText("ATENCIÓN");
            alerta.setContentText("Debe introducir un valor numérico en el campo de texto para iniciar el temporizador.");
            alerta.showAndWait();
        }
    }


    // Inicializador Controlador
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        selectorDeslizamiento.setItems(contenidoSelectorDeslz);
        selectorDeslizamiento.setRepetitive(false);
        temporizador.iniciaTemporizador();
    }
}