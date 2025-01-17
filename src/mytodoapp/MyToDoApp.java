/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytodoapp;

import java.sql.SQLException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

//        imageCirle.setStroke(Color.WHITE);
//        imageCirle.setStrokeWidth(2);
//        Image img = new Image("/mytodoapp/myimage.jpg", false);
//        imageCirle.setFill(new ImagePattern(img));
/**
 *
 * @author Arafat Hossain Ar
 */
public class MyToDoApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("dashboardFXML.fxml"));

        Scene scene = new Scene(root);
        stage.initStyle(StageStyle.TRANSPARENT);
        scene.setFill(null);
        stage.setScene(scene);
        stage.show();

    }

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        launch(args);
    }


}
