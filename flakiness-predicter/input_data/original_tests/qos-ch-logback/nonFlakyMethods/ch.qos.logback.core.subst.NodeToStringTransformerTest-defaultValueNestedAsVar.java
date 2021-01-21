@Test public void defaultValueNestedAsVar() throws ScanException {
  String input="a${k67:-x${k0}}c";
  Node node=makeNode(input);
  NodeToStringTransformer nodeToStringTransformer=new NodeToStringTransformer(node,propertyContainer0);
  assertEquals("axv0c",nodeToStringTransformer.transform());
}
