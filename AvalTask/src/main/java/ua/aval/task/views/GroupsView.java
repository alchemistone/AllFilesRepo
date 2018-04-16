package ua.aval.task.views;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import ua.aval.task.entities.Group;
import ua.aval.task.model.GroupsBean;

@ManagedBean(name = "dtGroupsView")
@ViewScoped
public class GroupsView implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Group> groups;

	@ManagedProperty("#{groupsBean}")
	private GroupsBean grBean;

	@PostConstruct
	public void init() {
		groups = grBean.returnGroups();
	}

	public List<Group> getGroups() {
		return groups;
	}

	public void setGrBean(GroupsBean grBean) {
		this.grBean = grBean;
	}

}