/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * Copyright (c) 2008, Red Hat Middleware LLC or third-party contributors as
 * indicated by the @author tags or express copyright attribution
 * statements applied by the authors.  All third-party contributions are
 * distributed under license by Red Hat Middleware LLC.
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to:
 * Free Software Foundation, Inc.
 * 51 Franklin Street, Fifth Floor
 * Boston, MA  02110-1301  USA
 *
 */
package org.hibernate.usertype;

import java.util.Comparator;

import org.hibernate.engine.SessionImplementor;

/**
 * A user type that may be used for a version property
 * 
 * @author Gavin King
 */
public interface UserVersionType extends UserType, Comparator {
	/**
	 * Generate an initial version.
	 *
	 * @param session The session from which this request originates.  May be
	 * null; currently this only happens during startup when trying to determine
	 * the "unsaved value" of entities.
	 * @return an instance of the type
	 */
	public Object seed(SessionImplementor session);
	/**
	 * Increment the version.
	 *
	 * @param session The session from which this request originates.
	 * @param current the current version
	 * @return an instance of the type
	 */
	public Object next(Object current, SessionImplementor session);

}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                /*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * Copyright (c) 2008, Red Hat Middleware LLC or third-party contributors as
 * indicated by the @author tags or express copyright attribution
 * statements applied by the authors.  All third-party contributions are
 * distributed under license by Red Hat Middleware LLC.
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to:
 * Free Software Foundation, Inc.
 * 51 Franklin Street, Fifth Floor
 * Boston, MA  02110-1301  USA
 *
 */
package org.hibernate.usertype;

import java.util.Iterator;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.collection.PersistentCollection;
import org.hibernate.engine.SessionImplementor;
import org.hibernate.persister.collection.CollectionPersister;

/**
 * A custom type for mapping user-written classes that implement <tt>PersistentCollection</tt>
 * 
 * @see org.hibernate.collection.PersistentCollection
 * @author Gavin King
 */
public interface UserCollectionType {
	
	/**
	 * Instantiate an uninitialized instance of the collection wrapper
	 */
	public PersistentCollection instantiate(SessionImplementor session, CollectionPersister persister) 
	throws HibernateException;
	
	/**
	 * Wrap an instance of a collection
	 */
	public PersistentCollection wrap(SessionImplementor session, Object collection);
	
	/**
	 * Return an iterator over the elements of this collection - the passed collection
	 * instance may or may not be a wrapper
	 */
	public Iterator getElementsIterator(Object collection);

	/**
	 * Optional operation. Does the collection contain the entity instance?
	 */
	public boolean contains(Object collection, Object entity);
	/**
	 * Optional operation. Return the index of the entity in the collection.
	 */
	public Object indexOf(Object collection, Object entity);
	
	/**
	 * Replace the elements of a collection with the elements of another collection
	 */
	public Object replaceElements(
			Object original, 
			Object target, 
			CollectionPersister persister, 
			Object owner, 
			Map copyCache, 
			SessionImplementor session)
			throws HibernateException;

	/**
	 * Instantiate an empty instance of the "underlying" collection (not a wrapper),
	 * but with the given anticipated size (i.e. accounting for initial size
	 * and perhaps load factor).
	 *
	 * @param anticipatedSize The anticipated size of the instaniated collection
	 * after we are done populating it.  Note, may be negative to indicate that
	 * we not yet know anything about the anticipated size (i.e., when initializing
	 * from a result set row by row).
	 */
	public Object instantiate(int anticipatedSize);
	
}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            INDX( 	 +?2            (     ?         r                   $?     ? n     #?     P??P? )s!L?????B??-?????                       C o m p o s i t e U s e r T y p e . j a v a   %?     ? l     #?     <a??P? )s!L?????B???????       ?               E n h a n c e d U s e r T y p e . j a v a     &?     ? l     #?     1???P? )s!L???s?B???????       ?               L o g g a b l e U s e r T y p e . j a v a     '?     p Z     #?     ????P? )s!L?????B??4i}???      ?               p a c k a g e . h t m l       (?     ? n     #?     L??P? )s!L???s?B??s+????       f               P a r a m e t e r i z e d T y p e . j a v a   )?     ? p     #?     ?q??P? )s!L?????B???????       ?               U s e r C o l l e c t i o n T y p e . j a v a *?     p \     #?     ????P? )s!L?????B??s+????        P               U s e r T y p e . j a v a     +?     ? j     #?     ?4??P? )s!L????B??s+????       p               U s e r V e  s i o n T y p e . j a v a                                                                                                                                                                                                                                                                                                                                               