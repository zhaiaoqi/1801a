package com.zaq.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zaq.beans.Camp;
import com.zaq.beans.Hero;
import com.zaq.service.HeroService;

@Controller
public class HeroController {
	
	@Resource
	private HeroService hs;
	
	@RequestMapping("queryAll")
	public String list(@RequestParam(defaultValue="1")Integer pageNum,Model model,Integer cid,Integer stauts,Double startPrice,Double endPrice){
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cid", cid);
		map.put("stauts", stauts);
		map.put("startPrice", startPrice);
		map.put("endPrice", endPrice);
		
		PageHelper.startPage(pageNum, 3);
		
		List<Hero> list = hs.queryAll(map);
		
		PageInfo<Hero> page = new PageInfo<>(list);
		model.addAttribute("page", page);
		
		List<Camp> clist = hs.queryCamp();
		model.addAttribute("clist", clist);
		
		model.addAttribute("map", map);
		
		return "list";
		
	}
	
	@RequestMapping("queryCamp")
	@ResponseBody
	public List<Camp> queryCamp(){
		
		List<Camp> clist = hs.queryCamp();
		
		
		return clist;
		
	}
	
	
	@RequestMapping("add")
	public String add(Hero hero){
		
		int x = hs.addHero(hero);
		if(x>0){
			return "forward:queryAll";
		}else{
		return "add";
		}
	}
	
	@RequestMapping("queryHeroById")
	public String queryHeroById(Integer id, Model model){
		
		Hero hero = hs.querHeroById(id);
		
		model.addAttribute("hero", hero);
		
		return "show";
	
	}
	
	@RequestMapping("updateStatus")
	@ResponseBody
	public boolean updateStatus(Integer id){
		try {
			hs.updateStauts(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
	
	
	
	
	
	
	
	

}
