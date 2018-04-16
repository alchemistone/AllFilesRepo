package ua.aval.task.views;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import ua.aval.task.entities.Function;
import ua.aval.task.model.FuncsBean;

@ManagedBean(name = "dtFuncsView")
@ViewScoped
public class FuncsView implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Function> funcs;

	@ManagedProperty("#{funcsBean}")
	private FuncsBean fnBean;

	@PostConstruct
	public void init() {
		funcs = fnBean.createFuncs();
	}

	public List<Function> getFuncs() {
		return funcs;
	}

	public void setFnBean(FuncsBean fnBean) {
		this.fnBean = fnBean;
	}

}