package metodos;

import alumno.Alumno;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Metodos
{
    Vector vPrincipal = new Vector();
    
    //PROCEDIMIENTO PARA GUARDAR DATOS EN 1 VECTOR
    public void guardar(Alumno unAlumno)
    {
        vPrincipal.addElement(unAlumno);
    }
    
    //PROCEDIMIENTO PARA GUARDAR EN UN ARCHIVO TXT
    public void guardarArchivo(Alumno alumno)
    {
        try
        {
            FileWriter fw = new FileWriter("Alumnos.txt",true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.print(alumno.getCodigo());
            pw.print("|"+alumno.getNombre());
            pw.println("|"+alumno.getEdad());
            pw.close();
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    //FUNCION PARA MOSTRAR LOS DATOS EN UNA JTABLE
    
    public DefaultTableModel listaAlumnos()
    {
        Vector cabeceras = new Vector();
        cabeceras.addElement("Codigo");
        cabeceras.addElement("Nombre");
        cabeceras.addElement("Edad");
        //CREAMOS UN VECTOR QUE CONTENGA CODIGO, NOMBRE, EDAD
        //CREAMOS UN MODELO DE TABLA PARA AGREGAR EL VECTOR, EN LA UBCACION 0
        DefaultTableModel mdlTable = new DefaultTableModel(cabeceras,0);
        
        try
        {
            FileReader fr = new FileReader("Alumnos.txt");
            BufferedReader br = new BufferedReader(fr);
            String d;
            while((d=br.readLine())!=null)
            {
                StringTokenizer dato = new StringTokenizer(d,"|");
                Vector x = new Vector();
                while(dato.hasMoreTokens())
                {
                    x.addElement(dato.nextToken());
                }
                mdlTable.addRow(x);
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        return mdlTable;
    }
    
    //PROCEDIMIENTO PARA POBLAR O LLENAR UN JCOMBOBOX CON LAS EDADES
    public void cboEdad(JComboBox edades)
    {
        edades.removeAllItems();
        for(int x = 10; x<60;x++)
        {
            edades.addItem(x);
        }
    }
}
