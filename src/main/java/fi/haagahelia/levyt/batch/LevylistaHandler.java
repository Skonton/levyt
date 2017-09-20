package fi.haagahelia.levyt.batch;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fi.haagahelia.levyt.bean.Levy;
import fi.haagahelia.levyt.dao.LevyDao;


public class LevylistaHandler {

public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		LevyDao dao = (LevyDao)context.getBean("daoLuokka");
		
		System.out.println("-------------------");
		System.out.println("LISTATAAN KAIKKI");
		System.out.println("-------------------");
		
		List<Levy> levyt = dao.haeKaikki();
		for (Levy l : levyt) {
			System.out.println(l.getNimi());
		}
		
		System.out.println("-------------------");
		System.out.println("HAETAAN YKSI (ID=3)");
		System.out.println("-------------------");
		
		Levy levy = dao.etsi(1);
		System.out.println(levy.getId());
		System.out.println(levy.getArtisti());
		System.out.println(levy.getNimi());
		System.out.println(levy.getJulkaisuvuosi());
		
		System.out.println("-------------------");
		System.out.println("LISÄTÄÄN UUSI");
		System.out.println("-------------------");
		
		Levy l = new Levy();
		l.setArtisti("Jari Sillanpää");
		l.setNimi("Piritorin Jari");
		l.setJulkaisuvuosi(2017);
		dao.talleta(l);
		
		System.out.println("-------------------");
		System.out.println("HAETAAN KAIKKI");
		System.out.println("-------------------");
		levyt = dao.haeKaikki();
		for (Levy le : levyt) {
			System.out.println(le.getNimi());
		}
		
		context.close();

	}
	
}
