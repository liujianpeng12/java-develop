package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import com.roywmiller.contacts.model.*;

public final class contactList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.List _jspx_dependants;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>Contacts List 1.0</title>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("     body, table, hr {\r\n");
      out.write("          color: black;\r\n");
      out.write("          background: silver;\r\n");
      out.write("          font-family: Verdana, sans-serif;\r\n");
      out.write("          font-size: x-small;\r\n");
      out.write("     }\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t");
      com.roywmiller.contacts.model.ContactsUser user = null;
      synchronized (session) {
        user = (com.roywmiller.contacts.model.ContactsUser) _jspx_page_context.getAttribute("user", PageContext.SESSION_SCOPE);
        if (user == null){
          user = new com.roywmiller.contacts.model.ContactsUser();
          _jspx_page_context.setAttribute("user", user, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("\t<h2>Contact List 1.0</h2><a href=\"logoutAction.perform\">Logout</a>\r\n");
      out.write("\t<hr size=\"2\"/>\r\n");
      out.write("\t<table frame=\"below\" width=\"100%\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("         <th align=\"left\"></th>\r\n");
      out.write("         <th align=\"left\">Name</th>\r\n");
      out.write("         <th align=\"left\">Street</th>\r\n");
      out.write("         <th align=\"left\">City</th>\r\n");
      out.write("         <th align=\"left\">State</th>\r\n");
      out.write("         <th align=\"left\">Zip</th>\r\n");
      out.write("         <th align=\"left\">Type</th>\r\n");
      out.write("       </tr>\r\n");
      out.write("       ");

       	List list=user.getContacts();
       	for(Iterator i=list.iterator();i.hasNext();)
       	{
       		Contact contact=(Contact)i.next();       	
       
      out.write("\r\n");
      out.write("       \t<tr>\r\n");
      out.write("       \t\t<td width=\"100\"><a href=\"removeContactAction.perform?id=");
      out.print(contact.getId());
      out.write("\">Delete</a></td>\r\n");
      out.write("       \t\t<td width=\"200\">");
      out.print(contact.getFirstName());
      out.write(' ');
      out.print(contact.getLastName());
      out.write("</td>\r\n");
      out.write("\t         <td width=\"150\">");
      out.print(contact.getStreet());
      out.write("</td>\r\n");
      out.write("\t         <td width=\"100\">");
      out.print(contact.getCity());
      out.write("</td>\r\n");
      out.write("\t         <td width=\"100\">");
      out.print(contact.getState());
      out.write("</td>\r\n");
      out.write("\t         <td width=\"100\">");
      out.print(contact.getZip());
      out.write("</td>\r\n");
      out.write("\t         <td width=\"100\">");
      out.print(contact.getType());
      out.write("</td>\r\n");
      out.write("       \t</tr>\r\n");
      out.write("       ");
}
      out.write("\r\n");
      out.write("\t</table>\r\n");
      out.write("\t<br/>\r\n");
      out.write("     <br/>\r\n");
      out.write("     <br/>\r\n");
      out.write("     <fieldset>\r\n");
      out.write("          <legend><b>Add Contact</b></legend>\r\n");
      out.write("          <form method=\"post\" action=\"addContactAction.perform\">\r\n");
      out.write("               <table>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                         <td>First Name:<td>\r\n");
      out.write("                         <td><input type=\"text\" size=\"30\" name=\"firstname\"></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                         <td>Last Name:<td>\r\n");
      out.write("                         <td><input type=\"text\" size=\"30\" name=\"lastname\"></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                         <td>Street:<td>\r\n");
      out.write("                         <td><input type=\"text\" size=\"30\" name=\"street\"></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                         <td>City:<td>\r\n");
      out.write("                         <td><input type=\"text\" size=\"30\" name=\"city\"></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                         <td>State:<td>\r\n");
      out.write("                         <td><input type=\"text\" size=\"30\" name=\"state\"></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                         <td>Zip:<td>\r\n");
      out.write("                         <td><input type=\"text\" size=\"30\" name=\"zip\"></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                         <td>Type:<td>\r\n");
      out.write("                         <td><input type=\"radio\" size=\"30\" name=\"type\" value=\"family\">\r\n");
      out.write("                             Family <input type=\"radio\" size=\"30\" name=\"type\" \r\n");
      out.write("                                value=\"acquaintance\"\r\n");
      out.write("                                 checked> Acquaintance</td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("               </table>\r\n");
      out.write("               <br/>\r\n");
      out.write("               <input type=\"submit\" name=\"addContact\" value=\"  Add  \">\r\n");
      out.write("          </form>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
