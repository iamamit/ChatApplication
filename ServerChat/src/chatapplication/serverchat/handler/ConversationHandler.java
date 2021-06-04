package chatapplication.serverchat.handler;


import java.io.*;
import java.net.Socket;

import chatapplication.serverchat.ServerChat;

public class ConversationHandler extends Thread
{

    public Socket socket;

    public BufferedReader in;

    public PrintWriter out;

    public String name;

    public PrintWriter pw;

    public static FileWriter fw;

    public static BufferedWriter bw;



    public ConversationHandler(Socket socket) throws IOException {

        this.socket = socket;

        try {
            fw = new FileWriter("..\\ChatServer-Logs.txt",true);

        bw = new BufferedWriter(fw);

        pw = new PrintWriter(bw,true);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void run()

    {

        try

        {

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out = new PrintWriter(socket.getOutputStream(), true);



            int count = 0;

            while (true)

            {

                if(count > 0)

                {

                    out.println("NAMEALREADYEXISTS");

                }

                else

                {

                    out.println("NAMEREQUIRED");

                }



                name = in.readLine();



                if (name == null)

                {

                    return;

                }



                if (!ServerChat.userNames.contains(name))

                {

                    ServerChat.userNames.add(name);

                    break;

                }

                count++;

            }



            out.println("NAMEACCEPTED"+name);

            ServerChat.printWriters.add(out);



            while (true)

            {

                String message = in.readLine();



                if (message == null)

                {

                    return;

                }



                pw.println(name + ": " + message);

                for (PrintWriter writer : ServerChat.printWriters) {

                    writer.println(name + ": " + message);

                }

            }



        }

        catch (Exception e)

        {

            System.out.println(e);

        }

    }

}
