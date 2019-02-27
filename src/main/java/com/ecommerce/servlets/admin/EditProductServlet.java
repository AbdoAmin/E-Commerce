/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecommerce.servlets.admin;

import com.ecommerce.beans.Product;
import com.ecommerce.daos.DaoProduct;
import com.ecommerce.daos.DaoProductImages;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
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
@WebServlet(name = "EditProductServlet", urlPatterns = {"/EditProductServlet"})
public class EditProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String productId = req.getParameter("productId");
        if (productId != null) {
            DaoProduct daoProduct = new DaoProduct();
            Product product = daoProduct.getProduct(Integer.parseInt(productId));
            req.setAttribute("product", product);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String validation = "";
        try {
            Product product = new Product();
            DaoProduct daoProduct = new DaoProduct();
            DaoProductImages daoProductImages = new DaoProductImages();

            DiskFileItemFactory factory = new DiskFileItemFactory();

            ServletFileUpload upload = new ServletFileUpload(factory);

            List<FileItem> items;
            InputStream inputStream = null;
            int size = 0;

            items = upload.parseRequest(req);
            Iterator<FileItem> iter = items.iterator();
            while (iter.hasNext()) {
                FileItem item = iter.next();
                if (item.isFormField()) {
                    if (item.getFieldName().equals("name")) {
                        product.setName(item.getString());
                    } else if (item.getFieldName().equals("id")) {
                        product.setId(Integer.parseInt(item.getString()));
                    } else if (item.getFieldName().equals("price")) {
                        product.setPrice(Double.parseDouble(item.getString()));
                    } else if (item.getFieldName().equals("discount")) {
                        product.setDiscount(Double.parseDouble(item.getString()) / 100.0);
                    } else if (item.getFieldName().equals("quantity")) {
                        product.setQuantity(Integer.parseInt(item.getString()));
                    } else if (item.getFieldName().equals("categoryId")) {
                        product.setCategoryId(Integer.parseInt(item.getString()));
                    } else if (item.getFieldName().equals("description")) {
                        product.setDescription(item.getString());
                    }
                }
            }
            // it's to delete all image from database before adding new images
            daoProductImages.deleteProductImages(product.getId());
            if (daoProduct.updateProduct(product) > 0) {
                Iterator<FileItem> iterator = items.iterator();
                while (iterator.hasNext()) {
                    FileItem item = iterator.next();
                    if (!item.isFormField()) {
                        inputStream = item.getInputStream();
                        size = (int) item.getSize();
                        if (item.getFieldName().contains("image") && size > 0) {
                            daoProductImages.insertProductImage(product.getId(), inputStream, size);
                        }
                    }
                }
            } else {
                validation = "?error";
            }
        } catch (FileUploadException ex) {
            validation = "?error";
        }
        resp.sendRedirect("editProduct.jsp");
    }
}
