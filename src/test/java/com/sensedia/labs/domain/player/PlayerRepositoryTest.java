package com.sensedia.labs.domain.player;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sensedia.labs.FifaTournamentApplication;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.MediaType;
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
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.subsectionWithPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FifaTournamentApplication.class)
public class PlayerRepositoryTest {

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
  public void getPlayers() throws Exception {
    this.mockMvc.perform(get("/players"))
        .andExpect(status().isOk())
        .andDo(document("get-players",
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
  public void getPlayer() throws Exception {
    this.mockMvc.perform(get("/players/{playerId}", 3))
        .andExpect(status().isOk())
        .andDo(document("get-player",
            preprocessRequest(prettyPrint()),
            preprocessResponse(prettyPrint()),
            responseFields(
                subsectionWithPath("name").description("Player name"),
                subsectionWithPath("role").description("The role that this player performs on the system"),
                subsectionWithPath("_links").description("Links to other resources")),
            responseHeaders(headerWithName("Content-Type").description("The payload type, e.g." + MediaTypes.HAL_JSON_VALUE))
        ));
  }

  @Test
  public void postPlayer() throws Exception {
    final Player diones = new Player();
    diones.setName("Diones");
    diones.setRole(Role.USER);
    final String bodyRequest = this.mapper.writeValueAsString(diones);
    this.mockMvc.perform(post("/players")
        .content(bodyRequest)
        .contentType(MediaType.APPLICATION_JSON_UTF8))
        .andDo(print())
        .andExpect(status().isCreated())
        .andExpect(header().exists("Location"))
        .andDo(document("post-player",
            preprocessRequest(prettyPrint()),
            preprocessResponse(prettyPrint()),
            responseHeaders(headerWithName("Location").description("The URI of the resource just created"))
        ));
  }
}