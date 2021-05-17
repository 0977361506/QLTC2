package com.vnpost.e_learning.bean;

import org.springframework.stereotype.Component;

@Component
public class Stars {
  private String starOne;
  private String starTwo;
  private String starThree;
  private Long idRate;
  private String starFor;
  private String starFive;
public Stars() {
	
}

public Stars(String starOne, String starTwo, String starThree, Long idRate, String starFor, String starFive) {
	super();
	this.starOne = starOne;
	this.starTwo = starTwo;
	this.starThree = starThree;
	this.idRate = idRate;
	this.starFor = starFor;
	this.starFive = starFive;
}

public Long getIdRate() {
	return idRate;
}

public void setIdRate(Long idRate) {
	this.idRate = idRate;
}

public String getStarOne() {
	return starOne;
}
public void setStarOne(String starOne) {
	this.starOne = starOne;
}
public String getStarTwo() {
	return starTwo;
}
public void setStarTwo(String starTwo) {
	this.starTwo = starTwo;
}
public String getStarThree() {
	return starThree;
}
public void setStarThree(String starThree) {
	this.starThree = starThree;
}
public String getStarFor() {
	return starFor;
}
public void setStarFor(String starFor) {
	this.starFor = starFor;
}
public String getStarFive() {
	return starFive;
}
public void setStarFive(String starFive) {
	this.starFive = starFive;
}
}
