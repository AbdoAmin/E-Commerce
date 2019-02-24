/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.servlets;

import com.ecommerce.beans.Product;
import com.ecommerce.daos.DaoProduct;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Ashraf_R
 */
@WebServlet(name = "AddProductServlet", urlPatterns = {"/AddProductServlet"})
public class AddProductServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            Product product = new Product();
            DaoProduct daoProduct = new DaoProduct();

            DiskFileItemFactory factory = new DiskFileItemFactory();

            ServletFileUpload upload = new ServletFileUpload(factory);

            List<FileItem> items;
            InputStream inputStream = null;
            int size = 0;

            items = upload.parseRequest(req);
            Iterator<FileItem> iter = items.iterator();
            while (iter.hasNext()) {
                FileItem item = iter.next();
                if (!item.isFormField()) {
                    if (item.getFieldName().equals("image")) {
                        inputStream = item.getInputStream();
                        size = (int) item.getSize();
                    }
                } else {
                    if (item.getFieldName().equals("name")) {
                        product.setName(item.getString());
                    } else if (item.getFieldName().equals("price")) {
                        product.setPrice(Integer.parseInt(item.getString()));
                    } else if (item.getFieldName().equals("discount")) {
                        product.setDiscount(Integer.parseInt(item.getString()));
                    } else if (item.getFieldName().equals("quantity")) {
                        product.setQuantity(Integer.parseInt(item.getString())/100);
                    } else if (item.getFieldName().equals("categoryId")) {
                        product.setCategoryId(Integer.parseInt(item.getString()));
                    } else if (item.getFieldName().equals("description")) {
                        product.setDescription(item.getString());
                    }
                }
            }
            daoProduct.addProduct(product);
        } catch (FileUploadException ex) {
            Logger.getLogger(AddProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
