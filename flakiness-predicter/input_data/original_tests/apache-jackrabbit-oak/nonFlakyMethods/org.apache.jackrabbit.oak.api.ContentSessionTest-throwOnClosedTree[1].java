@Test(expected=IllegalStateException.class) public void throwOnClosedTree() throws LoginException, NoSuchWorkspaceException, IOException {
  ContentSession session=repository.login(null,null);
  Root root=session.getLatestRoot();
  Tree tree=root.getTree("/");
  session.close();
  tree.getChild("any");
}
