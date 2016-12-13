<%-- 
    Document   : AddDetails
    Created on : Nov 16, 2016, 2:55:32 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<!DOCTYPE html>
                <%@include file="header.jsp"  %>

<html>
    <head>
        <link href="css/addformdesign.css" rel='stylesheet' type='text/css' />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Address Book</title>
       
    </head>
    <body>
        <!--<p class="texto">Add Address Info</h1>-->
        
        
    <div class="register">        
        <h3>Add Information <a id="back" href="home.do" title="Back"><img src="img/back.png" width="20px" height="20px"/></a></h3>
       <div class="Registro">                      
        <html:form action="save.do" method="post">           
            <span><img src="img/name.png"></span><html:text property="name" value="" />
            <span><img src="img/email.png"></span><html:text property="email" value="" />
            <span><img src="img/phone.png"></span><html:text property="mob" value="" />
            <div class="btn_window">
                <input type="submit"  id="save" value="" title="Save"/>
                <input type="reset" id="clear" value="" title="Clear"/>
            </div>
        </html:form>
       </div>
        
    </div>

    </body>
</html>

            <%@include file="footer.jsp"  %>
