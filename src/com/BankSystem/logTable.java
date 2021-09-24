package com.BankSystem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

public class logTable
{

    public logTable(User user)
    {
        LogsDao logsdao = new LogsDaoImpl();
        ResultSet rs = logsdao.getLog(user);

        JTable table = new JTable(buildTableModel(rs));
        UIManager.put("OptionPane.minimumSize",new Dimension(1000,600));
        JOptionPane.showMessageDialog(null, new JScrollPane(table), "Transaction History", JOptionPane.PLAIN_MESSAGE);

    }


    public DefaultTableModel buildTableModel(ResultSet rs)
    {
        try
        {
            Vector<String> columnNames = new Vector<String>();

            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            for (int column = 1; column <= columnCount; column++)
            {
                columnNames.add(metaData.getColumnName(column));
            }

            Vector<Vector<Object>> data = new Vector<Vector<Object>>();
            while (rs.next())
            {
                Vector<Object> vector = new Vector<Object>();
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++)
                {
                    vector.add(rs.getObject(columnIndex));
                }
                data.add(vector);
            }
            return new DefaultTableModel(data, columnNames);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
