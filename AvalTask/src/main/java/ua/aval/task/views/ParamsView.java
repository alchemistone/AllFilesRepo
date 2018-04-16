package ua.aval.task.views;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import ua.aval.task.entities.Parameter;
import ua.aval.task.model.ParamsBean;

@ManagedBean(name = "dtParamsView")
@ViewScoped
public class ParamsView implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Parameter> params;

	@ManagedProperty("#{paramsBean}")
	private ParamsBean prBean;

	@PostConstruct
	public void init() {
		params = prBean.createParams();
	}

	public List<Parameter> getParams() {
		return params;
	}

	public void setPrBean(ParamsBean prBean) {
		this.prBean = prBean;
	}

}