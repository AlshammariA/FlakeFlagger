@Test public void testReadNonExisting() throws Exception {
  PrivilegeDefinitionReader reader=new PrivilegeDefinitionReader(root);
  assertNull(reader.readDefinition("nonexisting"));
}
