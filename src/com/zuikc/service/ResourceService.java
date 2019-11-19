package com.zuikc.service;

import com.zuikc.bean.PageBean;
import com.zuikc.bean.Resource;
import com.zuikc.dao.ResourceDao;

import java.util.List;

public class ResourceService {

    //查询所有资源记录
    public List<Resource> listResource(){
        ResourceDao resourceDao = new ResourceDao();
        return resourceDao.listResource();
    }

    //分页查询所有资源
    public PageBean<Resource> pageListResource(int pageNum){
        int pageSize=10;  //每页几条数据
        int start=(pageNum-1)*pageSize;
        ResourceDao resourceDao =new ResourceDao();
        List<Resource> resources= resourceDao.pageListResource(start,pageSize);
        int totalCount=resourceDao.findCount();
        int totalPageNum=(totalCount+pageSize-1)/pageSize;

        PageBean<Resource> resourcePageBean=new PageBean<Resource>();
        resourcePageBean.setPageNum(pageNum);
        resourcePageBean.setPageSize(pageSize);
        resourcePageBean.setTotalCount(totalCount);
        resourcePageBean.setTotalPageNum(totalPageNum);
        resourcePageBean.setBeanList(resources);

        return resourcePageBean;
    }

    //按条件分页查询资源
    public PageBean<Resource> resourceConditionQuery(String conditionName,String conditionValue,int pageNum){
        int pageSize=10; //每页几条数据
        int start=(pageNum-1)*pageSize;
        ResourceDao resourceDao =new ResourceDao();

        List<Resource> resources=resourceDao.resourceConditionQuery(conditionName,conditionValue,start,pageSize);
        int totalCount=resourceDao.findCount(conditionName,conditionValue);
        int totalPageNum=(totalCount+pageSize-1)/pageSize;
        PageBean<Resource> resourcePageBean=new PageBean<Resource>();
        resourcePageBean.setPageNum(pageNum);
        resourcePageBean.setPageSize(pageSize);
        resourcePageBean.setTotalCount(totalCount);
        resourcePageBean.setTotalPageNum(totalPageNum);
        resourcePageBean.setBeanList(resources);

        return resourcePageBean;
    }

    //根据id批量更改资源的状态
    public void changeResourceStatus(String[] ids,String status) {
        ResourceDao resourceDao = new ResourceDao();
        resourceDao.changeResourceStatus(ids,status);
    }

    //添加资源
    public int addResource(Resource resource) {
        ResourceDao resourceDao = new ResourceDao();
        return resourceDao.addResource(resource);
    }

    //根据id查资源信息
    public Resource showResource(String resource_id) {
        ResourceDao resourceDao = new ResourceDao();
        return resourceDao.showResource(resource_id);
    }

    //根据id改资源信息
    public int editResource(Resource resource){
        ResourceDao resourceDao =new ResourceDao();
        return resourceDao.editResource(resource);
    }

    //根据id删除资源信息
    public int delResource(String resource_id) {
        ResourceDao resourceDao = new ResourceDao();
        return resourceDao.delResource(resource_id);
    }
}
