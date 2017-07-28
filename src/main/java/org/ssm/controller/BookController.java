package org.ssm.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.ssm.until.Book;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/json")
public class BookController {
    private static final Log logger = LogFactory.getLog(BookController.class);
    //@RequestMappingBody根据json数据，转换成对应的Object
    @RequestMapping(value="/testRequestBody")
    public void setJson(@RequestBody Book book, HttpServletResponse response) throws Exception{
//       使用JSONObject将book对象转换成json输出
        logger.info(JSONObject.toJSONString(book));
        book.setAuthor("杨昌敏");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print(JSONObject.toJSONString(book));
        System.out.println("调用BookController中的setJson方法"+JSONObject.toJSONString(book));
    }
}
