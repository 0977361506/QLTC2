//package com.vnpost.e_learning.test;
//
//import com.vnpost.e_learning.common.UsernameUtils;
//import com.vnpost.e_learning.common.VNCharecterUtils;
//import com.vnpost.e_learning.dto.CourseDTO;
//import com.vnpost.e_learning.entities.ScormLecture;
//import com.vnpost.e_learning.entities.VideoLecture;
//
//import javax.xml.crypto.Data;
//import java.lang.reflect.Field;
//import java.text.FieldPosition;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.*;
//
//public class main {
//    public static void main(String[] args) throws ParseException {
//      String name ="nguyễn Anh Tuấn";
//      Date date = Calendar.getInstance().getTime();
//        System.out.println(UsernameUtils.convertUsername(name,date));
//        CourseDTO courseDTO = new CourseDTO();
//        Field[] fields = CourseDTO.class.getDeclaredFields();
//        for (Field field : fields){
//            System.out.println("type:"+field.getGenericType().getTypeName());
//        }
//
//
//    }
//}
