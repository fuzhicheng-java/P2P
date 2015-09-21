/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2p_cs535;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author zhichengfu
 */
public class Server {

    public String server_IP;
    public int port;
    public LinkedList<String> allPeers = new LinkedList();
    public HashMap<String, LinkedList<FileEntry>> shareFiles = new HashMap();
    public static ServerSocket server = null;

    public Server(Init_Setting inter, int port) throws IOException {
        //InetAddress addr = InetAddress.getByName(server_IP);
        this.port = port;
        try {
            server = new ServerSocket(this.port, 50);
            inter.showServerState(true);
            while (true) {
                Socket socket = server.accept();
                ServerProcessThread rt = new ServerProcessThread(socket, this);
                Thread temp = new Thread(rt);
                temp.start();
            }
        } catch (Exception e) {
            inter.showServerPortState();
        }

    }

    public LinkedList<FileEntry> getFileEntry(String fileName) {

        Iterator tempItem = this.shareFiles.keySet().iterator();
        while (tempItem.hasNext()) {
            String key = (String) tempItem.next();
            if (key.contains(fileName)) {
                return this.shareFiles.get(key);
            }
        }
        return null;
    }

    public boolean addNewFileEntry(FileEntry temp) {
        try {
            LinkedList<FileEntry> files = this.shareFiles.get(temp.name);
            if (files == null) {
                LinkedList<FileEntry> temps = new LinkedList<FileEntry>();
                temps.add(temp);
                this.shareFiles.put(temp.name, temps);
            } else {
                files.add(temp);
            }
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    // 1: already exist, 2; done
    public int doRegister(String localIP) {
        for (String temp : this.allPeers) {
            if (temp.equals(localIP)) {
                return 1;
            }
        }
        this.allPeers.add(localIP);
        return 2;
    }

}
