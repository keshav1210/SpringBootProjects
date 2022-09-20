package org.practice.project.global;

import java.util.ArrayList;
import java.util.List;

import org.practice.project.entity.Product;
import org.practice.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

public class GlobalData {
	public static List<Product> cart;
public static Product globalVariable;
static {
	cart=new ArrayList<Product>();
}
}
