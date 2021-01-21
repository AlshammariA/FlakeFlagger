@Test public void testGetAndPostArticleViaJson() throws Exception {
  sayNextSection("Retrieving articles for a user (Json)");
  say("Retrieving all articles of a user is a GET request to " + GET_ARTICLES_URL);
  ApiResponse apiResponse=makeGetRequest(buildUri(GET_ARTICLES_URL.replace("{username}","bob@gmail.com")));
  ArticlesDto articlesDto=getGsonWithLongToDateParsing().fromJson(apiResponse.payload,ArticlesDto.class);
  assertEqualsAndSay(3,articlesDto.articles.size(),"We get back all 3 articles of that user");
  sayNextSection("Posting new article (Json)");
  say("Posting a new article is a post request to " + POST_ARTICLE_URL);
  say("Please note that you have to be authenticated in order to be allowed to post.");
  ArticleDto articleDto=new ArticleDto();
  articleDto.content="contentcontent";
  articleDto.title="new title new title";
  apiResponse=makePostRequest(buildUri(POST_ARTICLE_URL.replace("{username}",USER)),articleDto);
  assertEqualsAndSay(403,apiResponse.httpStatus,"You have to be authenticated in order to post articles");
  doLogin();
  say("Now we are authenticated and expect the post to succeed...");
  apiResponse=makePostRequest(buildUri(POST_ARTICLE_URL.replace("{username}",USER)),articleDto);
  assertEqualsAndSay(200,apiResponse.httpStatus,"After successful login we are able to post articles");
  say("If we now fetch the articles again we are getting a new article (the one we have posted successfully");
  apiResponse=makeGetRequest(buildUri(GET_ARTICLES_URL.replace("{username}","bob@gmail.com")));
  articlesDto=getGsonWithLongToDateParsing().fromJson(apiResponse.payload,ArticlesDto.class);
  assertEqualsAndSay(4,articlesDto.articles.size(),"We are now getting 4 articles.");
}
