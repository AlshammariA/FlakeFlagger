@Test public void nestedVariable() throws ScanException {
  String input="a${k${zero}}b";
  Node node=makeNode(input);
  NodeToStringTransformer nodeToStringTransformer=new NodeToStringTransformer(node,propertyContainer0);
  assertEquals("av0b",nodeToStringTransformer.transform());
}
