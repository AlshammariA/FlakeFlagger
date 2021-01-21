@Test public void relativeNotExistsProperty() throws Exception {
  Session session=getAdminSession();
  Node content=session.getRootNode().addNode("test");
  content.addNode("one").addNode("child").setProperty("prop","hello");
  content.addNode("two").addNode("child");
  session.save();
  String query="//*[not(child/@prop)]";
  QueryResult r=session.getWorkspace().getQueryManager().createQuery(query,"xpath").execute();
  NodeIterator it=r.getNodes();
  assertTrue(it.hasNext());
  String path=it.nextNode().getPath();
  assertEquals("/test/two",path);
  assertFalse(it.hasNext());
}
