package sample;

//import java.awt.*;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.*;

public class Controller {
    @FXML
    public TextField name;
    public TextField surname;
    public TextField age;
    public TextField hight;
    public TextField nrpesel;
     public TableView<Czlowieczek> table;

   public static class Czlowieczek {

         protected String imie;
         protected String nazwisko;
         protected Integer wiek;
         protected Integer wzrost;
         protected String pesel;
        // protected String urodziny;
         //protected String plec;


         public Czlowieczek(String imie, String nazwisko, Integer wiek , Integer wzrost, String pesel) {
             this.imie = imie;
             this.nazwisko=nazwisko;
             this.wiek = wiek;
             this.wzrost=wzrost;
             this.pesel=pesel;
         }
 // set i get imie
         public String getImie() {
             return imie;
         }

         public void setImie(String imie) {
             this.imie = imie;
         }
 // set i get nazwisko
          public String getNazwisko() {
             return nazwisko;
 }

         public void setNazwisko(String nazwisko) {
             this.nazwisko = nazwisko;
         }
 // set i get wiek
         public Integer getWiek() {
             return wiek;
 }

         public void setWiek(Integer wiek) {
             this.wiek= wiek;
         }
 // set i get wzrost
         public Integer getWzrost() {
             return wzrost;
 }

         public void setWzrost(Integer wzrost) {
             this.wzrost = wzrost;
         }
 // set i get urodziny
     /*    public String getUrodziny() {
             return urodziny;
 }

         public void setUrodziny(String urodziny) {
             this.urodziny= urodziny;
         }

 // set i get plec
         public String getPlec() {
             return plec;
 }

         public void setPlec(String plec) {
             this.plec=plec;

         }
         */
// set i get pesel
        public String getPesel()
        {
            return pesel;
}

        public void setPesel(String pesel) {
            this.pesel = pesel;
        }
        // wylicz plec
        ///wylicz uro
        //wylicz wiek
    }

   public void handleClick(ActionEvent actionEvent) {
       table.getItems().add(new Czlowieczek(name.getText(), surname.getText(), Integer.parseInt(age.getText()), Integer.parseInt(hight.getText()), nrpesel.getText()));}


    public void initialize() {
        for (TableColumn<Czlowieczek, ?> column : table.getColumns()) {
            if ("imie1".equals(column.getId())) {
                TableColumn<Czlowieczek, String> textColumn = (TableColumn<Czlowieczek, String>) column;
                textColumn.setCellValueFactory(new PropertyValueFactory<>("imie"));
            } else if ("nazwisko1".equals(column.getId())) {
                TableColumn<Czlowieczek, String> textColumn = (TableColumn<Czlowieczek, String>) column;
                textColumn.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
            }else if ("wiek1".equals(column.getId())) {
                TableColumn<Czlowieczek, Integer> lengthColumn = (TableColumn<Czlowieczek, Integer>) column;
                lengthColumn.setCellValueFactory(new PropertyValueFactory<>("wiek"));
            } else if ("wzrost1".equals(column.getId())) {
                TableColumn<Czlowieczek, Integer> lengthColumn = (TableColumn<Czlowieczek, Integer>) column;
                lengthColumn.setCellValueFactory(new PropertyValueFactory<>("wzrost"));
            } else if ("pesel1".equals(column.getId())) {
                TableColumn<Czlowieczek, String> textColumn = (TableColumn<Czlowieczek, String>) column;
                textColumn.setCellValueFactory(new PropertyValueFactory<>("pesel"));
            } else if ("usun".equals(column.getId())){
                TableColumn<Czlowieczek, Czlowieczek> delateCol=(TableColumn<Czlowieczek, Czlowieczek>) column;
                delateCol.setCellValueFactory( param -> new ReadOnlyObjectWrapper<>(param.getValue()));
                delateCol.setCellFactory(param -> new TableCell<Czlowieczek, Czlowieczek>() {
                    private final Button deleteButton = new Button("Usuń");

                    @Override
                    protected void updateItem(Czlowieczek osoba, boolean empty) {
                        super.updateItem(osoba, empty);

                        if (osoba == null) {
                            setGraphic(null);
                            return;
                        }

                        setGraphic(deleteButton);
                        deleteButton.setOnAction(
                                event -> getTableView().getItems().remove(osoba));

                    }
                });
            };
            }
        }
    }


