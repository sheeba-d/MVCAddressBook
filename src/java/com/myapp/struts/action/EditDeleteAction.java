/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts.action;

import com.myapp.struts.db.DbConnect;
import com.myapp.struts.form.SearchActionFormBean;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import java.sql.*;

/**
 *
 * @author admin
 */
public class EditDeleteAction extends org.apache.struts.actions.DispatchAction {

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
    
    public ActionForward edit(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
            SearchActionFormBean saf = (SearchActionFormBean)form;
            try{
            con = new DbConnect().getConnect();
            st = con.createStatement();
            String qry="update addbook set name='"+saf.getName()+"',mob='"+
                    saf.getMob()+"',email='"+saf.getEmail()+"' where name='"+
                    saf.getHname()+"' and mob='"+saf.getHmob()+"'";
            st.executeUpdate(qry);
            }catch(Exception e){
                e.printStackTrace();
            }
        return mapping.findForward(SUCCESS);
    }
    public ActionForward delete(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        SearchActionFormBean saf = (SearchActionFormBean)form;
        try{
            con = new DbConnect().getConnect();
            st = con.createStatement();
            String qry = "Delete from addbook where name='"+saf.getName()+"' and mob='"+saf.getMob()+"'";
            st.executeUpdate(qry);
        }catch(Exception e){
            e.printStackTrace();
        }
        return mapping.findForward(SUCCESS);
    }
}
