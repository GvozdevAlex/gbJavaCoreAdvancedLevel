package hw_06;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        Socket socket = null;
        ServerSocket server = null;
        Scanner scanner = new Scanner(System.in);
        int PORT = 8189;
        try {
            server = new ServerSocket(PORT);
            System.out.println("Сервер запущен");
            socket = server.accept();
            System.out.println("Клиент подключился");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            Thread threadRead = new Thread(()->{
                try {
                    out.writeUTF(scanner.nextLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            threadRead.setDaemon(true);
            threadRead.start();

            while (true){
                String str = in.readUTF();
                if(str.equals("/end")){
                    System.out.println("Клиент отключился");
                    out.writeUTF("/end");
                    break;
                }
                System.out.println("Клиент: " + str);
            }

        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try{
                socket.close();
                server.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
