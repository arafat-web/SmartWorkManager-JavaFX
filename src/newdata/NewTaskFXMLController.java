/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newdata;

import database.InsertData;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import mytodoapp.taskFXMLController;

/**
 * FXML Controller class
 *
 * @author Arafat Hossain Ar
 */
public class NewTaskFXMLController implements Initializable {

    private double xMouse = 0;
    private double yMouse = 0;
    @FXML
    private Button close_win_button;
    @FXML
    private MaterialDesignIconView hide_win_button;
    @FXML
    private TextArea getTask;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
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
    private void saveTask(MouseEvent event) {

        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        LocalDate currentDate = LocalDate.parse(date);

        int day = currentDate.getDayOfMonth();
        int month = currentDate.getMonthValue();

        int year = currentDate.getYear();
        String getdate = "" + day + month + year;
        System.out.println(getdate);

        String task = getTask.getText();
        InsertData insertData = new InsertData();
        insertData.insertTask(task, getdate);

    }

    @FXML
    private void resetTask(MouseEvent event) {
        getTask.setText("");
    }

}
