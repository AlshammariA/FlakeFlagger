@Test public void variable() throws ScanException {
  String input="${k0}";
  Node node=makeNode(input);
  NodeToStringTransformer nodeToStringTransformer=new NodeToStringTransformer(node,propertyContainer0);
  assertEquals("v0",nodeToStringTransformer.transform());
}
