package hw_06;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String IP_ADDRESS = "localhost";
        int PORT = 8189;
        Socket socket = null;
        Scanner scanner = new Scanner(System.in);
        try {
            socket = new Socket(IP_ADDRESS, PORT);
            System.out.println("Выполнено подключение");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());


            Thread threadRead = new Thread(() -> {
                while (true) {
                    try {
                        out.writeUTF(scanner.nextLine());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            threadRead.setDaemon(true);
            threadRead.start();

            while (true) {
                String str = in.readUTF();
                if (str.equals("/end")){
                    System.out.println("Подключение закрыто");
                    out.writeUTF("/end");
                    break;
                }
                System.out.println("Сервер: " + str);
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
