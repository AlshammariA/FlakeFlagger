@Test public void testReadDefinition() throws Exception {
  PrivilegeDefinitionReader reader=new PrivilegeDefinitionReader(root);
  assertNotNull(reader.readDefinition(JCR_READ));
}
