/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newdata;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Arafat Hossain Ar
 */
public class newTask extends Application {

       @Override
    public void start(Stage pstage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("newTaskFXML.fxml"));

        Scene scene = new Scene(root);
        pstage.initStyle(StageStyle.TRANSPARENT);
        scene.setFill(null);
        pstage.setScene(scene);
        pstage.show();

    }
    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        launch(args);
    }

}
