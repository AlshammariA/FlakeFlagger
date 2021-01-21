@Test public void setPrimaryType() throws Exception {
  new TestContentLoader().loadTestContent(getAdminSession());
  Session session=getAdminSession();
  Node root=session.getRootNode().addNode("test","nt:folder");
  List<String> names=new ArrayList<String>();
  for (int i=0; i < 100; i++) {
    String name="node-" + i;
    root.addNode(name,"nt:folder");
    names.add(name);
  }
  root.setPrimaryType("test:orderableFolder");
  List<String> expected=getChildNames(root);
  while (!expected.isEmpty()) {
    String name=expected.remove((int)Math.floor(Math.random() * expected.size()));
    root.getNode(name).remove();
    assertEquals(expected,getChildNames(root));
  }
  for (  String name : names) {
    root.addNode(name,"nt:folder");
    expected.add(name);
    assertEquals(expected,getChildNames(root));
  }
}
