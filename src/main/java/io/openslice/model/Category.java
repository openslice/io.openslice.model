/*-
 * ========================LICENSE_START=================================
 * io.openslice.model
 * %%
 * Copyright (C) 2019 openslice.io
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * =========================LICENSE_END==================================
 */

package io.openslice.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "Category")
@JsonIgnoreProperties(value = {  "products" }, ignoreUnknown = true )
public class Category {

	private static final transient Logger logger = LoggerFactory.getLogger(Category.class.getName());
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id = 0;
	
	@Basic()
	private String name=null;



	@ManyToMany(cascade = { CascadeType.ALL })
	 @JoinTable(
		        name = "CATEGORY_PRODUCTS", 
		        joinColumns = { @JoinColumn(name = "CAT_ID") }, 
		        inverseJoinColumns = { @JoinColumn(name = "PROD_ID") }
		    )
	private Set<Product> products = new HashSet<Product>();
	
	
	
	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public void addProduct(Product product) {
		if (!products.contains(product)) {
			logger.info("ACTUALLY add into category "+ this.getName()+"  product "+product.getId());
			products.add(product);
			//product.addCategory(this);
		}		
	}
	

	public void removeProduct(Product p) {
		if (products.contains(p)) {
			products.remove(p);
			//p.removeCategory(this);
		}		
	}
	
	@JsonIgnore
	public int getAppscount() {
		int c = 0;
		for (Product p : products) {
			if ( p  instanceof ExperimentMetadata)
				c++;
		}
		return c;
	}
	@JsonIgnore
	public int getVxFscount() {
		int c = 0;
		for (Product p : products) {
			if ( p  instanceof VxFMetadata)
				c++;
		}
		
		return c;
	}
	
	
	@JsonIgnore
	public int getProductsCount() {
		return products.size();
	}
	

}
