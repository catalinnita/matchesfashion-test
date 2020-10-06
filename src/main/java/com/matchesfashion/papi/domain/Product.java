package com.matchesfashion.papi.domain;

import com.fasterxml.jackson.annotation.JsonView;
import com.matchesfashion.papi.api.jsonview.View;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "products")
public class Product {

  @GeneratedValue
  @Id
  @JsonView(value = View.Product.class)
  private Integer id;

  @Column
  @JsonView(value = View.Product.class)
  private String title;

  @Column
  @JsonView(value = View.Product.class)
  private String category;

  @Column
  @JsonView(value = View.Product.class)
  private Integer price;

  public Product() {

  }

  public Product(String title, String category, Integer price) {
    this.title = title;
    this.category = category;
    this.price = price;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Product product = (Product) o;
    return Objects.equals(title, product.title) &&
            Objects.equals(category, product.category) &&
            Objects.equals(price, product.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, category, price);
  }

  @Override
  public String toString() {
    return "Product{" +
        "id=" + id +
        ", title='" + title + '\'' +
        ", category='" + category + '\'' +
        ", price=" + price +
        '}';
  }
}
