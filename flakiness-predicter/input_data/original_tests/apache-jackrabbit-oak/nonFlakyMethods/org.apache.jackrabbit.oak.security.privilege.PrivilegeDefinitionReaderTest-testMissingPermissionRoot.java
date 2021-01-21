@Test public void testMissingPermissionRoot() throws Exception {
  ContentRepository repo=new Oak().with(new OpenSecurityProvider()).createContentRepository();
  Root tmpRoot=repo.login(null,null).getLatestRoot();
  try {
    PrivilegeDefinitionReader reader=new PrivilegeDefinitionReader(tmpRoot);
    assertNull(reader.readDefinition(JCR_READ));
  }
  finally {
    tmpRoot.getContentSession().close();
  }
}
