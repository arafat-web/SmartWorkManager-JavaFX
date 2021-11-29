/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytodoapp;

import database.DatabaseConnection;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import newdata.newAssignment;
import newdata.newNote;
import newdata.newTask;

/**
 *
 * @author Arafat Hossain Ar
 */
public class taskFXMLController implements Initializable {

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
    @FXML
    private TableView<ModelTable> tasktable;
    @FXML
    private TableColumn<ModelTable, String> alltasks;
    ObservableList<ModelTable> list = FXCollections.observableArrayList();

    @FXML
    private Button newTask;
    @FXML
    private TableView<ModelTableAssignment> assignmentTableValue;
    @FXML
    private TableColumn<ModelTableAssignment, String> assignmentTable;
    ObservableList<ModelTableAssignment> assignmentlist = FXCollections.observableArrayList();

    @FXML
    private TableColumn<ModelTableNote, String> noteTableValue;
    @FXML
    private TableView<ModelTableNote> noteTable;
    ObservableList<ModelTableNote> notelist = FXCollections.observableArrayList();

    private void handleButtonAction(ActionEvent event) {

        Stage stage = new Stage(StageStyle.UNDECORATED);
        stage.centerOnScreen();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadTableTask();
        loadTableAssignment();
        loadTableNote();

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

    @FXML
    private void newTask(MouseEvent event) throws Exception {

        Stage s = new Stage();
        newTask t = new newTask();
        t.start(s);

    }

    @FXML
    private void newAssignment(MouseEvent event) throws Exception {
        Stage s = new Stage();
        newAssignment a = new newAssignment();
        a.start(s);
    }

    @FXML
    private void newNote(MouseEvent event) throws IOException {
        Stage s = new Stage();
        newNote n = new newNote();
        n.start(s);
    }

    public void loadTableTask() {
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
                    list.add(new ModelTable(rs.getString("text")));
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(taskFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }

        alltasks.setCellValueFactory(new PropertyValueFactory<>("task"));
        tasktable.setItems(list);

    }

    private void loadTableAssignment() {

        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        LocalDate currentDate = LocalDate.parse(date);

        int day = currentDate.getDayOfMonth();
        int month = currentDate.getMonthValue();

        int year = currentDate.getYear();
        String getdate = "" + day + month + year;
        try {
            Connection conn = DatabaseConnection.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM assignment");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                String assign = rs.getString("text") + "\n" + rs.getString("sub") + "\n" + rs.getString("dead");
                if (rs.getString("key").equals(getdate)) {

                    assignmentlist.add(new ModelTableAssignment(assign));

                } else {
                    assignmentlist.add(new ModelTableAssignment(assign));
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(taskFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }

        assignmentTable.setCellValueFactory(new PropertyValueFactory<>("assignment"));
        assignmentTableValue.setItems(assignmentlist);

    }

    private void loadTableNote() {
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        LocalDate currentDate = LocalDate.parse(date);

        int day = currentDate.getDayOfMonth();
        int month = currentDate.getMonthValue();

        int year = currentDate.getYear();
        String getdate = "" + day + month + year;
        try {
            Connection conn = DatabaseConnection.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM note");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                if (rs.getString("key").equals(getdate)) {
                    notelist.add(new ModelTableNote(rs.getString("text")));
                } else {
                    notelist.add(new ModelTableNote(rs.getString("text")));
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(taskFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }

        noteTableValue.setCellValueFactory(new PropertyValueFactory<>("note"));
        noteTable.setItems(notelist);
    }

    @FXML
    private void reload(MouseEvent event) {
        tasktable.getItems().clear();
        loadTableTask();
        assignmentTableValue.getItems().clear();
        loadTableAssignment();
        noteTable.getItems().clear();
        loadTableNote();

    }

}
