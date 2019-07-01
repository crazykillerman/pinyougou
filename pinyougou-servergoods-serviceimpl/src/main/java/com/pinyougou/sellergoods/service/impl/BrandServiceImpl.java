package com.pinyougou.sellergoods.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TbAddressMapper;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.pojo.TbBrandExample;
import com.pinyougou.pojo.TbBrandExample.Criteria;
import com.pinyougou.sellergoods.service.BrandService;

import entity.PageResult;

@Service/* 为什么用dubbox的？？？？？ 因为这是web端远程调用了service*/
public class BrandServiceImpl implements BrandService {
	
	
	@Autowired
	/*本地调用*/
	private TbBrandMapper brandMapper;
	
	
	public List<TbBrand> findAll() {
		
		return brandMapper.selectByExample(null);
		
	}

	
	@Override
	/* 分页功能的实现 */
	public PageResult findPage(int pageNum, int pageSize) {
		/* 使用mybatis中的分页插件，已经在dao层引入，由于依赖dao层所以可以直接*/	
		PageHelper.startPage(pageNum, pageSize);
		/* 此page为mybatis的分页对象，获取所有数据 */
		Page<TbBrand> page = (Page<TbBrand>) brandMapper.selectByExample(null);
		/* 将需要的数据返回 */
		return new PageResult(page.getTotal(), page.getResult());
	}


	@Override
	public void add(TbBrand brand) {
		brandMapper.insert(brand);
		
	}


	@Override
	public TbBrand findOne(long ID) {
		return brandMapper.selectByPrimaryKey(ID);
	}


	@Override
	public void update(TbBrand brand) {
		brandMapper.updateByPrimaryKey(brand);
		
	}


	@Override
	public void delete(long[] ids) {
		for(long id:ids) {
			brandMapper.deleteByPrimaryKey(id);
		}
	}


	@Override
	public PageResult findPage(TbBrand brand, int pageNum, int pageSize) {
	
	
		PageHelper.startPage(pageNum, pageSize);
		TbBrandExample example=new TbBrandExample();
		Criteria criteria = example.createCriteria();
		if(brand!=null)
			if(brand.getName()!=null&&brand.getName().length()>0) {
				criteria.andNameLike("%"+brand.getName()+"%");
			}
		if(brand.getFirstChar()!=null&&brand.getFirstChar().length()>0) {
				criteria.andFirstCharLike("%"+brand.getFirstChar()+"%");
		}
		Page<TbBrand> page = (Page<TbBrand>) brandMapper.selectByExample(example);
	
		return new PageResult(page.getTotal(), page.getResult());
		
	}
	

}
