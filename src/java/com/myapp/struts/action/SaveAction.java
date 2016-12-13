/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts.action;

import com.myapp.struts.db.DbConnect;
import com.myapp.struts.form.SearchActionFormBean;
import java.sql.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author admin
 */
public class SaveAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "home";
    
    Connection con = null;
    Statement st = null;
    
    
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
        SearchActionFormBean saf = (SearchActionFormBean)form;
        try{
            con = new DbConnect().getConnect();
            st = con.createStatement();
            String qry="insert into addbook values('"+saf.getName()+"','"+saf.getMob()+"','"+saf.getEmail()+"')";
            st.executeUpdate(qry);
            
        }catch(Exception e){
            e.printStackTrace();
        }    
          request.setAttribute("msg", "Contact Saved");
          return mapping.findForward(SUCCESS); 
    }
}
