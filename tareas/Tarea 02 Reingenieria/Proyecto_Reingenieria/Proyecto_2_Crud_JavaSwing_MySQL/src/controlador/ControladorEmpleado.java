package controlador;

import vista.*;
import dao.*;
import modelo.*;
import javax.swing.table.DefaultTableModel;

public class ControladorEmpleado {

    private EmpleadoForm vista;
    private EmpleadoDAO dao;

    public ControladorEmpleado(EmpleadoForm vista) {
        this.vista = vista;
        this.dao = new EmpleadoDAO();

        vista.btnGuardar.addActionListener(e -> guardar());
        vista.btnEliminar.addActionListener(e -> eliminar());

        cargarTabla();
    }

    private void guardar() {
        Empleado emp = new Empleado();
        emp.setNombre(vista.txtNombre.getText());
        emp.setGenero(vista.rbM.isSelected() ? "M" : "F");
        emp.setCargo(vista.cbCargo.getSelectedItem().toString());
        dao.insertar(emp);
        cargarTabla();
    }

    private void eliminar() {
        int fila = vista.tabla.getSelectedRow();
        if (fila >= 0) {
            int id = Integer.parseInt(vista.tabla.getValueAt(fila, 0).toString());
            dao.eliminar(id);
            cargarTabla();
        }
    }

    private void cargarTabla() {
        DefaultTableModel m = (DefaultTableModel) vista.tabla.getModel();
        m.setRowCount(0);
        for (Empleado e : dao.listar()) {
            m.addRow(new Object[]{
                    e.getId(),
                    e.getNombre(),
                    e.getGenero(),
                    e.getCargo()
            });
        }
    }
}