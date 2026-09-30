package com.appoinment.Service;

import com.appoinment.DTO.AppoinmentDTO;
import com.appoinment.Microservice.HospitalService;
import com.appoinment.Respositry.AppoinmentRepositry;
import com.appoinment.entity.Appoinment;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppoinmentServiceImpl implements AppoinmentService{

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    AppoinmentRepositry appoinmentRepositry;
    @Autowired
    HospitalService hospitalService;






    @Override
    public AppoinmentDTO add(AppoinmentDTO appoinmentDTO) {

        if ((boolean) hospitalService.getSingleHospital(appoinmentDTO.getHospitalId())) {

            Appoinment map = modelMapper.map(appoinmentDTO, Appoinment.class);

            Appoinment save = appoinmentRepositry.save(map);

            AppoinmentDTO map1 = modelMapper.map(save, AppoinmentDTO.class);

            return map1;
        }

        return null;
    }

    @Override
    public List<AppoinmentDTO> all() {
        return List.of();
    }

    @Override
    public AppoinmentDTO getSingleAppId(Long appId) {
        return null;
    }

    @Override
    public AppoinmentDTO updateApp(Long appId, AppoinmentDTO appoinmentDTO) {
        return null;
    }

    @Override
    public String deleteApp(Long appId) {
        return "";
    }
}
