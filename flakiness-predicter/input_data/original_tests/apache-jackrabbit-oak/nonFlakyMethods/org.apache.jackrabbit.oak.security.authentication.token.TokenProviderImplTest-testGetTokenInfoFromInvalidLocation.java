@Test public void testGetTokenInfoFromInvalidLocation() throws Exception {
  TokenInfo info=tokenProvider.createToken(userId,Collections.<String,Object>emptyMap());
  Tree tokenTree=getTokenTree(info);
  assertNotNull(tokenProvider.getTokenInfo(info.getToken()));
  NodeUtil node=new NodeUtil(root.getTree("/")).addChild("testNode","nt:unstructured");
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
