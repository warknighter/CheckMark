package sample;

import com.sun.org.apache.regexp.internal.RE;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.util.Date;

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
    private TableView<Reports> Tb_ReportList;

    @FXML
    private TableColumn<Reports, String> ReportNumber;

    @FXML
    private TableColumn<Reports, String> ReportRegid;

    @FXML
    private TableColumn<Reports, Date> ReportDate;

    public static ObservableList<Reports> SelectedReports = FXCollections.observableArrayList();


    @FXML
    void initialize(){
        ReportNumber.setCellValueFactory(new PropertyValueFactory<Reports,String>("reportNummber"));
        ReportRegid.setCellValueFactory(new PropertyValueFactory<Reports,String>("reportRegNum"));
        ReportDate.setCellValueFactory(new PropertyValueFactory<Reports,Date>("reportDate"));
        Tb_ReportList.setItems(SelectedReports);
        btn_Select.setOnAction(event -> {

            OpenScene("/sample/PickReport.fxml","Выбор отчета");

        });

        btn_load.setOnAction(event -> {
//            System.out.println(SelectedReports.size());
//             for (int i = 0; i < SelectedReports.size();i++){
//              System.out.println(SelectedReports.get(i).getReportNummber() + ' ' +  SelectedReports.get(i).getReportNummber() + ' ' + SelectedReports.get(i).getReportDate());
//          }
        });

        btn_ClearList.setOnAction(event -> {
            SelectedReports.clear();
        });

    }

    public void OpenScene(String window, String Title){
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
        stage.setTitle(Title);
        stage.showAndWait();

    }



}
