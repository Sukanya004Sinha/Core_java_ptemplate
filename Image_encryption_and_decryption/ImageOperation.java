import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.awt.FlowLayout;
public class ImageOperation{
    public static void operate(int key){
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.showOpenDialog(null); 
    File file = fileChooser.getSelectedFile();
    // basically we need to read the data from file so we will use FileInput Stream
    // file input stream reader to read the data from file 
    try{
        FileInputStream fis = new FileInputStream(file);
       byte[] data = new byte[fis.available()];
        fis.read(data);
       int i =0;
        for(byte b: data){
            System.out.println(b);
            data[i]=(byte)(b^key);
            i++;
        }
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(data);
        fos.close();
        fis.close();
        JOptionPane.showMessageDialog(null, "Done");
        

    } catch(Exception e){
        e.printStackTrace();
    }

    }
    public static void main(String[] args){
        System.out.println("this is testing");
        JFrame f = new JFrame();
        f.setTitle("Image operation");
        f.setSize(400,400);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //creating button
        Font font = new Font("Roboto",Font.BOLD,25);
        JButton button = new JButton();
        button.setText("open Image");
        button.setFont(font);
       // Note- On button click we need to add Listener 
       // basically on button click that is know as addActionListener
       // basically we need to pass an object Listener  Object and Object Listener is an interface.
       // we can't create an object of interface so we can create an object of the  child class
       // and we need to create a child class
       
      
        //creating text field 
        JTextField textField  = new JTextField(10);
        textField.setFont(font);
        button.addActionListener(e->{ // that is known as lambda function we get a lambda function by replacing an annonymous function
            System.out.println("button click");
            String text = textField.getText();
            int temp = Integer.parseInt(text);
            operate(temp);
           });
        f.setLayout(new FlowLayout());

        
        f.add(button);
        f.add(textField);
        f.setVisible(true);
    }
}