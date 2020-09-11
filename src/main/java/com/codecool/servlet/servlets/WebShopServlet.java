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

@WebServlet(urlPatterns = {"/shop"})
public class WebShopServlet extends HttpServlet {
    static Stock stock;

    public WebShopServlet() {
        initializeStock();
    }

    private void initializeStock() {
        stock = new Stock();
        stock.addToStock(new Item("Ulisses", 200.0));
        stock.addToStock(new Item("The Phenomenology of Spirit", 350.0));
        stock.addToStock(new Item("Idiot", 180.0));
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        PrintWriter out = response.getWriter();
        JtwigTemplate template = JtwigTemplate.classpathTemplate("templates/shop.twig");
        JtwigModel model = JtwigModel.newModel();
        model.with("stock", stock.getItemSet());
        String message = template.render(model);
        out.println(message);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int itemId = Integer.parseInt(request.getParameterMap().get("id")[0].replace("/", ""));
        System.out.println("item id: "+itemId);
        ShoppingCartServlet.cart.addItem(stock.getItemById(itemId));
        doGet(request, response);
    }
}
