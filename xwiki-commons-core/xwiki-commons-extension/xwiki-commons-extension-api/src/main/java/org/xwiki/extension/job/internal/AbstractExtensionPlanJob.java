/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.xwiki.extension.job.internal;

import org.xwiki.extension.job.ExtensionRequest;
import org.xwiki.extension.job.internal.AbstractInstallPlanJob.ModifableExtensionPlanTree;
import org.xwiki.extension.job.plan.internal.DefaultExtensionPlan;
import org.xwiki.logging.marker.TranslationMarker;

/**
 * Base class for plan calculation jobs.
 * 
 * @param <R> the type of the request
 * @version $Id$
 * @since 5.4RC1
 */
public abstract class AbstractExtensionPlanJob<R extends ExtensionRequest> extends
    AbstractExtensionJob<R, DefaultExtensionPlan<R>>
{
    protected static final TranslationMarker LOG_RESOLVE = new TranslationMarker("extension.log.job.plan.resolve");

    protected static final TranslationMarker LOG_RESOLVE_NAMESPACE = new TranslationMarker(
        "extension.log.job.plan.resolve.namespace");

    protected static final TranslationMarker LOG_RESOLVEDEPENDENCY = new TranslationMarker(
        "extension.log.job.plan.resolvedependency");

    protected static final TranslationMarker LOG_RESOLVEDEPENDENCY_NAMESPACE = new TranslationMarker(
        "extension.log.job.plan.resolvedependency.namespace");

    /**
     * The install plan.
     */
    protected ModifableExtensionPlanTree extensionTree = new ModifableExtensionPlanTree();

    @Override
    protected DefaultExtensionPlan<R> createNewStatus(R request)
    {
        return new DefaultExtensionPlan<R>(request, this.observationManager, this.loggerManager, this.extensionTree,
            this.jobContext.getCurrentJob() != null);
    }
}
