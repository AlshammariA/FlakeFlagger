@Test public void getIdentifierTest(){
  Tree rootTree=root.getTree("/");
  assertEquals(ID_ROOT,getIdentifier(rootTree));
  Tree xx1=root.getTree(PATH_X1);
  assertEquals(ID_X1,getIdentifier(xx1));
  Tree yy1=root.getTree(PATH_Y1);
  assertEquals(ID_Y1,getIdentifier(yy1));
  Tree zz1=root.getTree(PATH_Z1);
  assertEquals(ID_Z1,getIdentifier(zz1));
}
