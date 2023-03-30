import java.net.*;
import java.io.*;

class Server{
    ServerSocket server ;
    Socket socket; 
    BufferedReader br ; // whaever we will receive the input stream through  socket= server.accept(); give it to BufferedReader br to read that 
    PrintWriter out; // whaever we will receive the output stream through  socket= server.accept(); give it toPrintWriter out to write that 

   
    //constructor
    public Server(){
        try{
        server=new ServerSocket(7777); //passing port
        System.out.println("Server is ready to accept connection");
        System.out.println("Waiting........");
        socket= server.accept();
        br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        startReading();
        startWriting();
    
      out = new  PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

    }
    catch(Exception e){
        e.printStackTrace();
    }
    }
    public void startReading(){
      //  thread1 will gives the data after reading that
      Runnable r1 =()-> {
      
        
         System.out.println("reader startred ");
         try{
         while(true){ // because we need to read the data everytime
        // try{
           String msg =  br.readLine(); //that message will come from client
           if(msg.equals("exit")){ // if client has stop sending the mesage the we need to quite or exit on that time so it means clients has terminated the chat
            System.out.println("Client terminated the chat");
            socket.close(); // closed connection
            break;
           }
           System.out.println("client:" +msg);
         }
        }
         catch(Exception e){
            e.printStackTrace();
         }
        // }

      };
      new Thread (r1).start();


    }
    public void startWriting(){
        // it will take data from user and send it to client
      Runnable r2 = ()->{
        System.out.println("writer started...");
        try{
        while (!socket.isClosed()){
            // try{
                BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
                String content =br1.readLine();
    out.println(content);
    out.flush(); //sometimes when when is full then send is not send then we had to flush here 
    if(content.equals("exit")){
      socket.close();
      break;
    }     
  
  }
          }
           catch(Exception e){
            System.out.println("connection closed");
                e.printStackTrace();
                //print all stacktrace
                // it is used for Trace the exception on what line we get an exception on console. in which line we get an exception for that we used a trace
           }

        };      

      
      new Thread(r2).start();
    }
    public static void main(String[] args){
        System.out.println("This is a server");
        new Server();
    }
}