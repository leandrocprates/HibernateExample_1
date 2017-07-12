package com.mkyong;

import com.finnet.model.Doenca;
import com.finnet.model.Paciente;
import com.finnet.model.Periodo;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;
import com.mkyong.stock.Category;
import com.mkyong.stock.Stock;
import com.mkyong.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;


public class App {
	public static void main(String[] args) {
		System.out.println("Hibernate many to many (Annotation)");
		Session session = HibernateUtil.getSessionFactory().openSession();

//		session.beginTransaction();
//
//		Stock stock = new Stock();
//        stock.setStockCode("7052");
//        stock.setStockName("PADINI");
// 
//        Category category1 = new Category("CONSUMER", "CONSUMER COMPANY");
//        Category category2 = new Category("INVESTMENT", "INVESTMENT COMPANY");
//    
//        Set<Category> categories = new HashSet<Category>();
//        categories.add(category1);
//        categories.add(category2);
//        
//        stock.setCategories(categories);
//        
//        session.save(stock);
//    
//		session.getTransaction().commit();
//        
                
                
            Query query = session.createQuery("from Stock where stockCode = '7052' ");
            List<Stock> list = query.list();
                
            for ( Stock stock : list ){
                System.out.println(stock.getStockCode());
                System.out.println(stock.getStockId());
                System.out.println(stock.getStockName());
            }
            

            System.out.println("=============== Primeira Parte ==================");
            
            
            Query query2 = session.createQuery("select s from Stock s , Category cat where s.stockCode='7052'  and cat.name ='CONSUMER'  ");
            List<Stock> list2 = query2.list();
                
            for ( Stock stock : list2 ){
                System.out.println(stock.getStockCode());
                System.out.println(stock.getStockId());
                System.out.println(stock.getStockName());
                
                for (   Category cate : stock.getCategories() ){
                    System.out.println(cate.getCategoryId());
                    System.out.println(cate.getName());
                }
                
            }

            System.out.println("=============== Segunda Parte ==================");
            
            Query query3 = session.createQuery("select  cat  from Category cat where cat.name ='CONSUMER'  ");
            List<Category> list3 = query3.list();
                
            for ( Category cate : list3 ){
                System.out.println(cate.getCategoryId());
                System.out.println(cate.getName());
                
                for ( Stock  stock:  cate.getStocks()){
                    System.out.println(stock.getStockCode());
                    System.out.println(stock.getStockId());
                    System.out.println(stock.getStockName());
                }
                
            }
                
            System.out.println("=============== Teste Finnet  ==================");
            
            
            Query query4 = session.createQuery("from Paciente  ");
            List<Paciente> list4 = query4.list();
                
            for ( Paciente paciente : list4 ){
                System.out.println(paciente.getId()  );
                System.out.println(paciente.getName()  );
                
                for ( Periodo periodo :   paciente.getPeriodos()  )   {
                    
                    System.out.println(periodo.getId()  );
                    System.out.println(periodo.getName()  );
                    
                    
                    for ( Doenca doenca : periodo.getDoencas() ) {
                        System.out.println(doenca.getId()  );
                        System.out.println(doenca.getName()  );
                    }
                    
                }
                
                System.out.println( "###################" );
                
            }
            
	}
}
