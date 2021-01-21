@Test public void testAddSomeNodes() throws Exception {
  Root r=createRoot();
  r.getTree("/").addChild("a").addChild("b").addChild("doc1").setProperty("text","hit that hot hat tattoo");
  r.getTree("/").getChild("a").addChild("c").addChild("doc2").setProperty("text","it hits hot hats");
  r.getTree("/").getChild("a").getChild("b").addChild("doc3").setProperty("text","tattoos hate hot hits");
  r.getTree("/").getChild("a").getChild("b").addChild("doc4").setProperty("text","hats tattoos hit hot");
  r.commit();
  SolrQuery query=new SolrQuery();
  query.setQuery("*:*");
  QueryResponse queryResponse=server.query(query);
  assertTrue("no documents were indexed",queryResponse.getResults().size() > 0);
}
