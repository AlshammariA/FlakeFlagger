@Test public void literal() throws ScanException {
  String input="abv";
  Node node=makeNode(input);
  NodeToStringTransformer nodeToStringTransformer=new NodeToStringTransformer(node,propertyContainer0);
  assertEquals(input,nodeToStringTransformer.transform());
}
