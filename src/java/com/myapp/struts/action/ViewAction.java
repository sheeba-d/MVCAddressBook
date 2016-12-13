/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts.action;

import com.myapp.struts.db.DbConnect;
import com.myapp.struts.form.SearchActionFormBean;
import java.sql.*;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author admin
 */
public class ViewAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "update";
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        SearchActionFormBean saf=(SearchActionFormBean)form;
      //  saf.setName(request.getParameter("name"));
      //  saf.setMob(request.getParameter("mob"));
      //  ArrayList<SearchActionFormBean> alist = new ArrayList<SearchActionFormBean>();
        try{
            con = new DbConnect().getConnect();
            st = con.createStatement();
            String qry = "select * from addbook where name='"+saf.getName()+"' and mob='"+saf.getMob()+"'";
            rs = st.executeQuery(qry);
         SearchActionFormBean ob = new SearchActionFormBean();
         
         //while(rs.next()){
         if(rs.next()){
            ob.setName(rs.getString("name"));
            ob.setMob(rs.getString("mob"));
            ob.setEmail(rs.getString("email"));
            ob.setHname(rs.getString("name"));
            ob.setHmob(rs.getString("mob"));
        //    alist.add(ob);
            request.setAttribute("ct", ob);
         }
        }catch(Exception e){
            e.printStackTrace();
        }
       // request.setAttribute("alist", alist);
        return mapping.findForward(SUCCESS);
    }
}
