/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proven.webservices;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
 
/**
 * L'anotació @ApplicationPath determina la URL Base de tots els controladors.
 * En aquest cas v1 vol dir que per accedir a qualsevol controlador haurem de fer
 * les peticions HTTP a http://IP_Servidor/Nom_APP/v1/[controlador]
 * @author Author
 */
@ApplicationPath("actor-film-service")
public class ServiceConfiguration extends Application {
 
}