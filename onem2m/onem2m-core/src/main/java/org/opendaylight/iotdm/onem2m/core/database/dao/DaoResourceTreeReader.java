/*
 * Copyright (c) 2015 Cisco Systems, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.iotdm.onem2m.core.database.dao;

import java.util.List;
import org.opendaylight.iotdm.onem2m.core.database.transactionCore.Onem2mResourceElem;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.iotdm.onem2m.rev150105.Onem2mCseList;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.iotdm.onem2m.rev150105.Onem2mResourceTree;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.iotdm.onem2m.rev150105.onem2m.cse.list.Onem2mCse;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.iotdm.onem2m.rev150105.onem2m.cse.list.Onem2mCseKey;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.iotdm.onem2m.rev150105.onem2m.resource.tree.Onem2mResourceKey;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.iotdm.onem2m.rev150105.onem2m.resource.tree
        .onem2m.parent.child.list.Onem2mParentChild;
import org.opendaylight.yang.gen.v1.urn.opendaylight.params.xml.ns.yang.iotdm.onem2m.rev150105.onem2m.resource.tree
        .Onem2mParentChildListKey;

import java.io.Closeable;

/**
 * Created by gguliash on 5/20/16.
 */
public interface DaoResourceTreeReader extends Closeable {
    /**
     *
     * @param key name of the CSE element
     * @return Cse element
     */
    Onem2mCse retrieveCseByName(Onem2mCseKey key);

    /**
     *
     * @param key id of the Resource element
     * @return Resource element
     */
    Onem2mResourceElem retrieveResourceById(Onem2mResourceKey key);

    /**
     *
     * @param key id of the Resource element
     * @return childList list of resources
     */
    List<Onem2mParentChild> retrieveParentChildList(Onem2mParentChildListKey key);

    /**
     * Retrieve list of child resource data of specific parent resource
     * @param key Key identifying the parent resource
     * @param limit Number of child resource data items to be returned
     * @return  List including child resource data
     */
    List<Onem2mParentChild> retrieveParentChildListLimitN(Onem2mParentChildListKey key, int limit);


    /**
     * Retrieve child of parent resource.
     * @param resourceId ResourceId of the parent resource
     * @param name ResourceName of the child resource
     * @return Child resource data
     */
    Onem2mParentChild retrieveChildByName(String resourceId, String name);

    /**
     *
     * @return all existing CSE elements
     */
    Onem2mCseList retrieveFullCseList();

    /**
     *
     * @return all existing Resource elements
     */
    Onem2mResourceTree retrieveFullResourceList();

    /**
     * Retrieve the resourceID of the AE by its AE-ID.
     * @param cseBaseName The name of cseBase.
     * @param aeId The AE-ID of the AE.
     * @return resourceID of the AE
     */
    String retrieveAeResourceIdByAeId(String cseBaseName, String aeId);

    /**
     * Checks whether the entity specified by the entityId is registered at the cseBase.
     * Returns type of entity as Onem2m resource type string if the entity is registered
     * as AE or remoteCSE.
     * @param entityId The ID of entity (CSE-ID or AE-ID)
     * @param cseBaseCseId CSE-ID of the cseBase
     * @return AE resource type or remoteCSE resource type if the entity is registered, null otherwise
     */
    Integer isEntityRegistered(String entityId, String cseBaseCseId);

    /**
     * Returns the last used resourceId stored in data store.
     * @return The last used resourceId
     */
    int retrieveSystemStartId();
}
