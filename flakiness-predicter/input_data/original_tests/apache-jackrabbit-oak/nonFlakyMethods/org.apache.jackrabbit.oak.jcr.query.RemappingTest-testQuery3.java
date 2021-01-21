public void testQuery3() throws Exception {
  String statement=createStatement("my:nameProperty","my:nameValue");
  QueryManager qm=session.getWorkspace().getQueryManager();
  QueryResult qr=qm.createQuery(statement,"xpath").execute();
  NodeIterator ni=qr.getNodes();
  assertTrue(ni.hasNext());
  assertEquals(resultPath,ni.nextNode().getPath());
}
