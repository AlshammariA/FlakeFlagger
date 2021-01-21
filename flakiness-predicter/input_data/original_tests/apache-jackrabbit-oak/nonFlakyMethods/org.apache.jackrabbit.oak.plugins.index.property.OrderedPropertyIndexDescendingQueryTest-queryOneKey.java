/** 
 * test the index for returning the items related to a single key
 * @throws CommitFailedException
 * @throws ParseException
 */
@Test public void queryOneKey() throws CommitFailedException, ParseException {
  setTravesalEnabled(false);
  Tree rTree=root.getTree("/");
  Tree test=rTree.addChild("test");
  List<ValuePathTuple> nodes=addChildNodes(generateOrderedValues(NUMBER_OF_NODES),test,OrderDirection.DESC,Type.STRING);
  root.commit();
  ValuePathTuple searchfor=nodes.get(NUMBER_OF_NODES / 2);
  Map<String,PropertyValue> filter=ImmutableMap.of(ORDERED_PROPERTY,PropertyValues.newString(searchfor.getValue()));
  String query="SELECT * FROM [%s] WHERE %s=$%s";
  Iterator<? extends ResultRow> results=executeQuery(String.format(query,NT_UNSTRUCTURED,ORDERED_PROPERTY,ORDERED_PROPERTY),SQL2,filter).getRows().iterator();
  assertTrue("one element is expected",results.hasNext());
  assertEquals("wrong path returned",searchfor.getPath(),results.next().getPath());
  assertFalse("there should be not any more items",results.hasNext());
  setTravesalEnabled(true);
}
