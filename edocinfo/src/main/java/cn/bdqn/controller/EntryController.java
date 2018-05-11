package cn.bdqn.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import cn.bdqn.entity.Category;
import cn.bdqn.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import cn.bdqn.entity.Entry;
import cn.bdqn.service.EntryService;

@Controller
public class EntryController /*extends BaseController*/ {
	private Logger logger = LoggerFactory.getLogger(EntryController.class);
	@Resource
	private EntryService entryService;
	@Resource
	private CategoryService categoryService;

	@RequestMapping("list")
	public String list(@RequestParam(value = "id",required = false)
						String	id , Model model){
		List<Entry> entryList = entryService.findEntryList(id);
		model.addAttribute("entryList", entryList);
		return "list";
	}
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String update(@RequestParam("eId") String eId,Model model){
		logger.info("id:"+eId);
		Entry entry = entryService.findObjectById(Integer.parseInt(eId));
		model.addAttribute("entry", entry);
		return "modify";
	}
	@RequestMapping("/toAdd")
	public String toAdd(){
		return "add";
	}

	@RequestMapping("/add")
	public String add(Entry entry) {
		String name = entry.getTitle();
		logger.info("name===="+name);
		Integer id = categoryService.findIdByName(name);
		if (id != null) {
			entry.setCategoryId(id);
			logger.info("id=="+entry.getCategoryId());
			boolean flag = entryService.insertObject(entry);
			if (flag) {
				return "redirect:/list";
			} else {
				return "add";
			}
		} else {
			Category category = new Category();
			category.setName(name);
			boolean flag = categoryService.add(category);
			if (flag) {
				entry.setCategoryId(category.getId());
				boolean flags = entryService.insertObject(entry);
				if (flags) {
					return "redirect:/list";
				} else {
					return "add";
				}
			}
		}
		return "add";
	}
	@RequestMapping("/toUpdate")
    public String toUpdate(Entry entry){
	    logger.info("id===="+entry.getId());
		Category category = new Category();
		category.setId(entry.getCategoryId());
		category.setName(entry.getTitle());
		boolean flagCate = categoryService.updateCategory(category);
		boolean flagEntry = entryService.updateEntry(entry);
		if (flagCate && flagEntry){
			return "redirect:/list";
		}
		return "modify";
    }



	@RequestMapping("/deleteEntry")
	@ResponseBody
	public Map<String,Object> deleteEntry(String id){
		Map<String,Object> result = new HashMap<>();
		boolean flag = entryService.deleteObject(id);
		if (flag){
			result.put("OK","true");
		}else {
			result.put("OK","false");
		}
		return result;
	}


}
