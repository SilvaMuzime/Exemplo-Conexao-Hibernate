/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import java.util.ArrayList;
import modelo.Estudante;
import modelo.NewHibernateUtil;
import modelo.Pessoa;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Silva Muzime
 */
public class Teste {

    public static void gravarDados(ArrayList dados) {

        SessionFactory e = NewHibernateUtil.getSessionFactory();
        Session sessao = e.openSession();
        sessao.beginTransaction();

        dados.forEach(p -> {
            sessao.save(p);
        });

        sessao.getTransaction().commit();
        sessao.close();
        //e.close();
    }

    public static ArrayList lerDados() {
        ArrayList dados = new ArrayList();
        SessionFactory e = NewHibernateUtil.getSessionFactory();
        Session sessao = e.openSession();
        sessao.beginTransaction();
        
        Criteria criterio = sessao.createCriteria(Estudante.class);
        dados.addAll((ArrayList) criterio.list());
        
        Criteria criterio1 = sessao.createCriteria(Pessoa.class);
        dados.addAll((ArrayList) criterio1.list());
        
        sessao.getTransaction().commit();
        sessao.close();
        //e.close();
        

        return dados;
    }
    
    public static void actualizarDados(Object o) {

        SessionFactory e = NewHibernateUtil.getSessionFactory();
        Session sessao = e.openSession(); 
        sessao.beginTransaction();

        sessao.saveOrUpdate(o);

        sessao.getTransaction().commit();
        sessao.close();
        e.close();
    }
    
    public static void apagarDados(Object o) {

        SessionFactory e = NewHibernateUtil.getSessionFactory();
        Session sessao = e.openSession();
        sessao.beginTransaction();

        sessao.delete(o);
        sessao.flush();

        sessao.getTransaction().commit();
        sessao.close();
        e.close();
    }
    
    

    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Silva Muzime");
        pessoa.setDataNascimento(java.sql.Date.valueOf("1998-08-15"));

        Estudante estudante = new Estudante();
        //estudante.setId(10);
        estudante.setCurso("Informatica");
        estudante.setNome("SSSS MoisesSSS Muzime");
        estudante.setDataNascimento(java.sql.Date.valueOf("1998-08-15"));

        ArrayList data = new ArrayList();
        data.add(pessoa);
        data.add(estudante);
        
        
       // actualizarDados(estudante);
        //apagarDados(estudante);
       // gravarDados(data);
//        
        lerDados().forEach(n->{
            System.out.println(n.toString());    
        });

        apagarDados(estudante);

        
    }
}
