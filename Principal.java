/*
 * Created by Hugo Teixeira Mafra <hugorc10@hotmail.com> on 20/09/2018. Last modification on 23/09/2018.
 * <p>
 * Enrollment number: 201611540
 * <p>
 * Readers-writers problem it is a software that simulates the first
 * readers-writers problem (also called readers-preference) of three variations of the readers-writers problems,
 * which deal with situations in which many threads try to access the same shared resource at one time.
 * Some threads may read and some may write, with the constraint that no process may access
 * the shared resource for either reading or writing while another process is in the act of writing to it.
 * <p>
 * Readers-writers problem is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * Readers-writers problem is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * To see the GNU General Public License
 * please visit this site: <http://www.gnu.org/licenses/>.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Database;
import model.Reader;
import model.Writer;
import view.ScreenView;

public class Principal extends Application {
    
    // main method
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        ScreenView view = new ScreenView();
        
        Scene scene = new Scene(view.createContent());
        
        // inicializa a classe contendo os semaforos
        Database database = new Database();
        
        Reader[] readers = new Reader[4];
        Writer[] writers = new Writer[3];
        
        // instancia todos os leitores
        for (int i = 0; i < readers.length; i++) {
            readers[i] = new Reader(i + 1);
        }
        
        // instancia todos os escritores
        for (int i = 0; i < writers.length; i++) {
            writers[i] = new Writer(i + 1);
        }
        
        // starta todas as threads leitores
        for (int i = 0; i < readers.length; i++) {
            readers[i].setDaemon(true);
            readers[i].start();
        }
        
        // starta todas as threads escritores
        for (int i = 0; i < writers.length; i++) {
            writers[i].setDaemon(true);
            writers[i].start();
        }
        
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Readers-writers problem");
        stage.setResizable(false);
        stage.setAlwaysOnTop(true);
        stage.show();
    } // fim do metodo start
}
