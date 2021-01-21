@Test public void loneColonShouldReadLikeAnyOtherCharacter() throws ScanException {
  String input="java:comp/env/jdbc/datasource";
  Node node=makeNode(input);
  NodeToStringTransformer nodeToStringTransformer=new NodeToStringTransformer(node,propertyContainer0);
  assertEquals(input,nodeToStringTransformer.transform());
}
