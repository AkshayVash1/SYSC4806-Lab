/**
package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JPATest {

    @Test
    public void performJPABuddyInfo() {

        // Creating objects representing some products
        BuddyInfo buddy1 = new BuddyInfo();
        buddy1.setId(1);
        buddy1.setName("Tennis racket");

        BuddyInfo buddy2 = new BuddyInfo();
        buddy2.setId(2);
        buddy2.setName("Sam");

        AddressBook addressBook = new AddressBook();

        // Connecting to the database through EntityManagerFactory
        // connection details loaded from persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");

        EntityManager em = emf.createEntityManager();

        // Creating a new transaction
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        // Persisting the product entity objects
        em.persist(buddy1);
        em.persist(buddy2);

        addressBook.addBuddy(buddy1);
        addressBook.addBuddy(buddy2);

        em.persist(addressBook);

        tx.commit();

        // Querying the contents of the database using JPQL query
        Query q = em.createQuery("SELECT b FROM BuddyInfo b");

        @SuppressWarnings("unchecked")
        List<BuddyInfo> buddyInfoResults = q.getResultList();

        System.out.println("List of BuddyInfos\n----------------");

        for (BuddyInfo b : buddyInfoResults) {

            System.out.println(b.getName() + " (id=" + b.getId() + ")");

        }

        // Querying the contents of the database using JPQL query
        Query q1 = em.createQuery("SELECT a FROM AddressBook a");

        @SuppressWarnings("unchecked")
        List<AddressBook> addressBookResults = q1.getResultList();

        System.out.println("\nList of AddressBooks\n----------------");

        for (AddressBook a : addressBookResults) {

            System.out.println("(id=" + a.getId() + ")");
        }

        // Closing connection
        em.close();

        emf.close();
    }
}
 **/
