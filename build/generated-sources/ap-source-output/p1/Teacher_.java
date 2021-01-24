package p1;

import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Teacher.class)
public abstract class Teacher_ {

	public static volatile SingularAttribute<Teacher, String> teacherId;
	public static volatile SingularAttribute<Teacher, String> name;
	public static volatile SingularAttribute<Teacher, BigInteger> salary;

}

