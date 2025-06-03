package elabyad.mohamed.dam.mp09.uf03.a01;

import java.io.ObjectOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    private static final String HOST = "localhost";
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try (Socket socket = new Socket(HOST, PORT);
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())) {
            System.out.println("Connected to server at " + HOST + ":" + PORT);
            Book book = new Book("1984", "George Orwell");
            out.writeObject(book);
            out.flush();
            System.out.println("Sent: " + book);
        } catch (IOException e) {
            System.err.println("Client error: " + e.getMessage());
        }
    }
}
