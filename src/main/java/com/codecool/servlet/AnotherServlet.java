package com.codecool.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "anotherServlet", urlPatterns = {"/another"}, loadOnStartup = 2)
public class AnotherServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            builder.append("<div>");
            builder.append("<a href=\"/another?link_id=").append(i).append("\">");
            builder.append("Hello ").append(i).append(". link:");
            builder.append("</a>");
            builder.append("</div>");
        }

        String linkId = request.getParameter("link_id");

        out.println(
                "<html>\n" +
                        "<head><title>Another page</title></head>\n" +
                        "<body>\n" +
                        "<h1>Hello CodeCooler!</h1>" +
                        (linkId == null ?
                                "<h3>No link was pressed</h3>" :
                                "<h3>Link " + linkId + " was pressed!</h3>") +
                        "<br/>" +
                        "<div>" + builder.toString() + "</div>" +
                        "</body></html>"
        );
    }
}
