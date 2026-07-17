package fr.diginamic;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnexionJpa {
    public static void main(String[] args) {

        EntityManagerFactory
                entityManagerFactory = Persistence.createEntityManagerFactory("demo-jpa");
        EntityManager
                em = entityManagerFactory.createEntityManager();

    }
}
