@Test public void testMissingPrivilegeRoot() throws Exception {
  ContentRepository repo=new Oak().with(new OpenSecurityProvider()).createContentRepository();
  Root tmpRoot=repo.login(null,null).getLatestRoot();
  try {
    PrivilegeDefinitionWriter writer=new PrivilegeDefinitionWriter(tmpRoot);
    writer.writeDefinition(new ImmutablePrivilegeDefinition("newName",true,null));
    fail("missing privilege root");
  }
 catch (  RepositoryException e) {
  }
 finally {
    tmpRoot.getContentSession().close();
  }
}
