@Test public void testValidSubjectWithCredentials() throws Exception {
  Set<SimpleCredentials> publicCreds=Collections.singleton(new SimpleCredentials("testUserId",new char[0]));
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
    assertSame(AuthInfo.EMPTY,cs.getAuthInfo());
  }
  finally {
    if (cs != null) {
      cs.close();
    }
  }
}
