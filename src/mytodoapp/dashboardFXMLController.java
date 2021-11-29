/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytodoapp;

import database.DatabaseConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Arafat Hossain Ar
 */
public class dashboardFXMLController implements Initializable {

    //Mouse position
    private double xMouse = 0;
    private double yMouse = 0;
    @FXML
    private TableView<ModelTable> todaystask;
    @FXML
    private TableColumn<ModelTable, String> todaystasktable;
    ObservableList<ModelTable> list = FXCollections.observableArrayList();

    private void handleButtonAction(ActionEvent event) {

        Stage stage = new Stage(StageStyle.UNDECORATED);
        stage.centerOnScreen();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadTable();
    }

    public void loadTable() {
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        LocalDate currentDate = LocalDate.parse(date);

        int day = currentDate.getDayOfMonth();
        int month = currentDate.getMonthValue();

        int year = currentDate.getYear();
        String getdate = "" + day + month + year;
        try {
            Connection conn = DatabaseConnection.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM task");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                if (rs.getString("key").equals(getdate)) {
                    list.add(new ModelTable(rs.getString("text")));
                } else {
                   // list.add(new ModelTable(rs.getString("text")));
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(taskFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }

        todaystasktable.setCellValueFactory(new PropertyValueFactory<>("task"));
        todaystask.setItems(list);

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
    private void emailMouseClicked(MouseEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("emailFXML.fxml"));
        Node node = (Node) event.getSource();

        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(root));

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

}
