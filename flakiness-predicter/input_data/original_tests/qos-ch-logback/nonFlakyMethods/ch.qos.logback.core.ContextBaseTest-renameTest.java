@Test public void renameTest(){
  context.setName("hello");
  try {
    context.setName("x");
    fail("renaming is not allowed");
  }
 catch (  IllegalStateException ise) {
  }
}
