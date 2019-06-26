package com.youle.item.web;

import com.youle.item.pojo.SpecGroup;
import com.youle.item.pojo.SpecParam;
import com.youle.item.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 规格组及参数controller
 * @author xw
 * @date 2019/6/5 10:47
 */
@RestController
@RequestMapping("spec")
public class SpecificationController {

    @Autowired
    private SpecificationService specificationService;

    /**
     * 根据分类查询规格组
     * @param cid
     * @return
     */
    @GetMapping("/groups/{cid}")
    public ResponseEntity<List<SpecGroup>> querySpecGroup(@PathVariable("cid")Long cid){
        return ResponseEntity.ok(specificationService.querySpecGroup(cid));
    }

    @PostMapping("group")
    public ResponseEntity<Void> saevSpecGroup(@RequestBody SpecGroup specGroup){
        specificationService.saveSpecGroup(specGroup);
//        System.out.println(json);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping("group")
    public ResponseEntity<Void> updateSpecGroup(@RequestBody SpecGroup specGroup){
        specificationService.saveSpecGroup(specGroup);
//        System.out.println(json);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("group/{id}")
    public ResponseEntity<Void> deleteSpecGroup(@PathVariable("id")Long id){
        specificationService.deleteSpecGroup(id);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * 根据组id查询参数
     * @param gid
     * @return
     */
    @GetMapping("params")
    public ResponseEntity<List<SpecParam>> queryParamByGid(@RequestParam("gid")Long gid){
        return ResponseEntity.ok(specificationService.querySpecParamByGid(gid));
    }

    @PostMapping("param")
    public ResponseEntity<Void> saveSpecParam(@RequestBody SpecParam specParam){
        specificationService.saveSpecParam(specParam);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("param")
    public ResponseEntity<Void> updateSpecParam(@RequestBody SpecParam specParam){
        specificationService.saveSpecParam(specParam);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("param/{id}")
    public ResponseEntity<Void> deleteSpecParam(@PathVariable("id")Long id){
        specificationService.deleteSpecParam(id);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
