package com.ezeeinfo.issuemanager.service;

import com.ezeeinfo.issuemanager.IssueManagerManager;
import com.ezeeinfo.issuemanager.model.Issue;
import com.ezeeinfo.issuemanager.store.IssueStore;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.Calendar;

/**
 * IssueService.
 */
public class IssueService {

    /**
     * Issue Store.
     */
    private final IssueStore issueStore;

    /**
     * Build IssueService.
     * @param issueManagerManager
     */
    public IssueService(final IssueManagerManager issueManagerManager) {
        this.issueStore = issueManagerManager.getIssueStore();
    }

    /**
     * create a Issue .
     * @param username
     * @param issue
     * @return CreatedName
     */
    public Issue create(final String username,
                        final Issue issue) throws SQLException {
        return this.issueStore.insert().values(issue).returning();
    }

    /**
     * Read Issue By id.
     * @param username
     * @param issueId
     * @return issue
     */
    public Optional<Issue> read(final String username,
                                final Long issueId) throws SQLException {
        return this.issueStore.select(issueId);
    }

    /**
     * Update Issue By id.
     * @param username
     * @param issueId
     * @param issue
     * @return IssueUpdated
     */
    public Optional<Issue> update(final String username,
                                  final Long issueId,
                                  final Issue issue) throws SQLException {
        this.issueStore.update().set(issue).execute();
        return read(username, issue.getId());
    }

    /**
     * Delete Issue By id.
     * @param username
     * @param issueId
     * @return IsDeleted
     */
    public boolean delete(final String username,
                          final Long issueId) throws SQLException {
        return this.issueStore.delete(issueId) == 1;
    }


    /**
     * Delete All Issues.
     * @param userName
     * @return nofOfDeleteIssues
     */
    public int delete(final String userName) throws SQLException {
        return this.issueStore.delete().execute();
    }

    /**
     * Selects All.
     * @param userName
     * @return issues
     * @throws SQLException
     */
    public List<Issue> list(final String userName) throws SQLException {
        return this.issueStore.select()
                .execute();
    }
}
