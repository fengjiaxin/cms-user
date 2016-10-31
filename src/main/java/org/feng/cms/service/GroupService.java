package org.feng.cms.service;

import java.util.List;

import javax.inject.Inject;

import org.feng.basic.model.Pager;
import org.feng.cms.dao.IGroupDao;
import org.feng.cms.dao.IUserDao;
import org.feng.cms.model.CmsException;
import org.feng.cms.model.Group;
import org.feng.cms.model.User;
import org.springframework.stereotype.Service;

@Service("groupService")
public class GroupService implements IGroupService{
	private IGroupDao groupDao;
	private IUserDao userDao;

	
	public IGroupDao getGroupDao() {
		return groupDao;
	}
	@Inject
	public void setGroupDao(IGroupDao groupDao) {
		this.groupDao = groupDao;
	}

	public IUserDao getUserDao() {
		return userDao;
	}
	@Inject
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void add(Group group) {
		groupDao.add(group);
	}

	@Override
	public void delete(int id) {
		List<User> users = userDao.listGroupUsers(id);
		if(users!=null&&users.size()>0) throw new CmsException("删除的组中还有用户，不能删除");
		groupDao.delete(id);
	}

	@Override
	public Group load(int id) {
		return groupDao.load(id);
	}

	@Override
	public void update(Group group) {
		groupDao.update(group);
	}

	@Override
	public List<Group> listGroup() {
		return groupDao.listGroup();
	}

	@Override
	public Pager<Group> findGroup() {
		return groupDao.findGroup();
	}

	@Override
	public void deleteGroupUsers(int gid) {
		groupDao.deleteGroupUsers(gid);
	}

}
