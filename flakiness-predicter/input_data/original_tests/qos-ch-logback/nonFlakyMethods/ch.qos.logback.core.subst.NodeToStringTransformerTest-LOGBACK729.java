@Test public void LOGBACK729() throws ScanException {
  String input="${${k0}.jdbc.url}";
  Node node=makeNode(input);
  NodeToStringTransformer nodeToStringTransformer=new NodeToStringTransformer(node,propertyContainer0);
  assertEquals("http://..",nodeToStringTransformer.transform());
}
