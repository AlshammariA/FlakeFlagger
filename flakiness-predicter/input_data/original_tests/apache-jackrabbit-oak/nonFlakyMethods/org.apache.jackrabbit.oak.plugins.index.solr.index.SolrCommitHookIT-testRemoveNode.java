@Test public void testRemoveNode() throws Exception {
  Root r=createRoot();
  r.getTree("/").addChild("testRemoveNode").setProperty("foo","bar");
  r.commit();
  SolrQuery query=new SolrQuery();
  query.setQuery("path_exact:\\/testRemoveNode");
  assertTrue("item with id:testRemoveNode was not found in the index",server.query(query).getResults().size() > 0);
  r.getTree("/").getChild("testRemoveNode").remove();
  r.commit();
  assertTrue("item with id:testRemoveNode was found in the index",server.query(query).getResults().size() == 0);
}
