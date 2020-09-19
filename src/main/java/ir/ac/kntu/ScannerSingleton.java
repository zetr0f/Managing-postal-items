package ir.ac.kntu;

import java.util.Scanner;

/**
 * @author Ali Afshar
 * @since 3/14/2020
 * @version version 1.0
 * @see Scanner
 */
public class ScannerSingleton {
    /**
     * declaring scanner and scannerSingleton
     */
    private static ScannerSingleton instance;
    private static Scanner scanner;

    private ScannerSingleton() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
    }

    /**
     * @return scannerSingleton of class
     */
    public static ScannerSingleton getInstance() {
        if (instance == null){
            instance = new ScannerSingleton();
        }
        return instance;
    }

    /**
     * @return the next line of cmd in string
     */
    public String nextLine() {
        return scanner.nextLine();
    }

    /**
     * @return the next Integer of cmd
     */
    public Integer nextInt() {
        String input = scanner.nextLine();
        input = input.trim();
        return Integer.parseInt(input);
    }

    /**
     * @return the next Double of cmd
     */
    public Double nextDouble(){
        return scanner.nextDouble();
    }

    /**
     * if we don,t need this class , we close the Scanner
     */
    public void close() {
        scanner.close();
    }
}
