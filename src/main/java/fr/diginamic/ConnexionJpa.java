package fr.diginamic;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Set;

public class ConnexionJpa {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("compta");
        EntityManager em = entityManagerFactory.createEntityManager();
        Region r = em.find(Region.class, 1);

        System.out.println(r);

        Livre livre = em.find(Livre.class, 1);
        System.out.println(livre);

        TypedQuery<Livre> query = em.createQuery("SELECT l FROM Livre l", Livre.class);
        List<Livre> listeLivres = query.getResultList();

        for (Livre l : listeLivres) {
            System.out.println(l);
        }

        TypedQuery<Client> queryClient = em.createQuery("SELECT cli FROM Client cli WHERE cli.id=1", Client.class);
        List<Client> listeClients = queryClient.getResultList();
        if (!listeClients.isEmpty()) {
            Client client = listeClients.getFirst();
            System.out.println(client);

            List<Emprunt> listeEmprunts = client.getEmprunts();

            for (Emprunt emprunt : listeEmprunts) {
                System.out.println(emprunt);
            }
        }

        System.out.println("-----------------");

        Emprunt emprunts = em.find(Emprunt.class, 1);
        for (Livre l : emprunts.getLivres()) {
            System.out.println("les livres associés à l'emprunt d'ID 1 sont : " + l.getTitre() + ",de : " + l.getAuteur());
        }
        System.out.println("-----------------");

        TypedQuery<Client> queryClient2 = em.createQuery("SELECT cli FROM Client cli WHERE cli.id=1", Client.class);
        // slectionner ID client, prendre ID emprunt quand ID_client d'emprunt est = .
        List<Client> abonne = queryClient2.getResultList();
        for (Client c : abonne) {
            if (c != null) {
                List<Emprunt> empruntClient1 = c.getEmprunts();
                for (Emprunt e : empruntClient1) {
                    if (e != null) {
                        Set<Livre> livEmpruntesClient1 = e.getLivres();
                        for (Livre livresempruntes : livEmpruntesClient1) {
                            if (livresempruntes != null) {
                                System.out.println(livresempruntes);
                            }
                        }
                    }
                }
            }
        }
    }
}