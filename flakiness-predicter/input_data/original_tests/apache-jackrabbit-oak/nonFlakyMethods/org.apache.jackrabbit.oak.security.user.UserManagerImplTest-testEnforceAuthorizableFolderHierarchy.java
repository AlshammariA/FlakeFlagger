@Test public void testEnforceAuthorizableFolderHierarchy() throws RepositoryException, CommitFailedException {
  User user=userMgr.createUser(testUserId,null);
  root.commit();
  NodeUtil userNode=new NodeUtil(root.getTree(user.getPath()));
  NodeUtil folder=userNode.addChild("folder",UserConstants.NT_REP_AUTHORIZABLE_FOLDER);
  String path=folder.getTree().getPath();
  try {
    Principal p=new PrincipalImpl("test2");
    userMgr.createUser(p.getName(),p.getName(),p,path);
    root.commit();
    fail("Users may not be nested.");
  }
 catch (  CommitFailedException e) {
  }
 finally {
    Authorizable a=userMgr.getAuthorizable("test2");
    if (a != null) {
      a.remove();
      root.commit();
    }
  }
  NodeUtil someContent=userNode.addChild("mystuff",JcrConstants.NT_UNSTRUCTURED);
  path=someContent.getTree().getPath();
  try {
    try {
      Principal p=new PrincipalImpl("test3");
      userMgr.createUser(p.getName(),p.getName(),p,path);
      root.commit();
      fail("Users may not be nested.");
    }
 catch (    CommitFailedException e) {
    }
 finally {
      Authorizable a=userMgr.getAuthorizable("test3");
      if (a != null) {
        a.remove();
        root.commit();
      }
    }
    folder=someContent.addChild("folder",UserConstants.NT_REP_AUTHORIZABLE_FOLDER);
    root.commit();
    try {
      Principal p=new PrincipalImpl("test4");
      userMgr.createUser(p.getName(),p.getName(),p,folder.getTree().getPath());
      root.commit();
      fail("Users may not be nested.");
    }
 catch (    CommitFailedException e) {
    }
 finally {
      root.refresh();
      Authorizable a=userMgr.getAuthorizable("test4");
      if (a != null) {
        a.remove();
        root.commit();
      }
    }
  }
  finally {
    root.refresh();
    Tree t=root.getTree(path);
    if (t.exists()) {
      t.remove();
      root.commit();
    }
  }
}
