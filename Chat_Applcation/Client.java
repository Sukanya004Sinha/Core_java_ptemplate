
import java.net.*;
import java.io.*;

public class Client {
    Socket socket;
    BufferedReader br;
    PrintWriter out;
    public Client(){
        try{
            System.out.println("sending request to server");
            socket = new Socket("127.0.0.1",7777);
            System.out.println("connection done.");
        br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream());
        startReading();
        startWriting();

        
    }
    catch(Exception e){
        e.printStackTrace();
 

    }
}

public void startReading(){
    //  thread1 will gives the data after reading that
    Runnable r1 =()-> {
    
      
       System.out.println("reader startred... ");
       while(true){ // because we need to read the data everytime
       try{
         String msg =  br.readLine(); //that message will come from server
         if(msg.equals("exit")){ // if server has stop sending the mesage the we need to quite or exit on that time so it means server has terminated the chat
          System.out.println("server terminated the chat");
          break;
         }
         System.out.println("server:" +msg);
       }
       catch(Exception e){
          e.printStackTrace();
       }
       }

    };
    new Thread (r1).start();


  }
  public void startWriting(){
    Runnable r2 = ()->{
        System.out.println("writer started...");
        while (true){
            try{
                BufferedReader br1 = new BufferedReader
                (new InputStreamReader(System.in));
                String content =br1.readLine();
    out.println(content);
    out.flush(); //sometimes when when is full then send is not send then we had to flush here 
            }
            catch(Exception e){
                e.printStackTrace();
                // it is used for Trace the exception on what line we get an exception on console. in which line we get an exception for that we used a trace
            }

        }

      };
      new Thread(r2).start();
    }


    public static void main(String[] args){
        System.out.println("This is client");
        new Client();
    }
}
