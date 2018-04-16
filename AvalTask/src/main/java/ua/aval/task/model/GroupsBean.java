package ua.aval.task.model;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import ua.aval.task.dao.GroupsDao;
import ua.aval.task.entities.Group;

@ManagedBean(name= "groupsBean")
@ApplicationScoped
public class GroupsBean {
	
	private static List<Group> groupsList = new ArrayList<Group>();
	
	public List<Group> createGroups() {
		groupsList = GroupsDao.getGroups();
		return groupsList;
	}

	public List<Group> returnGroups() {
		return groupsList;
	}

}