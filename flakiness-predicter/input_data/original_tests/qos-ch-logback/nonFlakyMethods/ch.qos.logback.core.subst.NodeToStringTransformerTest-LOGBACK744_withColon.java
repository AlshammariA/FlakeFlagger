@Test public void LOGBACK744_withColon() throws ScanException {
  String input="%d{HH:mm:ss.SSS} host:${host} %logger{36} - %msg%n";
  Node node=makeNode(input);
  NodeToStringTransformer nodeToStringTransformer=new NodeToStringTransformer(node,propertyContainer0);
  System.out.println(nodeToStringTransformer.transform());
  assertEquals("%d{HH:mm:ss.SSS} host:local %logger{36} - %msg%n",nodeToStringTransformer.transform());
}
