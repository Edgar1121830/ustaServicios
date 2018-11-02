package co.com.serviciosusta.services;

import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import co.com.serviciosejb.managedbean.ServiciosService;

@WebService
@Stateless
public class ObtenerCertificado {
	
	@EJB
	ServiciosService service;
	
	/**
	En este metodo verifica la clave ingresada por el usuario para poder generar el certificado solicitado
	 * @param clave
	 * @return object
	 */
	@WebMethod(operationName="obtenerCertificado")
	public void obtenerCertificado(@WebParam(name="clave") String clave){
		try {
			if(clave!=null && !clave.equals("")) {
				service.obtenerCertificado(clave);
			}
		}catch (Exception e) {
			Logger.getLogger("Error al consultar el inscripcion");
		}
	}

}


