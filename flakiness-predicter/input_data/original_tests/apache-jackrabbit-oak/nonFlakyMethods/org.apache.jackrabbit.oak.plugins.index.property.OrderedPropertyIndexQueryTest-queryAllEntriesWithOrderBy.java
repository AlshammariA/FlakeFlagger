@Test public void queryAllEntriesWithOrderBy() throws CommitFailedException, ParseException, RepositoryException {
  setTravesalEnabled(false);
  Tree rTree=root.getTree("/");
  Tree test=rTree.addChild("test");
  List<ValuePathTuple> nodes=addChildNodes(generateOrderedValues(NUMBER_OF_NODES),test,OrderDirection.ASC,Type.STRING);
  root.commit();
  Iterator<? extends ResultRow> results;
  String query=String.format("SELECT * from [nt:base] WHERE %s IS NOT NULL ORDER BY %s",ORDERED_PROPERTY,ORDERED_PROPERTY);
  results=executeQuery(query,SQL2,null).getRows().iterator();
  assertRightOrder(nodes,results);
  setTravesalEnabled(true);
}
