package com.navigatingcancer.codingexercise.controller;

import com.navigatingcancer.codingexercise.model.BasicMathResult;
import com.navigatingcancer.codingexercise.model.MathOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathsController {

    @GetMapping("/math/add")
    public BasicMathResult addTwoIntegers(@RequestParam int parameter1,
                                          @RequestParam int parameter2){
        long result = (long) parameter1 + (long) parameter2;
        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            throw new ArithmeticException("Adding the two parameters resulted in integer overflow");
        }
        return new BasicMathResult(parameter1, parameter2, MathOperation.ADDITION, (int) result);
    }

    @GetMapping("/math/subtract")
    public BasicMathResult subtractTwoIntegers(@RequestParam int parameter1,
                                               @RequestParam int parameter2){
        long result = (long) parameter1 - (long) parameter2;
        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            throw new ArithmeticException("Subtracting the two parameters resulted in integer overflow");
        }
        return new BasicMathResult(parameter1, parameter2, MathOperation.SUBTRACTION, (int) result);
    }
}
