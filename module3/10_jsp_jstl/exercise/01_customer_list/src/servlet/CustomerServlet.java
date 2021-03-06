package servlet;

import customer.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "servlet.CustomerServlet", urlPatterns = {""})
public class CustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Mai Văn Hoàng", "1983-08-20", "Hà Nội", "https://photographer.com.vn/wp-content/uploads/2020/08/1596889696_Anh-avatar-dep-va-doc-dao-lam-hinh-dai-dien.jpg "));
        customers.add(new Customer("Nguyễn Văn Nam", "1983-08-21", "Bắc Giang", "https://photographer.com.vn/wp-content/uploads/2020/08/1596889696_Anh-avatar-dep-va-doc-dao-lam-hinh-dai-dien.jpg"));
        customers.add(new Customer("Nguyễn Thái Hòa", "1983-08-22", "Nam Định", "https://photographer.com.vn/wp-content/uploads/2020/08/1596889696_Anh-avatar-dep-va-doc-dao-lam-hinh-dai-dien.jpg"));
        customers.add(new Customer("Trần Đăng Khoa", "1983-08-17", "Hà Tây", "https://photographer.com.vn/wp-content/uploads/2020/08/1596889696_Anh-avatar-dep-va-doc-dao-lam-hinh-dai-dien.jpg"));
        customers.add(new Customer("Nguyễn Đình Thi", "1983-08-19", "Hà Nội", "https://photographer.com.vn/wp-content/uploads/2020/08/1596889696_Anh-avatar-dep-va-doc-dao-lam-hinh-dai-dien.jpg"));

        request.setAttribute("customers", customers);
        request.getRequestDispatcher("list.jsp").forward(request,response);
    }
}
