package ua.aval.task.model;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import ua.aval.task.dao.FuncsDao;
import ua.aval.task.entities.Function;

@ManagedBean(name= "funcsBean")
@ApplicationScoped
public class FuncsBean {

	private List<Function> filteredFuncsList = new ArrayList<Function>();
	private List<Function> funcsList = null;

	public List<Function> createFuncs() {
		funcsList = FuncsDao.getFunctions();
		return funcsList;
	}

	public List<Function> returnFilteredFuncs() {
		return filteredFuncsList;
	}

	public void refreshFilter () {
		filteredFuncsList.clear();
	}

	public void doFilterFuncs(String currentGroupName) {	
		if (funcsList != null) {
			for(Function f : funcsList) {
				if (f.getGroupName().equals(currentGroupName)) {
					filteredFuncsList.add(f);
				}
			}
		}
    }

}