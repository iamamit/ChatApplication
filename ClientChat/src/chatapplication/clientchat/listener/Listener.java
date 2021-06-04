package chatapplication.clientchat.listener;

import chatapplication.clientchat.ClientChat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Listener implements ActionListener

{

    @Override

    public void actionPerformed(ActionEvent e) {

        // TODO Auto-generated method stub

        ClientChat.out.println(ClientChat.textField.getText());

        ClientChat.textField.setText("");

    }



}