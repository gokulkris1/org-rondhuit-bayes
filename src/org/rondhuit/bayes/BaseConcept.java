/*
 * This program is distributed under LGPL.
 * 
 * Source:
 * http://code.google.com/p/yooreeka/source/browse/tags/Book-final-code/tags/Final%20code%20of%20the%20book/src/iweb2/ch5/ontology/core/BaseConcept.java
 */
package org.rondhuit.bayes;

import java.util.ArrayList;
import java.util.List;

/**
 * @author babis
 *
 */
public class BaseConcept implements Concept {

	private String name;
	private Concept parent;

	private List<Instance> instances = new ArrayList<Instance>();
	
	public BaseConcept(String name) {
		this.name = name;
	}
	
	public BaseConcept(String name, Concept parent) {
		this.name = name;
		this.parent = parent;
	}

	public synchronized void addInstance(Instance i) {
		instances.add(i);
	}
	
	public Instance[] getInstances() {
		return instances.toArray(new Instance[instances.size()]);
	}

	public String getName() {
		return name;
	}

	public Concept getParent() {
		return parent;
	}
	
	public void setParent(Concept parent) {
		this.parent = parent;
	}
	
	@Override
	public String toString() {
	  StringBuilder sb = new StringBuilder();
	  sb.append("name=").append(name).append(",parent=");
	  if(parent == null) return sb.append("null").toString();
	  else return sb.append(parent.toString()).toString();
	}
	
	@Override
	public int hashCode() {
	  final int prime = 37;
	  int result = 1;
	  result = prime * result + ((name == null) ? 0 : name.hashCode());
	  result = prime * result + ((parent == null) ? 0 : parent.hashCode());
	  return result;
	}

	@Override
	public boolean equals(Object obj) {
	  if (this == obj) {
	    return true;
	  }
	  if ( !(obj instanceof BaseConcept) ) {
	    return false;
	  }
    final BaseConcept other = (BaseConcept) obj;
	  if (name == null) {
	    if (other.name != null) {
	      return false;
	    }
	  } else if (!name.equals(other.name)) {
	    return false;
	  }
	  if (parent == null) {
	    if (other.parent != null) {
	      return false;
	    }
	  } else if (!parent.equals(other.parent)) {
	    return false;
	  }
	  return true;
	}	
}
