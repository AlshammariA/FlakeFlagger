/** 
 * query the index in case of mixed situation eg: SELECT * FROM [nt:base] WHERE pinned=1 ORDER BY lastModified
 * @throws RepositoryException
 * @throws IllegalArgumentException
 * @throws CommitFailedException
 * @throws ParseException
 */
@Test public void queryOrderAndWhereMixed() throws IllegalArgumentException, RepositoryException, CommitFailedException, ParseException {
  setTravesalEnabled(false);
  Tree rTree=root.getTree("/");
  Tree test=rTree.addChild("test");
  List<ValuePathTuple> nodes=addChildNodes(generateOrderedValues(NUMBER_OF_NODES),test,OrderDirection.ASC,Type.STRING);
  root.commit();
  String where="wholetthedogsout";
  String value="woof-woof-woof-woof";
  Tree t=root.getTree(nodes.get(0).getPath());
  t.setProperty(where,value);
  t=root.getTree(nodes.get(1).getPath());
  t.setProperty(where,value);
  root.commit();
  Iterator<? extends ResultRow> results;
  String query=String.format("SELECT * from [nt:base] WHERE %s=$%s ORDER BY %s",where,where,ORDERED_PROPERTY);
  Map<String,PropertyValue> filter=ImmutableMap.of(where,PropertyValues.newString(value));
  results=executeQuery(query,SQL2,filter).getRows().iterator();
  assertTrue(results.hasNext());
  setTravesalEnabled(true);
}
