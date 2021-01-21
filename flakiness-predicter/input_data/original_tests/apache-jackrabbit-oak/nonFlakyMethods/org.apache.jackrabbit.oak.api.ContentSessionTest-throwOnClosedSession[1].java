@Test(expected=IllegalStateException.class) public void throwOnClosedSession() throws LoginException, NoSuchWorkspaceException, IOException {
  ContentSession session=repository.login(null,null);
  session.close();
  session.getLatestRoot();
}
