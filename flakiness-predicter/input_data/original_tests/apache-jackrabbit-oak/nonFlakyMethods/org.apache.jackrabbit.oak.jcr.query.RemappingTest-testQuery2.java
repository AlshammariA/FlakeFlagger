public void testQuery2() throws Exception {
  String statement=createStatement("my:booleanProperty","true");
  QueryManager qm=session.getWorkspace().getQueryManager();
  QueryResult qr=qm.createQuery(statement,"xpath").execute();
  NodeIterator ni=qr.getNodes();
  assertTrue(ni.hasNext());
  assertEquals(resultPath,ni.nextNode().getPath());
}
