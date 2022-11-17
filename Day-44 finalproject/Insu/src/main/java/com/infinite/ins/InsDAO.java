package com.infinite.ins;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class InsDAO {
	SessionFactory sessionFactory;
	
	public int loginCheck(String userName, String passWord) {
		sessionFactory = SessionHelper.getConnection();

		Session session = sessionFactory.openSession(); 
		Criteria cr = session.createCriteria(InsUsers.class);
		cr.add(Restrictions.eq("userName", userName));
		cr.add(Restrictions.eq("passWord", passWord));
		List<InsUsers> listUsers = cr.list();
		return listUsers.size();
	}
	public String generateLoanId(){
		sessionFactory = SessionHelper.getConnection();
		
	Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Lapsed.class);
		List<Lapsed> Lapsed = cr.list();
		if(Lapsed.size()==0){
			return "L001";
		}
		int id = Integer.parseInt(Lapsed.get(Lapsed.size()-1).getLoanId().substring(1));
		String lid = String.format("L%03d", ++id);
		return lid;
	}

	public String addLapsed(Lapsed lapsed) {	
		sessionFactory = SessionHelper.getConnection();
		Session session = sessionFactory.openSession();
		String LoanId=generateLoanId();
		Transaction t = session.beginTransaction();

		lapsed.setLoanId(LoanId);	
		session.save(lapsed);
		t.commit();
		return "Lapsed Added";
		}

}
