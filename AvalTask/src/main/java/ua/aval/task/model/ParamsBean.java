package ua.aval.task.model;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import ua.aval.task.dao.ParamsDao;
import ua.aval.task.entities.Parameter;


@ManagedBean(name= "paramsBean")
@ApplicationScoped
public class ParamsBean {

	private List<Parameter> filteredParamsList = new ArrayList<Parameter>();
	private List<Parameter> paramsList = null;

	public List<Parameter> createParams() {
		paramsList = ParamsDao.getParameters();
		return paramsList;
	}

	public List<Parameter> returnFilteredParams() {
		return filteredParamsList;
	}

	public void refreshFilter () {
		filteredParamsList.clear();
	}

	public void doFilterParams (String currentFuncName) {
		if (paramsList != null) { 
			for(Parameter p : paramsList) {
				if (p.getFuncName().equals(currentFuncName)) {
					filteredParamsList.add(p);
				}
			}
		}
	}

}