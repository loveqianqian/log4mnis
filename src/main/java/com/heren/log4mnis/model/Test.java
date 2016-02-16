package com.heren.log4mnis.model;

/**
 * <p>ProjectName:log4mnis</p>
 * <p>Description:emp测试</p>
 *
 * @author:diaozhiwei
 * @data:2016/2/11
 */
public class Test {
    private int id;
    private String name;
    private int deptNo;

    @Override
    public String toString() {
        return "id:" + id + "-name:" + name + "-dept_no:" + deptNo;
    }

    public Test() {
    }

    public Test(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(int deptNo) {
        this.deptNo = deptNo;
    }
}
