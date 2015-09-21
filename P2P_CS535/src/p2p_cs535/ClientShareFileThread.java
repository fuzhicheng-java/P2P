/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2p_cs535;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zhichengfu
 */
public class ClientShareFileThread implements Runnable {

    public Socket socket;

    public ClientShareFileThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            this.handleSendShareFile();
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (Exception ex) {
            Logger.getLogger(ServerProcessThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void handleSendShareFile() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String temp;
        while ((temp = br.readLine()) != null) {
            if (temp.equals("eof")) {
                break;
            }
            sb.append(temp);
        }
        br.close();
        File file = new File(sb.toString());
        byte[] sendBytes = null;
        long l = file.length();
        int length=0;
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        double sumL = 0;
        FileInputStream fis = new FileInputStream(file);
        sendBytes = new byte[1024];
        while ((length = fis.read(sendBytes, 0, sendBytes.length)) > 0) {
            sumL += length;
            //System.out.println("已传输：" + ((sumL / l) * 100) + "%");
            dos.write(sendBytes, 0, length);
            dos.flush();
        }
        dos.close();
        fis.close();
        socket.close();
    }
}
