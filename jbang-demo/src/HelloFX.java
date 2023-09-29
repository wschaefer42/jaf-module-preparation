//DEPS org.openjfx:javafx-controls:21:${os.detected.jfxname}
//DEPS org.openjfx:javafx-controls:21:${os.detected.jfxname}

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloFX extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Label label = new Label("Hello JBang");
        Scene scene = new Scene(new StackPane(label), 640, 400);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
