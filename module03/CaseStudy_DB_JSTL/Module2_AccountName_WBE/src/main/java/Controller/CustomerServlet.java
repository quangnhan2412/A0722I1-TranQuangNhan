package Controller;

import bean.model.person.Customer;
import bean.service.CustomerService;
import bean.service.CustomerServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/customers")
public class CustomerServlet extends HttpServlet {

    private CustomerService customerService = new CustomerServiceImpl();

    public void init() {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showNewFormCustomer(request, response);
                break;
            case "delete":
                try {
                    showDeleteCustomer(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "deleteAll":
                try {
                    showDeleteALLCustomer(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "update":
                showUpdateFormCustomer(request, response);
                break;
                case "search":
                showSearchFormCustomer(request, response);
                break;
                case "search2":
                showOneSearchFormCustomer(request, response);
                break;
            default:
                listCustomer(request, response);
                break;
        }
    }

    private void showOneSearchFormCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchPhone = request.getParameter("searchABC");
        List<Customer> customerList ;
        customerList = customerService. searchThreeOne(searchPhone);
        RequestDispatcher dispatcher;
        request.setAttribute("customerList", customerList);
        dispatcher = request.getRequestDispatcher("customer/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showSearchFormCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchName = request.getParameter("searchName");
        String searchIdCard = request.getParameter("searchIdCard");
        String searchPhone = request.getParameter("searchPhone");

        List<Customer> customerList ;
        customerList = customerService.searchThree(searchName,searchIdCard,searchPhone);
        RequestDispatcher dispatcher;
        request.setAttribute("customerList", customerList);
        dispatcher = request.getRequestDispatcher("customer/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showDeleteALLCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String[] selectedIds = request.getParameterValues("customerId");
        List<Integer> customerIds = new ArrayList<>();
        for (String selectedId : selectedIds) {
            customerIds.add(Integer.parseInt(selectedId));
        }
            customerService.deleteCustomerStr(customerIds);
            List<Customer> customerList = customerService.selectAllCustomer();
            request.setAttribute("customerList", customerList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
            dispatcher.forward(request, response);

    }
    private void showDeleteCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        customerService.deleteCustomer(id);
        List<Customer> customerList = customerService.selectAllCustomer();
        request.setAttribute("customerList", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showUpdateFormCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer existingCustomer = customerService.getCustomerById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/update.jsp");
        request.setAttribute("existingCustomer", existingCustomer);
        dispatcher.forward(request, response);

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    createCustomer(request, response);
                    break;
                case "update":
                    updateCustomer(request, response);
                    break;
//                case "search":
//                    searchCustomerById(request, response);
//                    break;
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    private void searchCustomerById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        List<Customer> customerList = customerService.searchCustomerById(id);
        RequestDispatcher dispatcher;
        request.setAttribute("customerList", customerList);
        dispatcher = request.getRequestDispatcher("customer/list.jsp");
        dispatcher.forward(request, response);
    }


    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        int typeId = Integer.parseInt(request.getParameter("typeId"));
        String fullName = request.getParameter("fullName");
        Date dateOfBirth = Date.valueOf(request.getParameter("dateOfBirth"));
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        Customer customerUpdate = new Customer(fullName, idCard, dateOfBirth, phoneNumber, email, address, id, typeId, gender);
        customerService.updateCustomer(customerUpdate);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/update.jsp");
//        dispatcher.forward(request, response);
        response.sendRedirect("customers");

    }

    private void showNewFormCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create.jsp");
        dispatcher.forward(request, response);
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int typeId = Integer.parseInt(request.getParameter("typeId"));
        String fullName = request.getParameter("fullName");
        Date dateOfBirth = Date.valueOf(request.getParameter("dateOfBirth"));
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(fullName, idCard, dateOfBirth, phoneNumber, email, address, typeId, gender);
        customerService.addCustomer(customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create.jsp");
        dispatcher.forward(request, response);

    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("search");
        List<Customer> customerList;
        if (search != null) {
            customerList = customerService.searchCustomerByName(search);
        } else {
            customerList = customerService.selectAllCustomer();
        }
        request.setAttribute("customerList", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/customer/list.jsp");
        dispatcher.forward(request, response);
    }

}
