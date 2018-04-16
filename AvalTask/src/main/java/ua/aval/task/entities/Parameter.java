package ua.aval.task.entities;

import java.util.Objects;

public class Parameter {

	private Integer id;
	private String name;
	private String funcName;
	private String descr;

	public Parameter() {
	}

	public Parameter(Integer id, String name, String funcName, String descr) {
		this.id = id;
		this.name = name;
		this.funcName = funcName;
		this.descr = descr;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFuncName() {
		return funcName;
	}

	public void setFuncName(String funcName) {
		this.funcName = funcName;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	@Override
    public int hashCode() {
        int hash = 9;
        hash = 19 * hash + Objects.hashCode(this.name) + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Parameter other = (Parameter) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.funcName != other.funcName) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.descr, other.descr)) {
            return false;
        }
        return true;
    }

	@Override
    public String toString() {
        return "Parameter: " + "id= " + id + "; Name= " + name + "; funcName= " + funcName + "; Description= " + descr + ";";
    }

}
