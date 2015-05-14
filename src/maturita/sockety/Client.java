package maturita.sockety;

//import potřebných balíčků
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

    private Socket clientSocket; // socket pro klients
    private Scanner in; // scanner pro načítání dat od uživatele


    public static void main( String[] args ) {
        Client client = new Client(); // vytvoření instance třídy server
    }


	//konstruktor třídy Client
    public Client() {
        try {
            this.clientSocket = new Socket( "localhost", 8080 ); // inicializace client socketu
            System.out.println( "Spuštění klienta proběhlo úspěšně." ); // zpráva o úspěšném spuštění
            this.in = new Scanner( System.in ); // inicializace Scanneru
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            BufferedWriter out = new BufferedWriter( new OutputStreamWriter( this.clientSocket.getOutputStream() ) ); //vytvoření BufferedWriteru

            while( true ) {
                String temp = in.nextLine(); // proměnná pro ukládání zpráv uživatele
                out.write( temp + "\r\n" ); // zapsání zprávy do BuffredWriteru
                out.flush(); // odeslání zprávy
                System.out.println( "Zpráva: \"" + temp + "\" byla odeslána."); // oznámení o úspěšném odeslání
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
