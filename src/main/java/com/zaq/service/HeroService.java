package com.zaq.service;

import java.util.List;
import java.util.Map;

import com.zaq.beans.Camp;
import com.zaq.beans.Hero;

public interface HeroService {
	
	
	//列表
		public List<Hero> queryAll(Map<String, Object> map);
		
		public List<Camp> queryCamp();
		//添加
		public int addHero(Hero hero);
		
		
		public Hero querHeroById(Integer id);
		
		public void updateStauts(Integer id);

}
