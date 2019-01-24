package com.sh.vehiclemanagement.demo.controller;

import com.sh.base.annotation.RequestFormBody;
import com.sh.base.result.ResultConstant;
import com.sh.base.result.ResultData;
import com.sh.vehiclemanagement.demo.entity.VehicleEntity;
import com.sh.vehiclemanagement.demo.entity.form.VehicleForm;
import com.sh.vehiclemanagement.demo.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("vehicle")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    private ResultData resultData;

    @RequestMapping("insertVehicle")
    @ResponseBody
    public String insertVehicle(HttpServletRequest request){
        return "";
    }
    @RequestMapping("insertVehicleJson")
    @ResponseBody
    public String insertVehicleJson(@RequestBody VehicleForm vehicleForm){

        return "";
    }
    @RequestMapping("insertVehicleForm")
    @ResponseBody
    public ResultData insertVehicleForm(@RequestFormBody(value = "vehicleForm") VehicleForm vehicleForm,HttpServletRequest request){
        resultData =new ResultData();

        vehicleForm = (VehicleForm) request.getAttribute("vehicleForm");
        VehicleEntity entity = new VehicleEntity();
        try {
            vehicleForm.FormToEntity(entity);
            vehicleService.insert(entity);
            resultData.setState(ResultConstant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            resultData.setMsg(e.getMessage());
            resultData.setState(ResultConstant.ERROR);
        }
        return resultData;
    }



}
