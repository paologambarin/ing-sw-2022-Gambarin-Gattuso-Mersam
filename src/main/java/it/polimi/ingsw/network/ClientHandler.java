package it.polimi.ingsw.network;

import it.polimi.ingsw.network.Message.ClientToServer.ReadyTodisconnection;
import it.polimi.ingsw.network.Message.Message;
import it.polimi.ingsw.network.Message.Ping;
import it.polimi.ingsw.network.Message.ServerToClient.WaitLoginMessage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * is used for create an instance of client
 */
public class ClientHandler implements ClientHandlerInterface,Runnable {
    private final Lobby lobby;
    private final Socket mySocket;
    private String userNickname;
    private volatile boolean connected;
    private volatile boolean myTurn;
    private Message message;
    private Ping ping;
    private volatile boolean messageReady;
    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;

    public ClientHandler(Socket socket, Lobby lobby) {
        this.lobby = lobby;
        this.mySocket = socket;
        this.connected = true;
        this.myTurn = false;
        this.messageReady = false;
        ping = new Ping();
    }

    public String getUserNickname() {
        return userNickname;
    }

    public boolean getMyTurn() {
        return myTurn;
    }

    @Override
    public void setTurn(boolean myTurn) {
        this.myTurn = myTurn;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    /**
     * Sends the messages to the server
     */
    public synchronized void sendObject(Message object) {
        try {
            if (!(object instanceof WaitLoginMessage)) {
                objectOutputStream.reset();
            }
            objectOutputStream.writeObject(object);
            objectOutputStream.flush();
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }

    private void pingToClient() {
        Thread thread = new Thread(() -> {
            int c = 0;
            while (connected) {
                try {
                    Thread.sleep(50);
                    c++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (c > 100) {
                    c = 0;
                    sendObject(ping);
                }
            }
        });
        thread.start();
    }

    /**
     * Close the Client connection
     */
    public void closeConnect(String userNickname) {
        try {
            connected = false;
            mySocket.close();
            objectOutputStream.close();
            objectInputStream.close();
            updateDisconnection(this);
            System.out.println("SERVER: " + userNickname + " connection close by the server.\n");
        } catch (IOException e) {
            System.out.println("SERVER: errore closing: " + userNickname + "\n");
            e.printStackTrace();
        }
    }

    public void readFromClient() {
        Thread thread = new Thread(() -> {
            while (connected) {
                try {
                    mySocket.setSoTimeout(30000);
                    Message toServer = null;
                    try {
                        toServer = (Message) objectInputStream.readObject();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    if (lobby.isDisconnectAll()) {
                        if (toServer instanceof ReadyTodisconnection) {
                            lobby.processMessage(this, toServer);
                        }
                    } else if (!(toServer instanceof Ping)) {
                        lobby.processMessage(this, toServer);
                        messageReady = true;
                        synchronized (this) {
                            notifyAll();
                        }
                    }
                } catch (IOException | NullPointerException | IllegalArgumentException e) {
                    System.out.println("SERVER: " + userNickname + " connection close by the client");
                    lobby.setDisconnectionCounter();
                    closeConnect(userNickname);
                    break;
                }
            }
        });
        thread.start();
    }

    @Override
    public Message read() {
        synchronized (this) {
            while (!messageReady) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        messageReady = false;
        return message;
    }

    public void run() {
        try {
            this.objectOutputStream = new ObjectOutputStream(mySocket.getOutputStream());
            this.objectInputStream = new ObjectInputStream(mySocket.getInputStream());
            System.out.println("[SERVER] new Client Created.");
            readFromClient();
            pingToClient();
            lobby.loginUser(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateDisconnection(ClientHandlerInterface client) {
        lobby.updateDisconnection(this);
    }
}