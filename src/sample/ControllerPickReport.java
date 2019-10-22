package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.xml.crypto.Data;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Observable;

public class ControllerPickReport {

    private ObservableList<Reports> reports = FXCollections.observableArrayList();
    @FXML
    private TableView<Reports> table_Report;
    @FXML
    private TableColumn<Reports, String> ReportNumber;
    @FXML
    private TableColumn<Reports, String> ReportRegNum;
    @FXML
    private TableColumn<Reports, Date> ReportDate;


    @FXML
    private Button btn_pickreport;

    @FXML
    void initialize(){
        FillTable();

        btn_pickreport.setOnAction(event -> {

        });
    }

    private void FillTable(){
        Database db = new Database();
        ResultSet rs_Reports = null;

        rs_Reports = db.select();
        try {
            while (rs_Reports.next()){
                String Number = rs_Reports.getString("Number");
                String RegistrationId = rs_Reports.getString("RegistrationId");
                Date reportDate = rs_Reports.getDate("Date");

                reports.add(new Reports(Number,RegistrationId,reportDate));
                //reports.add();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ReportNumber.setCellValueFactory(new PropertyValueFactory<Reports,String>("reportNummber"));
        ReportRegNum.setCellValueFactory(new PropertyValueFactory<Reports,String>("reportRegNum"));
        ReportDate.setCellValueFactory(new PropertyValueFactory<Reports,Date>("reportDate"));
        table_Report.setItems(reports);

    }


}
