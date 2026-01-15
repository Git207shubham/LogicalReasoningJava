package com.core.seterGeter;

class Bank
{
 int id;
 String name;
 String ifsc;
 String add;
public Bank(int id,String name,String ifsc,String add)
 {
  this.id=id;
  this.name=name;
  this.ifsc=ifsc;
  this.add=add;
  }

 public int getId() {
  return id;
 }

 public void setId(int id) {
  this.id = id;
 }

 public void setName(String name) {
  this.name = name;
 }

 public void setIfsc(String ifsc) {
  this.ifsc = ifsc;
 }

 public void setAdd(String add) {
  this.add = add;
 }

 public String getName() {
  return name;
 }

 public String getIfsc() {
  return ifsc;
 }

 public String getAdd() {
  return add;
 }
}
