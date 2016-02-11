package com.heren.log4mnis.dao;

/**
 * <p>ProjectName:log4mnis</p>
 * <p>Description:</p>
 *
 * @author:diaozhiwei
 * @data:2016/2/11
 */
public class TestDao {
    private String id;
    private String name;
    private String deptNo;

    @Override
    public String toString() {
        return "id:" + id + "-name:" + name + "-dept_no:" + deptNo;
    }

    public TestDao() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }
}
