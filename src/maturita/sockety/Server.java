/**
 * Author: Filip Stryk ( Leaf )
 * Created on 8. 10. 2014
 * Created for Java tutorial on www.itnetwork.cz
 */

package maturita.sockety;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

    private ServerSocket serverSocket;
    private ArrayList<BufferedReader> clientBufReaders;

    public static void main(String[] args) {
        Server server = new Server();
    }

    public Server() {
        try {
            this.serverSocket = new ServerSocket( 8080 );
            System.out.print( "Spuštění serveru proběhlo úspěšně.\nČekám na připojení klienta...\n" );
            this.clientBufReaders = new ArrayList<BufferedReader>();

            this.clients();
        } catch (IOException e ) {
            e.printStackTrace();
        }
    }

    private void clients() {
        Thread acceptThread = new Thread(new Runnable() {
            public void run() {
                while(true) {
                    try {
                        Socket clientSocket = serverSocket.accept();
                        clientBufReaders.add(new BufferedReader(new InputStreamReader(clientSocket.getInputStream())));
                        System.out.println("Klient se připojil.");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        acceptThread.start();

        while(true) {
            synchronized(clientBufReaders) {
                for(BufferedReader in :  clientBufReaders) {
                    try {
                        if(in.ready()) {
                            System.out.println(in.readLine());
                        } else {
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
