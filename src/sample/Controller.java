package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    @FXML
    private Button btn_Select;

    @FXML
    private Button btn_ClearList;

    @FXML
    private Label lbl_List;

    @FXML
    private TextField txt_series;

    @FXML
    private TextField txt_start;

    @FXML
    private TextField txt_end;

    @FXML
    private Button btn_unload;

    @FXML
    private Button btn_load;

    @FXML
    private Button btn_unloadALL;

    @FXML
    private Label lbl_List1;

    @FXML
    void initialize(){
        btn_Select.setOnAction(event -> {
            OpenScene("/sample/PickReport.fxml");
        });

    }

    public void OpenScene(String window){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(window));

        try {
            loader.load();
        }
        catch (IOException e){
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();

    }

}
