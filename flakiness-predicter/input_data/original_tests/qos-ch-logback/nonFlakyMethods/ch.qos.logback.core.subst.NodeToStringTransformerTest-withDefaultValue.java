@Test public void withDefaultValue() throws ScanException {
  String input="${k67:-b}c";
  Node node=makeNode(input);
  NodeToStringTransformer nodeToStringTransformer=new NodeToStringTransformer(node,propertyContainer0);
  assertEquals("bc",nodeToStringTransformer.transform());
}
