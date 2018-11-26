package com.hnyhgw;

/**
 * @创建时间 2018/11/10
 * @描述
 */

import com.hnyhgw.entity.ArticleContentEntity;
import com.hnyhgw.service.ArticleContentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=SpringBootShiroApplication.class)
@WebAppConfiguration
public class SpringBootJdbcTest {

    @Autowired
    private ArticleContentService articleContentService;

    @Test
    public void testRepository(){
        ArticleContentEntity articleContentEntity = articleContentService.findById("134");
        if(articleContentEntity != null){
            System.out.println(articleContentEntity.getTitleName());
        }else{
            System.out.println("xxxxx");
        }
    }
}
