package com.company;

import java.io.IOException;
import java.net.*;
import java.time.LocalDateTime;

public class Main {

    static int DESTINATION_PORT = 9999;     // sending on this port
    static int SOURCE_PORT = 5555;          // listening on this port
    static InetAddress broadcast;


    public static void main(String[] args) throws IOException, InterruptedException {
        // define broadcast address 192.168.1.255/24
        broadcast = InetAddress.getByName( "192.168.1.255"  );  // or 255.255.255.255
	    // open a serversocket UDP
        DatagramSocket serverSocket = new DatagramSocket(Main.SOURCE_PORT);

        while(true){
            String time=String.valueOf(LocalDateTime.now());
            System.out.println(time);
            // create payload
            byte[] payload=time.getBytes();
            // define the packet to send
            DatagramPacket sendPacket = new DatagramPacket(payload, payload.length, Main.broadcast, Main.DESTINATION_PORT);
            // send packet via serversocket
            serverSocket.send(sendPacket);
            // wait
            Thread.sleep(2000);
        }
    }
}
