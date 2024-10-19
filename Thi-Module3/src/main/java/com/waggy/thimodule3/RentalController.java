package com.waggy.thimodule3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name ="home" , value = "/rentals")
public class RentalController extends HttpServlet {
    RentalsService rentalsService = new RentalsService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "showAll":
                showAllInfo(req ,resp) ;
                break;
        }

    }
    public void showAllInfo(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        List<InfoRentals> list = rentalsService.getAllInfo();
        req.setAttribute("list", list);
        req.getRequestDispatcher("index.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String date = req.getParameter("date");
        String payment = req.getParameter("payment");
        String notes = req.getParameter("note");
        InfoRentals infoRentals = new InfoRentals(name, phone, date, payment, notes);
        rentalsService.addNewInfo(infoRentals);
        List<InfoRentals> list = rentalsService.getAllInfo();
        req.setAttribute("list", list);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }


}
