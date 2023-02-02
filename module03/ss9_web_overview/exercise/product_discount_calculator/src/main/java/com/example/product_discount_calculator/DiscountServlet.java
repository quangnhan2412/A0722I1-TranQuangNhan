package com.example.product_discount_calculator;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DiscountServlet", value = "/DiscountServlet")
public class DiscountServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("product_description");
        float listPrice = Float.parseFloat(request.getParameter("list_price"));
        float discount = Float.parseFloat(request.getParameter("discount_percent"));

        double discountAmount = listPrice * discount * 0.01;

//  c2        PrintWriter writer = response.getWriter();
//        writer.println("<html>");
//        writer.println("<table>");
//        writer.println("<tr><th>Product description</th>");
//        writer.println("<td>" + description + "</td></tr>");
//
//        writer.println("<tr><th>Price</th>");
//        writer.println("<td>" + listPrice + "</td></tr>");
//
//        writer.println("<tr><th>Discount</th>");
//        writer.println("<td>" + discount + "</td></tr>");
//
//        writer.println("<tr><th>Discount amount</th>");
//        writer.println("<td>" + discountAmount + "</td></tr>");
//
//        writer.println("<tr><th>Discount price</th>");
//        writer.println("<td>" + discountAmount + "</td></tr>");
//
//        writer.println("</table>");
//        writer.println("</html>");


//        c3
//sevlet gán gửi sang jsp
        request.setAttribute("resultDiscountAmount", discountAmount);
//        đẩy
        request.getRequestDispatcher("result_final.jsp").forward(request, response);
    }
}
