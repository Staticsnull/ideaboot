package cn.bdqn.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.bdqn.entity.Entry;
@Mapper
public interface EntryDao {
	List<Entry> getEntryList();
	Entry findEntryById(@Param("id") Integer id);
	List<Entry> findCategory(@Param("id") String id);
	int deleteObject(@Param("id") String id);
	int insertObject(Entry entry);
	int updateEntry(Entry entry);

}
