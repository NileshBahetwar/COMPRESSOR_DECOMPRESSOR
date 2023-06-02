/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import comp_decomp.compressor;
import comp_decomp.decompressor;
import java.awt.Color;
//import static java.awt.Color.RED;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

/**
 *
 * @author sai
 */
public class AppFrame extends JFrame implements ActionListener{
    JButton compressButton;
    JButton decompressButton;
    
    AppFrame(){
        setLayout(null);
        setSize(800,500);
        setTitle("COMPRESSOR_DECOMPRESSOR");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        compressButton=new JButton("Select file to compress");
        compressButton.setBounds(20,100,200,30);
        compressButton.addActionListener(this);
       
        
        decompressButton=new JButton("Select file to decompress");
        decompressButton.setBounds(250,100,200,30);
        decompressButton.addActionListener(this);
        
        this.add(compressButton);
        this.add(decompressButton);
        this.getContentPane().setBackground(Color.cyan);
        this.setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==compressButton){
            
            JFileChooser filechooser=new JFileChooser();
            int response=filechooser.showSaveDialog(null);
            
            if(response==JFileChooser.APPROVE_OPTION){
            File file=new File(filechooser.getSelectedFile().getAbsolutePath());
            System.out.print(file);
            
            try{
                compressor.method(file);
            }
            catch(Exception ee){
                JOptionPane.showMessageDialog(null,e.toString());
            }
           }  
          }
        
        if(e.getSource()==decompressButton){
           JFileChooser filechooser=new JFileChooser();
            int response=filechooser.showSaveDialog(null);
            
            if(response==JFileChooser.APPROVE_OPTION){
            File file=new File(filechooser.getSelectedFile().getAbsolutePath());
            System.out.print(file);
            
            try{
                decompressor.method(file);
            }
            catch(Exception ee){
                JOptionPane.showMessageDialog(null,ee.toString());
            }
           } 
        }
        
    }
}
