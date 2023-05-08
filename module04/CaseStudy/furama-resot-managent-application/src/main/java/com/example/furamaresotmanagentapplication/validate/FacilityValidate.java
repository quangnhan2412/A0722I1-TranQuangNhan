//package com.example.furamaresotmanagentapplication.validate;
//
//import com.example.furamaresotmanagentapplication.entity.facility.Facility;
//import com.example.furamaresotmanagentapplication.service.facility.FacilityService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.validation.Errors;
//import org.springframework.validation.Validator;
//
//@Component
//public class FacilityValidate implements Validator {
//    @Autowired
//    private FacilityService facilityService;
//
//    @Override
//    public boolean supports(Class<?> clazz) {
//        return Facility.class.isAssignableFrom(clazz);
//    }
//
//    @Override
//    public void validate(Object target, Errors errors) {
//        if (!(target instanceof Facility)) {
//            return;
//        }
//        Facility facility = (Facility) target;
//if(facilityService.findById(facility.getId()) != null){
//errors
//}
//
//    }
//}
