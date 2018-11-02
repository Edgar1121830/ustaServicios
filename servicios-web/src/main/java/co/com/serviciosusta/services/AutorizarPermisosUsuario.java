package co.com.serviciosusta.services;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import co.com.servicios.dto.CursosPermisosDTO;
import co.com.servicios.dto.CursosVerDTO;
import co.com.serviciosejb.managedbean.ServiciosService;

@WebService
@Stateless
public class AutorizarPermisosUsuario {
	
	@EJB
	ServiciosService service;
	
	/**
	 * en este metodo cosultamos la inscripcion de usuario ingresando en documento que se obtiene del servicio de autenticar,
	 * y retorna la inscripcion para consultar los cursos que esta activo
	 * @param idUsuario: String
	 * @return verDTOS
	 */
	@WebMethod(operationName="autorizarPermisosUsuario")
	public List<CursosPermisosDTO> autorizarPermisosUsuario(@WebParam(name="idUsuario") String idUsuario){
		List<CursosPermisosDTO> verDTOs = new ArrayList<CursosPermisosDTO>();
		try {
			if(idUsuario!=null && !idUsuario.equals("")) {
				verDTOs = service.listarCursosUsuario(Integer.valueOf(idUsuario));
			}
		}catch (Exception e) {
			Logger.getLogger("Error al consultar la inscripcion");
		}
		return verDTOs;
	}
	
	/**
	 * Se obtienen los cursos (niveles) al cual el usuario esta inscrito y activo, se obtiene el dato por el 
	 * metodo de autorizarPermisoUsuario
	 * @param idCurso: String
	 * @return verDTOS
	 */
	@WebMethod(operationName="cargarCursosUsuario")
	public List<CursosVerDTO> cargarCursosUsuario(@WebParam(name="idCurso") String idCurso){
		List<CursosVerDTO> verDTOs = new ArrayList<CursosVerDTO>();
		try {
			if(idCurso!=null && !idCurso.equals("")) {
				verDTOs = service.cargarCursosUsuario(idCurso);
			}
		}catch (Exception e) {
			Logger.getLogger("Error al cargar el curso");
		}
		return verDTOs;
	}

}

