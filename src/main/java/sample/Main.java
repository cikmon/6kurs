package sample;

import com.bulletphysics.linearmath.Transform;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.vecmath.Matrix4f;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
       Parent root = FXMLLoader.load(getClass().getResource("/form.fxml"));
        primaryStage.setTitle("Razmeshenie");
       primaryStage.setScene(new Scene(root, 370, 275));
       primaryStage.show();
     //  Controller cde=new Controller();
    //   cde.toString();

/*
       Check drt= new Check();
       Ploskosti p1 = new Ploskosti("1",
               313,313,313,976,365,305,0,0,0),
               p2=new Ploskosti("2",
                       200,800,1100,10,10,300,0,45,0);

    System.out.print(drt.start(p1,p2));
/*
        Transform transform =new Transform();
        transform.basis.rotY(1);
        transform.origin.set(800,10,10);
        Matrix4f rte=new Matrix4f();
        transform.getMatrix(rte);
        System.out.print(rte.toString());
*/

    }

    public static void main(String[] args) {
        launch(args);
    }

    }










