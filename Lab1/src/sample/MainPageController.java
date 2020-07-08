package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public class MainPageController {
    @FXML
    public TextField name;

    @FXML
    public TextField answer;

    @FXML
    public Button start;

    @FXML
    public Label x;

    @FXML
    public Label y;

    @FXML
    public Label corranswer;

    @FXML
    public Label control;


    User user = new User();
    ArrayList<String> list = new ArrayList<>();
    Stage stage;

    @FXML
    public void Start(ActionEvent event) {
        Lab1 var = new Lab1();
        x.setText(Integer.toString(var.getX()));
        y.setText(Integer.toString(var.getY()));
        corranswer.setText(Integer.toString(var.getC()));
        start.setDisable(true);
        user.setName(name.getText());
    }

    public void next(ActionEvent event) {
        Alert input_err = new Alert(Alert.AlertType.INFORMATION);
        input_err.setTitle("Error");
        input_err.setHeaderText(null);
        input_err.setContentText("Error!\nInvalid input!\n" + "Must be an integer.");
        int Answer = 0;

        try {
            Answer = Integer.parseInt(answer.getText());
        } catch (NumberFormatException e) {
            input_err.showAndWait();
            return;
        }

        if (Answer == Integer.parseInt(corranswer.getText())) {
            user.CorrAnswer();
        } else {
            user.WrAnswer();
            list.add("x = " + x.getText() + " y = " + y.getText() + "\nYour answer: " + Answer + "\nCorrect answer: " + corranswer.getText());
        }

        user.setMark();
        user.OutputResults();
        control.setText(user.Result);
        Lab1 var = new Lab1();
        x.setText(Integer.toString(var.getX()));
        y.setText(Integer.toString(var.getY()));
        corranswer.setText(Integer.toString(var.getC()));
    }

    public void errors(ActionEvent event) {
        String errors_list = " ";

        for (int i = 0; i < list.size(); i++) {
            errors_list += list.get(i) + "\n";
            if (i == 4) {
                break;
            }
        }

        Alert errors_alert = new Alert(Alert.AlertType.INFORMATION);
        errors_alert.setTitle("Your mistakes: ");
        errors_alert.setHeaderText(null);
        errors_alert.setContentText(errors_list);
        errors_alert.showAndWait();
    }

    public void stop(ActionEvent event) {
        stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.close();
    }
}