package com.codecool.servlet.servlets;

import com.codecool.servlet.models.Cart;
import com.codecool.servlet.models.Item;
import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/cart", "/add/"}, loadOnStartup = 0)
public class ShoppingCartServlet extends HttpServlet {
    static Cart cart;

    public ShoppingCartServlet() {
        cart = new Cart();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        JtwigTemplate template = JtwigTemplate.classpathTemplate("templates/cart.twig");
        JtwigModel model = JtwigModel.newModel();
        double totalPrice = cart.getItemList().stream().mapToDouble(Item::getPrice).sum();
        model.with("totalPrice", totalPrice);
        model.with("cart", cart.getItemList());
        String message = template.render(model);
        out.println(message);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int itemId = Integer.parseInt(request.getParameterMap().get("id")[0].replace("/", ""));
        System.out.println(itemId);
        cart.removeItem(WebShopServlet.stock.getItemById(itemId));
        doGet(request, response);
    }
}
