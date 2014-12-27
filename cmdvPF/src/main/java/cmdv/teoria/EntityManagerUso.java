package cmdv.teoria;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import cmdv.domain.User;

public class EntityManagerUso {

	Object articulo;
	Object proveedor;
	Object cliente;
	Object Proveedor;
	
	/**************************
	 * 		USO GENERAL
	 **************************/
	
	private void usoGeneral(){
		// Paso 1: Creo un Entity Manager Factory utilizando  la clase
		//      Persistence y la unidad de persistencia
		EntityManagerFactory factory = 
		     Persistence.createEntityManagerFactory("UnidadPersistencia");
		
		//Paso 2: Con el factory puedo crear un Entity Manager
		EntityManager em = factory.createEntityManager();
		
		//Paso 3: Iniciar la transacción através del entity manager
		em.getTransaction().begin();
		
		//Paso 4: Ejecutar las operaciones de actualización de base de datos
		em.persist(articulo); // Registra INSERT
		em.merge(proveedor);  // Actualiza UPDATE
		em.detach(cliente);   // Elimina DELETE
		em.remove(cliente);	  // Elimina DELETE
		
		//Paso 5: Es necesario utilzar el commit() para ejectuar la transacción
		em.getTransaction().commit();
		
		//Paso 6: Es necesario cerrar el entity manager
		em.close();
	}
	
	private void escritura(){
		// Paso 1: Creo un Entity Manager Factory utilizando  la clase
		//      Persistence y la unidad de persistencia
		EntityManagerFactory factory = 
		     Persistence.createEntityManagerFactory("UnidadPersistencia");
		
		//Paso 2: Con el factory puedo crear un Entity Manager
		EntityManager em = factory.createEntityManager();
		
		//Paso O1: Es para moniterear errores
		try {
		     // Paso 3: Iniciar la transacción através del entity manager
		     em.getTransaction().begin();
		
		     // Paso 4: Ejecutar las operaciones de actualización de base de datos
		     em.persist(articulo); // Registra INSERT
		     em.merge(proveedor);  // Actualiza UPDATE
		     em.detach(cliente);   // Elimina DELETE
		
		     // Paso 5: Es necesario utilzar el commit() para ejectuar la transacción
		     em.getTransaction().commit();
		     // Cierre Bloque de monitoreo
		} catch (Exception e) {
		     // Paso O2: Se cancela la transacción
		     em.getTransaction().rollback();
		} finally {
		     // Paso 6: Es necesario cerrar el entity manager
		     em.close();
		}
	}
	
	private void lectura(){
		EntityManagerFactory factory = 
			     Persistence.createEntityManagerFactory("UnidadPersistencia");
			
			//Paso 2: Con el factory puedo crear un Entity Manager
			EntityManager em = factory.createEntityManager();
		//Leer los datos de manera inmediata
		Object pelicula = em.find(Object.class, 5l);
		
		//Leer los datos de manera demorada (la primera vez que se accede a ellos)
		pelicula = em.getReference(Object.class, 5l);
		
		//Paso O1: Es para moniterear errores
		try {
		
		     // Paso 3: Ejecutar las operaciones de consulta de base de datos
		     // Paso 3.1: Se inicializa la consulta con un objeto Query
		     //           La consulta de EJB-QL: SELECT p FROM Proveedor p
		     //           Se traduce en:  SELECT * FROM Proveedor
		     Query consulta = em.createQuery("SELECT p FROM Proveedor p");
		     // Paso 3.2: Se obtiene el resultado de la consulta y se registra en una
		     //           lista.
		     List<Object> proveedores = consulta.getResultList();
		
		     // Cierre Bloque de monitoreo
		} finally {
		     // Paso 6: Es necesario cerrar el entity manager
		     em.close();
		}
	}
	
	private void teoria(){
		/*
		 * 	Persistence: La clase javax.persistence.Persistence contiene métodos estáticos de ayuda para obtener una instancia de EntityManagerFactory de una forma independiente al vendedor de la implementación de JPA.
    		EntityManagerFactory: La clase javax.persistence.EntityManagerFactory nos ayuda a crear objetos de EntityManager utilizando el patrón de diseño del Factory (fábrica).
    		EntityManager: La clase javax.persistence.EntityManager es la interfaz principal de JPA utilizada para la persistencia de las aplicaciones. Cada EntityManager puede realizar operaciones CRUD (Create, Read, Update, Delete) sobre un conjunto de objetos persistentes.
    		Entity: La clase javax.persistence.Entity es una anotación Java que se coloca a nivel de clases Java serializables y que cada objeto de una de estas clases anotadas representa un registro de una base de datos.
    		EntityTransaction: Cada instancia de EntityManager tiene una relación de uno a uno con una instancia de javax.persistence.EntityTransaction, permite operaciones sobre datos persistentes de manera que agrupados formen una unidad de trabajo transaccional, en el que todo el grupo sincroniza su estado de persistencia en la base de datos o todos fallan en el intento, en caso de fallo, la base de datos quedará con su estado original. Maneja el concepto de todos o ninguno para mantener la integridad de los datos.
    		Query: La interface javax.persistence.Query está implementada por cada vendedor de JPA para encontrar objetos persistentes manejando cierto criterio de búsqueda. JPA estandariza el soporte para consultas utilizando Java Persistence Query Language (JPQL) y Structured Query Language (SQL). Podemos obtener una instancia de Query desde una instancia de un EntityManager.
		 */
		EntityManagerFactory factory = 
			     Persistence.createEntityManagerFactory("UnidadPersistencia");
			
		EntityManager em = factory.createEntityManager();
			
		final CriteriaBuilder cb = em.getCriteriaBuilder();
		final CriteriaQuery<User> q = cb.createQuery(User.class);
		final Root<User> users = q.from(User.class);
		final Predicate condition = cb.equal(users.get("privilegeLevel"),5);
		q.select(users).where(condition).orderBy(cb.asc(users.get("userId")));
		
	}
	
}
