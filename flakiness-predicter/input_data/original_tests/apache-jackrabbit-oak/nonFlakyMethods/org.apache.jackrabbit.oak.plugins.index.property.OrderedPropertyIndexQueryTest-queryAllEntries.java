/** 
 * Query the index for retrieving all the entries
 * @throws CommitFailedException
 * @throws ParseException
 * @throws RepositoryException
 */
@Test public void queryAllEntries() throws CommitFailedException, ParseException, RepositoryException {
  setTravesalEnabled(false);
  Tree rTree=root.getTree("/");
  Tree test=rTree.addChild("test");
  List<ValuePathTuple> nodes=addChildNodes(generateOrderedValues(NUMBER_OF_NODES),test,OrderDirection.ASC,Type.STRING);
  root.commit();
  Iterator<? extends ResultRow> results;
  results=executeQuery(String.format("SELECT * from [%s] WHERE foo IS NOT NULL",NT_UNSTRUCTURED),SQL2,null).getRows().iterator();
  assertRightOrder(nodes,results);
  setTravesalEnabled(true);
}
