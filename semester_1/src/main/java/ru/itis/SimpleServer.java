package ru.itis;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Программа демонстрирует простой сервер.
 * После получения запроса от клиента выводим его в консоль (только заголовок),
 * отправляем ответ и завершаем работу.
 * Запрос можно отправить, набрав в браузере localhost:9999
 */
public class SimpleServer {
    public static void main(String args[]){

        SimpleServer simpleServer = new SimpleServer();

        System.out.println("start: http:\\\\localhost:9999");
        try{
            // Создаем серверный сокет, привязанный к порту 9999
            ServerSocket server = new ServerSocket(9999);

            // accept - запуск прослушивания порта
            // как только accept обнаруживает соединение с клиентской стороны
            // создается дополнительный сокет для работы с этим конкретным клиентом
            Socket clientSocket = server.accept();

            // Получаем ссылку на входной поток данных от клиента
            InputStream inputStream = clientSocket.getInputStream();

            String header = "";

            List<String> rawHeaders = new ArrayList<>();
            int sizeCurrentString=0;
            boolean foundCR = false;
            // Читаем из входного потока информацию от клиента побайтно (интерпретируем как символ)
            // Чтение останавливаем когда достигнем пустой строки
            // (это конец заголовка запроса по стандарту), т.е. обнаружим последовательность \r\n\r\n
            while (true) {
                int c = inputStream.read(); // читаем 1 байт

                if (c==-1) break;// Если не смогли ничего прочитать - выходим из цикла

                header += (char)c; // Все, что прочитаем - добавим в строку для вывода заголовка

                if (c!='\r' && c!='\n') // если обычный символ - добавляем его в заголовок
                {
                    sizeCurrentString++;
                }
                else if (c=='\r') //если пришел перевод каретки - фиксируем это событие
                {
                    foundCR = true;
                }
                else if (c=='\n' && foundCR && sizeCurrentString > 0) //если добрались до конца непустой строки
                {
                    sizeCurrentString=0;
                    foundCR = false;
                    rawHeaders.add(header);
                    header = "";
                }
                else if (c=='\n' && foundCR && sizeCurrentString == 0) //если получилась пустая строка - завершаем
                {
                    break;
                }
            }

            // Печатаем заголовок
            rawHeaders.forEach(s -> System.out.println(s));



            // Получаем ссылку на выходной поток клиентского сокета, через него передадим ответ
            OutputStream outputStream= clientSocket.getOutputStream();

            // Готовим ответ клиенту - сначала заголовок, потом пустую строку, потом HTML страницу
            byte[] response = ("HTTP/1.1 200 OK\r\n"+
                    "Server: test server 0.0\r\n"+
                    "Set-Cookie: JSESSIONID=asdfghjkl\r\n" +
                    "Content-Type: text/html;charset=UTF-8\r\n"+
                    "\r\n").getBytes("UTF8");
            //"<html><body><h1>Hello from simple server!</h1></body></html>"

            // Отправляем ответ клиенту - пишем массив байтов в выходной поток сокета
            outputStream.write(response);

            InputStream is = simpleServer.getClass().getClassLoader().getResourceAsStream("application/html/index.html");

            byte[] buf = new byte[2048];
            int r;
            while ( (r = is.read(buf)) != -1) {
                outputStream.write(buf,0,r);
            }

            // Закрываем все потоки и соединения
            outputStream.close();
            inputStream.close();
            clientSocket.close();
            server.close();

        } catch(IOException e){
           e.printStackTrace();
        }

        System.out.println("stop");
    }
}
/*

cookies
TLS (HTTPS)
GET  ... ?JSESSIONID=0876868896760
 */