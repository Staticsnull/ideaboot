package cn.bdqn.controller;

import cn.bdqn.entity.Category;
import cn.bdqn.entity.Entry;
import cn.bdqn.service.CategoryService;
import cn.bdqn.service.EntryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class CategoryController /*extends BaseController*/ {
	private Logger logger = LoggerFactory.getLogger(CategoryController.class);
	@Resource
	private CategoryService categoryService;
	@Resource
	private EntryService entryService;
	@RequestMapping("getCategoryList")
	@ResponseBody
	public List<Category> getCategoryList(){
		logger.info("getCategoryList===>");
		List<Category> list = categoryService.getCategoryList() ;
		return list;
	}
	@RequestMapping("findCategorys")
	@ResponseBody
	public List<Entry> findCategorys(String id,Model model){
		List<Entry> entryList = entryService.findEntryList(id);
		model.addAttribute("entryList", entryList);
		return entryList;
	}

	@RequestMapping("findCategory")
	//@ResponseBody
	public String findCategory(String id,Model model){
		List<Entry> entryList = entryService.findEntryList(id);
		model.addAttribute("entryList", entryList);
		return "list";
	}

}
