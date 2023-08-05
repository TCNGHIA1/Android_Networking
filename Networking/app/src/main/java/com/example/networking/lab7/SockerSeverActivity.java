package com.example.networking.lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.example.networking.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SockerSeverActivity extends AppCompatActivity {

    private ServerSocket serverSocket;
    Handler updateConversationHandler;
    Thread serverThread = null;
    private TextView text;
    public static final int SERVERPORT = 6000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_socker_sever);
        text = (TextView) findViewById(R.id.tv);
        updateConversationHandler = new Handler();
        this.serverThread = new Thread(new ServerThread());
        this.serverThread.start();
    }
    @Override
    protected void onStop() {
        super.onStop();
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    class ServerThread implements Runnable{
        @Override
        public void run() {
            Socket socket = null;
            try {
                serverSocket = new ServerSocket(SERVERPORT);
            } catch (IOException e) {
                e.printStackTrace();
            }
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    socket = serverSocket.accept();
                    CommunicationThread commnThread = new
                            CommunicationThread(socket);
                    new Thread(commnThread).start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    class CommunicationThread implements Runnable {
        private Socket clientSocket;
        private BufferedReader input;
        public CommunicationThread(Socket clientSocket) {
            this.clientSocket = clientSocket;
            try {
                this.input = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    String read = input.readLine();
                    updateConversationHandler.post(new
                            UpdateUIThread(read));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    class UpdateUIThread implements Runnable{
        private String msg;
        public UpdateUIThread(String str) {
            this.msg = str;
        }

        @Override
        public void run() {
            text.setText(text.getText().toString() + "Client says: " + msg + "\n");
        }
    }
}