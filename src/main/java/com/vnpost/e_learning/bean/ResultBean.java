package com.vnpost.e_learning.bean;

import com.vnpost.e_learning.entities.BaoMat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter
@Setter
public class ResultBean {
    private List<BaoMat> data ;
}
