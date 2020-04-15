package br.edu.unisep.contacts.model.dao;

import br.edu.unisep.contacts.model.entity.Contact;
import br.edu.unisep.contacts.model.hibernate.HibernateSessionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContactDao {



    public void save(Contact contact ){
        var session = HibernateSessionFactory.getSession();
        var trans = session.beginTransaction();
        try {
            session.save(contact);
            trans.commit();

        } catch (Exception e){
            e.printStackTrace();
            trans.rollback();
        }
        session.close();
    }

    public List<Contact> findAll(){
        var session = HibernateSessionFactory.getSession();

        var query= session.createQuery("from Contact",Contact.class);
        var result=query.list();

        session.close();



        return result;


    }

    public void exclude(Contact contact){
        var session = HibernateSessionFactory.getSession();
        var trans = session.beginTransaction();
        try {

            session.delete(contact);
            trans.commit();

        }catch (Exception e){
            e.printStackTrace();
            trans.rollback();
        }
        session.close();

    }

   public Contact  findById(Integer id){
        var session = HibernateSessionFactory.getSession();

       var query = session.createQuery("from Contact where id = :CONTACT_ID" , Contact.class);

       query.setParameter("CONTACT_ID",id);

       var result=query.uniqueResult();

       session.close();



       return result;
   }

    public void update(Contact contact){
        var session = HibernateSessionFactory.getSession();
        var trans = session.beginTransaction();
        try {
            session.update(contact);
            trans.commit();


        }catch (Exception e){
            e.printStackTrace();
            trans.rollback();
        }
        session.close();

    }
}
