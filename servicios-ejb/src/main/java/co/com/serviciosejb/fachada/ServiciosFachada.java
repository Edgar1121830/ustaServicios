package co.com.serviciosejb.fachada;

import java.util.List;

import javax.ejb.Remote;

import co.com.servicios.dto.CursosPermisosDTO;
import co.com.servicios.dto.CursosVerDTO;
import co.com.servicios.dto.UsuariosDTO;

/* Es la capa intermedia de donde heredan los metodos hacia la clase logica, se definen todos los metodos que se van a utiliizar.
 El EJB de fachada es el que proporciona todos los métodos de establecimiento de datos para los objetos de valor y datos. */

@Remote
public interface ServiciosFachada {
	/**
	 * Este método sirve para autenticar el usuario que ingrese a la plataforma
	 * @param usuario: String 
	 * @param clave: String
	 * @return UsuarioDTO: retorna objetos de tipo person, Ingreso, Opcion, Rol, Personaopcion e Institucione
	 * @throws Exception
	 */
	public UsuariosDTO autenticar(String usuario, String clave) throws Exception;
	
	/**
	 * Este método sirve para listar los cursos que ofrece la plataforma al usuario que ingreso a esta.
	 * @param id: int
	 * @return CursosPermisosDTO: retornara una lista de inscripciones, instrucciones y habilidades;
	 * @throws Exception
	 */
	public List<CursosPermisosDTO>listarCursosUsuario(int id) throws Exception;
	
	/**
	 * Este método es el que mostrara los certificados que el usuario ha obtenido por cada curso terminado y aprobado
	 * @param clave: String
	 * @return boolean true si el certificado esta en estado 1: Disponible en la tabla inscripción, false 
	 * si el certificado esta en estado 2: No disponible en la tabla inscripción.
	 * @throws Exception
	 */
	public boolean obtenerCertificado(String clave) throws Exception;
	
	/**
	 * Este método le mostrara al usuario los avances de todos los cursos, subtemas y actividades que ha realizado.
	 * @param cursosDto: CursosVerDTO
	 * @throws Exception
	 */
	public void actualizarCurso(CursosVerDTO cursosDto) throws Exception;
	
	/**
	 * Se obtienen los cursos (niveles) al cual el usuario esta inscrito y activo, se obtiene el dato por el 
	 * metodo de autorizarPermisoUsuario
	 * @param cursosDto: CursosVerDTO
	 * @throws Exception
	 */
	public List<CursosVerDTO> cargarCursosUsuario(String idCurso) throws Exception;
}

