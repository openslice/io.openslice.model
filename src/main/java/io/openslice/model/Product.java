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
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

/**
 * @author ctranoris
 *
 */
@Entity(name = "Product")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "app_type", discriminatorType = DiscriminatorType.STRING)
public class Product {

	private static final transient Logger logger = LoggerFactory.getLogger(Product.class.getName());
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id = 0;

	@ManyToOne
	@JoinColumns({ @JoinColumn() })
	private PortalUser owner = null;

	
	@Basic()
	@Column(unique = true)
	private String uuid = null;
	@Basic()
	private String name = null;
	@Basic()
	private String iconsrc = null;
	@Basic()
	private String shortDescription = null;


	@Lob
	@Column(name = "LDESCRIPTION", columnDefinition = "LONGTEXT")
	private String longDescription = null;
	@Basic()
	private String version = null;
	@Basic()
	private String packageLocation = null;

	@Basic()
	private Date dateCreated;

	@Basic()
	private Date dateUpdated;

	@ManyToMany( mappedBy ="products" )
	private Set<Category> categories = new HashSet<Category>();

	@OneToMany(cascade = { CascadeType.ALL })
	@JoinTable()
	private List<ProductExtensionItem> extensions = new ArrayList<ProductExtensionItem>();
	
	@OneToMany(cascade = {  CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH  })
	@JoinTable()
	private List<ValidationJob> validationJobs = new ArrayList<ValidationJob>();
	
	
	
	
	@Basic() 
	@Column(name = "SCREENSPATH", columnDefinition = "LONGTEXT")		
	private String screenshots= null; //comma separated file paths

	@Basic()
	private String vendor = null;
	

	@Basic()
	private boolean published;	
	

	@Lob
	@Column(name = "TERMS", columnDefinition = "LONGTEXT")
	private String termsOfUse;	
	

	@Lob
	@Column(name = "DESCRIPTOR", columnDefinition = "LONGTEXT")
	private String descriptor;	
	

	@Lob
	@Column(name = "DESCRIPTORHTML", columnDefinition = "LONGTEXT")
	private String descriptorHTML;	

	
	public String getScreenshots() {
		return screenshots;
	}

	public void setScreenshots(String screenshots) {
		this.screenshots = screenshots;
	}

	public List<ProductExtensionItem> getExtensions() {
		return extensions;
	}

	public void setExtensions(List<ProductExtensionItem> extensions) {
		this.extensions = extensions;
	}

	public Product() {
	}

	public Product(String uuid, String name) {
		super();
		this.name = name;
		this.uuid = uuid;
	}

	public PortalUser getOwner() {
		if (owner!=null){
			return owner.getSnippedDetails() ;			
		} else {
			return null;
		}
	}

	public void setOwner(PortalUser newOwner) {
		owner = newOwner;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIconsrc() {
		return iconsrc;
	}

	public void setIconsrc(String iconsrc) {
		this.iconsrc = iconsrc;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getPackageLocation() {
		return packageLocation;
	}

	public void setPackageLocation(String packageLocation) {
		this.packageLocation = packageLocation;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories( Set<Category> categories) {
		this.categories = categories;
	}
	

//	public void addCategory(Category category) {
//		logger.info("IN Product  "+ this.getId()+"  category "+category.getId());
//		if (!this.categories.contains(category) ){
//			this.categories.add(category);
//			category.addProduct(this);
//		}
//	}
//	
//	public void removeCategory(Category category) {
//		if (this.categories.contains(category) ){
//			this.categories.remove(category);
//			category.removeProduct(this);
//		}
//	}
	
	public void addExtensionItem(ProductExtensionItem i){
		if (!this.extensions.contains(i)){
			if (findProductExtensionItemByName(i.getName())==null )
				this.extensions.add(i);
		}
	}
	
	public void removeExtensionItem(ProductExtensionItem i){
		if (this.extensions.contains(i)){
			this.extensions.remove(i);
		}
	}
	
	public void addExtensionItem(String name, String value){
		ProductExtensionItem i = new ProductExtensionItem();
		i.setName(name);
		i.setValue(value);
		this.addExtensionItem(i);
	}
	
	public ProductExtensionItem findProductExtensionItemByName(String name){
		for (ProductExtensionItem p : this.extensions) {
			if (p.getName().equals(name))
				return p;
		}
		return null;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}


	public boolean isPublished() {
		return published;
	}

	public void setPublished(boolean published) {
		this.published = published;
	}
	

	public String getTermsOfUse() {
		return termsOfUse;
	}

	public void setTermsOfUse(String termsOfUse) {
		this.termsOfUse = termsOfUse;
	}

	public String getDescriptor() {
		return descriptor;
	}

	public void setDescriptor(String descriptor) {
		this.descriptor = descriptor;
	}

	public String getDescriptorHTML() {
		return descriptorHTML;
	}

	public void setDescriptorHTML(String descriptorHTML) {
		this.descriptorHTML = descriptorHTML;
	}

	/**
	 * @return the validationJobs
	 */
	public List<ValidationJob> getValidationJobs() {
		return validationJobs;
	}

	/**
	 * @param validationJobs the validationJobs to set
	 */
	public void setValidationJobs(List<ValidationJob> validationJobs) {
		this.validationJobs = validationJobs;
	}
	
	

}
