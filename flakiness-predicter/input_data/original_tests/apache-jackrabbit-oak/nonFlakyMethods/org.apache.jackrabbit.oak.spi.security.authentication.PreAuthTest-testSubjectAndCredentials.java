@Test public void testSubjectAndCredentials() throws Exception {
  final Subject subject=new Subject(true,Collections.singleton(new TestPrincipal()),Collections.<Object>emptySet(),Collections.<Object>emptySet());
  ContentSession cs=Subject.doAsPrivileged(subject,new PrivilegedAction<ContentSession>(){
    @Override public ContentSession run(){
      ContentSession cs;
      try {
        cs=login(new GuestCredentials());
        return cs;
      }
 catch (      Exception e) {
        return null;
      }
    }
  }
,null);
  assertNull("Login should have failed.",cs);
}
