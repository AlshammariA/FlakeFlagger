/** 
 * @since OAK 1.0 The anonymous user is optional.
 */
@Test public void testAnonymousConfiguration() throws Exception {
  Map<String,Object> userParams=new HashMap();
  userParams.put(UserConstants.PARAM_ANONYMOUS_ID,"");
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
    Authorizable anonymous=umgr.getAuthorizable(UserConstants.DEFAULT_ANONYMOUS_ID);
    assertNull(anonymous);
  }
  finally {
    cs.close();
  }
  ContentSession anonymousSession=null;
  try {
    anonymousSession=repo.login(new GuestCredentials(),null);
    fail();
  }
 catch (  LoginException e) {
  }
 finally {
    if (anonymousSession != null) {
      anonymousSession.close();
    }
  }
}
