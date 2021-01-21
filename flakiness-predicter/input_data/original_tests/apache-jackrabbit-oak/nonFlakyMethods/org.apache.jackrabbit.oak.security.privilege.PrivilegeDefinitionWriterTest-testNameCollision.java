@Test public void testNameCollision(){
  try {
    PrivilegeDefinitionWriter writer=new PrivilegeDefinitionWriter(root);
    writer.writeDefinition(new ImmutablePrivilegeDefinition(JCR_READ,true,null));
    fail("name collision");
  }
 catch (  RepositoryException e) {
  }
}
