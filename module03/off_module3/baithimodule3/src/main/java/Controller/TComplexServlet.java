package Controller;

import bean.model.ToaNhaTComplex;
import bean.service.ToaNhaService;
import bean.service.ToaNhaServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "TComplexServlet", value = "/tComplexs")
public class TComplexServlet extends HttpServlet {
private ToaNhaService toaNhaService = new ToaNhaServiceImpl();
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
                    showDeleteToaNha(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "deleteAll":
//                try {
//                    showDeleteALLCustomer(request, response);
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                }
                break;
            case "update":
//                showUpdateFormCustomer(request, response);
                break;
            case "search":
//                showSearchFormCustomer(request, response);
                break;
            case "search2":
                showSearchToaNha(request, response);
                break;
            default:
                listToaNha(request, response);
                break;
        }
    }

    private void showNewFormCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("toanha/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showDeleteToaNha(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String id = request.getParameter("id");
        toaNhaService.deleteToaNha(id);
        List<ToaNhaTComplex> toaNhaTComplexes = toaNhaService.selectAllToaNha();
        request.setAttribute("complexServletsList", toaNhaTComplexes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("toanha/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showSearchToaNha(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchPhone = request.getParameter("searchABC");
        List<ToaNhaTComplex> complexServletsList ;
        complexServletsList = toaNhaService. searchThreeOne(searchPhone);
        RequestDispatcher dispatcher;
        request.setAttribute("complexServletsList", complexServletsList);
        dispatcher = request.getRequestDispatcher("toanha/list.jsp");
        dispatcher.forward(request, response);
    }

    private void listToaNha(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("search");
        List<ToaNhaTComplex> complexServletsList;
        if (search != null) {
            complexServletsList = toaNhaService.searchThreeOne(search);
        } else {
            complexServletsList = toaNhaService.selectAllToaNha();
        }
        request.setAttribute("complexServletsList", complexServletsList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/toanha/list.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
            switch (action) {
                case "create":
                    createToaNha(request, response);
                    break;
                case "update":
//                    updateToaNha(request, response);
                    break;
//                case "search":
//                    searchCustomerById(request, response);
//                    break;
            }

    }

    private void createToaNha(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maId = request.getParameter("fullName");
        String trangThai = request.getParameter("dateOfBirth");
        int tang = Integer.parseInt(request.getParameter("dateOfBirth"));
        String matBang = request.getParameter("idCard");
        double giaTien = Double.parseDouble(request.getParameter("giaTien"));
        double dth = Double.parseDouble(request.getParameter("dt"));
        Date batdau = Date.valueOf(request.getParameter("email"));
        Date ketThuc = Date.valueOf(request.getParameter("address"));


        ToaNhaTComplex customer = new ToaNhaTComplex(maId, trangThai,dth, tang, matBang, giaTien, batdau, ketThuc);
        toaNhaService.addCustomer(customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("toanha/create.jsp");
        dispatcher.forward(request, response);
    }

}
