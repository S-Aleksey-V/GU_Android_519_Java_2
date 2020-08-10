package java2.lesson6;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {


    private static final int SERVER_PORT = 8080;
    private static final String END_MESSAGE = "/end";


    public static void main(String[] args) {
        Socket socket;
        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            System.out.println("Сервер запущен, ожидаем подключения...");
            socket = serverSocket.accept();
            System.out.println("Клиент подключчился");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            new Thread(() -> {
                while (true) {
                    String msg = null;
                    try {
                        msg = reader.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        out.writeUTF("Сообщение отправлено с сервера: " + msg);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            while (true) {
                String str = in.readUTF();
                if (str.equals(END_MESSAGE)) {
                    break;
                }
                System.out.println("Received: " + str);
                out.writeUTF("Сообщение от клиента : " + str);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
