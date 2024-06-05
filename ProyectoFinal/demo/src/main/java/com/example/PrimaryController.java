package com.example;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class PrimaryController implements Initializable {
    ObservableList<Prueba> datos = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Prueba, String> columnaEdad;

    @FXML
    private TableColumn<Prueba, String> columnaNombre;

    @FXML
    private Button primaryButton;

    @FXML
    private TableView<Prueba> tablaCliente;

    @FXML
    private TextField texfEdad;

    @FXML
    private TextField textfNombre;

    @FXML
    private void switchToSecondary() throws IOException {
        // App.setRoot("secondary");

    }

    @FXML
    void evento(MouseEvent event) {
        tablaCliente.setOnMouseClicked(eventi -> {
            if (eventi.getClickCount() == 2) {
                Prueba prueba= tablaCliente.getSelectionModel().getSelectedItem();
                if(prueba!= null){
                    texfEdad.setText(prueba.getEdad() + "");
                    textfNombre.setText(prueba.getNombre());
                }
            }

        });
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // dialogSeleccion2();
        // confirmacionPersonalizado();
        // alertError();
        // alertInfo();
        cargarTablas();
        // ObservableList<Prueba> tablaClienteSel = tablaCliente.getSelectionModel().getSelectedItems();
        // tablaClienteSel.addListener(selectorTablaClientes);
    }

    public void inputDialog() {
        TextInputDialog dialog = new TextInputDialog("Pepe"); // Por defecto
        dialog.setTitle("Diálogo de entrada de texto");
        dialog.setHeaderText("Cabecera");
        dialog.setContentText("Introduce tu nombre:");
        Optional<String> result = dialog.showAndWait(); // Obteniendo el resultado
        if (result.isPresent()) {
            // System.out.println("Hola " + result.get());
            // Obteniendo el resultado con una lambda
            result.ifPresent(name -> {
                System.out.println("Hola " + name);
            }

            );
            // result.ifPresent(name ->

            // System.out.println("Hola " + name)

            // );
        }
    }

    public void dialogSeleccion() {
        List<Prueba> choices = new ArrayList<>();
        choices = listaPrueba();
        // choices.add();
        // choices.add("dos");
        // choices.add("tres");
        ChoiceDialog<Prueba> dialog = new ChoiceDialog<>(choices.get(1), choices);
        dialog.setTitle("Diálogo de selección");
        dialog.setHeaderText("Cabecera");
        dialog.setContentText("Elige un número:");
        Optional<Prueba> result = dialog.showAndWait();
        if (result.isPresent()) {
            // System.out.println("Has elegido: " + result.get());
            // Obteniendo el resultado con una lambda
            result.ifPresent(numero -> System.out.println("Has elegido: " + numero));
        }
    }

    public void dialogSeleccion2() {
        List<String> choices = new ArrayList<>();
        choices.add("uno");
        choices.add("dos");
        choices.add("tres");
        ChoiceDialog<String> dialog = new ChoiceDialog<>("dos", choices);
        dialog.setTitle("Diálogo de selección");
        dialog.setHeaderText("Cabecera");
        dialog.setContentText("Elige un número:");
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            // System.out.println("Has elegido: " + result.get());
            // Obteniendo el resultado con una lambda
            result.ifPresent(numero -> System.out.println("Has elegido: " + numero));
        }
    }

    public ArrayList<Prueba> listaPrueba() {
        ArrayList<Prueba> listaPrueba = new ArrayList<>();
        Prueba prueba = new Prueba();
        prueba.setEdad(30);
        prueba.setNombre("Paco");
        Prueba prueba2 = new Prueba();
        prueba2.setNombre("Tuca");
        prueba2.setEdad(25);
        listaPrueba.add(prueba);
        listaPrueba.add(prueba2);
        return listaPrueba;
    }

    public void confirmacionPersonalizado() {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Diálogo de confirmación");
        alert.setHeaderText("Este diálogo tiene acciones personalizadas");
        alert.setContentText("Elige una opción");
        ButtonType buttonTypeOne = new ButtonType("Uno");
        ButtonType buttonTypeTwo = new ButtonType("Dos");
        ButtonType buttonTypeThree = new ButtonType("Tres");
        ButtonType buttonTypeCancel = new ButtonType("Cancelar", ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeThree,
                buttonTypeCancel);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent()) {
            if (result.get() == buttonTypeOne)
                System.out.println("Uno");
            else if (result.get() == buttonTypeTwo)
                System.out.println("Dos");
            else if (result.get() == buttonTypeThree)
                System.out.println("Tres");
            else
                System.out.println("Cancelar");
        }
    }

    public void alertError() {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Diálogo de excepción");
        alert.setHeaderText("Cabecera");
        alert.setContentText("Se ha producido un error");
        Exception ex = new FileNotFoundException("Detalles del error"); // Error forzado
        // Formato de una excepción desplegable
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        String exceptionText = sw.toString();
        Label label = new Label("Excepción:");
        TextArea textArea = new TextArea(exceptionText);
        textArea.setEditable(false);
        textArea.setWrapText(true);
        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);
        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(label, 0, 0);
        expContent.add(textArea, 0, 1);
        // Introduce
        alert.getDialogPane().setExpandableContent(expContent);
        alert.showAndWait();
    }

    public void alertInfo() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Diálogo de información");
        alert.setHeaderText("Cabecera");
        alert.setContentText("Aquí tenes toda la info");
        // Formato de una excepción desplegable
        String texto = "Acá deberíamos escribir muchísimo texto";
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        pw.print(texto);
        pw.close();
        String escribirText = sw.toString();
        Label label = new Label("Información:");
        TextArea textArea = new TextArea(escribirText);
        textArea.setEditable(false);
        textArea.setWrapText(true);
        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);
        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(label, 0, 0);
        expContent.add(textArea, 0, 1);
        // Introduce
        alert.getDialogPane().setExpandableContent(expContent);
        alert.showAndWait();
    }

    public void cargarTablas() {
        datos = FXCollections.observableArrayList(listaPrueba());
        tablaCliente.setItems(datos);
        columnaNombre.setCellValueFactory(new PropertyValueFactory<Prueba, String>("nombre"));
        columnaEdad.setCellValueFactory(new PropertyValueFactory<Prueba, String>("edad"));

    }

    // private final ListChangeListener<Prueba> selectorTablaClientes = new ListChangeListener<Prueba>() {
    //     @Override
    //     public void onChanged(ListChangeListener.Change<? extends Prueba> c) {
    //         ponerClienteSeleccionado();
    //     }
    // };

    // Método que devuelve el objeto de la fila seleccionada
    // public Prueba getTablaClientesSeleccionado() {
    //     if (tablaCliente != null) {
    //         List<Prueba> tabla = tablaCliente.getSelectionModel().getSelectedItems();
    //         if (tabla.size() == 1) {
    //             final Prueba clienteSeleccionado = tabla.get(0);
    //             return clienteSeleccionado;
    //         }
    //     }
    //     return null;
    // }

    // // Método que a partir del objeto seleccionado lo muestra en el formulario
    // // También puede habilitar/deshabilitar botones en el formualrio
    // public void ponerClienteSeleccionado() {
    //     final Prueba cliente = getTablaClientesSeleccionado();
    //     int posicionCliente = listaPrueba().indexOf(cliente);
    //     if (cliente != null) {
    //         texfEdad.setText(cliente.getEdad() + "");
    //         textfNombre.setText(cliente.getNombre());

    //     }
    // }

}
