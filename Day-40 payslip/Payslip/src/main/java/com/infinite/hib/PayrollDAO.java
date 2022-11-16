 



package com.infinite.hib;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
     import org.hibernate.SessionFactory;
     import org.hibernate.Transaction;




     public class PayrollDAO {
         
         SessionFactory sFactory;
         
         
         
         public String addEmploy(Employ employ) {
             sFactory = SessionHelper.getConnection();
             Session session = sFactory.openSession();
             Criteria cr = session.createCriteria(Employ.class);
          
             double  sal = employ.getSalary() ;
             double hra = (0.02*sal);
             employ.setHra(hra);
             double da= (0.0125*sal);
             employ.setDa(da);
             double ta = (0.0095*sal);
             employ.setTa(ta);
             double tax = (0.0023*sal);
             employ.setTax(tax);
             double pf = (0.03*sal);
             employ.setPf(pf);
             double gross = sal + hra + da + ta;
             employ.setGross(gross);
             double netpay = gross - tax - pf;
             employ.setNetPay(netpay);
             employ.setLeaveAvailable(16);
             Transaction transaction = session.beginTransaction();
             session.save(employ);
             transaction.commit();
             session.close();
             return "Employ Added...";
         }
         
         
       //date
         public Date convertDate(java.util.Date dt) {
                         java.sql.Date sqlDate = new java.sql.Date(dt.getTime());
                         return sqlDate;
         }

        

         
         
         
       //Apply Leave
         
         
         public String applyLeave(LeaveTable leaveTable) {
             sFactory = SessionHelper.getConnection();
             Session session = sFactory.openSession();
             Criteria cr = session.createCriteria(LeaveTable.class);
             
             long sdate = leaveTable.getLeaveStartdate().getTime();
             long edate = leaveTable.getLeaveEnddate().getTime();
             
             long diff =  edate - sdate;
             long m = diff/(1000*24*60*60);
             int days=(int)m;
             days=days+1;
             
             leaveTable.setNoOfDays(days);

             int no = leaveTable.getNoOfDays();
             if(no > 3) {
                 leaveTable.setLossOfPay((double) (no-3));
                  }else {
                      leaveTable.setLossOfPay((double) 0);
                    }
             
             Transaction transaction = session.beginTransaction();
             session.save(leaveTable);
             transaction.commit();
             session.close();
             return "Leave Applied successfully";
             
}
     

         
         
         public Employ searchemploy(int empNo) {
                    sFactory = SessionHelper.getConnection();
                    Session session = sFactory.openSession();
                    
                    Criteria cr = session.createCriteria(Employ.class);
                    cr.add(Restrictions.eq("empNo", empNo));
                    List<Employ> employList = cr.list();
                    
                    return employList.get(0);
                }
         
         
     public List<LeaveTable> searchleave(int empNo) {
    	 sFactory = SessionHelper.getConnection();
         Session session = sFactory.openSession();
         
         
         Criteria cr = session.createCriteria(LeaveTable.class);
         cr.add(Restrictions.eq("empNo", empNo));
         List<LeaveTable> leaveList = cr.list();
         
         return leaveList;
     }
     
     public int noOfDays(Date leaveStartDate,Date leaveEndDate) {
                                 int days = 0;
                   
                                  days=(int)((leaveEndDate.getTime()-leaveStartDate.getTime())/(1000*60*60*24));
                                 days++;
                                 return days;
                      }
                      public double lossOfPay(int empNo,int month) {
                                 LeaveTable leavetable=new LeaveTable();
                                 
                                 
                                 Employ employ =new Employ();
                             
                   employ= searchemploy(empNo);
                      double sal= employ.getSalary();
                      double s=sal/30.46,lospay = 0;
                      long d;
                                 sFactory = SessionHelper.getConnection();
                                 Session session = sFactory.openSession(); 
                                 
                                 Query query=session.createQuery("select sum(noOfDays) from"
                                                       + " LeaveTable where empNo=:empNo AND (MONTH(leaveStartDate)=:month AND "
                                                       + "MONTH(leaveEndDate)=:month)")
                                                       .setParameter("empNo", empNo).setParameter("month",month);
                                 
                                 
                                   
                                 List<Long> count=query.list();
                      long x = (Long)count.get(0);
                                 if(x>=3) {
                                            d=x-3;
                                            lospay=d*s;
                                 }
                                 query = session.createQuery("from LeaveTable where empNo=:empNo AND (MONTH(leaveStartDate)=:month AND "
                                                       + "MONTH(leaveEndDate)=:month)")
                                                       .setParameter("empNo", empNo).setParameter("month", month);
                                 List<LeaveTable> leaveList = query.list();
                                 LeaveTable lastRecord = leaveList.get(leaveList.size()-1);
                                 lastRecord.setLossOfPay(lospay);
                                 Transaction tr = session.beginTransaction();
                                 session.update(lastRecord);
                                 tr.commit();
                                 return lospay;
                                 
                      }

  
  
}

     





