package br.com.borovicz.estephano.GUI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import br.com.borovicz.estephano.model.EstacioneMais;

import java.time.LocalDateTime;
import java.util.ArrayList;

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

        //adicionar funcionalidade aos botoes

        btRegistrarEntrada.setOnAction(event -> {
            EstacioneMais.placaDoVeiculo = tfPlacaDoVeiculo.getText();
            EstacioneMais.nomeDoProprietario = tfNomeDoProprietario.getText();
            EstacioneMais.modeloDoVeiculo = tfModeloDoVeiculo.getText();

            EstacioneMais.veiculoEstacionado = EstacioneMais.placaDoVeiculo + ";" + EstacioneMais.nomeDoProprietario + ";" +
                    EstacioneMais.modeloDoVeiculo + ";" + LocalDateTime.now();

            tfPlacaDoVeiculo.clear();
            tfNomeDoProprietario.clear();
            tfModeloDoVeiculo.clear();
            tfPlacaDoVeiculo.requestFocus();
        });

        btRegistrarSaida.setOnAction(event -> {
            EstacioneMais.placaDoVeiculo = tfPlacaDoVeiculo.getText();
            EstacioneMais.nomeDoProprietario = tfNomeDoProprietario.getText();
            EstacioneMais.modeloDoVeiculo = tfModeloDoVeiculo.getText();
            tfPlacaDoVeiculo.clear();
            tfNomeDoProprietario.clear();
            tfModeloDoVeiculo.clear();
            tfPlacaDoVeiculo.requestFocus();
        });

//        //gravar os dados de entrada
//        Path entrada = Path.of("/Users/25203672/Documents/estacionamaisData/veiculosEstacionados.csv");
//        String dadosVeiculosEstacionados = tfPlacaDoVeiculo.getText() + ";" + tfNomeDoProprietario.getText() + ";" +
//                tfModeloDoVeiculo.getText() + ";" + LocalDateTime.now() + "/n";
//        try {
//            Files.writeString(entrada, dadosVeiculosEstacionados, StandardOpenOption.APPEND);
//            System.out.println("veículo registrado com sucesso!");
//        } catch (IOException erro) {
//            System.out.println(erro.getMessage());
//        }
//
//        //gravar os dados de saída
//        Path saida = Path.of("/Users/25203672/Documents/estacionamaisData/historico.csv");
//        String dadosHistorico = dadosVeiculosEstacionados + LocalDateTime.now() + "/n";
//        try {
//            Files.writeString(saida, dadosHistorico, StandardOpenOption.APPEND);
//        } catch (IOException erro) {
//            System.out.println(erro.getMessage());
//        }




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
        ListView lvVeiculosEstacionados = new ListView();
        lvVeiculosEstacionados.getItems().add(EstacioneMais.veiculoEstacionado);
        lvVeiculosEstacionados.setPrefHeight(100);



        //adicionar conteúdo ao vbox resultados
        VBoxListaDeVeiculosEstacionados.getChildren().addAll(lblVeiculosEstacionados, lvVeiculosEstacionados);

        //adicionar componentes ao root
        root.getChildren().add(header);
        root.getChildren().add(gridPane);
        root.getChildren().add(VBoxListaDeVeiculosEstacionados);

        primaryStage.show();
    }
}
