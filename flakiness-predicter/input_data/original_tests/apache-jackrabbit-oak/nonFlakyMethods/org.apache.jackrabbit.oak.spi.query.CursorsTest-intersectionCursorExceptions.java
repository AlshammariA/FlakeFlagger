@Test public void intersectionCursorExceptions(){
  QueryEngineSettings s=new QueryEngineSettings();
  Cursor a=new SimpleCursor("1:","/x","/b","/c","/e","/e","/c");
  Cursor b=new SimpleCursor("2:","/a","/c","/d","/b","/c");
  Cursor c=Cursors.newIntersectionCursor(a,b,s);
  c.next();
  c.next();
  try {
    c.remove();
    fail();
  }
 catch (  UnsupportedOperationException e) {
  }
  try {
    c.next();
    fail();
  }
 catch (  IllegalStateException e) {
  }
}
