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

//    public Contact  findById(Integer id){
//        try {
//          var session = HibernateSessionFactory.getSession();
    //          var ps = session.prepareStatement("select * from contats where id_contato= ?");
//      ps.setInt(1,id);
//          var result= ps.executeQuery();
    //          Contact contact=null;
    //      if(result.next()){
    //          contact=new Contact();
    //          contact.setId(result.getInt("id_contato"));
    //          contact.setNome(result.getString("nome"));
    //          contact.setEmail(result.getString("email"));
    //      }
    //      result.close();
    //      ps.close();
    //      session.close();
//
    //          return contact;
//
    //      }catch (Exception e){
    //      e.printStackTrace();
    //      return null;
    //  }


    //  }

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
