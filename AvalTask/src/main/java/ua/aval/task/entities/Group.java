package ua.aval.task.entities;

import java.util.Objects;

public class Group {

	private Integer id;
	private String name;
	private String descr;

	public Group() {
	}

	public Group(Integer id, String name, String descr) {
		this.id = id;
		this.name = name;
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

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	@Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.name) + this.id;
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
        final Group other = (Group) obj;
        if (this.id != other.id) {
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
        return "Group: " + "id= " + id + "; Name= " + name + "; " + "; Description= " + descr + ";";
    }

}