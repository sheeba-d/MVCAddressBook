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
        <script>
                function disableDeleteBtn() {
                           document.getElementById("delete").disabled = true;                           
                }
                function enableDeleteBtn() {
                           document.getElementById("delete").disabled = false;
                }
        </script>
    </head>
    <body>
        
        <!--<p class="texto">Add Address Info</h1>-->
    <div class="register">        
        <h3>Update Information <a id="back" href="home.do" title="Back"><img src="img/back.png" width="20px" height="20px"/></a></h3> 
       <div class="Registro">                      
        <html:form action="/editdelete.do" method="post">
            <!--Name : <input type="text" name="txt_name" /> <br>
            Mobile No  : <input type="text" name="txt_mobile" /> <br>
            E-Mail ID  : <input type="text" name="txt_mailid" /> <br>
            Address    : <textarea name="txt_address"></textarea> <br>
            <input type="submit" name="save" value="Save" />
            <input type="reset" name="clear" value="Clear" />-->
            <html:hidden property="hname" name="ct" />
            <html:hidden property="hmob" name="ct" />
            <span><img src="img/name.png"></span><html:text name="ct" property="name" onkeypress="disableDeleteBtn()" />
            <span><img src="img/email.png"></span><html:text name="ct" property="email" onkeypress="disableDeleteBtn()" />
            <span><img src="img/phone.png"></span><html:text name="ct" property="mob" onkeypress="disableDeleteBtn()" />
            <!--<span><img src="img/home.png"></span><textarea name="txt_address" required placeholder="Addresss" autocomplete="off"></textarea>-->
	    <!--<input type="submit" value="Save" title="Save">
            <input type="reset" value="Clear" title="Clear"> -->
            <div class="btn_window">
                <html:submit styleId="update" property="method" value="edit" title="Update" onclick="enableDeleteBtn()" />
                <html:submit styleId="delete" property="method" value="delete" title="Delete" />
               
                <input type="reset" id="clear" value="" title="Clear"/>                
            </div>
        </html:form>
       </div>
    </div>
    </body>
</html>
 <%@include file="footer.jsp"  %>