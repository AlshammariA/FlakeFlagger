@Test public void intersectionCursor(){
  QueryEngineSettings s=new QueryEngineSettings();
  Cursor a=new SimpleCursor("1:","/b","/c","/e","/e","/c");
  Cursor b=new SimpleCursor("2:","/a","/c","/d","/b","/c");
  Cursor c=Cursors.newIntersectionCursor(a,b,s);
  assertEquals("1:/b, 1:/c",list(c));
  assertFalse(c.hasNext());
}
