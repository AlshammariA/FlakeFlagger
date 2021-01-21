public void testQuery1() throws Exception {
  String statement=createStatement("my:property","stringValue");
  QueryManager qm=session.getWorkspace().getQueryManager();
  QueryResult qr=qm.createQuery(statement,"xpath").execute();
  NodeIterator ni=qr.getNodes();
  assertTrue(ni.hasNext());
  assertEquals(resultPath,ni.nextNode().getPath());
}
