package cn.bdqn.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.bdqn.dao.EntryDao;
import cn.bdqn.entity.Entry;
import cn.bdqn.service.EntryService;

@Service
public class EntryServiceImpl implements EntryService {

	@Resource
	private EntryDao entryDao;
//	@Override
//	public List<Entry> showAllEntryList() {
//		return entryDao.getEntryList();
//	}
	@Override
	public Entry findObjectById(Integer id) {
		return entryDao.findEntryById(id);
	}

	@Override
	public List<Entry> findEntryList(String id) {
		List<Entry> list = entryDao.findCategory(id);
		return list;
	}

	@Override
	public boolean deleteObject(String id) {
		int row = entryDao.deleteObject(id);
		return row > 0;
	}

	@Override
	public boolean insertObject(Entry entry) {
		int row = entryDao.insertObject(entry);
		return row > 0;
	}

	@Override
	public boolean updateEntry(Entry entry) {
		int row = entryDao.updateEntry(entry);
		return row > 0;
	}
}
