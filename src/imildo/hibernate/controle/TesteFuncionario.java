package imildo.hibernate.controle;

import imildo.hibernate.modelo.Caixa;
import imildo.hibernate.modelo.Director;
import imildo.hibernate.modelo.EstadoCivil;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Imildo Sitoe
 */
public class TesteFuncionario {
    
    public static void main(String[] args) {
        Director director = new Director();
        Caixa caixa = new Caixa();
        
        director.setNome("Silva");
        director.setEstadoCivil(EstadoCivil.CASADO);
        director.setDataNascimento(new Date());
        caixa.setNome("Leonardo");
        caixa.setEstadoCivil(EstadoCivil.SOLTEIRO);
        caixa.setDataNascimento(new Date());
        
        SessionFactory sessionFactory = new Configuration().configure("imildo/hibernate/controle/hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        session.save(director);
        session.save(caixa);
        
        session.getTransaction().commit();
        
        session.close();
    }
}
