@Test public void testGetTokenInfoFromInvalidLocation2() throws Exception {
  TokenInfo info=tokenProvider.createToken(userId,Collections.<String,Object>emptyMap());
  Tree tokenTree=getTokenTree(info);
  assertNotNull(tokenProvider.getTokenInfo(info.getToken()));
  Tree userTree=root.getTree(getUserManager(root).getAuthorizable(userId).getPath());
  NodeUtil node=new NodeUtil(userTree).addChild("testNode","nt:unstructured");
  try {
    createTokenTree(info,node,"rep:Token");
    tokenTree.remove();
    root.commit();
    assertNull(tokenProvider.getTokenInfo(info.getToken()));
  }
  finally {
    node.getTree().remove();
    root.commit();
  }
}
