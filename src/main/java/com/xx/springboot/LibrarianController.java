package com.xx.springboot;

import com.xx.springboot.entity.Librarian;
import com.xx.springboot.entity.User;
import com.xx.springboot.service.LibrarianService;
import com.xx.springboot.service.UserService;
import org.apache.catalina.connector.Request;
import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.util.List;

@RestController
public class LibrarianController {

    @Autowired
    private LibrarianService librarianService;
    @Autowired
    private UserService userService;

    @RequestMapping("/li")
    public List<User> getALibrarianInfo() {
        //System.out.println("test :id: "+id);
        //new HttpRequest().
        //HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        List<User> userList = userService.selectAll();

        for (User user : userList) {
            //校验字符方法
            new verify().btyeVerify(user);
        }

        return userList;
    }

    /**
     * 校验字符是否为空，字符长度
     * @param <T>
     */
    class verify<T> {
        public String btyeVerify(T t) {
            String code = "";
            try {
                Field[] fields = t.getClass().getDeclaredFields();
                for (Field field : fields) {
                    //field.getAnnotations();
                    //设置校验类的属性可达，不然会抛出IllegalAccessException异常
                    field.setAccessible(true);
                    Object value = field.get(t);
                    if (null != value && value instanceof String) {
                        System.out.println(value.toString().length());
                    }else{
                        code = "值存在为空或者超出字符长度。";
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return code;
        }
    }
}