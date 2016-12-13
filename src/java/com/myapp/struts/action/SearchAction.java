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
import java.util.*;

/**
 *
 * @author admin
 */
public class SearchAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "search";
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
        SearchActionFormBean saf =(SearchActionFormBean)form;
        ArrayList<SearchActionFormBean> alist = new ArrayList<SearchActionFormBean>();
        try{
            con = new DbConnect().getConnect();
            st = con.createStatement();
            String ctName = saf.getName();
            String qry = "select * from addbook where name like '"+ctName+"%' order by name";
            rs = st.executeQuery(qry);
            while(rs.next()){
                SearchActionFormBean ob = new SearchActionFormBean();
                ob.setName(rs.getString("name"));
                ob.setMob(rs.getString("mob"));
                ob.setEmail(rs.getString("email"));
                alist.add(ob);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        request.setAttribute("alist", alist);
        return mapping.findForward(SUCCESS);
    }
}
