package model;

import java.util.concurrent.Semaphore;

public class Database {
    
    // controla o acesso a regiao critica
    public static Semaphore mutex;
    // controla o acesso a base de dados
    public static Semaphore db;
    // numero de processos lendo ou querendo ler a base de dados
    public static int readCount;
    
    /**
     * Construtor da classe
     */
    public Database() {
        mutex = new Semaphore(1);
        db = new Semaphore(1);
        readCount = 0;
    }
}
