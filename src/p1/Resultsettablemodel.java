package p1;



/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PULAK
 */
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
public class Resultsettablemodel extends AbstractTableModel 
{
    private Connection connection;
    private Statement statement;
    private ResultSet resultset;
    private ResultSetMetaData metadata;
    private int numberofrows;
    private boolean connectiontodatabase=false;
    
    public Resultsettablemodel(String driver,String url,String username,String password,String query)
     throws SQLException ,ClassNotFoundException  
    {
    Class.forName(driver);
    connection=DriverManager.getConnection(url,username,password);
    statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
    connectiontodatabase=true;
    setQuery(query);
    }
    
 
  public Class getColumnClass(int column) throws IllegalStateException
  {
      if(!connectiontodatabase)
      { throw new IllegalStateException("Not connected to database");
      }
      
      try
      {
      String className =metadata.getColumnClassName(column+1);
     return Class.forName(className);
      }
      catch(Exception exception)
      {  exception.printStackTrace(); 
      }
      return Object.class;
  }
  
public int getColumnCount() throws IllegalStateException
{

if(!connectiontodatabase)
      { throw new IllegalStateException("Not connected to database");
      }

try
{return metadata.getColumnCount();
}
catch(SQLException sqlexception)
{ sqlexception.printStackTrace();
} 
return 0;
}

public String getColumnName(int column) throws IllegalStateException
{
  
if(!connectiontodatabase)
      { throw new IllegalStateException("Not connected to database");
      }
try
{
return metadata.getColumnName(column+1);
}
catch(SQLException sqlexception)
{ sqlexception.printStackTrace();
} 
return "";
}
 public int getRowCount() throws IllegalStateException
 {
 if(!connectiontodatabase)
      { throw new IllegalStateException("Not connected to database");
      }
 return numberofrows;
 }
 public Object getValueAt(int row,int column) throws IllegalStateException
 {
 if(!connectiontodatabase)
      { throw new IllegalStateException("Not connected to database");
      }
 try
 {
 resultset.absolute(row+1);
 return resultset.getObject(column+1);
 
 }
catch(SQLException sqlexception)
{ sqlexception.printStackTrace();
} 
 return "";
  
 }  
  
 public  void setQuery(String query) throws SQLException, IllegalStateException
 {
 if(!connectiontodatabase )
      {      
                throw new IllegalStateException("Not connected to database");
      
      }
 resultset=statement.executeQuery(query);
 metadata=resultset.getMetaData();
 resultset.last();
 numberofrows=resultset.getRow();
 fireTableStructureChanged();
 }
  
 public void disconnectFromDatabase()
 {
 if(connectiontodatabase)
 {
 try
 {
 resultset.close();
 statement.close();
 connection.close();
 
 }
 catch(SQLException sqlexception)
{ sqlexception.printStackTrace();
} 
 connectiontodatabase=false;
 }
 }

    private Exception IllegalStateException(String string) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
  
  
  
}
