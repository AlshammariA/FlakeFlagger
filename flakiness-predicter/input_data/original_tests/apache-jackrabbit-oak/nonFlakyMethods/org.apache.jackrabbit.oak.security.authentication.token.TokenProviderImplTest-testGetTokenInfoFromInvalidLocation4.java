@Test public void testGetTokenInfoFromInvalidLocation4() throws Exception {
  TokenInfo info=tokenProvider.createToken(userId,Collections.<String,Object>emptyMap());
  Tree tokenTree=getTokenTree(info);
  assertNotNull(tokenProvider.getTokenInfo(info.getToken()));
  TokenInfo info2=null;
  try {
    Tree adminTree=root.getTree(getUserManager(root).getAuthorizable(adminSession.getAuthInfo().getUserID()).getPath());
    NodeUtil node=new NodeUtil(adminTree).getOrAddChild(".tokens","nt:unstructured");
    assertTrue(root.move(tokenTree.getPath(),node.getTree().getPath() + "/" + tokenTree.getName()));
    root.commit();
    info2=tokenProvider.getTokenInfo(info.getToken());
    assertNotNull(info2);
    assertFalse(info2.matches(new TokenCredentials(info.getToken())));
  }
  finally {
    Tree t=getTokenTree(info2);
    t.remove();
    root.commit();
  }
}
