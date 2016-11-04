package org.feng.cms.service;

import java.util.List;

import org.feng.basic.model.Pager;
import org.feng.cms.model.ChannelTree;
import org.feng.cms.model.Group;
import org.feng.cms.model.GroupChannel;

public interface IGroupService {
	public void add(Group group);
	public void delete(int id);
	public Group load(int id);
	public void update(Group group);
	
	public List<Group> listGroup();
	public Pager<Group> findGroup();
	public void deleteGroupUsers(int gid);
	/**
	 * 添加GroupChannel对象
	 * @param gid
	 * @param cid
	 * @return: void
	 */
	public void addGroupChannel(int gid,int cid);
	/**
	 * 加载GroupChannel对象
	 * @param gid
	 * @param cid
	 * @return
	 * @return: GroupChannel
	 */
	public GroupChannel loadGroupChannel(int gid,int cid);
	/**
	 * 清空组所管理的栏目
	 * @param gid
	 * @return: void
	 */
	public void clearGroupChannel(int gid);
	/**
	 * 删除组栏目
	 * @param gid
	 * @param cid
	 * @return: void
	 */
	public void deleteGroupChannel(int gid,int cid);
	/**
	 * 获取某个组的所有管理栏目的id
	 * @param gid
	 * @return
	 * @return: List<Integer>
	 */
	public List<Integer> listGroupChannelIds(int gid);
	/**
	 * 获取某个组的栏目树
	 * @param gid
	 * @return
	 * @return: List<ChannelTree>
	 */
	public List<ChannelTree> generateGroupChannelTree(int gid);
	/**
	 * 获取某个用户的栏目树
	 * @param uid
	 * @return
	 * @return: List<ChannelTree>
	 */
	public List<ChannelTree> generateUserChannelTree(int uid);
	
}
