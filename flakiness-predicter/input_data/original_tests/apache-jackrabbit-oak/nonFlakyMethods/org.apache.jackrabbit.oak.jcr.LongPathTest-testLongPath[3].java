@Test public void testLongPath() throws Exception {
  Session s=getAdminSession();
  StringBuilder buff=new StringBuilder();
  for (int i=0; i < 10; i++) {
    buff.append("0123456789");
  }
  String longName="n" + buff.toString();
  Node n=s.getRootNode();
  ArrayList<String> paths=new ArrayList<String>();
  for (int i=0; i < 30; i++) {
    n=n.addNode(longName + "_" + i);
    paths.add(n.getPath());
  }
  s.save();
  Session s2=createAdminSession();
  Node n2=s2.getRootNode();
  for (int i=0; i < 30; i++) {
    n2=n2.getNode(longName + "_" + i);
    assertEquals(paths.get(i),n2.getPath());
  }
  s2.logout();
}
