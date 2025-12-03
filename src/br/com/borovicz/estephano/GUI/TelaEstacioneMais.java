package br.com.borovicz.estephano.GUI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TelaEstacioneMais extends Application {
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setHeight(500);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Estacione +");

        //criar elemento principal, criar a cena, colocar o elemento principal na cena e a cena no palco
        VBox root = new VBox();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);

        //criar header
        VBox header = new VBox();
        header.setPrefHeight(100);

        //conteúdo do header
        Label lblTitulo = new Label("Estacione +");
        lblTitulo.setStyle("-fx-font-size: 20px;");
        lblTitulo.setAlignment (Pos.CENTER_LEFT);


        //adicionar conteúdo ao header
        header.getChildren().addAll(lblTitulo);

        //criar gridpane
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setPrefHeight(100);
        gridPane.setStyle("-fx-background-color: #06732a");

        //adicionar o conteúdo ao gridpane
        Label lblPlacaDoVeiculo = new Label("Placa do veículo: ");
        TextField tfPlacaDoVeiculo = new TextField();
        Label lblNomeDoProprietario = new Label("Nome do Proprietário: ");
        TextField tfNomeDoProprietario = new TextField();
        Label lblModeloDoVeiculo = new Label("Modelo do Veículo: ");
        TextField tfModeloDoVeiculo = new TextField();

        //criar botoes
        Button btRegistrarEntrada = new Button("Registrar Entrada");
        Button btRegistrarSaida = new Button("Registrar Saída");
        Button btLimpar = new Button("Limpar");
        btLimpar.setAlignment(Pos.CENTER);


        //colocar os componentes no grid

        gridPane.add(lblPlacaDoVeiculo, 0, 0);
        gridPane.add(tfPlacaDoVeiculo, 1, 0);
        gridPane.add(lblNomeDoProprietario, 0, 1);
        gridPane.add(tfNomeDoProprietario, 1, 1);
        gridPane.add(lblModeloDoVeiculo, 0, 2);
        gridPane.add(tfModeloDoVeiculo, 1, 2);
        gridPane.add(btRegistrarEntrada, 2, 0);
        gridPane.add(btRegistrarSaida, 2, 1);
        gridPane.add(btLimpar, 2, 2);

        //criar vbox de resultados
        VBox VBoxListaDeVeiculosEstacionados = new VBox();
        VBoxListaDeVeiculosEstacionados.setStyle("-fx-background-color: red");

        //criar conteúdo de resultados
        Label lblVeiculosEstacionados = new Label("Veículos estacionados:");
        ListView listaVeiculosEstacionados = new ListView();


        //adicionar conteúdo ao vbox resultados
        VBoxListaDeVeiculosEstacionados.getChildren().addAll(lblVeiculosEstacionados, listaVeiculosEstacionados);

        //adicionar componentes ao root
        root.getChildren().add(header);
        root.getChildren().add(gridPane);
        root.getChildren().add(VBoxListaDeVeiculosEstacionados);

        primaryStage.show();
    }
}
