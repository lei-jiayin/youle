package com.youle.item.service;

import com.youle.common.enums.ExceptionEnums;
import com.youle.common.exception.YlException;
import com.youle.item.mapper.SpecGroupMapper;
import com.youle.item.mapper.SpecParamMapper;
import com.youle.item.pojo.SpecGroup;
import com.youle.item.pojo.SpecParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 规格组及参数service
 * @author xw
 * @date 2019/6/5 10:46
 */
@Service
public class SpecificationService {

    @Autowired
    private SpecGroupMapper specGroupMapper;
    @Autowired
    private SpecParamMapper specParamMapper;

    public List<SpecGroup> querySpecGroup(Long cid) {
        SpecGroup specGroup = new SpecGroup();
        specGroup.setCid(cid);
        List<SpecGroup> specGroups = specGroupMapper.select(specGroup);
        if (CollectionUtils.isEmpty(specGroups)){
            // 抛出异常
            throw new YlException(ExceptionEnums.SPEC_GROUP_NOT_FOUND);
        }
        return specGroups;
    }

    public List<SpecParam> querySpecParamByGid(Long gid) {
        SpecParam specParam = new SpecParam();
        specParam.setGroupId(gid);
        List<SpecParam> sp = specParamMapper.select(specParam);
        if (CollectionUtils.isEmpty(sp)){
            throw new YlException(ExceptionEnums.SPEC_PARAM_NOT_FOUND);
        }
        return sp;
    }

    public void saveSpecGroup(SpecGroup specGroup) {
        if (specGroup.getId() != null){
            specGroupMapper.updateByPrimaryKeySelective(specGroup);
        }else {
            specGroupMapper.insertSelective(specGroup);
        }
    }

    public void deleteSpecGroup(Long id) {
        SpecGroup specGroup = new SpecGroup();
        specGroup.setId(id);
        specGroupMapper.delete(specGroup);
    }

    public void saveSpecParam(SpecParam specParam) {
        if (specParam.getId() != null){
            specParamMapper.updateByPrimaryKeySelective(specParam);
        }else {
            specParamMapper.insertSelective(specParam);
        }
    }

    public void deleteSpecParam(Long id) {
        SpecParam specParam = new SpecParam();
        specParam.setId(id);
        specParamMapper.deleteByPrimaryKey(specParam);
    }
}
