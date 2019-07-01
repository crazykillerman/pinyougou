package com.pinyougou.sellergoods.service;

import java.util.List;

import com.pinyougou.pojo.TbBrand;

import entity.PageResult;


/*品牌接口*/
public interface BrandService {
	public List<TbBrand> findAll();

	/* 分页方法 */
	public PageResult findPage(int pageNum,int pageSize);
	
	
	/**
	 * 增加商品方法
	 * @param brand
	 */
	public void add(TbBrand brand);
	
	/**
	 * @根据ID查询实体
	 * @return
	 */
	public TbBrand findOne(long ID);
	
	/**
	 * @param 将修改后的数据存进数据库
	 */
	public void update(TbBrand brand);
	
	/**批量删除
	 * @param ids
	 */
	public void delete(long[] ids);

	/* 条件查询 */
	public PageResult findPage(TbBrand brand, int pageNum,int pageSize);
}


