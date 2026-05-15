package com.mediateca.db;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase helper para operaciones comunes de base de datos.
 * Centraliza la apertura y cierre de conexiones, prepared statements y resultsets.
 * 
 * @author Mediateca Don Bosco
 */
public class DBHelper {
    
    private static final Logger logger = Logger.getLogger(DBHelper.class.getName());
    

    public static void executeQuery(String sql, Object[] params, ResultSetCallback callback) {
        try (Connection conn = DatabaseConnection.getInstancia().getConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            setParameters(pstmt, params);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                callback.process(rs);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error en executeQuery: " + sql, e);
        }
    }
    

    public static Object executeScalar(String sql, Object[] params, Object defaultValue) {
        try (Connection conn = DatabaseConnection.getInstancia().getConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            setParameters(pstmt, params);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getObject(1);
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error en executeScalar: " + sql, e);
        }
        return defaultValue;
    }
    

    public static int executeUpdate(String sql, Object[] params) {
        try (Connection conn = DatabaseConnection.getInstancia().getConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            setParameters(pstmt, params);
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error en executeUpdate: " + sql, e);
            return 0;
        }
    }
    

    public static int executeUpdateWithGeneratedKey(String sql, Object[] params) {
        try (Connection conn = DatabaseConnection.getInstancia().getConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            setParameters(pstmt, params);
            pstmt.executeUpdate();
            
            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error en executeUpdateWithGeneratedKey: " + sql, e);
        }
        return -1;
    }
    

    private static void setParameters(PreparedStatement pstmt, Object[] params) throws SQLException {
        if (params == null) return;
        
        for (int i = 0; i < params.length; i++) {
            pstmt.setObject(i + 1, params[i]);
        }
    }
    

    public static void close(ResultSet rs) {
        if (rs != null) {
            try { rs.close(); } catch (SQLException e) { logger.log(Level.WARNING, "Error closing ResultSet", e); }
        }
    }
    
 
    public static void close(Statement stmt) {
        if (stmt != null) {
            try { stmt.close(); } catch (SQLException e) { logger.log(Level.WARNING, "Error closing Statement", e); }
        }
    }
 
    public static void close(Connection conn) {
        if (conn != null) {
            try { conn.close(); } catch (SQLException e) { logger.log(Level.WARNING, "Error closing Connection", e); }
        }
    }

    @FunctionalInterface
    public interface ResultSetCallback {
        void process(ResultSet rs) throws SQLException;
    }
}