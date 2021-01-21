@Test public void getTreeTest(){
  assertEquals("/",identifierManager.getTree(ID_ROOT).getPath());
  assertEquals(PATH_X1,identifierManager.getTree(ID_X1).getPath());
  assertEquals(PATH_Y1,identifierManager.getTree(ID_Y1).getPath());
  assertEquals(PATH_Z1,identifierManager.getTree(ID_Z1).getPath());
  assertNull(identifierManager.getTree(ID_NON_EXISTING));
  try {
    identifierManager.getTree(ID_INVALID);
    fail("Expected IllegalArgumentException");
  }
 catch (  IllegalArgumentException expected) {
  }
}
