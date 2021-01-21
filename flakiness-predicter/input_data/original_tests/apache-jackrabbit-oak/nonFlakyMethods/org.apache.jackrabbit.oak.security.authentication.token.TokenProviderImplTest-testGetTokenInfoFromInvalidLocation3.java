@Test public void testGetTokenInfoFromInvalidLocation3() throws Exception {
  TokenInfo info=tokenProvider.createToken(userId,Collections.<String,Object>emptyMap());
  Tree tokenTree=getTokenTree(info);
  assertNotNull(tokenProvider.getTokenInfo(info.getToken()));
  Tree userTree=root.getTree(getUserManager(root).getAuthorizable(userId).getPath());
  NodeUtil node=new NodeUtil(userTree.getChild(".tokens"));
  try {
    createTokenTree(info,node,"nt:unstructured");
    tokenTree.remove();
    root.commit();
    assertNull(tokenProvider.getTokenInfo(info.getToken()));
  }
  finally {
    node.getTree().remove();
    root.commit();
  }
}
