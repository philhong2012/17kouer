package com.seventeenkouer.facade;

import com.seventeenkouer.da.model.SelCourse;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by wind on 17/4/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class SelectCourseFaceImplTest extends TestCase {
    @Autowired
    SelectCourseFace selectCourseFace;
    @Test
    public void testGetById() {
        SelCourse selCourse = selectCourseFace.getById("abc");
        Assert.assertTrue(selCourse == null);
    }
}