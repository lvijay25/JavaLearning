package com.java.dto;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Simple JavaFX Hello World application with button events.
 *
 * Run with:
 *   mvn javafx:run   (if using Maven + javafx-maven-plugin)
 * OR
 *   java --module-path /path/to/javafx-sdk/lib \
 *        --add-modules javafx.controls \
 *        -cp . HelloFX
 */
public class SimpleJavaFXProgram extends Application {

    private int clickCount = 0;

    @Override
    public void start(Stage primaryStage) {

        // ── Title label ──────────────────────────────────────────────────────
        Label titleLabel = new Label("Hello, JavaFX!");
        titleLabel.setFont(Font.font("Arial", 28));

        // ── Status label (updated on button clicks) ───────────────────────
        Label statusLabel = new Label("Press a button below.");
        statusLabel.setFont(Font.font("Arial", 14));

        // ── Say Hello button ──────────────────────────────────────────────
        Button helloBtn = new Button("Say Hello");
        helloBtn.setPrefWidth(160);
        helloBtn.setOnAction(event -> {
            clickCount++;
            statusLabel.setText("Hello there! 👋  (clicked " + clickCount + " time" + (clickCount == 1 ? "" : "s") + ")");
        });

        // ── Reset button ──────────────────────────────────────────────────
        Button resetBtn = new Button("Reset");
        resetBtn.setPrefWidth(160);
        resetBtn.setOnAction(event -> {
            clickCount = 0;
            statusLabel.setText("Counter reset. Press a button.");
        });

        // ── Close button ─────────────────────────────────────────────────
        Button closeBtn = new Button("Close App");
        closeBtn.setPrefWidth(160);
        closeBtn.setOnAction(event -> primaryStage.close());

        // ── Layout ────────────────────────────────────────────────────────
        VBox root = new VBox(16, titleLabel, statusLabel, helloBtn, resetBtn, closeBtn);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(40));
        root.setStyle("-fx-background-color: #f0f4f8;");

        // Style buttons
        String btnStyle = "-fx-background-color: #3b82f6; -fx-text-fill: white; "
                + "-fx-font-size: 14px; -fx-background-radius: 6;";
        String btnHover = "-fx-background-color: #2563eb; -fx-text-fill: white; "
                + "-fx-font-size: 14px; -fx-background-radius: 6;";

        for (Button btn : new Button[]{helloBtn, resetBtn, closeBtn}) {
            btn.setStyle(btnStyle);
            btn.setOnMouseEntered(e -> btn.setStyle(btnHover));
            btn.setOnMouseExited(e  -> btn.setStyle(btnStyle));
        }

        // ── Scene & Stage ─────────────────────────────────────────────────
        Scene scene = new Scene(root, 360, 320);
        primaryStage.setTitle("Hello JavaFX");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}