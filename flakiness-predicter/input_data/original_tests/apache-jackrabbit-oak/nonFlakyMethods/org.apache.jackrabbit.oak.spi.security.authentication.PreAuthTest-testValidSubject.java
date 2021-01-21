@Test public void testValidSubject() throws Exception {
  final Subject subject=new Subject(true,Collections.singleton(new TestPrincipal()),Collections.<Object>emptySet(),Collections.<Object>emptySet());
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
