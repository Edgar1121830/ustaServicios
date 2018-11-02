package co.com.serviciosejb.bean;




import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.com.servicios.dto.CursosPermisosDTO;
import co.com.servicios.dto.CursosVerDTO;
import co.com.servicios.dto.UsuariosDTO;
import co.com.servicios.modelo.Persona;
import co.com.serviciosejb.fachada.ServiciosFachada;

/*
  El bean de sesión se usa como una fachada para encapsular la complejidad de las interacciones entre los objetos de negocio.
*/
@Stateless
@LocalBean
public class ServiciosBean implements ServiciosFachada{

	@PersistenceContext(unitName="superint-dbsuper-jpa")
    private EntityManager em;

	/*
	 * (non-Javadoc)
	 * @see co.com.serviciosejb.fachada.ServiciosFachada#autenticar(java.lang.String, java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public UsuariosDTO autenticar(String usuario, String clave) throws Exception {
		UsuariosDTO usuarioDto = new UsuariosDTO();
		List<Object> ob = new ArrayList<Object>();
		
		Query query = em.createNamedQuery(Persona.CONSULTAR_USUARIO);
		
		query.setParameter("usuario", usuario);
		query.setParameter("clave",clave);
		try {
			ob = query.getResultList();
			if(ob.size()>0) {
				for(Object o: ob) {
					usuarioDto = new UsuariosDTO();
					Persona persona = new Persona();
					persona = (Persona) o;
					usuarioDto.setPersona(persona);
				}
					
			}
		} catch (NoResultException e) {
			e.printStackTrace();
			usuarioDto = null;
		}
		
		
		return usuarioDto;
	}

	/*
	 * (non-Javadoc)
	 * @see co.com.serviciosejb.fachada.ServiciosFachada#listarCursosUsuario(int)
	 */
	@Override
	public List<CursosPermisosDTO> listarCursosUsuario(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see co.com.serviciosejb.fachada.ServiciosFachada#obtenerCertificado(java.lang.String)
	 */
	@Override
	public boolean obtenerCertificado(String clave) throws Exception {
		// TODO Auto-generated method stub
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see co.com.serviciosejb.fachada.ServiciosFachada#actualizarCurso(co.com.servicios.dto.CursosVerDTO)
	 */
	@Override
	public void actualizarCurso(CursosVerDTO cursosDto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	/*
	 * (non-Javadoc)
	 * @see co.com.serviciosejb.fachada.ServiciosFachada#cargarCursosUsuario(java.lang.String)
	 */
	@Override
	public List<CursosVerDTO> cargarCursosUsuario(String idCurso) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
}

