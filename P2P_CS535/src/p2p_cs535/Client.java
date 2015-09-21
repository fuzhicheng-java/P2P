/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2p_cs535;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import javax.swing.JFrame;
import static p2p_cs535.Server.server;

/**
 *
 * @author zhichengfu
 */
public class Client {

    public int port=0;
    public String serverIP;
    public int serverPort;

    public void initResponse(Init_Setting inter, int port) throws IOException {
        this.port = port;
        ServerSocket server;
        try {
            server = new ServerSocket(port, 50);
            inter.showClientState(true);
            while (true) {
                Socket socket = server.accept();
                ClientShareFileThread cft = new ClientShareFileThread(socket);
                Thread temp = new Thread(cft);
                temp.start();
            }
        } catch (Exception e) {
            inter.showClientPortState();
        }

    }

    public int sendRegisterRequest(String host, int port) throws IOException {

        try {
            Socket client = new Socket(host, port);
            Writer writer = new OutputStreamWriter(client.getOutputStream());
            writer.write("1" + "\n");
            writer.write(client.getLocalAddress().getHostName() + "\n");
            writer.write("eof\n");
            writer.flush();
            //写完以后进行读操作  
            BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String temp;
            while ((temp = br.readLine()) != null) {
                if (temp.equals("eof")) {//遇到eof时就结束接收               
                    break;
                }
                sb.append(temp);
            }
            writer.close();
            br.close();
            client.close();
            //System.out.println("from server: " + sb);  
            if (sb.toString().equals("2")) {

                return 1;

            } else if (sb.toString().equals("1")) {

                return 2;
            } else // failed
            {
                return 3;
            }
        } catch (Exception e) {
            return 3;
        }

    }

    public boolean sendFileShareRequest(String host, int port, String fileName, String filePath) throws IOException {
        Socket client = new Socket(host, port);
        Writer writer = new OutputStreamWriter(client.getOutputStream());
        writer.write("2" + "\n");
        writer.write(client.getLocalAddress().getHostName() + "\n");
        writer.write(this.port + "\n");
        writer.write(fileName + "\n");
        writer.write(filePath + "\n");
        writer.write("eof\n");
        writer.flush();
        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String temp;
        while ((temp = br.readLine()) != null) {
            if (temp.equals("eof")) {//遇到eof时就结束接收  
                break;
            }
            sb.append(temp);
        }
        writer.close();
        br.close();
        client.close();
        //System.out.println("from server: " + sb);  
        if (sb.toString().equals("1")) {
            return true;
        } else // failed
        {
            return false;
        }
    }

    public LinkedList<FileEntry> getFilesIndexBasedName(String host, int port, String name) throws IOException {
        LinkedList<FileEntry> files = new LinkedList<>();
        Socket client = new Socket(host, port);
        Writer writer = new OutputStreamWriter(client.getOutputStream());
        writer.write("3" + "\n");
        writer.write(name + "\n");
        writer.write("eof\n");
        writer.flush();
        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
        String line;
        int index = 0;
        FileEntry fileEntry = null;
        while ((line = br.readLine()) != null) {
            if (line.equals("eof")) {
                break;
            }
            if (index == 0) {
                fileEntry = new FileEntry();
                fileEntry.localIP = line;
            } else if (index == 1) {
                fileEntry.port = Integer.parseInt(line);
            } else if (index == 2) {
                fileEntry.name = line;

            } else if (index == 3) {
                fileEntry.filePath = line;
                index = 0;
                files.add(fileEntry);
            }
            index++;
        }
        br.close();
        client.close();
        return files;
    }

    public void receiveFileFromSide(FileEntry file, File dest) throws IOException {
        Socket client = new Socket(file.localIP, file.port);
        Writer writer1 = new OutputStreamWriter(client.getOutputStream());
        writer1.write(file.filePath);
        writer1.flush();
        writer1.close();
        byte[] inputByte = null;
        int length = 0;
        DataInputStream dis = null;
        FileOutputStream fos = null;
        dis = new DataInputStream(client.getInputStream());
        fos = new FileOutputStream(dest);
        inputByte = new byte[1024];
        //System.out.println("开始接收数据...");
        while ((length = dis.read(inputByte, 0, inputByte.length)) > 0) {
            fos.write(inputByte, 0, length);
            fos.flush();
        }

        fos.close();
        dis.close();
        client.close();
    }
}
