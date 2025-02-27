package com.ezeeinfo.issuemanager.service;

import com.ezeeinfo.issuemanager.model.Issue;
import com.ezeeinfo.issuemanager.util.TestUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

class IssueServiceTest {

    private final IssueService tagService;

    IssueServiceTest() {
        this.tagService = new IssueService(TestUtil.questionBankManager());
    }

    /**
     * Before.
     *
     * @throws IOException the io exception
     */
    @BeforeEach
    void before() throws SQLException {
        cleanUp();
    }

    /**
     * After.
     */
    @AfterEach
    void after() throws SQLException {
        cleanUp();
    }

    private void cleanUp() throws SQLException {
        tagService.delete("hari");
    }

    @Test
    void create() throws SQLException {
        final Issue tag = tagService.create("hari", anIssue());
        Assertions.assertTrue(tagService.read("hari", tag.getId()).isPresent(), "Created Issue");
    }

    @Test
    void read() throws SQLException {
        final Issue tag = tagService.create("hari"
                ,anIssue());
        Assertions.assertTrue(tagService.read("hari", tag.getId()).isPresent(),
                "Created Issue");
    }

    @Test
    void update() throws SQLException {

        final Issue tag = tagService.create("hari"
                ,anIssue());
        Issue newIssue = new Issue();
        newIssue.setId(tag.getId());
        newIssue.setTitle("HansiIssue");
        newIssue.setStatus("INPROGRESS");
        newIssue.setTenant("Tenant1");
        Optional<Issue> updatedIssue = tagService
                .update("priya", tag.getId(), newIssue);
        Assertions.assertEquals("HansiIssue", updatedIssue.get().getTitle(), "Updated");
        Assertions.assertEquals("INPROGRESS", updatedIssue.get().getStatus(), "Updated");

//        Assertions.assertThrows(IllegalArgumentException.class, () -> {
//            tagService
//                    .update( "priya", 10000L, newIssue);
//        });
    }

    @Test
    void delete() throws SQLException {

        final Issue tag = tagService.create("hari",
                anIssue());
        tagService.delete("mani", tag.getId());
        Assertions.assertFalse(tagService.read("mani", tag.getId()).isPresent(), "Deleted Issue");
    }

    @Test
    void list() throws SQLException {

        final Issue tag = tagService.create("hari",
                anIssue());
        Issue newIssue = new Issue();
        newIssue.setTitle("HansiIssue");
        newIssue.setTenant("tenant2");
        tagService.create("hari",
                newIssue);
        List<Issue> listofCategories = tagService.list("hari", "tenant2");
        Assertions.assertEquals(1, listofCategories.size());

    }

    /**
     * Gets practice.
     *
     * @return the practice
     */
    Issue anIssue() {
        Issue tag = new Issue();
        tag.setTitle("HariIssue");
        tag.setDescription("Description");
        tag.setStatus("NEW");
        tag.setTenant("tenant1");
        return tag;
    }
}