package com.zaq.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zaq.beans.Camp;
import com.zaq.beans.Hero;
import com.zaq.mapper.HeroMapper;

@Service
public class HeroServiceImpl implements HeroService{

	@Resource
	private HeroMapper heroMapper;
	
	@Override
	public List<Hero> queryAll(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return heroMapper.queryAll(map);
	}

	@Override
	public List<Camp> queryCamp() {
		// TODO Auto-generated method stub
		return heroMapper.queryCamp();
	}

	@Override
	public int addHero(Hero hero) {
		// TODO Auto-generated method stub
		return heroMapper.addHero(hero);
	}

	@Override
	public Hero querHeroById(Integer id) {
		// TODO Auto-generated method stub
		return heroMapper.querHeroById(id);
	}

	@Override
	public void updateStauts(Integer id) {
		// TODO Auto-generated method stub
		heroMapper.updateStauts(id);
	}

}
