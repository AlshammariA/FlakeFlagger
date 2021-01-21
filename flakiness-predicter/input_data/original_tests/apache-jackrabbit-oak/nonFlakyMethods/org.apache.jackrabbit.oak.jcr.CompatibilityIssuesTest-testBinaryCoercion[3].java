@Test public void testBinaryCoercion() throws RepositoryException, IOException {
  Session session=getAdminSession();
  String ntName="binaryCoercionTest";
  NodeTypeManager ntm=session.getWorkspace().getNodeTypeManager();
  NodeTypeTemplate ntt=ntm.createNodeTypeTemplate();
  ntt.setName(ntName);
  PropertyDefinitionTemplate propertyWithType=ntm.createPropertyDefinitionTemplate();
  propertyWithType.setName("javaObject");
  propertyWithType.setRequiredType(PropertyType.STRING);
  PropertyDefinitionTemplate unnamed=ntm.createPropertyDefinitionTemplate();
  unnamed.setName("*");
  unnamed.setRequiredType(PropertyType.UNDEFINED);
  List<PropertyDefinition> properties=ntt.getPropertyDefinitionTemplates();
  properties.add(propertyWithType);
  properties.add(unnamed);
  ntm.registerNodeType(ntt,false);
  Node node=session.getRootNode().addNode("testNodeForBinary",ntName);
  ByteArrayOutputStream bos=serializeObject("testValue");
  node.setProperty("javaObject",session.getValueFactory().createBinary(new ByteArrayInputStream(bos.toByteArray())));
  Assert.assertTrue(IOUtils.contentEquals(new ByteArrayInputStream(bos.toByteArray()),node.getProperty("javaObject").getStream()));
}
