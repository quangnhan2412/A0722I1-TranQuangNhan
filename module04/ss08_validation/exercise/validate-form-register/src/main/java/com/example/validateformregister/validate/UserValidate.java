package com.example.validateformregister.validate;


import com.example.validateformregister.model.User;
import com.example.validateformregister.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

//tiêm vào để tạo bean
@Component
public class UserValidate implements Validator {

    @Autowired
    IUserService iUserService;

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
//        Ép kiểu
        if (!(target instanceof User)) {
            return;
        }
        User user = (User) target;
        if (iUserService.findById(user.getId()) != null) {
            errors.rejectValue("id", "duplicateId", new Long[]{user.getId()}, "ID bị trùng lặp");
        }
        if (user.getPhoneNumber().length() != 10) {
            errors.rejectValue("phoneNumber", "errorsNBPhone", new String[]{"10"}, "Số Điện thoại không đúng định dạng");
        } else if (!user.getPhoneNumber().startsWith("0")) {
            errors.rejectValue("phoneNumber", "phoneNBStart", "Số điện thoại không đúng định dạng VN");
        }
    }

    public IUserService getiUserService() {
        return iUserService;
    }

    public void setiUserService(IUserService iUserService) {
        this.iUserService = iUserService;
    }
}
