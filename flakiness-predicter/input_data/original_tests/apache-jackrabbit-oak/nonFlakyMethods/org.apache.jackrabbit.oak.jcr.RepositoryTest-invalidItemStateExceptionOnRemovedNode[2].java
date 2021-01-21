@Test public void invalidItemStateExceptionOnRemovedNode() throws Exception {
  Session session=getAdminSession();
  for (  String parentPath : new String[]{"/",TEST_PATH}) {
    Node parent=session.getNode(parentPath);
    Node child=parent.addNode("child");
    String childPath=child.getPath();
    child.remove();
    try {
      child.getPath();
      fail();
    }
 catch (    InvalidItemStateException expected) {
    }
    session.save();
    try {
      child.getPath();
      fail();
    }
 catch (    InvalidItemStateException expected) {
    }
    parent.addNode("child");
    assertEquals(childPath,child.getPath());
  }
}
