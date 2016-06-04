package com.example.user.myapp2.calc;

import android.app.Activity;
import android.os.Bundle;

import com.example.user.myapp2.R;

public class CalcServiceImpl implements CalcService {

    @Override
    public int getPlusResult(int firstInput, int secondInput) {
        return  firstInput + secondInput;
    }

    @Override
    public int getSubsResult(int firstInput, int secondInput) {
        return firstInput - secondInput;
    }

    @Override
    public int getMultResult(int firstInput, int secondInput) {
        return firstInput * secondInput;
    }

    @Override
    public int getDivdResult(int firstInput, int secondInput) {
        if (firstInput == 0 || secondInput == 0){
            return 0;
        } else {
            return firstInput / secondInput;
        }
    }

    @Override
    public int getModResult(int firstInput, int secondInput) {
        if (firstInput == 0 || secondInput == 0){
            return 0;
        } else {
            return firstInput % secondInput;
        }
    }
}
