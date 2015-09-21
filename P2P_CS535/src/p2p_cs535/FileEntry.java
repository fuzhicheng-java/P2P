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
public class FileEntry {
    
    public String name;
    
    public String filePath;
    
    public String localIP;
    
    public int port;
    
    public FileEntry(String name, String filePath,String localIP,int port)
    {
        this.name=name;
        this.filePath=filePath;
        this.localIP=localIP;
        this.port=port;
    }
    
    
    public FileEntry(){}
}
