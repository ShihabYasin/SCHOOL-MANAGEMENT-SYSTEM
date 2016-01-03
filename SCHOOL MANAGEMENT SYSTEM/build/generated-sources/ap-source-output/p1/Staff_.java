package p1;

import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Staff.class)
public abstract class Staff_ {

	public static volatile SingularAttribute<Staff, String> post;
	public static volatile SingularAttribute<Staff, String> name;
	public static volatile SingularAttribute<Staff, BigInteger> salary;
	public static volatile SingularAttribute<Staff, String> staffId;

}

