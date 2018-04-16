package ua.aval.task.views;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.event.CloseEvent;

import ua.aval.task.entities.Group;
import ua.aval.task.model.GroupsBean;
import ua.aval.task.entities.Function;
import ua.aval.task.model.FuncsBean;
import ua.aval.task.entities.Parameter;
import ua.aval.task.model.ParamsBean;

@ManagedBean(name = "dtValidationView")
@ViewScoped
public class ValidationView implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Group> groups = new ArrayList<Group>();
	private List<Function> funcs = new ArrayList<Function>();
	private List<Parameter> params = new ArrayList<Parameter>();

	@ManagedProperty("#{groupsBean}")
	private GroupsBean grBean;
	
	@ManagedProperty("#{funcsBean}")
	private FuncsBean funBean;

	@ManagedProperty("#{paramsBean}")
	private ParamsBean parBean;

	@PostConstruct
	public void init() {
		funBean.refreshFilter();
		parBean.refreshFilter();
		groups = grBean.createGroups();
		funcs = funBean.returnFilteredFuncs();
		params = parBean.returnFilteredParams();
	}

	public void onGroupSelect (SelectEvent event) {
		String currentGroupName = ((Group) event.getObject()).getName();
		funBean.refreshFilter();
		parBean.refreshFilter();
		funBean.doFilterFuncs(currentGroupName);
	}

	public void onGroupUnselect (UnselectEvent event) {
		funBean.refreshFilter();
		parBean.refreshFilter();
	}

	public void onFuncSelect (SelectEvent event) {
		String currentFuncName = ((Function) event.getObject()).getName();
		parBean.refreshFilter();
		parBean.doFilterParams(currentFuncName);
	}

	public void onFuncUnselect (UnselectEvent event) {
		parBean.refreshFilter();
	}

	public void onLoad (CloseEvent event) {
		funBean.refreshFilter();
		parBean.refreshFilter();
	}

	public void setGrBean(GroupsBean grBean) {
		this.grBean = grBean;
	}

	public void setFunBean(FuncsBean funBean) {
		this.funBean = funBean;
	}

	public void setParBean(ParamsBean parBean) {
		this.parBean = parBean;
	}

	public List<Group> getGroups() {
		return groups;
	}

	public List<Function> getFuncs() {
		return funcs;
	}

	public List<Parameter> getParams() {
		return params;
	}

}