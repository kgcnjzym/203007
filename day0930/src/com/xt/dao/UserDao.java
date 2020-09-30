package com.xt.dao;
/**
 * User的数据访问层
 * @author  杨卫兵
 * @version  [V1.00, 2020年9月30日]
 * @since V1.00
 */
public interface UserDao
{
    int add();
    int delete();
    int update();
    /**
     * 默认方法：实现类可以不用给出实现
     * @return
     */
    default int select() {
        return 0;
    }
}
