@Test public void testImmutable(){
  try {
    root.commit();
    fail();
  }
 catch (  UnsupportedOperationException e) {
  }
  try {
    root.rebase();
    fail();
  }
 catch (  UnsupportedOperationException e) {
  }
  try {
    root.refresh();
    fail();
  }
 catch (  UnsupportedOperationException e) {
  }
  try {
    root.createBlob(new ByteArrayInputStream(new byte[0]));
    fail();
  }
 catch (  UnsupportedOperationException e) {
  }
  try {
    root.move("/x","/b");
    fail();
  }
 catch (  UnsupportedOperationException e) {
  }
}
