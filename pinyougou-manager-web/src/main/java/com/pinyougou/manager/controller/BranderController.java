package com.pinyougou.manager.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;

import entity.PageResult;
import entity.Result;

@RestController
@RequestMapping("/brand")
public class BranderController {

	@Reference
	private BrandService brandservice;

	@RequestMapping("/findAll")
	public List<TbBrand> findAll() {
		Map map=new HashMap<>();
		return brandservice.findAll();
	}

	@RequestMapping("/findPage")
	public PageResult findPage(int page, int size) {
		return brandservice.findPage(page, size);
	}

	@RequestMapping("/add")
	public Result add(@RequestBody TbBrand brand) {
		try {
			brandservice.add(brand);
			return new Result(true, "添加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "添加失败");
		}
	}

	@RequestMapping("/findOne")
	public TbBrand findOne(long id) {
		return brandservice.findOne(id);
	}
	
	@RequestMapping("/update")
	public Result update(@RequestBody TbBrand brand) {
		try {
			brandservice.update(brand);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "修改失败");
		}
	}
	
	@RequestMapping("/delete")
	public Result delete(long[] ids) {
		try {
			brandservice.delete(ids);
			return new Result(true, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
	
	@RequestMapping("/search")
	public PageResult search(@RequestBody TbBrand brand, int page, int size) {
	
		return	brandservice.findPage(brand, page, size);
		
	}
}
