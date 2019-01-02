package com.sensedia.labs.domain.match;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sensedia.labs.FifaTournamentApplication;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.MediaTypes;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.restdocs.headers.HeaderDocumentation.headerWithName;
import static org.springframework.restdocs.headers.HeaderDocumentation.responseHeaders;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.subsectionWithPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FifaTournamentApplication.class)
public class TeamRepositoryTest {

  @Rule
  public final JUnitRestDocumentation documentation = new JUnitRestDocumentation("target/generated-snippets");
  @Autowired
  private WebApplicationContext context;
  @Autowired
  private ObjectMapper mapper;
  private MockMvc mockMvc;

  @Before
  public void setUp() {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
        .apply(documentationConfiguration(this.documentation))
        .alwaysDo(document("{method-name}", preprocessRequest(prettyPrint()), preprocessResponse(prettyPrint())))
        .build();
  }

  @Test
  public void getTeams() throws Exception {
    this.mockMvc.perform(get("/teams"))
        .andExpect(status().isOk())
        .andDo(document("get-teams",
            preprocessRequest(prettyPrint()),
            preprocessResponse(prettyPrint()),
            responseFields(
                subsectionWithPath("_links").description("Links to other resources"),
                subsectionWithPath("_embedded").description("Resources embedded on response body"),
                subsectionWithPath("page").description("The pagination cursor data")),
            responseHeaders(headerWithName("Content-Type").description("The payload type, e.g." + MediaTypes.HAL_JSON_VALUE))
        ));
  }

  @Test
  public void getTeam() throws Exception {
    this.mockMvc.perform(get("/teams/{teamId}", 3))
        .andExpect(status().isOk())
        .andDo(document("get-team",
            preprocessRequest(prettyPrint()),
            preprocessResponse(prettyPrint()),
            responseFields(
                subsectionWithPath("name").description("Team name"),
                subsectionWithPath("role").description("The role that this team performs on the system"),
                subsectionWithPath("_links").description("Links to other resources")),
            responseHeaders(headerWithName("Content-Type").description("The payload type, e.g." + MediaTypes.HAL_JSON_VALUE))
        ));
  }

}