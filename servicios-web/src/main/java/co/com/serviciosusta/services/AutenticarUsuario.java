package co.com.serviciosusta.services;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import co.com.servicios.dto.UsuariosDTO;
import co.com.serviciosejb.managedbean.ServiciosService;

@WebService
@Stateless
public class AutenticarUsuario implements Serializable{

	
	private static final long serialVersionUID = 1L;
	@EJB
	ServiciosService service;
	
	/**
	 * En este metodo se verifican las dos cadenas de texto ingresadas por le usuario para poder realizar la autenticacion 
	 * @param usuario: String
	 * @param contrasena: String
	 * @return usuariosDTO
	 */
	
	@WebMethod(operationName="autenticar")
	public UsuariosDTO autenticar(@WebParam(name="usuario") String usuario, @WebParam(name="contrasena") String contrasena){
		UsuariosDTO usuariosDTO = new UsuariosDTO();
		try {
			if (usuario!=null && !usuario.equals("")  && contrasena!=null && !contrasena.equals("")) {
				usuariosDTO = service.autenticar(usuario.trim(), contrasena.trim());
				if(usuariosDTO.getPersona().getDocumento()==null || usuariosDTO.getPersona().getDocumento().equals("")) {
					usuariosDTO.setMensaje("El Usuario no esta registrado");
				}
			}
		}catch (Exception e) {
			usuariosDTO.setMensaje("Error al consultar el usuario");
			Logger.getLogger("Error al consultar el usuario");
		}
		return usuariosDTO;
	}
	
}

