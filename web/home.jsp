<%-- 
    Document   : home
    Created on : Nov 25, 2016, 1:38:28 PM
    Author     : admin
--%>

<%@page import="javax.swing.JOptionPane"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-nested" prefix="nested" %>

<!DOCTYPE html>
<%@include file="header.jsp"  %>
<html>
    <head>
        <link href="css/style.css" rel='stylesheet' type='text/css' />               
        
        <title>Address Book</title>
        <script type="text/javascript">

//Get XMLHTTP Object
function getXMLHTTPObject() 
{
var xmlhttpObject = null;
try 
{
 // For Old Microsoft Browsers
 xmlhttpObject = new ActiveXObject("Msxml2.XMLHTTP"); 
}
catch (e) 
{
        try 
        {
        // For Microsoft IE 6.0+
        xmlhttpObject = new ActiveXObject("Microsoft.XMLHTTP"); 
        }
        catch (e1) 
        {
        // No Browser accepts the XMLHTTP Object then false
        xmlhttpObject = false; 
        }
}

if (!xmlhttpObject && typeof XMLHttpRequest != 'undefined') 
{
        //For Mozilla, Opera Browsers
        xmlhttpObject = new XMLHttpRequest(); 
}
        // Mandatory Statement returning the ajax object created
        return xmlhttpObject; 
}

        
// Change the value of the outputText field
function setAjaxOutput() 
{
document.getElementById('resrow').innerHTML = xmlhttpObject.responseText;
}

function handleServerResponse() 
{
        if (xmlhttpObject.readyState == 4) 
        {
                if (xmlhttpObject.status == 200) 
                {
                setAjaxOutput();
                }
                else 
                {
                    alert("Error during AJAX call. Please try again");
                }
        }
}
        
// Implement business logic
function doAjaxCall() 
{
   xmlhttpObject = getXMLHTTPObject();
   if (xmlhttpObject != null) 
   {
   var URL = "find.do?name="+document.getElementById('cname').value;
   xmlhttpObject.open("POST", URL, true);
   xmlhttpObject.onreadystatechange = handleServerResponse;
   xmlhttpObject.send(null);
   }
}       
</script>
    </head>
    <body>          
        
         <a id="addicon" href="add.do"><img src="img/user_add1.png" width="45px" height="45px"></a>            
            <div class="Find"> 
                <html:form action="find.do" >
                    Search <html:text property="name" styleId="cname" onkeypress="" />
                    <html:submit styleId="search" title="Search" />
                </html:form>
            </div>            
        
        <div id="wrapper">
 
  
  <table id="keywords" cellspacing="0" cellpadding="0">
    <thead>
      <tr>
        <th><span>Name</span></th>
        <th><span>E-Mail ID</span></th>
        <th><span>Mobile No</span></th>        
      </tr>
    </thead>
    <tbody>
        <logic:iterate name="alist" id="lid">   
      <tr id="resrow" >
         
          <td class="lalign"><a href="view.do?name=<bean:write name="lid" property="name" />&mob=<bean:write name="lid" property="mob" />" ><bean:write name="lid" property="name" /></a></td>
        <td><bean:write name="lid" property="mob" /></td>
        <td><bean:write name="lid" property="email" /></td>        
      </tr>
        </logic:iterate>
    </tbody>
  </table>
 </div>     
        
            
        
    </body>    
     
</html>
<div class="footspc">
   <%@include file="footer.jsp"  %>         
        </div>

