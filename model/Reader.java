package model;

import javafx.application.Platform;
import view.ScreenView;

import java.util.Random;

public class Reader extends Thread {
    
    private int readerNumber;
    private Random random = new Random();
    
    /**
     * Construtor.
     *
     * @param readerNumber Recebe um numero que identifica o leitor.
     */
    public Reader(int readerNumber) {
        this.readerNumber = readerNumber;
    }
    
    @Override
    public void run() {
        while (true) {
            try {
                // obtem acesso a regiao critica
                // down(mutex)
                Database.mutex.acquire();
                // um novo leitor
                Database.readCount++;
                
                    if (Database.readCount == 1) {
                        // se houver pelo menos um leior
                        // down(db)
                        Database.db.acquire();
                    }
                
                // libera o acesso
                // up(mutex)
                Database.mutex.release();
                    // regiao critica
                    // le a base de ddados
                    readDatabase();
                // down(mutex)
                Database.mutex.acquire();
                // menos um leitor
                Database.readCount--;
                
                    if (Database.readCount == 0) {
                        // caso essse seja o ultimo leitor
                        // up(db)
                        Database.db.release();
                    }
                
                // libera o acesso
                // up(mutex)
                Database.mutex.release();
                // regiao nao critica
                useDataRead();
            } catch (InterruptedException e) {
            }
        }
    }
    
    /**
     * Metodo responsavel por simular o momento em que o leitor
     * esta lendo o banco de dados
     */
    private void readDatabase() {
        switch (readerNumber) {
            case 1:
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        ScreenView.snoopySleepyView[0].setVisible(false);
                        ScreenView.snoopyReadingView[0].setVisible(true);
                        ScreenView.readerTxts[0].setText("The reader 1 is reading the database");
                    }
                });
                
                try {
                    Thread.sleep((long) (ScreenView.readersSlds[0].getValue() * 100));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        ScreenView.snoopySleepyView[1].setVisible(false);
                        ScreenView.snoopyReadingView[1].setVisible(true);
                        ScreenView.readerTxts[1].setText("The reader 2 is reading the database");
                    }
                });
                
                try {
                    Thread.sleep((long) (ScreenView.readersSlds[1].getValue() * 100));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        ScreenView.snoopySleepyView[2].setVisible(false);
                        ScreenView.snoopyReadingView[2].setVisible(true);
                        ScreenView.readerTxts[2].setText("The reader 3 is reading the database");
                    }
                });
                
                try {
                    Thread.sleep((long) (ScreenView.readersSlds[2].getValue() * 100));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            
            case 4:
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        ScreenView.snoopySleepyView[3].setVisible(false);
                        ScreenView.snoopyReadingView[3].setVisible(true);
                        ScreenView.readerTxts[3].setText("The reader 4 is reading the database");
                    }
                });
                
                try {
                    Thread.sleep((long) (ScreenView.readersSlds[3].getValue() * 100));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
    
    /**
     * Metodo responsavel por simular o momento em que o leitor nao esta lendo,
     * ou seja, esta usando o dado lido do banco de dados
     */
    private void useDataRead() {
        switch (readerNumber) {
            case 1:
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        ScreenView.snoopySleepyView[0].setVisible(true);
                        ScreenView.snoopyReadingView[0].setVisible(false);
                        ScreenView.readerTxts[0].setText("The reader 1 is using the data");
                    }
                });
                
                // gera um inteiro randomico entre 1 e 10
                int useTime1 = random.nextInt(10) + 1;
                try {
                    Thread.sleep(useTime1 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        ScreenView.snoopySleepyView[1].setVisible(true);
                        ScreenView.snoopyReadingView[1].setVisible(false);
                        ScreenView.readerTxts[1].setText("The reader 2 is using the data");
                    }
                });
    
                // gera um inteiro randomico entre 1 e 10
                int useTime2 = random.nextInt(10) + 1;
                try {
                    Thread.sleep(useTime2 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        ScreenView.snoopySleepyView[2].setVisible(true);
                        ScreenView.snoopyReadingView[2].setVisible(false);
                        ScreenView.readerTxts[2].setText("The reader 3 is using the data");
                        
                    }
                });
                
                // gera um inteiro randomico entre 1 e 10
                int useTime3 = random.nextInt(10) + 1;
                try {
                    Thread.sleep(useTime3 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case 4:
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        ScreenView.snoopySleepyView[3].setVisible(true);
                        ScreenView.snoopyReadingView[3].setVisible(false);
                        ScreenView.readerTxts[3].setText("The reader 4 is using the data");
                    }
                });
    
                // gera um inteiro randomico entre 1 e 10
                int useTime4 = random.nextInt(10) + 1;
                try {
                    Thread.sleep(useTime4 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}
