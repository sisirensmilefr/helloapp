package domainapp.dom.impl;

import java.io.Serializable;
import java.util.StringTokenizer;

public class VehicleProductId implements Serializable {
	public VehicleObject vehicle;
	public ProductObject product;

	public VehicleProductId() {
	}

	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof VehicleProductId)) {
			return false;
		}
		VehicleProductId c = (VehicleProductId) obj;

		return vehicle.equals(c.vehicle) && product.equals(c.product);
	}

	public int hashCode() {
		return this.vehicle.hashCode() ^ this.product.hashCode();
	}

	public String toString() {
		// Give output expected by String constructor
		return this.getClass().getName() + "::" + this.vehicle + "::" + this.product;
	}
}