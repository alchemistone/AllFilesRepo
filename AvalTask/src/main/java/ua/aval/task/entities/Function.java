package ua.aval.task.entities;

import java.util.Objects;

public class Function {

	private Integer id;
	private String name;
	private String groupName;
	private String descr;

	public Function() {
	}

	public Function(Integer id, String name, String groupName, String descr) {
		this.id = id;
		this.name = name;
		this.groupName = groupName;
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

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	@Override
    public int hashCode() {
        int hash = 7;
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
        final Function other = (Function) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.groupName != other.groupName) {
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
        return "Function: " + "id= " + id + "; Name= " + name + "; groupName= " + groupName + "; Description= " + descr + ";";
    }

}
