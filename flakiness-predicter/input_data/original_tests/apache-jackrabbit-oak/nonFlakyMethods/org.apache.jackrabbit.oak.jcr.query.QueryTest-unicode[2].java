@Test public void unicode() throws Exception {
  Session session=getAdminSession();
  Node content=session.getRootNode().addNode("test");
  String[][] list={{"three","\u00e4\u00f6\u00fc"},{"two","123456789"},{"one","\u3360\u3361\u3362\u3363\u3364\u3365\u3366\u3367\u3368\u3369"}};
  for (  String[] pair : list) {
    content.addNode(pair[0]).setProperty("prop","propValue testSearch " + pair[1] + " data");
  }
  session.save();
  for (  String[] pair : list) {
    String query="//*[jcr:contains(., '" + pair[1] + "')]";
    QueryResult r=session.getWorkspace().getQueryManager().createQuery(query,"xpath").execute();
    NodeIterator it=r.getNodes();
    assertTrue(it.hasNext());
    String path=it.nextNode().getPath();
    assertEquals("/test/" + pair[0],path);
    assertFalse(it.hasNext());
  }
}
