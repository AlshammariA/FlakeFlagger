@Test(expected=IllegalStateException.class) public void throwOnClosedRoot() throws LoginException, NoSuchWorkspaceException, IOException {
  ContentSession session=repository.login(null,null);
  Root root=session.getLatestRoot();
  session.close();
  root.getTree("/");
}
