package organizer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.ScrollPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TableFromDatabase extends JFrame
{
    public TableFromDatabase(JScrollPane s)
    {
        Vector<Object> columnNames = new Vector<Object>();
        Vector<Object> data = new Vector<Object>();
        ResultSet rs2_p;
        ResultSetMetaData rs2_m;
        try
        {

        String host = "jdbc:derby://localhost:1527/organizer";
        String uzytkownik = "org";
        String haslo = "org";
        Connection con = DriverManager.getConnection(host, uzytkownik, haslo);
         
        Statement stmt_p = con.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );
        String sql = "select p.NAZWA, p.SALA, p.DZIEŃ, g.GODZINA_OD, g.GODZINA_DO, t.NAZWA from PRZEDMIOTY p\n" +
        "JOIN GODZINY g USING(ID_GODZINY) \n" +
        "JOIN TYPY_ZAJEC t USING (ID_TYPU)\n" +
        "ORDER BY p.DZIEŃ asc";
        
        rs2_p = stmt_p.executeQuery(sql);
        rs2_m = rs2_p.getMetaData();
            int columns = rs2_m.getColumnCount();

            //  Get column names

            for (int i = 1; i <= columns; i++)
            {
                columnNames.addElement( rs2_m.getColumnName(i) );
            }

            //  Get row data

            while (rs2_p.next())
            {
                Vector<Object> row = new Vector<Object>(columns);

                for (int i = 1; i <= columns; i++)
                {
                    row.addElement( rs2_p.getObject(i) );
                }

                data.addElement( row );
            }

            rs2_p.close();
            stmt_p.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println( e );
        }

        //  Create table with database data

        DefaultTableModel model = new DefaultTableModel(data, columnNames)
        {
        	@Override
            public Class getColumnClass(int column)
            {
                for (int row = 0; row < getRowCount(); row++)
                {
                    Object o = getValueAt(row, column);

                    if (o != null)
                    {
                        return o.getClass();
                    }
                }

                return Object.class;
            }
        };
        
        JTable table = new JTable( model );
        
        try
        {
        for (int row = 0; row < table.getRowCount(); row++)
        {
            int rowHeight = table.getRowHeight();

            for (int column = 0; column < table.getColumnCount(); column++)
            {
                Component comp = table.prepareRenderer(table.getCellRenderer(row, column), row, column);
                rowHeight = 55;
            }

            table.setRowHeight(row, rowHeight);
            
        }
        
        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(true);
        table.setGridColor(Color.orange);
        table.setBackground(new java.awt.Color(255, 255, 204));
        s.setViewportView(table);

        
    }
    catch(ClassCastException e) {}
        
    }
    
    public TableFromDatabase(JScrollPane s, String st)
    {
        Vector<Object> columnNames = new Vector<Object>();
        Vector<Object> data = new Vector<Object>();
        ResultSet rs2_p;
        ResultSetMetaData rs2_m;
        try
        {

        String host = "jdbc:derby://localhost:1527/organizer";
        String uzytkownik = "org";
        String haslo = "org";
        Connection con = DriverManager.getConnection(host, uzytkownik, haslo);
         
        Statement stmt_p = con.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );
        String sql = st;
        
        rs2_p = stmt_p.executeQuery(sql);
        rs2_m = rs2_p.getMetaData();
            int columns = rs2_m.getColumnCount();

            //  Get column names

            for (int i = 1; i <= columns; i++)
            {
                columnNames.addElement( rs2_m.getColumnName(i) );
            }

            //  Get row data

            while (rs2_p.next())
            {
                Vector<Object> row = new Vector<Object>(columns);

                for (int i = 1; i <= columns; i++)
                {
                    row.addElement( rs2_p.getObject(i) );
                }

                data.addElement( row );
            }

            rs2_p.close();
            stmt_p.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println( e );
        }

        //  Create table with database data

        DefaultTableModel model = new DefaultTableModel(data, columnNames)
        {
        	@Override
            public Class getColumnClass(int column)
            {
                for (int row = 0; row < getRowCount(); row++)
                {
                    Object o = getValueAt(row, column);

                    if (o != null)
                    {
                        return o.getClass();
                    }
                }

                return Object.class;
            }
        };
        
        JTable table = new JTable( model );
        
        try
        {
        for (int row = 0; row < table.getRowCount(); row++)
        {
            int rowHeight = table.getRowHeight();

            for (int column = 0; column < table.getColumnCount(); column++)
            {
                Component comp = table.prepareRenderer(table.getCellRenderer(row, column), row, column);
                rowHeight = 55;
            }

            table.setRowHeight(row, rowHeight);
            
        }
        
        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(true);
        table.setGridColor(Color.orange);
        table.setBackground(new java.awt.Color(255, 255, 204));
        s.setViewportView(table);

        
    }
    catch(ClassCastException e) {}
        
    }
    
    public TableFromDatabase(JInternalFrame s, String st)
    {
        Vector<Object> columnNames = new Vector<Object>();
        Vector<Object> data = new Vector<Object>();
        ResultSet rs2_p;
        ResultSetMetaData rs2_m;
        try
        {

        String host = "jdbc:derby://localhost:1527/organizer";
        String uzytkownik = "org";
        String haslo = "org";
        Connection con = DriverManager.getConnection(host, uzytkownik, haslo);
         
        Statement stmt_p = con.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );
        String sql = st;
        
        rs2_p = stmt_p.executeQuery(sql);
        rs2_m = rs2_p.getMetaData();
            int columns = rs2_m.getColumnCount();

            //  Get column names

            for (int i = 1; i <= columns; i++)
            {
                columnNames.addElement( rs2_m.getColumnName(i) );
            }

            //  Get row data

            while (rs2_p.next())
            {
                Vector<Object> row = new Vector<Object>(columns);

                for (int i = 1; i <= columns; i++)
                {
                    row.addElement( rs2_p.getObject(i) );
                }

                data.addElement( row );
            }

            rs2_p.close();
            stmt_p.close();
            con.close();
        }
        catch(Exception e)
        {
            System.out.println( e );
        }

        //  Create table with database data

        DefaultTableModel model = new DefaultTableModel(data, columnNames)
        {
        	@Override
            public Class getColumnClass(int column)
            {
                for (int row = 0; row < getRowCount(); row++)
                {
                    Object o = getValueAt(row, column);

                    if (o != null)
                    {
                        return o.getClass();
                    }
                }

                return Object.class;
            }
        };
        
        JTable table = new JTable( model );
        
        try
        {
        for (int row = 0; row < table.getRowCount(); row++)
        {
            int rowHeight = table.getRowHeight();

            for (int column = 0; column < table.getColumnCount(); column++)
            {
                Component comp = table.prepareRenderer(table.getCellRenderer(row, column), row, column);
                rowHeight = 55;
            }

            table.setRowHeight(row, rowHeight);
            
        }
        
        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(true);
        table.setGridColor(Color.orange);
        table.setBackground(new java.awt.Color(255, 255, 204));
        
        JScrollPane scrollPane = new JScrollPane( table );
        getContentPane().add( scrollPane );

        JPanel buttonPanel = new JPanel();
        getContentPane().add( buttonPanel, BorderLayout.SOUTH );

        
    }
    catch(ClassCastException e) {}
        
    }
    
    public TableFromDatabase(JScrollPane s, int n)
    {
        Vector<Object> columnNames = new Vector<Object>();
        Vector<Object> data = new Vector<Object>();
        Vector<String> dni = new Vector <String>();
        dni.addElement("Poniedziałek");
        dni.addElement("Wtorek");
        dni.addElement("Środa");
        dni.addElement("Czwartek");
        dni.addElement("Piątek");

        try
        {

        String host = "jdbc:derby://localhost:1527/organizer";
        String uzytkownik = "org";
        String haslo = "org";
        Connection con = DriverManager.getConnection(host, uzytkownik, haslo);
         
        
        
        Statement stmt_p = con.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );
        String sql = 
        "select p.NAZWA as NAZWA , g.ID_GODZINY, t.NAZWA as Typ, n.IMIE, n.NAZWISKO, z.SALA, z.DZIEN\n" +
        "FROM ZAJĘCIA z JOIN PRZEDMIOTY p Using(ID_PRZEDMIOTU)\n" +
        "JOIN GODZINY g USING(ID_GODZINY)\n" +
        "JOIN TYPY_ZAJEC t USING(ID_TYPU)\n" +
        "JOIN NAUCZYCIELE n USING (ID_NAUCZYCIELA)\n" +
        "WHERE DZIEN = '" + dni.get(n) + "'";
        
        ResultSet rs2_p = stmt_p.executeQuery(sql);
        ResultSetMetaData rs2_m = rs2_p.getMetaData();
        
            int columns = rs2_m.getColumnCount();

            //  Get column names
            columnNames.addElement(dni.get(n));
            
            //for (int i = 1; i <= columns; i++)
            {
                //columnNames.addElement( rs2_m.getColumnName(i) );
            }

            //  Get row data

            while (rs2_p.next())
            {
                Vector<Object> row = new Vector<Object>(columns);

                //for (int i = 1; i <= columns; i++)
                {  
                    row.addElement(rs2_p.getObject(1));
                    
                }

                data.addElement( row );
            }

            rs2_p.close();
            stmt_p.close();
            con.close();

 }                
        catch(Exception e)
        {
            System.out.println( e );
        }
        
        

        //  Create table with database data    
        DefaultTableModel model = new DefaultTableModel(data, columnNames)
        {
        	@Override
            public Class getColumnClass(int column)
            {
                for (int row = 0; row < getRowCount(); row++)
                {
                    Object o = getValueAt(row, column);

                    if (o != null)
                    {
                        return o.getClass();
                    }
                }

                return Object.class;
            }
            
            
        };
        
        
        
        JTable table = new JTable( model );
        
        try
        {
        for (int row = 0; row < table.getRowCount(); row++)
        {
            int rowHeight = table.getRowHeight();

            for (int column = 0; column < table.getColumnCount(); column++)
            {
                Component comp = table.prepareRenderer(table.getCellRenderer(row, column), row, column);
                rowHeight = 55;
            }

            table.setRowHeight(row, rowHeight);
            
        }
        
        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(true);
        table.setGridColor(Color.orange);
        table.setBackground(new java.awt.Color(255, 255, 204));
        s.setViewportView(table);
        

        
    }
    catch(ClassCastException e) {}
        
    }
    
}