package com.lxl.BeanCopy;

import net.sf.cglib.beans.BeanCopier;

/**
 * @author 刘晓亮
 * @date 2020/11/13 17:26
 */
public class Test {
    public static void main(String[] args) {
        // create(Class source, Class target, boolean useConverter)
        final BeanCopier beanCopier = BeanCopier.create(User.class, UserDto.class, false);
        User user = new User();
        user.setAge(10);
        user.setName("zhangsan");
        UserDto userDto = new UserDto();
        beanCopier.copy(user, userDto, null);
        System.out.println(user);
        System.out.println(userDto);
    }
}
