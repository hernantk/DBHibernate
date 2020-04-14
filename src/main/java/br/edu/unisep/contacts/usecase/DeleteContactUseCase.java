package br.edu.unisep.contacts.usecase;

import br.edu.unisep.contacts.model.dao.ContactDao;
import br.edu.unisep.contacts.model.entity.Contact;

public class DeleteContactUseCase {
    

    public void execute(Contact contact){
        var dao= new ContactDao();
        dao.exclude(contact);
    }
}
