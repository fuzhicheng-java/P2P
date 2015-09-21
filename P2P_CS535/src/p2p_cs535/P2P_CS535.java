/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2p_cs535;

/**
 *
 * @author zhichengfu
 */
public class P2P_CS535 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Client client=new Client();
        ShareFileInterface fileShare=new ShareFileInterface(client);
        fileShare.setVisible(true);
    }
    
}
