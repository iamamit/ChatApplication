package chatapplication.serverchat;

import java.io.*;

import java.net.*;

import java.util.ArrayList;

import chatapplication.serverchat.handler.ConversationHandler;

public class ServerChat {



    public static ArrayList<String> userNames = new ArrayList<String>();

    public static ArrayList<PrintWriter> printWriters = new ArrayList<PrintWriter>();



    public static void main(String[] args) throws Exception{

        // TODO Auto-generated method stub

        System.out.println("Waiting for clients...");

        ServerSocket ss = new ServerSocket(9806);

        while (true)

        {

            Socket soc = ss.accept();

            System.out.println("Connection established");

            ConversationHandler handler = new ConversationHandler(soc);

            handler.start();

        }



    }

}
