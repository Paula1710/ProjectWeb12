/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.config;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;

/**
 * Clase ControlLog
 * 
 * @author Grupo12
 */
public class ControlLog {
    
    private static Logger LOG;
    
    /**
     * Genera un archivo Log
     * 
     * @param name Nombre de la clase dónde se generan los logs
     * @return Retorna el archivo actualizado
     */
    public static Logger getLogger(Class name) {
        try {
            LOG = Logger.getLogger(name);
            String logfile = "filelog.";
            Date fecha = new Date();
            
            SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
            String fechaAc = formato.format(fecha);
            PatternLayout defaultLayout = new PatternLayout("%d{dd-MM-yyyy HH:mm:ss} %-5p %c{1}:%L: %m%n");
            
            RollingFileAppender rollingFileAppender = new RollingFileAppender();
            rollingFileAppender.setFile(logfile + fechaAc + ".log", true, false, 0);
            rollingFileAppender.setMaxFileSize("10MB");
            rollingFileAppender.setMaxBackupIndex(5);
            rollingFileAppender.setLayout(defaultLayout);
            
            LOG.removeAllAppenders();
            LOG.addAppender(rollingFileAppender);
            LOG.setAdditivity(true);

        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(ControlLog.class.getName()).log(Level.SEVERE, null, ex);
        }
        return LOG;
    }
    
    
}
