module database {
    requires org.hibernate.orm.core;
    requires java.persistence;
    requires java.xml;
    requires java.naming;
    requires util;
    exports de.kessel.services;
    exports de.kessel.entities;
}
