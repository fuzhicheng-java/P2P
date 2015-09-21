/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2p_cs535;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zhichengfu
 */
public class ServerProcessThread implements Runnable {

    public Server server;
    public Socket socket;

    public ServerProcessThread(Socket socket, Server server) {
        this.socket = socket;
        this.server = server;
    }

    @Override
    public void run() {
        try {
            this.handleProcess();
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (Exception ex) {
            Logger.getLogger(ServerProcessThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void handleProcess() throws Exception {
        String con = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String temp;
        FileEntry fileE = null;
        int index = 0;
        int option = 0;
        int checkIndex = 0;
        int flag = 0;
        while ((temp = br.readLine()) != null) {
            if (checkIndex == 0) {
                option = Integer.parseInt(temp);
                if (option == 2) {
                    fileE = new FileEntry();
                }
            } else {
                if (temp.equals("eof")) {//遇到eof时就结束接收  
                    break;
                }
                if (option == 2) {
                    if (checkIndex == 1) {
                        fileE.localIP = temp;
                    } else if (checkIndex == 2) {
                        fileE.port = Integer.parseInt(temp);
                    } else if (checkIndex == 3) {
                        fileE.name = temp;
                    }
                    else if(checkIndex==4)
                    {
                        fileE.filePath = temp.substring(0, index);
                    }

                } else {
                    sb.append(temp);
                }
            }
            checkIndex++;
        }
        if (option == 1) {
            flag = this.server.doRegister(sb.toString());
            if (flag == 2) {
                con = "2";
            } else if (flag == 1) {
                con = "1";
            } else {
                con = "3";
            }
        } else if (option == 2) {
            boolean tempT = this.server.addNewFileEntry(fileE);
            if (tempT) {
                con = "1";

            } else {
                con = "2";
            }
        }
        else if(option==3)
        {
            con=this.getShareFileEntry(this.server.getFileEntry(sb.toString()));
        }

//        
        Writer writer = new OutputStreamWriter(socket.getOutputStream());
        if(option!=3)
        {
            con=con+"\n";
        }
        writer.write(con);
        writer.write("eof\n");
        writer.flush();
        writer.close();
        socket.close();
    }
    
    public String getShareFileEntry(LinkedList<FileEntry> files)
    {
        String out="";
        for(FileEntry f:files)
        {
            out+=f.localIP+"\n";
            out+=f.port+"\n";
            out+=f.name+"\n";
            out+=f.filePath+"\n";
        }
        if(out.equals(""))
        {
            out="eof\n";
        }
        return out;
    }

}
