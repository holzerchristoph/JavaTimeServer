package com.company;

import java.io.IOException;
import java.net.*;

public class Main {

    static int PORT = 5555;
    static InetAddress broadcast;


    public static void main(String[] args) throws IOException, InterruptedException {
        // define broadcast address 192.168.1.255/24
        broadcast = InetAddress.getByName( "192.168.1.255" );
	    // open a serversocket UDP
        DatagramSocket serverSocket = new DatagramSocket(5555);

        while(true){
            // create payload
            byte[] payload="hallo".getBytes();
            // define the packet to send
            DatagramPacket sendPacket = new DatagramPacket(payload, payload.length, Main.broadcast, Main.PORT);
            // send packet via serversocket
            serverSocket.send(sendPacket);
            // wait
            Thread.sleep(2000);
        }
    }
}
