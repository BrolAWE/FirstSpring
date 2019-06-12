package com.example.demo;


import com.example.demo.model.Bank;
import com.example.demo.model.Routes;
import com.google.gson.Gson;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

@RestController
public class LogisticController {
    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Autowired
    private DataSource dataSource;

    @RequestMapping(value="/my_route.htm", method = RequestMethod.GET)

    public byte[] Getroute(HttpServletRequest request,
                           HttpServletResponse response,
                           @RequestParam(value = "x", defaultValue= "001") int x) throws SQLException {   // throws SQLException ОБЯЗАТЕЛЕН!!!!
        Connection c = dataSource.getConnection();
        ResultSet rs = c.createStatement().executeQuery("SELECT * FROM public.\"routes\"");
        ArrayList<Routes> My_Routes = new ArrayList<Routes>();
        System.out.println("Маршруты водителям от САМОЙЛОВОЙ из POSTGRE:");
        while (rs.next()){
            // По каждой записи выборки формируется объект prod класса Routes
            // Значения свойств заполяются из полей записи
            Routes route = new Routes();
            route.setId(rs.getInt(1));
            route.setRoute_kod(rs.getString(2));
            route.setNum(rs.getInt(3));
            route.setRoute_point(rs.getString(4));
            route.setCome(rs.getString(5));
            route.setParking(rs.getString(6));
            route.setWeight(rs.getInt(7));
            // Добавление созданного объекта в коллекцию
            My_Routes.add(route);
        }
        rs.close();
        c.close();
        response.setContentType("text/html;charset=UTF-128");
        Gson gson = new Gson();
        String s = gson.toJson(My_Routes);
        return s.getBytes();
    }

}
