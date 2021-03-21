package Bolum2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class HareketEdenTop extends Application{

    public double dx = 0.2;
    public double dy = 3;
    public double dx_2 = 0.2;
    public double dy_2 = 3;

    @Override
    public void start(Stage stage) {

        Pane pane = new Pane();

        Circle ball1 = new Circle(20, Color.RED);
        ball1.relocate(10,10);

        Circle ball2 = new Circle(20, Color.BLUE);
        ball2.relocate(340,340);


        MovingBall blueBall = new MovingBall();
        blueBall.setBallAndPane(ball1,pane,dx,dy);

        MovingBall redBall = new MovingBall();
        redBall.setBallAndPane(ball2,pane,dx_2,dy_2);

        Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(20),redBall));
        timeline1.getKeyFrames().add(new KeyFrame(Duration.millis(20),blueBall));
        timeline1.setCycleCount(Timeline.INDEFINITE);
        timeline1.play();



        pane.getChildren().addAll(ball1,ball2);


        Scene scene = new Scene(pane, 400, 400, Color.WHITESMOKE);

        stage.setTitle("Hareket Eden Top");
        stage.setScene(scene);
        stage.show();
    }
    class MovingBall implements EventHandler<ActionEvent>
    {
        public Circle ball;
        public Pane pane;
        public double dx;
        public double dy;

        public void setBallAndPane(Circle ball,Pane pane,double dx,double dy)
        {
            this.dx = dx;
            this.dy = dy;
            this.ball = ball;
            this.pane = pane;
        }
        @Override
        public void handle(ActionEvent t)
        {
            //move the ball
            ball.setLayoutX(ball.getLayoutX() + dx);
            ball.setLayoutY(ball.getLayoutY() + dy);

            Bounds bounds = pane.getBoundsInLocal();

            if(ball.getLayoutX() <= (bounds.getMinX() + ball.getRadius()) || ball.getLayoutX() >= (bounds.getMaxX() - ball.getRadius()) )
            {
                dx = -dx;
            }

            if((ball.getLayoutY() >= (bounds.getMaxY() - ball.getRadius())) || (ball.getLayoutY() <= (bounds.getMinY() + ball.getRadius())))
            {
                dy = -dy;
            }

            ball.setOnMouseClicked(e->{
                dx = -dx;
                dy = -dy;
            });
        }
    }

    public static void main(String[] args) {
        launch();
    }
}