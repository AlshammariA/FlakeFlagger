@Test public void testEnforceHierarchy() throws RepositoryException, CommitFailedException {
  List<String> invalid=new ArrayList<String>();
  invalid.add("/");
  invalid.add("/jcr:system");
  String groupRoot=getConfig().getConfigValue(PARAM_GROUP_PATH,DEFAULT_GROUP_PATH);
  invalid.add(groupRoot);
  String userRoot=getConfig().getConfigValue(PARAM_USER_PATH,DEFAULT_USER_PATH);
  invalid.add(Text.getRelativeParent(userRoot,1));
  invalid.add(userPath);
  invalid.add(userPath + "/folder");
  for (  String path : invalid) {
    try {
      Tree parent=root.getTree(path);
      if (!parent.exists()) {
        String[] segments=Text.explode(path,'/',false);
        parent=root.getTree("/");
        for (        String segment : segments) {
          Tree next=parent.getChild(segment);
          if (!next.exists()) {
            next=parent.addChild(segment);
            next.setProperty(JcrConstants.JCR_PRIMARYTYPE,NT_REP_AUTHORIZABLE_FOLDER,Type.NAME);
            parent=next;
          }
        }
      }
      Tree userTree=parent.addChild("testUser");
      userTree.setProperty(JcrConstants.JCR_PRIMARYTYPE,NT_REP_USER,Type.NAME);
      userTree.setProperty(JcrConstants.JCR_UUID,UserProvider.getContentID("testUser"));
      userTree.setProperty(REP_PRINCIPAL_NAME,"testUser");
      root.commit();
      fail("Invalid hierarchy should be detected");
    }
 catch (    CommitFailedException e) {
    }
 finally {
      root.refresh();
    }
  }
}
