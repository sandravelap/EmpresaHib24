package repositories;

import dataBase.EmfSingleton;
import entities.EmpleadosEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import java.util.ArrayList;

public class EmpleadosRepository {
    EntityManagerFactory emf = EmfSingleton.getInstance().getEmf();
    public ArrayList<EmpleadosEntity> leerEmpleados(){
        ArrayList<EmpleadosEntity> listaEmpleados = new ArrayList<>();
        //aquí comienza nuestro contexto de persistencia asociado a nuestro em
        try(EntityManager em = emf.createEntityManager()){
            EmpleadosEntity emp = em.find(EmpleadosEntity.class, 7499);
            System.out.println(emp.getApellido());
        }catch (Exception e){
            System.out.println(e);
        }
        return listaEmpleados;
    }
    public void modificarSueldoEmpleado(float salario) throws Exception {
            EntityManager em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            EmpleadosEntity e = em.createQuery("from EmpleadosEntity where apellido like 'ARROYO'", EmpleadosEntity.class).getSingleResult();
            e.setSalario(salario);
            em.persist(e);
            tx.commit();
            em.close();
    }
}
