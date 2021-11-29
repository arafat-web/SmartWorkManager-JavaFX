/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytodoapp;

/**
 *
 * @author Arafat Hossain Ar
 */
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class emailFXMLController implements Initializable{

   //Mouse position
    private double xMouse = 0;
    private double yMouse = 0;
    @FXML
    private Button email_button;
    @FXML
    private Button close_win_button;
    @FXML
    private MaterialDesignIconView hide_win_button;
    @FXML
    private AnchorPane contentFrame;

    private void handleButtonAction(ActionEvent event) {

        Stage stage = new Stage(StageStyle.UNDECORATED);
        stage.centerOnScreen();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    @FXML
    private void close_Window(MouseEvent event) {

        Node node = (Node) event.getSource();

        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();

    }

    @FXML
    private void hide_Window(MouseEvent event) {

        Node node = (Node) event.getSource();

        Stage stage = (Stage) node.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    private void moveMousePressed(MouseEvent event) {

        xMouse = event.getSceneX();
        yMouse = event.getSceneY();
    }

    @FXML
    private void moveMouseDragged(MouseEvent event) {
        Node node = (Node) event.getSource();

        Stage stage = (Stage) node.getScene().getWindow();

        stage.setX(event.getScreenX() - xMouse);
        stage.setY(event.getScreenY() - yMouse);

    }



    @FXML
    private void taskMouseClicked(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("taskFXML.fxml"));
        Node node = (Node) event.getSource();

        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    private void routineMouseClicked(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("routineFXML.fxml"));
        Node node = (Node) event.getSource();

        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    private void settingsMouseClicked(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("settingsFXML.fxml"));
        Node node = (Node) event.getSource();

        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    private void aboutMouseClicked(MouseEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("aboutFXML.fxml"));
        Node node = (Node) event.getSource();

        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    private void dashboardMouseClicked(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("dashboardFXML.fxml"));
        Node node = (Node) event.getSource();

        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

}

