@Test public void getPathTest(){
  assertEquals("/",identifierManager.getPath(ID_ROOT));
  assertEquals(PATH_X1,identifierManager.getPath(ID_X1));
  assertEquals(PATH_Y1,identifierManager.getPath(ID_Y1));
  assertEquals(PATH_Z1,identifierManager.getPath(ID_Z1));
  assertNull(identifierManager.getPath(ID_NON_EXISTING));
  try {
    identifierManager.getPath(ID_INVALID);
    fail("Expected IllegalArgumentException");
  }
 catch (  IllegalArgumentException expected) {
  }
}
