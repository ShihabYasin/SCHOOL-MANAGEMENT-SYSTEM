package p1;



/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author PULAK
 */ 
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.regex.PatternSyntaxException;
import javax.swing.*;
import javax.swing.table.TableRowSorter;
import javax.swing.table.TableModel;
 
public class TEACHER_PANEL_PERSONAL_INFORMATION_SHOWER extends JFrame
{
    static final String DATABASE_URL="jdbc:oracle:thin:@localhost:1521:XE";
    static final String USERNAME="shihab";
    static final String PASSWORD="123";
    static final String JDBC_DRIVER = "oracle.jdbc.OracleDriver"; 
    static final String  DEFAULT_QUERY="select NAME	,SALARY  FROM TEACHER where TEACHER_ID = -1 ";
 
    private Resultsettablemodel tablemodel;
   private JTextArea queryarea;
   
   public TEACHER_PANEL_PERSONAL_INFORMATION_SHOWER() throws ClassNotFoundException
           
   {
   
super("Displaying query result" );

try
{
tablemodel= new Resultsettablemodel (JDBC_DRIVER,DATABASE_URL,USERNAME,PASSWORD,DEFAULT_QUERY);
queryarea=new JTextArea(DEFAULT_QUERY,3,100);
queryarea.setWrapStyleWord(true);
queryarea.setLineWrap(true);

JScrollPane scrollpane=new JScrollPane(queryarea,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
JButton submitbutton=new JButton("Submit");
Box boxnorth =Box.createHorizontalBox();
boxnorth. add(scrollpane);
boxnorth. add(submitbutton);
JTable resulttable=new JTable(tablemodel);
JLabel filterlabel=new JLabel("Filter:");
final JTextField filtertext=new JTextField();
JButton filterbutton=new JButton("Filter");
Box boxsouth=Box.createHorizontalBox();
 boxsouth.add(filterlabel);
boxsouth.add(filtertext);
boxsouth.add(filterbutton);
add(boxnorth,BorderLayout.NORTH);
add(new JScrollPane(resulttable),BorderLayout.CENTER);
add(boxsouth,BorderLayout.SOUTH);

submitbutton.addActionListener(
        
        new ActionListener()
        {
                 
          public void actionPerformed(ActionEvent event)
          {
          
          try
          {
          
          tablemodel.setQuery(queryarea.getText());
          }
          catch(SQLException sqlException)
          {
          JOptionPane.showMessageDialog(null,sqlException.getMessage() ,"Database Error",JOptionPane.ERROR_MESSAGE);
          
          try
          {
           tablemodel.setQuery(DEFAULT_QUERY);
           queryarea.setText(DEFAULT_QUERY);
          
          }
          
          catch(SQLException sqlexception2)
          {
          
          JOptionPane.showMessageDialog(null,sqlexception2.getMessage() ,"Database Error",JOptionPane.ERROR_MESSAGE);
          tablemodel.disconnectFromDatabase();
          //System.exit(1);
          }
          
          }
          }     
          });

// event 2.......................
final TableRowSorter <TableModel> sorter =new  TableRowSorter<TableModel>(tablemodel); 
resulttable.setRowSorter(sorter);
setSize(500,250);
setVisible(true);

filterbutton.addActionListener(
        
        new ActionListener()
        {
        public void actionPerformed(ActionEvent e)
        {
        
        String text=filtertext.getText();
        
        if(text.length()==0)
        {
        sorter.setRowFilter(null);
        }
        else
        {
        try{    
         sorter.setRowFilter(RowFilter.regexFilter(text) );
        }
        catch(PatternSyntaxException pse )
        {
        JOptionPane.showMessageDialog(null,"Bad regex pattern","Bad regex pattern",JOptionPane.ERROR_MESSAGE);
        
        }
        
        }
        
        }
       
        }
      
        );
   
}

catch(SQLException e)
{
 JOptionPane.showMessageDialog(null, e.getMessage(),"DATABASE ERROR",JOptionPane.ERROR_MESSAGE);
tablemodel.disconnectFromDatabase();
//System.exit(1);
}

setDefaultCloseOperation(DISPOSE_ON_CLOSE);
addWindowListener(
        new WindowAdapter()
        {
        public void windowClosed(WindowEvent  event)
        {
        tablemodel.disconnectFromDatabase();
        //System.exit(0);
        
        }
        
        }  
         
        );   
 
   }
   
public static void main(String args[]) throws ClassNotFoundException
{
        new TEACHER_PANEL_PERSONAL_INFORMATION_SHOWER();
}


}
