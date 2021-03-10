package com.duobaoyu.spring.spel;

import com.duobaoyu.spring.model.User;
import com.google.common.collect.Lists;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * @author FS001338
 * @date 2020/12/22
 */
public class DefaultSpel {

    public static void main(String[] args) {
        SpelExpressionParser sp
                =new SpelExpressionParser();
//        Expression expression = sp.parseExpression("'hello world'");
//        Expression expression = sp.parseExpression("'hello world'.concat('|')");
//        Expression expression = sp.parseExpression("5*9");
//        Expression expression = sp.parseExpression("5<9");
//        Expression expression = sp.parseExpression("5<9 && 4>5");
//        Expression expression = sp.parseExpression("'aa'==null?'some value':'default'");
//        System.out.println(expression.getValue());

        User user=new User();
        user.setName("zhangsan");
        user.setAge(20);
        user.setAddress(Lists.newArrayList("aa","bb","cc"));

        StandardEvaluationContext standardEvaluationContext=new StandardEvaluationContext();
        standardEvaluationContext.setRootObject(user);
//        Expression expression = sp.parseExpression("name");
//        Expression expression = sp.parseExpression("address[0]");
        Expression expression = sp.parseExpression("run(age)");
        Object value = expression.getValue(standardEvaluationContext);
        System.out.println(value);


    }
}
