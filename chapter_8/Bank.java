import org.apache.commons.lang3.builder.*;

public class Bank {
  String name;
  String address;

  public boolean equals(Object o) {
    // if (o == this) return true;
    // if (o == null) return false;
    // if (!(o instanceof Bank)) return false;
    // Bank r = (Bank) o;
    // return this.name.equals(r.name) && this.address.equals(r.address);
    // 以上のプログラムはEqualsBuilderで１行でかける
    return EqualsBuilder.reflectionEquals(this, o);
  }

  // hashCode()の省略可能
  public int hashCode() {
    return HashCodeBuilder.reflectionHashCode(this);
  }
}
