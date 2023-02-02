package servlet;

import bean.Customers;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomersServlet", value= "/customer")
public class CustomersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customers> customersList = new ArrayList<>();
        customersList.add(
                new Customers("Mai Van Hoang", "1983-08-20", "HN", "OIP.jpg"));
        customersList.add(
                new Customers("Nguyen Van Nam", "1983-08-21", "Bac Giang", "img2.png"));
        customersList.add(
                new Customers("Nguyen Thai Hoa", "1983-08-22", "Nam Dinh", "img3.webp"));
        customersList.add
                (new Customers("Tran Dang Khoa", "1983-08-17", "Ha Tay", "img4.webp"));
        customersList.add(
                new Customers("Nguyen Dinh Thi", "1983-08-19", "HN", "img5.webp"));

        request.setAttribute("list", customersList);
        request.getRequestDispatcher("/index.jsp").forward(request, response);

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
