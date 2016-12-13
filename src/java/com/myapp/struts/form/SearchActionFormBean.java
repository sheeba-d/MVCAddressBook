/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author admin
 */
public class SearchActionFormBean extends org.apache.struts.action.ActionForm {
    
   
    private String name;
    private int number;
    private String mob;
    private String email;
    private String hname;
    private String hmob;

    /**
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * @param string
     */
    public void setName(String string) {
        name = string;
    }

    /**
     * @return
     */
    public int getNumber() {
        return number;
    }

    /**
     * @param i
     */
    public void setNumber(int i) {
        number = i;
    }

    /**
     *
     */
    public SearchActionFormBean() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return
     */
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        if (getName() == null || getName().length() < 1) {
            errors.add("name", new ActionMessage("error.name.required"));
            // TODO: add 'error.name.required' key to your resources
        }
        return errors;
    }

    /**
     * @return the mob
     */
    public String getMob() {
        return mob;
    }

    /**
     * @param mob the mob to set
     */
    public void setMob(String mob) {
        this.mob = mob;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the hname
     */
    public String getHname() {
        return hname;
    }

    /**
     * @param hname the hname to set
     */
    public void setHname(String hname) {
        this.hname = hname;
    }

    /**
     * @return the hmob
     */
    public String getHmob() {
        return hmob;
    }

    /**
     * @param hmob the hmob to set
     */
    public void setHmob(String hmob) {
        this.hmob = hmob;
    }

    
}
