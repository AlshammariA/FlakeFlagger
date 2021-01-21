@Test public void testWithDefaultWorkspaceName() throws Exception {
  ContentRepository repo=new Oak().with("test").with(new OpenSecurityProvider()).createContentRepository();
  String[] valid=new String[]{null,"test"};
  for (  String wspName : valid) {
    ContentSession cs=null;
    try {
      cs=repo.login(null,wspName);
      assertEquals("test",cs.getWorkspaceName());
    }
  finally {
      if (cs != null) {
        cs.close();
      }
    }
  }
  String[] invalid=new String[]{"","another",Oak.DEFAULT_WORKSPACE_NAME};
  for (  String wspName : invalid) {
    ContentSession cs=null;
    try {
      cs=repo.login(null,wspName);
      fail("invalid workspace nam");
    }
 catch (    NoSuchWorkspaceException e) {
    }
 finally {
      if (cs != null) {
        cs.close();
      }
    }
  }
}
