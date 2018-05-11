package cn.bdqn.service;

import java.util.List;

import cn.bdqn.entity.Entry;

public interface EntryService {
	//List<Entry> showAllEntryList();
	Entry findObjectById(Integer id);
	List<Entry> findEntryList(String id);
	boolean deleteObject(String id);
	boolean insertObject(Entry entry);
	boolean updateEntry(Entry entry);

}
