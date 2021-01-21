@Test public void testValidSubjectWithAuthInfo() throws Exception {
  AuthInfo info=new AuthInfoImpl("testUserId",Collections.<String,Object>emptyMap(),Collections.<Principal>emptySet());
  Set<AuthInfo> publicCreds=Collections.singleton(info);
  final Subject subject=new Subject(false,Collections.singleton(new TestPrincipal()),publicCreds,Collections.<Object>emptySet());
  ContentSession cs=Subject.doAsPrivileged(subject,new PrivilegedAction<ContentSession>(){
    @Override public ContentSession run(){
      try {
        return login(null);
      }
 catch (      Exception e) {
        return null;
      }
    }
  }
,null);
  try {
    assertSame(info,cs.getAuthInfo());
  }
  finally {
    if (cs != null) {
      cs.close();
    }
  }
}
