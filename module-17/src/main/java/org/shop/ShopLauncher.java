package org.shop;

import org.shop.api.ProductService;
import org.shop.api.ProposalService;
import org.shop.api.SellerService;
import org.shop.api.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.List;

/**
 * The ShopLauncher class.
 */
public class ShopLauncher {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

        ProductService productService = (ProductService)context.getBean("productService");
        ProposalService proposalService = context.getBean(ProposalService.class);
        SellerService sellerService = context.getBean("sellerService", SellerService.class);
        UserService userService = (UserService)context.getBean("userServiceAlias");

        println("Products:", productService.getProducts());
        println("Proposals by product id(1):", proposalService.getProposalsByProductId(1l));
        println("Sellers:", sellerService.getSellers());
        println("Users:", userService.getUsers());
    }

    private static void println(String title, List list) {
        System.out.println("\n" + title);
        for(Object element : list) {
            System.out.println(element);
        }
    }

}