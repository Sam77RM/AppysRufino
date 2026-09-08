/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;

import Conectividad.Conexion;
import Interfaces.Cable_Interface;
import Modelo.Cable;
import Modelo.Cargos;
import Modelo.Permisos;
import Modelo.Preguntas;
import Modelo.Usuarios;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CablesDAO implements Cable_Interface {

    PreparedStatement ps;
    Conexion conec = new Conexion();
    Connection mycon;
    ResultSet rs;
    Cable miCable;

    @Override
    public boolean insertar(Cable p) {
        try {
            mycon = conec.getConexion();

            String sql = "INSERT INTO Cable (codigo, tipo, marca_auto, modelo_auto, anio_auto, cantidad, marcaC, precioUnt, precioCosto)"
                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            mycon = conec.getConexion();
            ps.setString(1, p.getCodigo());
            ps.setString(2, p.getTipo());
            ps.setString(3, p.getMarca_auto());
            ps.setString(4, p.getModelo_auto());
            ps.setInt(5, p.getAnio_auto());
            ps.setInt(6, p.getCantidad());
            ps.setString(7, p.getMarcaC());
            ps.setDouble(8, p.getPrecioUnt());
            ps.setDouble(9, p.getPrecioCosto());

            ps.executeUpdate();
            System.out.println("Cable insertado exitosamente");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CablesDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al insertar cable");
            return false;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (mycon != null) {
                    mycon.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(CablesDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    @Override
    public boolean eliminar(String codigo) {
        try {
            mycon = conec.getConexion();
            String sql = "DELETE FROM Cable WHERE codigo = ?";
            ps = mycon.prepareStatement(sql);
            ps.setString(1, codigo);
            ps.executeUpdate();

            ps.close();
            mycon.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CablesDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (mycon != null) {
                    mycon.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(CablesDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    @Override
    public Cable listarUno(String codigo) {
        try {
            String sql = "select * from Cable where codigo=?";
            mycon = conec.getConexion();
            ps = mycon.prepareStatement(sql);
            ps.setString(1, codigo);
            rs = ps.executeQuery();
            while (rs.next()) {
                miCable = new Cable();
                miCable.setCodigo(rs.getString("codigo"));
                miCable.setTipo(rs.getString("tipo"));
                miCable.setMarca_auto(rs.getString("marca_auto"));
                miCable.setModelo_auto(rs.getString("modelo_auto"));
                miCable.setAnio_auto(rs.getInt("anio_auto"));
                miCable.setCantidad(rs.getInt("cantidad"));
                miCable.setMarcaC(rs.getString("marcaC"));
                miCable.setPrecioUnt(rs.getDouble("precioUnt"));
                miCable.setPrecioCosto(rs.getDouble("precioCosto"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(CablesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (mycon != null) {
                    mycon.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(CablesDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return miCable;
    }

    @Override
    public boolean actualizar(Cable p) {
        try {
            String sql = "UPDATE Cable SET tipo = ?, marca_auto = ?, modelo_auto = ?, anio_auto = ?, cantidad = ?, marcaC = ?, precioUnt = ? , precioCosto = ?"
                    + "WHERE codigo = ?";
            mycon = conec.getConexion();
            ps = mycon.prepareStatement(sql);
            ps.setString(1, p.getTipo());
            ps.setString(2, p.getMarca_auto());
            ps.setString(3, p.getModelo_auto());
            ps.setInt(4, p.getAnio_auto());
            ps.setInt(5, p.getCantidad());
            ps.setString(6, p.getMarcaC());
            ps.setDouble(7, p.getPrecioUnt());
            ps.setDouble(8, p.getPrecioCosto());
            ps.setString(9, p.getCodigo());

            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CablesDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (mycon != null) {
                    mycon.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(CablesDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public ArrayList<Cable> listarTodos() {
        ArrayList<Cable> lista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Cable";
            mycon = conec.getConexion();
            ps = mycon.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Cable miCable = new Cable();
                miCable.setCodigo(rs.getString("codigo"));
                miCable.setTipo(rs.getString("tipo"));
                miCable.setMarca_auto(rs.getString("marca_auto"));
                miCable.setModelo_auto(rs.getString("modelo_auto"));
                miCable.setAnio_auto(rs.getInt("anio_auto"));
                miCable.setCantidad(rs.getInt("cantidad"));
                miCable.setMarcaC(rs.getString("marcaC"));
                miCable.setPrecioUnt(rs.getDouble("precioUnt"));
                miCable.setPrecioCosto(rs.getDouble("precioCosto"));
                lista.add(miCable);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CablesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (mycon != null) {
                    mycon.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(CablesDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lista;

    }

}
