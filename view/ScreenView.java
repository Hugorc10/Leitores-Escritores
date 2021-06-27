package view;

import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class ScreenView {
    
    public static ImageView[] snoopySleepyView;
    public static ImageView[] snoopyReadingView;
    public static ImageView[] snoopyThinkingView;
    public static ImageView[] snoopyWritingView;
    public static Slider[] readersSlds;
    public static Slider[] writersSlds;
    public static Label writerLbl1;
    public static Label writerLbl2;
    public static Label writerLbl3;
    public static Text[] readerTxts;
    
    public Parent createContent() {
        Pane canvas = new Pane();
        canvas.setPrefSize(940, 700);
        // seta a cor do pane como azul claro
        canvas.setStyle("-fx-background-color: #3867ff");
        
        // vetor de textos que sera usado como informacao das acoes dos leitores
        readerTxts = new Text[4];
        
        for (int i = 0; i < readerTxts.length; i++) {
            readerTxts[i] = new Text();
            readerTxts[i].setFont(Font.font("Cambria", FontWeight.BOLD, 16));
            
            if (i == 0) {
                readerTxts[0].setLayoutX(20);
                readerTxts[0].setLayoutY(145);
            } else if (i == 1) {
                readerTxts[1].setLayoutX(20);
                readerTxts[1].setLayoutY(295);
            } else if (i == 2) {
                readerTxts[2].setLayoutX(20);
                readerTxts[2].setLayoutY(445);
            } else {
                readerTxts[3].setLayoutX(20);
                readerTxts[3].setLayoutY(595);
            }
            
            canvas.getChildren().add(readerTxts[i]);
        }
        
        Image snoopySleepyImg = new Image(getClass().getResourceAsStream("/img/snoopy-sleepy.gif"));
        
        snoopySleepyView = new ImageView[4];
        
        for (int i = 0; i < snoopySleepyView.length; i++) {
            snoopySleepyView[i] = new ImageView(snoopySleepyImg);
            snoopySleepyView[i].setPreserveRatio(true);
            snoopySleepyView[i].setSmooth(true);
            snoopySleepyView[i].setFitHeight(100);
            snoopySleepyView[i].setVisible(false);
            
            if (i == 0) {
                snoopySleepyView[0].setX(20);
                snoopySleepyView[0].setY(20);
            } else if (i == 1) {
                snoopySleepyView[1].setX(20);
                snoopySleepyView[1].setY(170);
            } else if (i == 2) {
                snoopySleepyView[2].setX(20);
                snoopySleepyView[2].setY(320);
            } else if (i == 3) {
                snoopySleepyView[3].setX(20);
                snoopySleepyView[3].setY(470);
            }
            
            canvas.getChildren().add(snoopySleepyView[i]);
        }
        
        Image snoopyReadingImg = new Image(getClass().getResourceAsStream("/img/snoopy-reading.gif"));
        
        snoopyReadingView = new ImageView[4];
        
        for (int i = 0; i < snoopyReadingView.length; i++) {
            snoopyReadingView[i] = new ImageView(snoopyReadingImg);
            snoopyReadingView[i].setPreserveRatio(true);
            snoopyReadingView[i].setSmooth(true);
            snoopyReadingView[i].setFitHeight(100);
            snoopyReadingView[i].setVisible(false);
            
            if (i == 0) {
                snoopyReadingView[0].setX(20);
                snoopyReadingView[0].setY(20);
            } else if (i == 1) {
                snoopyReadingView[1].setX(20);
                snoopyReadingView[1].setY(170);
            } else if (i == 2) {
                snoopyReadingView[2].setX(20);
                snoopyReadingView[2].setY(320);
            } else if (i == 3) {
                snoopyReadingView[3].setX(20);
                snoopyReadingView[3].setY(470);
            }
            
            canvas.getChildren().add(snoopyReadingView[i]);
        }
    
        /*textos usados para indicar a informacoes de segundos dos sliders dos leitores*/
        
        // objeto do tipo Text que adiciona a informacao de '1s' a esquerda dos sliders
        Text readerSlidesTxt1 = new Text(5, 642, "1s\n\n1s");
        readerSlidesTxt1.setFont(new Font(15));
        
        // objeto do tipo Text que adiciona a informacao de '10s' a direita dos sliders
        Text readerSlidesTxt2 = new Text(285, 642, "10s\n\n10s");
        readerSlidesTxt2.setFont(new Font(15));
        
        // objeto do tipo Text que adiciona a informacao de '1s' a esquerda dos sliders
        Text readerSlidesTxt3 = new Text(318, 642, "1s\n\n1s");
        readerSlidesTxt3.setFont(new Font(15));
        
        // objeto do tipo Text que adiciona a informacao de '10s' a direita dos sliders
        Text readerSlidesTxt4 = new Text(595, 642, "10s\n\n10s");
        readerSlidesTxt4.setFont(new Font(15));
        
        // adiciona todos os textos
        canvas.getChildren().addAll(readerSlidesTxt1, readerSlidesTxt2, readerSlidesTxt3, readerSlidesTxt4);
    
        /*textos usados para indicar o slider de cada leitor */
        
        // vetor de textos que indica qual slider eh de qual leitor
        Text[] readersSlidesTxts = new Text[4];
        
        for (int i = 0; i < readersSlidesTxts.length; i++) {
            readersSlidesTxts[i] = new Text();
            readersSlidesTxts[i].setFill(Color.BLACK);
            readersSlidesTxts[i].setFont(Font.font("Cambria", FontWeight.SEMI_BOLD, 15));
            
            if (i == 0) {
                readersSlidesTxts[0].setText("Reader 1");
                readersSlidesTxts[0].setLayoutX(20);
                readersSlidesTxts[0].setLayoutY(630);
            } else if (i == 1) {
                readersSlidesTxts[1].setText("Reader 2");
                readersSlidesTxts[1].setLayoutX(20);
                readersSlidesTxts[1].setLayoutY(670);
            } else if (i == 2) {
                readersSlidesTxts[2].setText("Reader 3");
                readersSlidesTxts[2].setLayoutX(330);
                readersSlidesTxts[2].setLayoutY(630);
            } else {
                readersSlidesTxts[3].setText("Reader 4");
                readersSlidesTxts[3].setLayoutX(330);
                readersSlidesTxts[3].setLayoutY(670);
            }
            
            // adiciona todos os labels
            canvas.getChildren().addAll(readersSlidesTxts[i]);
        }
        
        readersSlds = new Slider[4];
        
        for (int i = 0; i < readersSlds.length; i++) {
            readersSlds[i] = new Slider();
            readersSlds[i].setMin(10);
            readersSlds[i].setMax(100);
            readersSlds[i].setOrientation(Orientation.HORIZONTAL);
            readersSlds[i].setPrefWidth(270);
            readersSlds[i].setShowTickLabels(true);
            readersSlds[i].setShowTickMarks(true);
            readersSlds[i].setBlockIncrement(10);
            
            if (i == 0) {
                readersSlds[0].setValue(30);
                readersSlds[0].setLayoutX(20);
                readersSlds[0].setLayoutY(630);
            } else if (i == 1) {
                readersSlds[1].setValue(40);
                readersSlds[1].setLayoutX(20);
                readersSlds[1].setLayoutY(670);
            } else if (i == 2) {
                readersSlds[2].setValue(60);
                readersSlds[2].setLayoutX(330);
                readersSlds[2].setLayoutY(630);
            } else if (i == 3) {
                readersSlds[3].setValue(50);
                readersSlds[3].setLayoutX(330);
                readersSlds[3].setLayoutY(670);
            }
            
            canvas.getChildren().add(readersSlds[i]);
        }
        
        Label houseLbl = new Label("The database");
        houseLbl.setTextFill(Color.BLACK);
        houseLbl.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
        houseLbl.setLayoutX(440);
        houseLbl.setLayoutY(120);
        
        canvas.getChildren().add(houseLbl);
        
        Image houseImg = new Image(getClass().getResourceAsStream("/img/snoopy-house.gif"));
        
        ImageView houseView = new ImageView(houseImg);
        houseView.setFitHeight(300);
        houseView.setPreserveRatio(true);
        houseView.setSmooth(true);
        houseView.setX(280);
        houseView.setY(150);
        
        canvas.getChildren().add(houseView);
        
        Image snoopyThinkingImg = new Image(getClass().getResourceAsStream("/img/snoopy-thinking.png"));
    
        // label que sera usado como informacao das acoes dos leitores
        writerLbl1 = new Label();
        writerLbl1.setFont(Font.font("Cambria", FontWeight.BOLD, 16));
        writerLbl1.setTextFill(Color.BLACK);
        writerLbl1.setLayoutX(760);
        writerLbl1.setLayoutY(190);
    
        // label que sera usado como informacao das acoes dos leitores
        writerLbl2 = new Label();
        writerLbl2.setFont(Font.font("Cambria", FontWeight.BOLD, 16));
        writerLbl2.setTextFill(Color.BLACK);
        writerLbl2.setLayoutX(760);
        writerLbl2.setLayoutY(340);
    
        // label que sera usado como informacao das acoes dos leitores
        writerLbl3 = new Label();
        writerLbl3.setFont(Font.font("Cambria", FontWeight.BOLD, 16));
        writerLbl3.setTextFill(Color.BLACK);
        writerLbl3.setLayoutX(760);
        writerLbl3.setLayoutY(490);
        
        // adiciona todos os labels
        canvas.getChildren().addAll(writerLbl1, writerLbl2, writerLbl3);
        
        snoopyThinkingView = new ImageView[3];
        
        for (int i = 0; i < snoopyThinkingView.length; i++) {
            snoopyThinkingView[i] = new ImageView(snoopyThinkingImg);
            snoopyThinkingView[i].setPreserveRatio(true);
            snoopyThinkingView[i].setSmooth(true);
            snoopyThinkingView[i].setFitHeight(100);
            snoopyThinkingView[i].setVisible(false);
            
            if (i == 0) {
                snoopyThinkingView[0].setX(760);
                snoopyThinkingView[0].setY(80);
            } else if (i == 1) {
                snoopyThinkingView[1].setX(760);
                snoopyThinkingView[1].setY(230);
            } else {
                snoopyThinkingView[2].setX(760);
                snoopyThinkingView[2].setY(380);
            }
            
            canvas.getChildren().add(snoopyThinkingView[i]);
        }
        
        Image snoopyWritingImg = new Image(getClass().getResourceAsStream("/img/snoopy-writing.gif"));
        
        snoopyWritingView = new ImageView[3];
        
        for (int i = 0; i < snoopyWritingView.length; i++) {
            snoopyWritingView[i] = new ImageView(snoopyWritingImg);
            snoopyWritingView[i].setPreserveRatio(true);
            snoopyWritingView[i].setSmooth(true);
            snoopyWritingView[i].setFitHeight(100);
            snoopyWritingView[i].setVisible(false);
            
            if (i == 0) {
                snoopyWritingView[0].setX(760);
                snoopyWritingView[0].setY(80);
            } else if (i == 1) {
                snoopyWritingView[1].setX(760);
                snoopyWritingView[1].setY(230);
            } else {
                snoopyWritingView[2].setX(760);
                snoopyWritingView[2].setY(380);
            }
            
            canvas.getChildren().add(snoopyWritingView[i]);
        }
        
        /*textos usados para indicar a informacoes de segundos dos sliders dos ecritores*/
        
        // objeto do tipo Text que adiciona a informacao de '1s' a esquerda dos sliders
        Text writerSlidesTxt1 = new Text(635, 600, "1s\n\n1s\n\n1s");
        writerSlidesTxt1.setFont(new Font(15));
        
        // objeto do tipo Text que adiciona a informacao de '10s' a direita dos sliders
        Text writerSlidesTxt2 = new Text(915, 600, "10s\n\n10s\n\n10s");
        writerSlidesTxt2.setFont(new Font(15));
        
        // adiciona todos os textos
        canvas.getChildren().addAll(writerSlidesTxt1, writerSlidesTxt2);
    
        /*textos usados para indicar o slider de cada escritor */
        
        // texto que informa qual slider e o leitor 1
        Text writerSliderTxt1 = new Text(650, 590, "Writer 1");
        writerSliderTxt1.setFont(Font.font("Cambria", FontWeight.SEMI_BOLD, 15));
        
        // texto que informa qual slider e o leitor 2
        Text writerSliderTxt2 = new Text(650, 630, "Writer 2");
        writerSliderTxt2.setFont(Font.font("Cambria", FontWeight.SEMI_BOLD, 15));
        
        // texto que informa qual slider e o leitor 3
        Text writerSliderTxt3 = new Text(650, 670, "Writer 3");
        writerSliderTxt3.setFont(Font.font("Cambria", FontWeight.SEMI_BOLD, 15));
        
        // adiciona todos os textos
        canvas.getChildren().addAll(writerSliderTxt1, writerSliderTxt2, writerSliderTxt3);
        
        writersSlds = new Slider[3];
        
        for (int i = 0; i < writersSlds.length; i++) {
            writersSlds[i] = new Slider();
            writersSlds[i].setMin(10);
            writersSlds[i].setMax(100);
            writersSlds[i].setOrientation(Orientation.HORIZONTAL);
            writersSlds[i].setPrefWidth(270);
            writersSlds[i].setShowTickLabels(true);
            writersSlds[i].setShowTickMarks(true);
            writersSlds[i].setBlockIncrement(10);
            
            if (i == 0) {
                writersSlds[0].setValue(30);
                writersSlds[0].setLayoutX(650);
                writersSlds[0].setLayoutY(590);
            } else if (i == 1) {
                writersSlds[1].setValue(70);
                writersSlds[1].setLayoutX(650);
                writersSlds[1].setLayoutY(630);
            } else if (i == 2) {
                writersSlds[2].setValue(50);
                writersSlds[2].setLayoutX(650);
                writersSlds[2].setLayoutY(670);
            }
            
            canvas.getChildren().add(writersSlds[i]);
        }
        
        return canvas;
    } // fim do metodo createContent
} // fim da classe ScreenView
