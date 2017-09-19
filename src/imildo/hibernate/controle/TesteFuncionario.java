package imildo.hibernate.controle;

import imildo.hibernate.modelo.pessoa.Caixa;
import imildo.hibernate.modelo.pessoa.Director;
import imildo.hibernate.modelo.pessoa.EstadoCivil;
import java.util.ArrayList;
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

//        session.save(director);
//        session.save(caixa);

        session.getTransaction().commit();

        readCaixa().forEach(c -> {
            System.out.println(c);
        });

        for (Director d : readDirector()) {
            System.out.println(d);
        }
        
        
        session.close();
    }

    private static boolean create(Object object) {
        SessionFactory sessionFactory = new Configuration().configure("imildo/hibernate/controle/hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        
        return true;
    }
    
    private static boolean updateOrSave(Object o) {
        SessionFactory sessionFactory = new Configuration().configure("imildo/hibernate/controle/hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        session.saveOrUpdate(o);
        return true;
    }
    
    private static boolean delete(Object o) {
        SessionFactory sessionFactory = new Configuration().configure("imildo/hibernate/controle/hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        
        session.delete(o);
        session.flush();
        session.close();
        return true;
    }

    private static ArrayList<Caixa> readCaixa() {
        SessionFactory s = new Configuration().configure("imildo/hibernate/controle/hibernate.cfg.xml").buildSessionFactory();
        Session session = s.openSession();
        session.beginTransaction();
        
        ArrayList<Caixa> arrayList = (ArrayList<Caixa>) session.createCriteria(Caixa.class).list();
        
        return arrayList;
    }
    
    
    private static ArrayList<Director> readDirector() {
        SessionFactory s = new Configuration().configure("imildo/hibernate/controle/hibernate.cfg.xml").buildSessionFactory();
        Session session = s.openSession();
        session.beginTransaction();
        
        ArrayList<Director> arrayList = (ArrayList<Director>) session.createCriteria(Director.class).list();
        return arrayList;
    }
}
