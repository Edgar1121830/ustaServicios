package co.com.serviciosejb.managedbean;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import co.com.servicios.dto.CursosPermisosDTO;
import co.com.servicios.dto.CursosVerDTO;
import co.com.servicios.dto.UsuariosDTO;
import co.com.serviciosejb.fachada.ServiciosFachada;

/* fachada entre la presentacion y la logica del negocio, En esta parte se crean todos los métodos que se necesitan para el intercambio de 
 * información de aplicación a base de datos y la base de datos a la aplicación*/
@Stateless
@LocalBean
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class ServiciosService {
	
	@EJB
	ServiciosFachada fachada;
	/**
	 * Este método sirve para autenticar el usuario que ingrese a la plataforma
	 * @param usuario: String 
	 * @param clave: String
	 * @return UsuarioDTO: restorna objetos de tipo person, Ingreso, Opcion, Rol, Personaopcion e Institucione
	 * @throws Exception
	 */
	public UsuariosDTO autenticar(String usuario, String clave) throws Exception{
		return fachada.autenticar(usuario, clave);
	}
	
	/**
	 * Este método sirve para listar los cursos que ofrece la plataforma al usuario que ingreso a esta.
	 * @param id: int
	 * @return CursosPermisosDTO: retornara una lista de inscripciones, instrucciones y habilidades;
	 * @throws Exception
	 */
	public List<CursosPermisosDTO>listarCursosUsuario(int id) throws Exception{
		return null;
	}
	
	/**
	 * Este método es el que mostrara los certificados que el usuario ha obtenido por cada curso terminado y aprobado
	 * @param clave: String
	 * @return boolean true si el certificado esta en estado 1: Disponible en la tabla inscripción, false 
	 * si el certificado esta en estado 2: No disponible en la tabla inscripción.
	 * @throws Exception
	 */
	public boolean obtenerCertificado(String clave) throws Exception{
		return fachada.obtenerCertificado(clave);
	}
	
	/**
	 * Este método le mostrara al usuario los avances de todos los cursos, subtemas y actividades que ha realizado.
	 * @param cursosDto: CursosVerDTO
	 * @throws Exception
	 */
	public void actualizarCurso(CursosVerDTO cursosDto) throws Exception{}
	
	/**
	 * Se obtienen los cursos (niveles) al cual el usuario esta inscrito y activo, se obtiene el dato por el 
	 * metodo de autorizarPermisoUsuario
	 * @param cursosDto: CursosVerDTO
	 * @throws Exception
	 */
	public List<CursosVerDTO> cargarCursosUsuario(String idCurso) throws Exception{
		List<CursosVerDTO> cursosVerDTOs = null; 
		return cursosVerDTOs;
	}

}

