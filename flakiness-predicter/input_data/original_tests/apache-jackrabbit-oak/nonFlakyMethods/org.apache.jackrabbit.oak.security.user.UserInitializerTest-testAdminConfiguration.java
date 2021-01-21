/** 
 * @since OAK 1.0 The configuration defines if the password of theadmin user is being set.
 */
@Test public void testAdminConfiguration() throws Exception {
  Map<String,Object> userParams=new HashMap();
  userParams.put(UserConstants.PARAM_ADMIN_ID,"admin");
  userParams.put(UserConstants.PARAM_OMIT_ADMIN_PW,true);
  ConfigurationParameters params=ConfigurationParameters.of(ImmutableMap.of(UserConfiguration.NAME,ConfigurationParameters.of(userParams)));
  SecurityProvider sp=new SecurityProviderImpl(params);
  final ContentRepository repo=new Oak().with(new InitialContent()).with(new PropertyIndexEditorProvider()).with(new PropertyIndexProvider()).with(new TypeEditorProvider()).with(sp).createContentRepository();
  ContentSession cs=Subject.doAs(SystemSubject.INSTANCE,new PrivilegedExceptionAction<ContentSession>(){
    @Override public ContentSession run() throws Exception {
      return repo.login(null,null);
    }
  }
);
  try {
    Root root=cs.getLatestRoot();
    UserConfiguration uc=sp.getConfiguration(UserConfiguration.class);
    UserManager umgr=uc.getUserManager(root,NamePathMapper.DEFAULT);
    Authorizable adminUser=umgr.getAuthorizable("admin");
    assertNotNull(adminUser);
    Tree adminTree=root.getTree(adminUser.getPath());
    assertTrue(adminTree.exists());
    assertNull(adminTree.getProperty(UserConstants.REP_PASSWORD));
  }
  finally {
    cs.close();
  }
  ContentSession adminSession=null;
  try {
    adminSession=repo.login(new SimpleCredentials("admin",new char[0]),null);
    fail();
  }
 catch (  LoginException e) {
  }
 finally {
    if (adminSession != null) {
      adminSession.close();
    }
  }
}
