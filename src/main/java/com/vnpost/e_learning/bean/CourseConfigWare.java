package com.vnpost.e_learning.bean;

import org.springframework.stereotype.Component;

@Component
public class CourseConfigWare {
  private Object idCourse ; //mã khóa học
  public Object getIdCourse() {
	return idCourse;
}
public void setIdCourse(Object idCourse) {
	this.idCourse = idCourse;
}
private String nameCourseWare; // ten hoc liêu
  private String nameTypeCoureWare ; // ten loại học liệu
  private String nameCategory ; // ten danh muc
  private Object idTypeCourseWare; // mã loại học liệu
  private Object  idCourseWare ; // mã hoc liệu


public String getNameCourseWare() {
	return nameCourseWare;
}
public void setNameCourseWare(String nameCourseWare) {
	this.nameCourseWare = nameCourseWare;
}
public String getNameTypeCoureWare() {
	return nameTypeCoureWare;
}
public void setNameTypeCoureWare(String nameTypeCoureWare) {
	this.nameTypeCoureWare = nameTypeCoureWare;
}
public String getNameCategory() {
	return nameCategory;
}
public void setNameCategory(String nameCategory) {
	this.nameCategory = nameCategory;
}
public Object getIdTypeCourseWare() {
	return idTypeCourseWare;
}
public void setIdTypeCourseWare(Object idTypeCourseWare) {
	this.idTypeCourseWare = idTypeCourseWare;
}
public Object getIdCourseWare() {
	return idCourseWare;
}
public void setIdCourseWare(Object idCourseWare) {
	this.idCourseWare = idCourseWare;
}

  
} 
