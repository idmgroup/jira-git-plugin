/*
 * User: Mike
 * Date: Oct 1, 2004
 * Time: 5:06:44 PM
 */
package com.xiplink.jira.git.revisions;

import org.apache.log4j.Logger;

import com.atlassian.configurable.ObjectConfiguration;
import com.atlassian.configurable.ObjectConfigurationException;
import com.atlassian.jira.component.ComponentAccessor;
import com.atlassian.jira.service.AbstractService;
import com.atlassian.jira.service.ServiceManager;
import com.xiplink.jira.git.MultipleGitRepositoryManager;
import com.xiplink.jira.git.MultipleGitRepositoryManagerImpl;

public class RevisionIndexService extends AbstractService
{
    private static Logger log = Logger.getLogger(MultipleGitRepositoryManagerImpl.class);
    
    public static final String REVISION_INDEX_SERVICE_NAME = "Git Revision Indexing Service";
    public static final long REVISION_INDEX_SERVICE_DELAY = 5 * 60 * 1000L;

    public RevisionIndexService()
    {
        log.debug("RevisionIndexService()");
    }
    
    public void run()
    {
        log.debug("run()");
        try
        {
            MultipleGitRepositoryManager multipleGitRepositoryManager = getMultipleGitRepositoryManager();

            if (null == multipleGitRepositoryManager)
            {
                log.debug("Plugin is disabled. Stopping.");
                return; // Just return --- the plugin is disabled. Don't log anything.
            }

            if (multipleGitRepositoryManager.getRevisionIndexer() != null)
            {
                log.debug("Updating the index");
                multipleGitRepositoryManager.getRevisionIndexer().updateIndex();
            }
            else
            {
                log.warn("Tried to index changes but SubversionManager has no revision indexer?");
            }
        }
        catch (Throwable t)
        {
            log.error("Error indexing changes: " + t, t);
        }
    }

    public ObjectConfiguration getObjectConfiguration() throws ObjectConfigurationException
    {
        return getObjectConfiguration("gitREVISIONSERVICE", "services/plugins/git/revisionindexservice.xml", null);
    }

    public static void install(ServiceManager serviceManager) throws Exception
    {
        log.info("install()");
        if (serviceManager.getServiceWithName(REVISION_INDEX_SERVICE_NAME) == null)
        {
            log.info("Installing service: " + REVISION_INDEX_SERVICE_NAME);
            serviceManager.addService(REVISION_INDEX_SERVICE_NAME, RevisionIndexService.class.getName(), REVISION_INDEX_SERVICE_DELAY);
        }
    }

    public static void remove(ServiceManager serviceManager) throws Exception
    {
        log.info("remove()");
        if (serviceManager.getServiceWithName(REVISION_INDEX_SERVICE_NAME) != null)
        {
            log.info("Removing service: " + REVISION_INDEX_SERVICE_NAME);
            serviceManager.removeServiceByName(REVISION_INDEX_SERVICE_NAME);
        }
    }

    private MultipleGitRepositoryManager getMultipleGitRepositoryManager()
    {
        log.debug("Retrieving component of type " + MultipleGitRepositoryManager.class.getCanonicalName());
        return ComponentAccessor.getOSGiComponentInstanceOfType(MultipleGitRepositoryManager.class);
    }

    public String getDescription()
    {
        return "This service indexes Git revisions.";
    }
}