package com.codecool.servlet.servlets;

import com.codecool.servlet.models.Item;
import com.codecool.servlet.models.Stock;
import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/shop"})
public class WebShopServlet extends HttpServlet {
    private Stock stock;

    public WebShopServlet() {
        initializeStock();
    }

    private void initializeStock() {
        Item book1 = new Item("Ulisses", 200.0);
        Item book2 = new Item("The Phenomenology of Spirit", 350.0);
        Item book3 = new Item("Idiot", 180.0);
        stock = new Stock();
        stock.addToStock(book1);
        stock.addToStock(book2);
        stock.addToStock(book3);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        PrintWriter out = response.getWriter();
        JtwigTemplate template = JtwigTemplate.classpathTemplate("templates/shop.twig");
        JtwigModel model = JtwigModel.newModel();

        model.with("stock", stock.getItemSet());
        String message = template.render(model);
        String test = "welcome to web shop";
        out.println(message);
    }
}
