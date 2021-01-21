@Test public void queryOrderByNonIndexedProperty() throws CommitFailedException, ParseException {
  setTravesalEnabled(false);
  Tree rTree=root.getTree("/");
  Tree test=rTree.addChild("test");
  addChildNodes(generateOrderedValues(NUMBER_OF_NODES),test,OrderDirection.ASC,Type.STRING);
  root.commit();
  Iterator<? extends ResultRow> results;
  String query="SELECT * from [nt:base] ORDER BY somethingnotindexed";
  results=executeQuery(query,SQL2,null).getRows().iterator();
  assertFalse("An empty resultset is expected",results.hasNext());
  setTravesalEnabled(true);
}
