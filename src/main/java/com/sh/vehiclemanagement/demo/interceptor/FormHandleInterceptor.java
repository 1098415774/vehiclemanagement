package com.sh.vehiclemanagement.demo.interceptor;
import com.sh.base.annotation.RequestFormBody;
import com.sh.base.form.BaseForm;
import com.sh.base.utils.StringUtils;
import com.sh.vehiclemanagement.demo.entity.form.VehicleForm;
import org.apache.log4j.Logger;
import org.springframework.core.MethodParameter;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class FormHandleInterceptor implements HandlerInterceptor {

    private static Logger logger = Logger.getLogger(FormHandleInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        HandlerMethod method = (HandlerMethod) handler;
        MethodParameter[] parameters = method.getMethodParameters();
        for (MethodParameter parameter : parameters){
            RequestFormBody requestFormBody = parameter.getParameterAnnotation(RequestFormBody.class);
            if (requestFormBody == null || !requestFormBody.required()){
                continue;
            }
            BaseForm baseForm = packForm(request,parameter.getParameter().getType());
            request.setAttribute(requestFormBody.value(),baseForm);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {


    }

    private BaseForm packForm(HttpServletRequest request, Class<?> formClass) {
        BaseForm baseForm = null;
        try {
            baseForm = (BaseForm) formClass.newInstance();
            Field[] fields = formClass.getDeclaredFields();
            for (Field field : fields){
                String param = request.getParameter(field.getName());
                logger.debug(field.getName() + " ----- " + field.getType());
                Object value = StringUtils.convertToOtherType(param,field.getType());
                char[] names = field.getName().toCharArray();
                if (!Character.isUpperCase(names[0])){
                    names[0]-=32;
                }
                String name = String.valueOf(names);
                formClass.getDeclaredMethod("set" + name,field.getType()).invoke(baseForm,value);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return baseForm;
    }


}
