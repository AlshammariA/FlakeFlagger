@Test public void literalVariableLiteral() throws ScanException {
  String input="a${k0}c";
  Node node=makeNode(input);
  NodeToStringTransformer nodeToStringTransformer=new NodeToStringTransformer(node,propertyContainer0);
  assertEquals("av0c",nodeToStringTransformer.transform());
}
