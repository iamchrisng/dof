package singleton;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {

    private final String logFile = "src/main/resources/log.txt";

    private static Logger logger = null;
    
    private PrintWriter printWriter;

    public static synchronized Logger getInstance() {
        if (logger == null) {
            logger = new Logger();
        }
        return logger;
    }
    
    private Logger() {
        try {
            FileWriter fileWriter = new FileWriter(logFile);
            printWriter = new PrintWriter(fileWriter, true);
        } catch (IOException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
    }
    
    public void logWithdraw (String account, double amount) {
        printWriter.println("WITHDRAW (" + account + "): " + amount + "$");
    }
    
    public void logDeposit (String account, double amount) {
        printWriter.println("DEPOSIT (" + account + "): " + amount + "$");
    }
    
    public void logTransfer (String fromAccount, String toAccount, double amount) {
        printWriter.println("TRANSFER (" + fromAccount + " -> " + toAccount + "): " + amount + "$");
    }
}