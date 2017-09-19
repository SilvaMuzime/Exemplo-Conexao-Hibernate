/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import modelo.Estudante;
import modelo.NewHibernateUtil;
import modelo.Pessoa;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Silva Muzime
 */
public class Teste {
    
    public static void main(String[] args) {
        SessionFactory e= NewHibernateUtil.getSessionFactory();
        Session sessao = e.openSession();
        sessao.beginTransaction();
        
        Pessoa pessoa= new Pessoa();
        pessoa.setNome("Silva Muzime");
        pessoa.setDataNascimento(java.sql.Date.valueOf("1998-08-15"));
        
        Estudante estudante = new Estudante();
        estudante.setCurso("Informatica");
        estudante.setNome("Moises Muzime");
        estudante.setDataNascimento(java.sql.Date.valueOf("1998-08-15"));
        
        
        sessao.save(pessoa);
        sessao.save(estudante);
        sessao.getTransaction().commit();
        sessao.close();
        e.close();
        
    }
}
