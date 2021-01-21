@Test public void testRemoveTokenRemovesNode() throws Exception {
  TokenInfo info=tokenProvider.createToken(userId,Collections.<String,Object>emptyMap());
  Tree userTree=root.getTree(getUserManager(root).getAuthorizable(userId).getPath());
  Tree tokens=userTree.getChild(".tokens");
  String tokenNodePath=tokens.getChildren().iterator().next().getPath();
  info.remove();
  assertFalse(root.getTree(tokenNodePath).exists());
}
