package model;

import javafx.application.Platform;
import view.ScreenView;

import java.util.Random;

public class Writer extends Thread {
    
    private int writerNumber;
    private Random random = new Random();
    
    /**
     * Construtor.
     *
     * @param writerNumber Recebe o numero que indentifica do escritor.
     */
    public Writer(int writerNumber) {
        this.writerNumber = writerNumber;
    }
    
    @Override
    public void run() {
        while (true) {
            try {
                // pensa em informacoes para adicionar no banco de dados
                // regiao nao critica
                thinkUpData();
                // obtem acesso a regiao critica
                // down(db)
                Database.db.acquire();
                
                    // escreve novas informacoes no banco de dados
                    // regiao critica
                    writeDatabase();
                
                // up no semaforo db para liberar o acesso a base de dados
                // up(db)
                Database.db.release();
            } catch (InterruptedException e) {
            }
        } // fim do while
    } // fim do metodo run
    
    /**
     * Metodo responsavel por simular o momento em que o escrito nao esta escrevendo,
     * ou seja, quando ele esta pensando.
     */
    private void thinkUpData() {
        switch (writerNumber) {
            case 1:
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        ScreenView.snoopyThinkingView[0].setVisible(true);
                        ScreenView.snoopyWritingView[0].setVisible(false);
                        ScreenView.writerLbl1.setText("Writer 1 is thinking");
    
                    }
                });
                
                // gera um inteiro randomico entre 1 e 10
                int thinkTime1 = random.nextInt(10) + 1;
                try {
                    Thread.sleep(thinkTime1 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        ScreenView.snoopyThinkingView[1].setVisible(true);
                        ScreenView.snoopyWritingView[1].setVisible(false);
                        ScreenView.writerLbl2.setText("Writer 2 is thinking");
    
                    }
                });
    
                // gera um inteiro randomico entre 1 e 10
                int thinkTime2 = random.nextInt(10) + 1;
                try {
                    Thread.sleep(thinkTime2 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        ScreenView.snoopyThinkingView[2].setVisible(true);
                        ScreenView.snoopyWritingView[2].setVisible(false);
                        ScreenView.writerLbl3.setText("Writer 3 is thinking");
    
                    }
                });
    
                // gera um inteiro randomico entre 1 e 10
                int thinkTime3 = random.nextInt(10) + 1;
                try {
                    Thread.sleep(thinkTime3 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
    
    /**
     * Metodo responsavel por simular o momento em que o escritor esta escrevendo.
     */
    private void writeDatabase() {
        switch (writerNumber) {
            case 1:
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        ScreenView.snoopyThinkingView[0].setVisible(false);
                        ScreenView.snoopyWritingView[0].setVisible(true);
                        ScreenView.writerLbl1.setText("Writer 1 is writing");
                    }
                });
                
                try {
                    Thread.sleep((long) (ScreenView.writersSlds[0].getValue() * 100));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        ScreenView.snoopyThinkingView[1].setVisible(false);
                        ScreenView.snoopyWritingView[1].setVisible(true);
                        ScreenView.writerLbl2.setText("Writer 2 is writing");
                    }
                });
                
                
                try {
                    Thread.sleep((long) (ScreenView.writersSlds[1].getValue() * 100));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        ScreenView.snoopyThinkingView[2].setVisible(false);
                        ScreenView.snoopyWritingView[2].setVisible(true);
                        ScreenView.writerLbl3.setText("Writer 3 is writing");
                    }
                });
                
                try {
                    Thread.sleep((long) (ScreenView.writersSlds[2].getValue() * 100));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}
